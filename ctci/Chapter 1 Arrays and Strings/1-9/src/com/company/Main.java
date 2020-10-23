package com.company;

class Solution {
    /***
     * Return whether s2 is a rotation of s1.
     */
//    boolean isRotation(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        if (s1.length() == 0) {
//            return true;
//        }
//        int rotate = -1;
//        int j = 0;
//        for (int i = 0; i < s2.length(); i++) {
//            if (s2.charAt(i) == s1.charAt(j)) {
//                j++;
//                if (rotate == -1) {
//                    rotate = i;
//                }
//            } else {
//                rotate = -1;
//                j = 0;
//            }
//        }
//        if (rotate == -1) {
//            return false;
//        }
//        return this.isSubstring(s1, s2.substring(0, rotate));
//    }
    boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        return this.isSubstring(s1 + s1, s2);
    }

    /***
     * Return whether s2 is a substring of s1.
     */
    boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}

public class Main {

    public static void main(String[] args) {
	    Solution sol = new Solution();
	    String s1 = "";
	    String s2 = "";
	    boolean res = sol.isRotation(s1, s2);
        System.out.println(res);
    }
}
