package com.company;

import java.util.HashMap;

class Solution {
    boolean canPalinDrome(char[] cArr) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : cArr) {
            countMap.putIfAbsent(c, 0);
            int count = countMap.get(c);
            countMap.put(c, count + 1);
        }
        boolean foundOdd = false;
        for (char c : countMap.keySet()) {
            if (countMap.get(c) % 2 != 0) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    boolean isPermutePalin(String s) {
        s = s.replaceAll(" ", "").toLowerCase();
        return canPalinDrome(s.toCharArray());
    }
}

public class Main {

    public static void main(String[] args) {
	    Solution sol = new Solution();
	    String s = "Tact Coa";
	    boolean res = sol.isPermutePalin(s);
        System.out.println(res);
    }
}
