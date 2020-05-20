package com.shenghaishxt.medium;

import java.util.*;

public class _0347 {
    /**
     * 堆
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 使用HashMap统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        // 遍历map，用最大堆统计出现频率最大的k个数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        maxHeap.addAll(map.keySet());

        // 将频率最大的k个数存入数组
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) res[i] = maxHeap.poll();
        }
        return res;
    }

    /**
     * 桶排序
     */
    public int[] topKFrequent2(int[] nums, int k) {
        // 使用HashMap统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        // 桶排序，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] table = new List[nums.length+1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (table[i] == null) table[i] = new ArrayList<>();
            table[i].add(key);
        }

        // 将频率最大的k个数存入数组
        List<Integer> res = new ArrayList<>(k);
        for (int i = table.length-1; i >= 0 && res.size() < k; i--) {
            if (table[i] != null) {
                res.addAll(table[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


        public static void main(String[] args) {
        System.out.println(Arrays.toString(new _0347().topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
