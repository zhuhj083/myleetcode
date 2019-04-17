package com.zhj.pearls.leftrotate;

/**
 * 将一个n元一维向量向左旋转i个位置（即循环移位）
 * 例如当n=8,i=3时候，向量abcdefgh旋转为defghabc
 * @author zhuhj
 */
public class LeftRotate {


    /**
     * 方法一：
     * 移动x[0]到临时变量t，然后移动x[i]至x[0],x[2i]至x[i],依次类推（将x中的所有下标对n取模）
     * 直到返回到取x[0]中的元素，此时改为从t取值然后终止过程
     * 如果该过程没有移动全部元素，就从x[1]开始，再次进行移动
     * @param x
     * @param i
     */
    public static void leftRotate1(char[] x , int i ){
        int n = x.length;
        while (i > n ) {
            i %= n;
        }

        int moved = 1 ;
        char t ;
        int start = 0 ;
        while(moved <= n ){
            t = x[ start ];
            int cur = start ;
            int next = start + i ;
            while(next % n != start){
                x[cur % n] = x[ next % n ];
                moved++;
                cur += i ;
                next += i ;
            }
            x[ cur % n ] = t ;
            moved++;

            start++ ;
        }
    }


    /**
     * 方法二：ab 分别反转为a' b' ,再反转整个a'b'
     * @param x
     * @param i
     */
    public static void leftRotate2(char[] x , int i ){
        int n = x.length;
        while (i > n ) {
            i %= n;
        }

        reverse(x,0 , i -1 );
        reverse(x , i , n - 1 );
        reverse(x,0 , n -1 );
    }

    /**
     * 反转一个数组
     * @param x
     */
    public static void reverse(char [] x,int s , int e){
        char t ;
        if (e  < s){
            return;
        }
        for (int i = s ; i <= (s + e) / 2 ; i++){
            t = x[i];
            x[i] = x[e-i+s];
            x[e-i+s] = t;
        }
    }

    public static void main(String[] args) {

//        char [] x = { '1','2', '3', '4', '5' , '6','7'};

        char [] x = {1};

        for (char s:x) {
            System.out.print(s+" ");
        }
        System.out.println();

        leftRotate2(x,7);

        for (char s:x) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
