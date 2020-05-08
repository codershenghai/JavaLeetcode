package com.shenghaishxt.hard;

public class _0154 {
    /**
     * 主体和上题基本一致，只是在二分查找失效时改用顺序查找。
     */
    public int findMin(int[] numbers) {
        int left = 0, right = numbers.length-1, mid;
        while (left+1 < right) {
            mid = (left + right) >> 1;
            if (numbers[mid] > numbers[right]) left = mid;
            else if (numbers[mid] < numbers[right]) right = mid;
            else return minArrayOrder(numbers);
        }
        return Math.min(numbers[left], numbers[right]);
    }

    private int minArrayOrder(int[] numbers) {
        int minVal = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < minVal) {
                minVal = num;
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        System.out.println(new _0154().findMin(new int[] {0,0,0}));
    }
}
