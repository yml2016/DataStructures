package com.yang.datastructures.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, -6, 8, -3, 4, 9, 7};
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1,tmp);

        System.out.println("排序后的数组："+ Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, tmp);
            mergeSort(arr, mid + 1, right, tmp);
            merge(arr, left, mid, right, tmp);

        }

    }

    private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        //int[] tmp = new int[a.length];//辅助数组
        int p1 = left, p2 = mid + 1, k = left;//p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2])
                tmp[k++] = arr[p1++];
            else
                tmp[k++] = arr[p2++];
        }

        while (p1 <= mid) tmp[k++] = arr[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= right) tmp[k++] = arr[p2++];//同上

        //复制回原素组
        for (int i = left; i <= right; i++)
            arr[i] = tmp[i];

    }
}
