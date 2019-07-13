package com.yin.dubboconsumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DubboConsumerApplication {

    public static void main(String[] args) {

        int[] arry = new int[]{34, 12, 43, 12, 5, 23, 8, 7, 56, 233, 89, 54};
        sort(arry, 0, arry.length-1);
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partion(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j+1, hi);
    }

    public static int partion(int[] arry, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = arry[lo];
        while (true) {
            while (arry[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < arry[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arry, i, j);
        }
        exch(arry, lo, j);
        return j;
    }

    private static void exch(int[] arry, int i, int j) {
        int v = arry[i];
        arry[i] = arry[j];
        arry[j] = v;
    }

}

