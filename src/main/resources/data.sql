-- 従業員テーブルのデータ
INSERT INTO employee (employee_id, employee_name, age)
VALUES(1, '山田太郎', 30);

-- ユーザーマスタのデータ
INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('yamada@example.com', 'password', '山田太郎', '1990-01-01', 28, false, 'ROLE_ADMIN');