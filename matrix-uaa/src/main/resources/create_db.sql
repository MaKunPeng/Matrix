-- 用户基本信息
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`            bigint(20)   NOT NULL,
    `user_code`     varchar(64)           DEFAULT NULL COMMENT '用户帐号',
    `nick_name`     varchar(64)           DEFAULT NULL COMMENT '用户昵称',
    `sex`           char(1)               DEFAULT NULL COMMENT '性别',
    `avatar`        varchar(100)          DEFAULT NULL COMMENT '头像地址',
    `status`        int(1)                DEFAULT '1' COMMENT '帐号状态：0->禁用；1->启用',
    `created_by`    varchar(64)           DEFAULT '',
    `created_time`  timestamp(3)          DEFAULT CURRENT_TIMESTAMP(3),
    `modified_by`   varchar(64)           DEFAULT '',
    `modified_time` timestamp(3) NOT NULL DEFAULT '2020-01-01 00:00:00.000' ON UPDATE CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

-- 登录凭证表
DROP TABLE IF EXISTS `user_auths`;
CREATE TABLE `user_auths`
(
    `id`            bigint(20)   NOT NULL,
    `user_id`       bigint(20)            DEFAULT NULL,
    `identity_type` varchar(20)           DEFAULT NULL COMMENT '登录类型(手机/邮箱/QQ/微信...)',
    `identifier`    varchar(100)          DEFAULT NULL COMMENT '登录唯一标识',
    `credentials`   varchar(200)          DEFAULT NULL COMMENT '登录凭证',
    `login_ip`      varchar(64)           DEFAULT NULL COMMENT '最后登录IP',
    `login_time`    datetime              DEFAULT NULL COMMENT '最后登录时间',
    `created_by`    varchar(64)           DEFAULT '',
    `created_time`  timestamp(3)          DEFAULT CURRENT_TIMESTAMP(3),
    `modified_by`   varchar(64)           DEFAULT '',
    `modified_time` timestamp(3) NOT NULL DEFAULT '2020-01-01 00:00:00.000' ON UPDATE CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8 COMMENT ='用户登录凭证表';