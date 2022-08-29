create table product_sku
(
    created_time   datetime      not null comment '创建时间',
    updated_time   datetime      null comment '更新时间',
    created_by     bigint        not null comment '创建人',
    updated_by     bigint        null comment '更新人',
    deleted        int default 1 not null comment '是否删除;0->已删除;1->未删除;',
    status         int default 1 not null comment '开启状态;0->禁用;1->启用;',
    id             bigint        not null comment '商品sku编码'
        primary key,
    spu_id         bigint        not null comment '商品spu编码',
    properties     varchar(900)  null comment '规格值数组;为JSON数组格式',
    price          int           not null comment '销售价格;单位：分',
    original_price int           not null comment '原价;单位：分',
    cost_price     int           not null comment '成本价;单位：分',
    bar_code       varchar(255)  null comment '条形码',
    pic_url        varchar(255)  not null comment '图片地址',
    constraint spu_sku
        unique (spu_id, id)
)
    comment '商品SKU表';

