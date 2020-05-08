package com.shenghaishxt.medium;

public class _0153 {
    public int findMin(int[] numbers) {
        int left = 0, right = numbers.length-1, mid;
        while (left+1 < right) {
            mid = (left + right) >> 1;
            if (numbers[mid] > numbers[right]) left = mid;
            if (numbers[mid] < numbers[right]) right = mid;
        }
        return Math.min(numbers[left], numbers[right]);
    }

    public static void main(String[] args) {
        System.out.println(new _0153().findMin(new int[] {3,4,5,1,2}));
        System.out.println(new _0153().findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(new _0153().findMin(new int[] {0,1,2}));
        System.out.println(new _0153().findMin(new int[] {1, 2}));
    }
}
