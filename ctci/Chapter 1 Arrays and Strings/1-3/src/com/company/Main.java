package com.company;

class Solution {
    String URLify(String s) {
        char[] content = s.toCharArray();
        int numSpace = countSpace(content);

        char[] newContent = new char[content.length + numSpace * 2];
        int j = 0;
        for (int i = 0; i < content.length; i++) {
            if (content[i] == ' ') {
                newContent[j] = '%';
                newContent[j+1] = '2';
                newContent[j+2] = '0';
                j += 3;
            } else {
                newContent[j] = content[i];
                j++;
            }
        }
        return new String(newContent);
    }

    int countSpace(char[] arr) {
        int numSpace = 0;
        for (char c : arr) {
            numSpace += 1;
        }
        return numSpace;
    }

}
public class Main {

    public static void main(String[] args) {
	    Solution sol = new Solution();
	    String s = "Mr John Smith  ";
	    String res = sol.URLify(s);
        System.out.println(res);
    }
}
