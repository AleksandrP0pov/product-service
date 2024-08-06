
create table product
(
    id  bigserial not null primary key,
    name        varchar(255),
    price       double precision not null,
    category_id bigint
);

create table category
(
    id   bigserial not null
        primary key,
    name varchar(255)
);

create table inventory
(
    id bigserial not null primary key ,
    quantity int ,
    reserve int,
    product_id bigint
);

alter table if exists product
    add constraint product_category_fk
    foreign key (category_id) references category;

alter table if exists inventory
    add constraint inventory_product_fk
    foreign key (product_id) references product;





