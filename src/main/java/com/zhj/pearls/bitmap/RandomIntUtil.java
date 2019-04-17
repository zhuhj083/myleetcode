package com.zhj.pearls.bitmap;

import java.util.Random;

public class RandomIntUtil {

    private static Random random = new Random();

    //返回l..u之间的一个随机数 [l,u)
    private static int randomint(int l , int r){
        return   random.nextInt(r - l ) + l ;
    }


    /**
     * 生成位于0至n-1之间的k个不同的随机顺序的随机整数
     * @param n 个数
     * @param k
     * @return
     */
    public static  int [] getRandomArray(int n , int k){
        int [] x = new int[n];
        for (int i = 0; i < n ; i++) {
            x[i] = i ;
        }

        for (int i = 0; i < k; i++) {
            int r = randomint(i , n - 1 );
            //swap(i , randomint(i,n-1) 交换x中的2个元素
            int temp = x[i];
            x[i] = x[r];
            x[r] = temp;
        }
        return x;
    }
}
