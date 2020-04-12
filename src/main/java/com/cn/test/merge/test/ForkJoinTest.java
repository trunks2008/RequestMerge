package com.cn.test.merge.test;

import com.cn.test.merge.entity.Item;
import com.cn.test.merge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ForkJoinPool;

@Controller
public class ForkJoinTest {

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping("/single")
    public int single() {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += itemService.queryByCode(i + "").getPrice();
        }
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        return sum;
    }

    @ResponseBody
    @RequestMapping("/fork")
    public int forkJoin() {
        long startTime = System.currentTimeMillis();
        int arr[] = new int[10000];
        for (int i = 0; i < 1000; i++) {
            arr[i]=i;
        }

        ForkJoinPool pool=new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ForkJoinTask task=new ForkJoinTask(arr,0,arr.length);
        Integer sum =  pool.invoke(task);
        System.out.println(sum);

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        return sum;
    }


}
