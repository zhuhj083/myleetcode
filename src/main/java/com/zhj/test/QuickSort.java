package com.zhj.test;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] a , int start , int end){
        if ( a == null || a.length < 1 || start >= a.length || end <= 0  || start >= end){
            return;
        }

        int t = a[start];
        int i = start;
        int j = end ;

        while (i < j){
            //从尾部开始，找到一个比t小的元素
            while (i < j){
                if (a[j] < t)
                    break;
                j--;
            }

            //找到一个比t大的元素
            while (i < j){
                if (a[i] > t)
                    break;
                i++;
            }

            // 交换i和j位置的元素
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }

        int temp = a[j];
        a[j] = a[start];
        a[start] = temp;

        quickSort( a , start , j -1  );
        quickSort(a,j + 1 , end);

    }

    public static void printArray(int[] a){
        for (int i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int count = 10;
        int[]b = new int[count];
        for (int i = 0; i < count; i++) {
            b[i] = new Random().nextInt(100000);
        }
        printArray(b);

        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
           a[i] = b[i];
        }
        printArray(a);


        System.out.println("---------------------");

        long start = System.currentTimeMillis();
        quickSort(b,0,b.length - 1);
        long end1 = (System.currentTimeMillis() - start);
        printArray(b);

        start = System.currentTimeMillis();
        Arrays.sort(a);
        long end2 = (System.currentTimeMillis() - start);
        printArray(a);

        System.out.println("------------------cost1=" + end1);
        System.out.println("------------------cost2=" + end2);

    }
}
