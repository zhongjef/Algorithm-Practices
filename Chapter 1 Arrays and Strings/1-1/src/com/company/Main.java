package com.company;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
//    // Extra data structure
//    boolean isUnique(String s) {
//        HashMap<Character, Boolean> existenceMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (existenceMap.containsKey(c)) {
//                return false;
//            } else {
//                existenceMap.put(c, true);
//            }
//        }
//        return true;
//    }

    // No extra data structure, O(nlogn) sorting, O(n) extra space
    boolean isUnique(String s) {
        if (s.length() <= 1) {
            return true;
        }
        char c[] = s.toCharArray();
        Arrays.sort(c);
        for (int i = 1; i < s.length(); i++) {
            if (c[i] == c[i - 1]) {
                return false;
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
	    Solution sol = new Solution();
	    String s = "11";
        boolean res = sol.isUnique(s);
        System.out.println(res);
    }
}
