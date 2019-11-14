package easy;

public class _0027 {
    private int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0027 Sol = new _0027();
        int res = Sol.removeElement(new int[] {0,1,2,2,3,0,4,2}, 2);
        System.out.println(res);
    }
}
