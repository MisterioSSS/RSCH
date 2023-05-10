

create table if not exists roles
(

  name        varchar     not null,
  UNIQUE      (name),
  PRIMARY KEY (name)
);
create table if not exists users
(
    users_id uuid,
    firstname  varchar(100) not null,
    lastname   varchar(100) not null,
    role_id       varchar,
    UNIQUE      (users_id),
    PRIMARY KEY (users_id),
    FOREIGN KEY (role_id) references roles(name)
);


create table if not exists film
(
    film_id uuid,
    name  varchar not null,
    UNIQUE      (film_id),
    PRIMARY KEY (film_id)

    );
create table if not exists users_roles
(
    id uuid,
    user_id uuid,
    film_id uuid,
    role varchar not null,
    UNIQUE      (id),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) references users(users_id),
    FOREIGN KEY (film_id) references film(film_id)
    );

