create table product (
    id int auto_increment,
    name varchar(150) NOT NULL unique,
    description varchar(255),
    price decimal(6,2),
    PRIMARY KEY (id));