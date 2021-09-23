DROP TABLE IF EXISTS phone;

CREATE TABLE phone
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    is_available BOOLEAN      default true,
    booked_by        VARCHAR(250) default null,
    booked_on    timestamp    DEFAULT NULL,
    brand       varchar(250) not null,
    model       varchar(250) not null
);