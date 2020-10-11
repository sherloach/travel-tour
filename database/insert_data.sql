USE travelbooking

INSERT INTO [user] (username, password, status)
VALUES ('admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1)

INSERT INTO [user] (username, password, status)
VALUES ('nguyenvana', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1)

INSERT INTO [user] (username, password, status)
VALUES ('nguyenvanb', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1)

INSERT INTO [user] (username, password, status)
VALUES ('nguyenvanc', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1)

insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('CLIENT','Người dùng');
insert into role(code,name) values('GUIDE','Hướng dẫn viên');
insert into role(code,name) values('EMPLOYEE','Nhân viên');

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,4);
INSERT INTO user_role(userid,roleid) VALUES (3,3);
INSERT INTO user_role(userid,roleid) VALUES (4,2);