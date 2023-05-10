create table if not exists cars
(
    id          uuid         not null,
    modelname  varchar(100) not null,
    color   varchar(100) not null,
    platenumber   varchar(100) not null,
    users        uuid,
    UNIQUE      (id),
    PRIMARY KEY (id)
    );
ALTER TABLE cars ADD CONSTRAINT fk_roles FOREIGN KEY (users) references users(id)
