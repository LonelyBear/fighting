package com.yang.fighting.sort;

import java.util.ArrayList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/2 11:36
 * @description
 */

/**
 * 1.人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
 * 2.遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 3.对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
 * 4.从不是空的桶里把排好序的数据拼接起来。
 *
 * 注：如果递归使用桶排序为各个桶排序，则当桶数量为1时要手动减小BucketSize增加下一循环桶的数量，否则会陷入死循环，导致内存溢出。
 */

public class BucketSort {

    /**
     * 桶排序
     *
     * @param array
     * @param bucketSize
     * @return
     */
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (Integer value : array) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (Integer integer : array) {
            bucketArr.get((integer - min) / bucketSize).add(integer);
        }
        for (int i = 0; i < bucketCount; i++) {
            // 如果带排序数组中有重复数字时
            if (bucketSize == 1) {
                resultArr.addAll(bucketArr.get(i));
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                resultArr.addAll(temp);
            }
        }
        return resultArr;
    }


}
