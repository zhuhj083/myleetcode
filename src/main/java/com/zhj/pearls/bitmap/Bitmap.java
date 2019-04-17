package com.zhj.pearls.bitmap;

import java.util.Arrays;

/**
 * 现在有n个无重复的正整数（n 小于10的7次方），如果内存限制在1.5M以内，要求对着n个数进行排序
 */
public class Bitmap {
    private static final int BITSPERWORD = 32;
    private static final int SHIFT = 5 ;

    /**
     * 00011111 --> 31 ;
     */
    private static final int MASK = 0x1F;

    /**
     * 10^7 1000万
     */
    private static int N = 10000000;
    private static int[] a = new int[1 +  N / BITSPERWORD ];

    // 00000000 00000000 00000000 00011111

    //n在数组中的位置为 a[n >> 5 ][a % 32]
    // 例如 133 ,133 >> 5 (即 133/32 = 4 ),说明133 在a[4]上，  a[0] a[1] a[2] a[3] 一共128位 所以在a[4]的 第4位上（0 1 2 3 4）
    // a[0] --> 0  ~ 31
    // a[1] --> 32 ~ 63
    // a[2] --> 64 ~ 95
    // a[3] --> 96 ~ 127
    // n & 0x1F 等价于  n % 32
    public static  void set(int n){
        a[ n >> SHIFT ] |= (1 << ( n & MASK ));     // 1是2^0,代表第0位，n & MASK 表示在第几位， << 左移
    }

    public static void clr(int n){
        a[ n >> SHIFT ] &= ~(1 << ( n & MASK ));     // 1是2^0,代表第0位，n & MASK 表示在第几位， << 左移
    }

    public static boolean test(int n){
        return (a[ n >> SHIFT ] &  (1 << ( n & MASK ))) != 0 ;
    }

    public static void main(String[] args) {
        int k = 1000000;
        int n = 10000000;
        int[] a = RandomIntUtil.getRandomArray(n,k);

        for (int i : a) {
            //System.out.print(i +" ");
        }
        System.out.println("create nums done");


        long start = System.currentTimeMillis();
        int i ;
        for (i = 0 ; i < N ; i++){
            clr(i);
        }

        for (int s : a) {
            set(s);
        }

        for (i = 0 ; i < N ; i++){
            if (test(i)){
                //System.out.print(i + " ");
            }
        }
        System.out.println("bitmap sort done! cost=" + (System.currentTimeMillis() - start ));

        start = System.currentTimeMillis();
        Arrays.sort(a);
        System.out.println("Arrays.sort done! cost=" + (System.currentTimeMillis() - start ));


    }

}
