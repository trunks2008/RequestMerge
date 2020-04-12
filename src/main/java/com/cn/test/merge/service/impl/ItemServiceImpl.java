package com.cn.test.merge.service.impl;

import com.cn.test.merge.entity.Item;
import com.cn.test.merge.mapper.ItemMapper;
import com.cn.test.merge.service.ItemService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public void addItem(Item item) {
        itemMapper.insert(item);
    }

    @Override
    public Item queryByCode(String id) {
        return itemMapper.selectByCode(id);
    }

    @Override
    public List<Map<String, Object>> queryByCodes(List<String> codes) {
        List<Map<String, Object>> ret=new ArrayList<>();

        List<Item> items = itemMapper.selectByCodes(codes);
        for (Item item : items) {
            Map<String,Object> map=new HashMap();
            map.put("code",item.getId());
            map.put("value",item.getPrice());
            ret.add(map);
        }

        return ret;
    }

}
