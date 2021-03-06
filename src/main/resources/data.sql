-- 従業員テーブルのデータ
INSERT INTO employee (employee_id, employee_name, age)
VALUES(1, '山田太郎', 30);

-- ユーザーマスタのデータ(アドミン権限)
INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('yamada@example.com', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1hulPa', '山田太郎', '1990-01-01', 28, false, 'ROLE_ADMIN');

-- ユーザーマスタのデータ(一般権限)
INSERT INTO m_user(user_id, password, user_name, birthday, age, marriage, role)
VALUES('tamura@example.com', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1hulPa', '田村達也', '1986-11-05', 31, false, 'ROLE_GENERAL');