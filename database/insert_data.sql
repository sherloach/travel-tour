USE travelbooking

INSERT INTO [user] (username, password, status)
VALUES ('admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1)
INSERT INTO [user] (username, password, status)
VALUES ('nguyenvana', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1)
INSERT INTO [user] (username, password, status)
VALUES ('nguyenvanb', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1)

INSERT INTO [client] (name, address, email, gender, phonenumber, user_id)
VALUES (N'Nguyễn Văn B', N'Việt Nam', 'nguyenvanb@gmail.com', 1, '0199292454', 3)
INSERT INTO [employee] (name, address, email, gender, phonenumber, user_id)
VALUES (N'Nguyễn Văn A', N'Việt Nam', 'nguyenvana@gmail.com', 0, '0155592454', 4)

insert into role(code,name) values('ADMIN', N'Quản trị');
insert into role(code,name) values('EMPLOYEE', N'Nhân viên');
insert into role(code,name) values('CLIENT', N'Người dùng');

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);
INSERT INTO user_role(user_id,role_id) VALUES (3,3);