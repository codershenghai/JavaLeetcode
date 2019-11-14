package easy;

import java.util.Arrays;
import java.util.Hashtable;

public class _0001 {
    // 暴力法
    private int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // hashtable
    private int[] twoSum2(int[] nums, int target) {
        Hashtable ht = new Hashtable();
        for (int i = 0; i < nums.length; i++) {
            ht.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(target - nums[i]) && i != (int)ht.get(target-nums[i])) {
                return new int[] {i, (int)ht.get(target-nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        _0001 Sol = new _0001();
        int[] res = Sol.twoSum2(new int[] {2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }
}
