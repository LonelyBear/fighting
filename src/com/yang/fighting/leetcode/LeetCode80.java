package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/10 15:15
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/ 80. 删除有序数组中的重复项 II
 */

public class LeetCode80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int left = 2, right = 2;
        Pair pair;
        if (nums[1] == nums[0]) {
            pair = Pair.of(nums[1], 2);
        } else {
            pair = Pair.of(nums[1], 1);
        }
        for (; right < nums.length; right++) {
            if (nums[right] != pair.getNum()) {
                nums[left] = nums[right];
                pair = Pair.of(nums[left], 1);
                left++;
            } else if (pair.getSize() < 2) {
                nums[left] = nums[right];
                pair.pairAdd();
                left++;
            }
        }
        return left;
    }

    public static class Pair{
        private int num;
        private int size;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Pair() {
        }

        public static Pair of(int num, int size) {
            Pair pair = new Pair();
            pair.setNum(num);
            pair.setSize(size);
            return pair;
        }

        public void pairAdd () {
            this.setSize(this.getSize() + 1);
        }


    }
}
