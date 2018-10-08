package com.hanhan.test1.controller;

import java.math.BigDecimal;

/**
 *测试没有get和set方法但是field是public的时候是否能用json序列化
 * */
public class TestEntity {
    public String k="";
    public BigDecimal b;
}
