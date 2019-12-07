package com.shenghaishxt.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 和_0001不同之处在于：本题的输入数组是升序排列的，而_0001的输入数组没有限定是升序排列或是降序排列
public class _0167 {
    private int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[] {i+1, j+1};
            }
        }
        return null;
    }

    private int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i]))
                return new int[] {map.get(target - numbers[i])+1, i+1};
            else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }

    private int[] twoSum3(int[] numbers, int target) {
        int head = 0, tail = numbers.length-1;
        while (numbers[head] + numbers[tail] != target) {
            if (numbers[head] + numbers[tail] > target)
                tail--;
            else head++;
        }
        return new int[] {head+1, tail+1};
    }

    public static void main(String[] args) {
        _0167 Sol = new _0167();
//        int[] res = Sol.twoSum2(new int[] {0,0,3,4}, 0);
        int[] res = Sol.twoSum3(new int[] {2,7,11,15}, 9);
        System.out.println(Arrays.toString(res));
    }
}
