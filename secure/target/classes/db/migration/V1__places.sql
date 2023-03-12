create sequence comment_seq minvalue 0 start with 0 increment by 1;
create sequence institute_seq minvalue 0 start with 0 increment by 1;
create sequence user_seq minvalue 0 start with 0 increment by 1;
create table comments (
                          id bigint not null,
                          comment varchar(255),
                          date timestamp(6),
                          user_id bigint not null,
                          primary key (id)
);

create table favorite_institutes (
                                     user_id bigint not null,
                                     institute_id bigint not null
);

create table institute_comments (
                                    place_id bigint not null,
                                    comment_id bigint not null
);

create table institutes (
                            id bigint not null,
                            bias_type varchar(255),
                            description varchar(3000),
                            frame_url varchar(3000),
                            image_url varchar(1000),
                            institute_type varchar(255),
                            name varchar(255),
                            web_url varchar(1000),
                            primary key (id)
);

create table users (
                       id bigint not null,
                       first_name varchar(255),
                       last_name varchar(255),
                       password varchar(255),
                       role smallint,
                       username varchar(255),
                       primary key (id)
);

alter table if exists institute_comments
    add constraint UK_kdrm9amuu2mfnymyiumykxtw3 unique (comment_id);

alter table if exists comments
    add constraint FK8omq0tc18jd43bu5tjh6jvraq
    foreign key (user_id)
    references users;

alter table if exists favorite_institutes
    add constraint FK8ny9cfcoxmba9ykqx0vbefcpn
    foreign key (institute_id)
    references institutes;

alter table if exists favorite_institutes
    add constraint FK4ygj908m5flp80nt7rhmj0rb9
    foreign key (user_id)
    references users;

alter table if exists institute_comments
    add constraint FK2kp912pxw2tob9cb3nrxjmpy3
    foreign key (comment_id)
    references comments;

alter table if exists institute_comments
    add constraint FKjyscy9kbmcnmemuc4m08ww3wh
    foreign key (place_id)
    references institutes;
