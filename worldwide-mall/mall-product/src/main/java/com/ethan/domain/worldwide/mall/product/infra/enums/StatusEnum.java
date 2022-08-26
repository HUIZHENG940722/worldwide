package com.ethan.domain.worldwide.mall.product.infra.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum StatusEnum {
    NUMBER_0(0, "关闭"),
    
    NUMBER_1(1, "开启");

    @EnumValue
    private Integer value;

    private String description;

    StatusEnum(Integer value, String description) {
      this.value = value;
      this.description = description;
    }
  }