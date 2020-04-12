package com.cn.test.merge.service;

import com.cn.test.merge.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ItemService {

    public void addItem(Item item);

    Item queryByCode(String id);

    public List<Map<String, Object>> queryByCodes(List<String> codes);



}
