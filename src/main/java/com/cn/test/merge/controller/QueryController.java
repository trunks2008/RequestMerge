package com.cn.test.merge.controller;

import com.cn.test.merge.entity.Item;
import com.cn.test.merge.service.BatchQueryService;
import com.cn.test.merge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class QueryController {

    @Autowired
    BatchQueryService queryService;

    @Autowired
    ItemService itemService;

    @ResponseBody
    @RequestMapping("/query")
    public void singleQuery(){
        for (int i = 0; i <1000 ; i++) {
            Item item = itemService.queryByCode(i + "");
        }
    }

    @ResponseBody
    @RequestMapping("/singleQuery")
    public void singleQuery2(){
        Item item = itemService.queryByCode("1");
    }

    @ResponseBody
    @RequestMapping("/batchQuery")
    public String batchQuery(){
        Thread thread[]=new Thread[1000];
        for (int i = 0; i <1000 ; i++) {
            int j=i;
            thread[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    queryService.queryItem(j + "");
                }
            });
            thread[i].start();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "ok";
    }

}
