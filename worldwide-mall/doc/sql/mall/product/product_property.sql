create table product_property
(
    created_time datetime      not null comment '创建时间',
    updated_time datetime      null comment '更新时间',
    created_by   bigint        not null comment '创建人',
    updated_by   bigint        null comment '更新人',
    deleted      int default 1 not null comment '是否删除;0->已删除;1->未删除;',
    status       int default 1 not null comment '开启状态;0->禁用;1->启用;',
    id           bigint        not null comment '规格名称编码'
        primary key,
    name         varchar(90)   not null comment '规格名称',
    constraint name
        unique (name)
)
    comment '商品规格表';

