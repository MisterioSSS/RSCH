create table if not exists authors
(
    name        varchar     not null,
    UNIQUE      (name),
    PRIMARY KEY (name)
);
create table if not exists books
(
    id          uuid         not null,
    name  varchar(100) not null,
    pagecount   integer not null,
    yearofissue integer not null,
    author varchar,
    UNIQUE      (id),
    PRIMARY KEY (id)
);
ALTER TABLE books ADD CONSTRAINT fk_authors FOREIGN KEY (author) references authors(name)

