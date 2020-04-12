package com.cn.test.merge.test;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTask  extends RecursiveTask<Integer> {
    private int arr[];
    private int start;
    private int end;

    private static final int MAX = 500;

    public ForkJoinTask(int[] arr, int start, int end){
        this.arr=arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        if((end - start) < MAX) {
            //直接做业务工作
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }   else{
            //继续拆分
            int middle = (start + end) / 2;
            ForkJoinTask left=new ForkJoinTask(arr, start, middle);
            ForkJoinTask right=new ForkJoinTask(arr, middle, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
}
