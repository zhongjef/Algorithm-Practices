package com.company;

class Solution {
    // assume that source is 1 character longer than target
    boolean isInsert(String source, String target) {
        int foundInsert = 0;
        int i = 0;
        while (i < source.length()) {
            if (source.charAt(i) != target.charAt(i + foundInsert)) {
                if (foundInsert > 0) {
                    return false;
                }
                i--;
                foundInsert = 1;
            }
            i++;
        }
        return true;
    }

    // assume source and target of equal length
    boolean isReplace(String source, String target) {
        boolean foundReplace = false;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                if (foundReplace) {
                    return false;
                }
                foundReplace = true;
            }
        }
        return foundReplace;
    }

    boolean isOneAway(String source, String target) {
        int ls = source.length(), lt = target.length();
        if (Math.abs(ls - lt) > 1) {
            return false;
        }
        if (ls > lt) {
            return isInsert(target, source);
        } else if (ls < lt) {
            return isInsert(source, target);
        } else {
            return isReplace(source, target);
        }
    }
}

public class Main {

    public static void main(String[] args) {
	    Solution sol = new Solution();
	    String source = "pale";
	    String target = "bake";
	    boolean res = sol.isOneAway(source, target);
        System.out.println(res);
    }
}
