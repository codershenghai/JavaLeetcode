package com.shenghaishxt.easy;

public class _0014 {
    private String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        _0014 Sol = new _0014();
        String res = Sol.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(res);
    }
}
