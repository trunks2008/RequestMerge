package com.cn.test.merge.controller;

import com.cn.test.merge.entity.Item;
import com.cn.test.merge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping("/insert")
    public void insert(){
        Item item=new Item();
        for (int i = 0; i <10000 ; i++) {
            item.setId(i+"");
            item.setPrice(i);
            itemService.addItem(item);
        }
    }


}
