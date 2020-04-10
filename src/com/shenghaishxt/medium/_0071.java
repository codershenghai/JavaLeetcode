package com.shenghaishxt.medium;

import java.util.Stack;

public class _0071 {
    // 使用"/"来分割字符串，然后使用栈来存储需要的字符串
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strings) {
            if (str.equals("") || str.equals(".") || (str.equals("..") && stack.isEmpty()))
                continue;
            else if (str.equals(".."))
                stack.pop();
            else stack.push(str);
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            if (i != stack.size()-1)
                sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _0071().simplifyPath("/home/"));
        System.out.println(new _0071().simplifyPath("/../"));
        System.out.println(new _0071().simplifyPath("/home//foo/"));
        System.out.println(new _0071().simplifyPath("/a/./b/../../c/"));
        System.out.println(new _0071().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new _0071().simplifyPath("/a//b////c/d//././/.."));
    }
}
