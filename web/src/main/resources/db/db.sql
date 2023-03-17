create
database Knowledge_Fragment_Index;

use
knowledge_fragment_index;
create table `Knowledge_Fragment_Basic_Info`
(
    `Id`                     bigint(20) not null comment '自增主键',
    `info_id`                varchar(50)           default null comment '知识碎片主键',
    `info_type`              varchar(20)           default null comment '信息的类型（url、文章、片段、一言）',
    `source`                 varchar(50)           default null comment '来源（社区、公众号、git等）',
    `uri`                    varchar(500)          default null comment '资源所在的uri',
    `summary`                text(1000) default null comment '摘要',
    `tags`                   varchar(200)          default null comment '自定义tags（逗号分隔）',
    `data_change_crate_time` timestamp(3) not null default current_timestamp(3) comment '创建时间',
    `data_change_last_time`  timestamp(3) not null default current_timestamp(3) on update current_timestamp (3) comment '数据更新时间',


    primary key (`Id`),
    unique key `udx_info_id` (`info_id`),
    key                      `idx_tags` (`tags`)
) engine = innoDB default charset = utf8mb4 comment '知识碎片基础信息';


use
knowledge_fragment_index;
create table `Knowledge_Fragment_Tag_Info`
(
    `Id`                     bigint(20) not null comment '自增主键',
    `tag_id`                 varchar(50)           default null comment '知识碎片Tag主键(uuid)',
    `tag`                    varchar(20)           default null comment 'tag',
    `data_change_crate_time` timestamp(3) not null default current_timestamp(3) comment '创建时间',
    `data_change_last_time`  timestamp(3) not null default current_timestamp(3) on update current_timestamp (3) comment '数据更新时间',


    primary key (`Id`),
    unique key `udx_tag` (`tag`)
) engine = innoDB default charset = utf8mb4 comment '知识碎片Tag信息'