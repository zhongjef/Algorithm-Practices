package com.company;

import java.util.HashMap;

class Solution {
    // Does not require extra space, but slower
    String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

//    // Requires hash table
//    boolean checkPermutation(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        HashMap<Character, Integer> countMap = countChar(s1);
//        for (int i = 0; i < s1.length(); i++) {
//            Character currChar = s1.charAt(i);
//            if (countMap.containsKey(currChar)) {
//                Integer count = countMap.get(currChar);
//                countMap.put(currChar, count - 1);
//                if (count - 1 == 0) {
//                    countMap.remove(currChar);
//                }
//            } else {
//                return false;
//            }
//        }
//        return countMap.isEmpty();
//    }

    HashMap<Character, Integer> countChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer currVal = countMap.putIfAbsent(s.charAt(i), 1);
            if (currVal != null) {
                countMap.put(s.charAt(i), currVal + 1);
            }
        }
        return countMap;
    }
}

public class Main {

    public static void main(String[] args) {
	    Solution sol = new Solution();
	    String s1 = "acc";
	    String s2 = "ccaa";
	    Boolean res = sol.checkPermutation(s1, s2);
        System.out.println(res);
    }
}
