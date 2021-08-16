DROP TABLE IF EXISTS `user_base_info`;
CREATE TABLE `user_base_info`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `uid`           int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
    `name`          varchar(36) NOT NULL DEFAULT '' COMMENT '用户呢称',
    `sex`           tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别 0:保密 1:男 2:女',
    `account_state` tinyint(4) NOT NULL DEFAULT '' COMMENT '账户状态',
    `ctime`         timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime`         timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    KEY             `ix_mtime` (`mtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

DROP TABLE IF EXISTS `post_info`;
CREATE TABLE `post_info`
(
    `id`            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `pid`           bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '文章id',
    `uid`           int(11) unsigned NOT NULL DEFAULT '0' COMMENT '作者id',
    `title`         varchar(50)  NOT NULL DEFAULT '' COMMENT '文章标题',
    `summary`       varchar(200) NOT NULL DEFAULT '' COMMENT '摘要',
    `comment_count` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
    `likes_count`   int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
    `ctime`         timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime`         timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_pid` (`pid`),
    KEY             `ix_mtime` (`mtime`),
    KEY             `ix_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';


DROP TABLE IF EXISTS `post_body`;
CREATE TABLE `post_body`
(
    `id`      bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `pid`     bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '文章id',
    `content` text COMMENT '文章内容',
    `ctime`   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mtime`   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_pid` (`pid`),
    KEY       `ix_mtime` (`mtime`),
    KEY       `ix_pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章主体表';
