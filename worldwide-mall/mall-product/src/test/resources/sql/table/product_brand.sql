DROP TABLE IF EXISTS `product_brand`;
create table product_brand
(
    created_time datetime      not null comment '创建时间',
    updated_time datetime      null comment '更新时间',
    created_by   bigint        not null comment '创建人',
    updated_by   bigint        null comment '更新人',
    deleted      int default 1 not null comment '是否删除;0->已删除;1->未删除;',
    status       int default 1 not null comment '开启状态;0->禁用;1-启用;',
    id           bigint auto_increment comment '品牌编码'
        primary key,
    name         varchar(90)   not null comment '品牌名称',
    banner_url   varchar(255)  not null comment '品牌图片链接',
    sort         int           not null comment '排序',
    description  varchar(255)  null comment '品牌描述',
    constraint name
        unique (name)
);

