package com.company;

class Solution {
    String compress(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char prev = s.charAt(0);
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                res.append(prev);
                res.append(count);
                prev = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        res.append(prev);
        res.append(count);
        return res.length() < s.length() ? res.toString() : s;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aa";
        String res = sol.compress(s);
        System.out.printf(res);
    }
}
