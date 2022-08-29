create table product_property_value
(
    created_time datetime      not null comment '创建时间',
    updated_time datetime      null comment '更新时间',
    created_by   bigint        not null comment '创建人',
    updated_by   bigint        null comment '更新人',
    deleted      int default 1 not null comment '是否删除;0->已删除;1->未删除;',
    status       int default 1 not null comment '开启状态;0->禁用;1->启用;',
    id           bigint        not null comment '规格值编码'
        primary key,
    property_id   bigint        not null comment '规格编码',
    name         varchar(90)   not null comment '规格值名称',
    constraint property_value
        unique (property_id, name)
)
    comment '商品规格值表';

