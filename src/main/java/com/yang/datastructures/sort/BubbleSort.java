package com.yang.datastructures.sort;

import java.util.Arrays;
/**
冒泡排序的时间复杂度为O(n^2)
**/
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {2, 5, 1, 6, 8, 3, 4, 9, 4};
        //int[] arr = {2, 5, 1, -6, 8, -3, 4, 9, 7};
        //int[] arr = {2};
        System.out.println("排序前的数组为"+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后的数组为"+Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr){
        boolean isSwap = false; //标示变量，表示是否进行过交换
        int tmp = 0; //临时变量，用于交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //相邻两数对比，逆序则交换
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSwap = true;
                }

            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组");
            //System.out.println(Arrays.toString(arr));

            //对排序的优化
            if (isSwap) {
                isSwap = false; //重置标识，进行下次判断
            }
            else {
                break; //在一趟排序中，一次交换都没有，则说明数组已经有序了，可以提前退出
            }

        }

    }
}
