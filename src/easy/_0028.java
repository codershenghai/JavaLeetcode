package easy;

public class _0028 {
    private int strStr(String haystack, String needle) {
        if (needle.equals("") || haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length() && i+needle.length()-1 < haystack.length(); i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _0028 Sol = new _0028();
        int res = Sol.strStr("aaaaa", "bba");
        System.out.println(res);
    }
}
