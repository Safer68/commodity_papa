create table client
(
    id           int auto_increment
    primary key,
    city         varchar(255) null,
    postal_code  int          null,
    street       varchar(255) null,
    name         varchar(20)  null,
    patronymic   varchar(20)  null,
    phone_number varchar(15)  null,
    surname      varchar(20)  null
    );

create table delivery
(
    id   int auto_increment
        primary key,
    name varchar(255) null
);

create table manager
(
    id   int auto_increment
    primary key,
    name varchar(255) null
    );

create table orders
(
    id          int auto_increment
    primary key,
    date        datetime(6) null,
    client_id   int         null,
    delivery_id int         null,
    manager_id  int         null,
    constraint client_fk
    foreign key (client_id) references client (id),
    constraint manager_fk
    foreign key (manager_id) references manager (id),
    constraint delivery_fk
    foreign key (delivery_id) references delivery (id)
    );

create table product
(
    id          int auto_increment
    primary key,
    description varchar(2000) null,
    price       double        null,
    section     varchar(255)  null
    );

create table order_products
(
    order_id    int not null,
    products_id int not null,
    primary key (order_id, products_id),
    constraint order_fk
    foreign key (order_id) references orders (id),
    constraint products_fk
    foreign key (products_id) references product (id)
    );