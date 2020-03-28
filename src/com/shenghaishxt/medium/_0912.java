package com.shenghaishxt.medium;

import com.shenghaishxt.hard._0297;

import java.util.ArrayList;
import java.util.List;

public class _0912 {
    /**
     * 快排的思想是每趟排序都选择一个pivot，然后将所有小于pivot的数字都放到pivot的左边，
     * 大于pivot的数字都放在右边。此时左右两边的数组不一定是有序的，继续递归直到数组只有一个元素为止，
     * 此时的数组便是排好序的了。
     * 时间复杂度为O(nlogn)，空间复杂度为O(1)。
     */
    public List<Integer> sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        List<Integer> res = new ArrayList<>();
        for (int num : nums)
            res.add(num);
        return res;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int pivotPos = partition(nums, left, right);
        quickSort(nums, left, pivotPos-1);
        quickSort(nums, pivotPos+1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--; // 右边的元素大于等于pivot就可以走
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++; // 左边的元素小于等于pivot就可以走
            nums[right] = nums[left];
        }
        nums[left] = pivot; // 每趟循环都会将pivot放到最终位置
        return left; // 返回本趟循环pivot的最终位置
    }

    public static void main(String[] args) {
        _0912 Sol = new _0912();
        System.out.println(Sol.sortArray(new int[] {1,6,2,4,9,7,3}));
    }
}
