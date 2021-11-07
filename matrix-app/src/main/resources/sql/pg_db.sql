create table post_info
(
    id      bigint primary key not null,
    pid     bigint             not null,
    uid     bigint             not null,
    title   varchar(50)        not null default '',
    summary varchar(200)       not null default '',
    ctime   timestamp                   default current_timestamp,
    mtime   timestamp                   default current_timestamp
);
comment on column post_info.pid is '文章唯一编号';
comment on column post_info.uid is '文章作者uid';
comment on column post_info.title is '文章标题';
comment on column post_info.summary is '文章摘要';
comment on column post_info.ctime is '创建时间';
comment on column post_info.mtime is '修改时间';

create table post_body
(
    id      bigint primary key not null,
    pid     bigint             not null,
    content text,
    ctime   timestamp default current_timestamp,
    mtime   timestamp default current_timestamp
);
comment on column post_body.pid is '文章唯一编号';
comment on column post_body.content is '文章内容';
comment on column post_body.ctime is '创建时间';
comment on column post_body.mtime is '修改时间';
create index IDX_POST_BODY_ON_PID on post_body (pid);
