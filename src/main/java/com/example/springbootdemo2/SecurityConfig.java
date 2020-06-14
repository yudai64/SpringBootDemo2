package com.example.springbootdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  private DataSource dataSource;

  //ユーザーIDとパスワードを取得するSQL文
  private static final String USER_SQL = "SELECT user_id, password, true FROM m_user WHERE user_id = ?";

  //ユーザーのロールを取得SQL文
  private static final String ROLE_SQL = "SELECT user_id, role FROM m_user WHERE user_id = ?";
  
  @Override
  public void configure(WebSecurity web) throws Exception {

    //静的リソースへのアクセスには、セキュリティを適用しない
    web.ignoring().antMatchers("/webjars/**", "/css/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http

        .authorizeRequests()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/signup").permitAll()
            .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
            .anyRequest().authenticated()

        .and()

        .formLogin()
            .loginProcessingUrl("/login")
            .loginPage("/login")
            .failureUrl("/login")
            .usernameParameter("userId")
            .passwordParameter("password")
            .defaultSuccessUrl("/home", true)

        .and()

        .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login");

    // //CSRF対策を一時的に無効に設定
    // http.csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.jdbcAuthentication()
      .dataSource(dataSource)
      .usersByUsernameQuery(USER_SQL)
      .authoritiesByUsernameQuery(ROLE_SQL)
      .passwordEncoder(passwordEncoder());
  }
}