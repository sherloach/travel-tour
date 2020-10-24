USE travelbooking;

INSERT INTO user (username, password, status, role)
VALUES ('admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'ADMIN');
INSERT INTO user (username, password, status, role)
VALUES ('nguyenvana', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'EMPLOYEE');
INSERT INTO user (username, password, status, role)
VALUES ('nguyenvanb', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'CLIENT');

INSERT INTO employee (name, address, email, gender, phonenumber, userid)
VALUES (N'Trần văn admin', N'Việt Nam', 'admin@gmail.com', 1, '0188892454', 1);
INSERT INTO client (name, address, email, gender, phonenumber, userid)
VALUES (N'Nguyễn Văn B', N'Việt Nam', 'nguyenvanb@gmail.com', 1, '0199292454', 3);
INSERT INTO employee (name, address, email, gender, phonenumber, userid)
VALUES (N'Nguyễn Văn A', N'Việt Nam', 'nguyenvana@gmail.com', 0, '0155592454', 2);