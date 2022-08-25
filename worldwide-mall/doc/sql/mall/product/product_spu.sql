create table product_spu
(
    created_time datetime      not null comment '创建时间',
    updated_time datetime      null comment '更新时间',
    created_by   bigint        not null comment '创建人',
    updated_by   bigint        null comment '更新人',
    deleted      int default 1 not null comment '是否删除;0->已删除;1->未删除;',
    status       int default 1 not null comment '开启状态;0->禁用;1->启用;',
    id           bigint        not null comment '商品SPU编码'
        primary key,
    name         varchar(90)   not null comment '商品名称',
    sell_point   varchar(255)  null comment '卖点',
    description  varchar(255)  null comment '描述',
    category_id  bigint        not null comment '分类编码',
    brand_id     bigint        not null comment '品牌编码',
    pic_urls     varchar(900)  null comment '商品主图地址',
    sort         int           not null comment '排序',
    like_count   int default 0 not null comment '点赞初始人数',
    price        int           not null comment '商品价格',
    quantity     int           not null comment '库存数量'
)
    comment '商品SPU表';

