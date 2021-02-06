package com.yang.fighting.sort;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/9 11:33
 * @description 堆排序
 */

/**
 *
 * 堆排序的过程
 * #  利用堆的数据结构特性: 子结点的键值和索引总是小于(或者大于)它的父结点
 * 1. 将初始的数据建立大顶堆, 此时堆为初始的无序区
 * 2. 将堆顶元素和最后一个元素交换, 得到新的无序区 (R1,R2,....,Rn-1)和有序区Rn, 对新的无序区调整为新堆,
 * 3. 不断重复2的过程,直到有序区的元素为全部元素
 *
 */
public class HeapSort {

    static int[] arr = {
            //定义待排序数组
            16, 7, 3, 20, 17, 8
    };

    public static void main(String[] args) {
        //建立大顶堆并排序
        buildHeap();
        System.out.println("排序好的为：" + Arrays.toString(arr));
    }

    private static void buildHeap() {
        int len = arr.length;
        //建立大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            sortHeap(i, len);
        }
        System.out.println("建立好的大顶堆例如以下：" + Arrays.toString(arr));
        //对大顶堆进行排序
        for (int j = len - 1; j > 0; j--) {
            swap(0, j);
            sortHeap(0, j);
        }
    }

    /**
     * 构建堆的过程
     * @param i
     * @param len
     */
    private static void sortHeap(int i, int len) {
        //定义左节点
        int left = 2 * i + 1;
        //定义右节点
        int right = 2 * i + 2;
        //存放三个节点中最大节点的下标
        int large = 0;
        //假设左孩子大于根节点 将左孩子下标赋值给large
        if (len > left && arr[left] > arr[i]) {
            large = left;
        } else {
            //否之。将根节点下标赋值给large
            large = i;
        }
        //若右孩子节点大于根节点，把右孩子节点下标赋值给large
        if (len > right && arr[right] > arr[large]) {
            large = right;
        }
        //若最大节点的下标不等于根节点的下标时，交换其值
        if (large != i) {
            swap(large, i);
            sortHeap(large, len);
        }
    }

    private static void swap(int m, int n) {
        int temp;
        temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
