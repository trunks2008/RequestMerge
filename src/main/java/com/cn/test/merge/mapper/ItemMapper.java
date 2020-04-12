package com.cn.test.merge.mapper;

import com.cn.test.merge.entity.Item;

import java.util.List;

public interface ItemMapper {
    int insert(Item record);

    int insertSelective(Item record);

    Item selectByCode(String code);

    List<Item> selectByCodes(List<String> codes);
}