USE travelbooking;

INSERT INTO user (username, password, status, role)
VALUES ('admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'ADMIN');
INSERT INTO user (username, password, status, role)
VALUES ('nguyenvana', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'EMPLOYEE');
INSERT INTO user (username, password, status, role)
VALUES ('nguyenvanb', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'CLIENT');

INSERT INTO employee (name, address, email, gender, phonenumber, userid, employeecol)
VALUES (N'Trần văn admin', N'Việt Nam', 'admin@gmail.com', 1, '0188892454', 1, '2020-12-1');
INSERT INTO client (name, address, email, gender, phonenumber, userid)
VALUES (N'Nguyễn Văn B', N'Việt Nam', 'nguyenvanb@gmail.com', 1, '0199292454', 3);
INSERT INTO employee (name, address, email, gender, phonenumber, userid)
VALUES (N'Nguyễn Văn A', N'Việt Nam', 'nguyenvana@gmail.com', 0, '0155592454', 2);

INSERT INTO tour (name, tourID, description, summary, duration, employee_id, location, maxgroupsize, price, startdate)
VALUES ('The Perfect Tour', 'the-perfect-tour', 'Chuyến du lịch không thể hoàn hảo hơn', 'Chuyến du lịch không thể hoàn hảo hơn', 14, 2, 'Đà Nẵng, Hà Nội, Tây Bắc', 10, 2000, '2020-12-2 20:00:00')