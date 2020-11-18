from collections import Counter
class Solution1:
    """
    @param paragraph: 
    @param banned: 
    @return: nothing
    """
    def mostCommonWord(self, paragraph, banned):
        if not paragraph:
            return None
        banned_set = set(banned)
        paragraph = paragraph.lower()
        alpha_space = ""
        for c in paragraph:
            if c.isalnum() or c == ' ':
                alpha_space += c
        words = alpha_space.split()
        counter = Counter(words)
        max_occur = -1
        max_word = ""
        for w in counter:
            if w not in banned_set:
               if counter[w] >= max_occur:
                   max_occur = counter[w]
                   max_word = w
        return max_word

import re
class Solution:
    """
    @param paragraph: 
    @param banned: 
    @return: nothing
    """
    def mostCommonWord(self, paragraph, banned):
        ban = set(banned)
        words = re.findall(r'\w+', paragraph.lower())
        return Counter(w for w in words if w not in ban).most_common(1)[0][0]

if __name__ == '__main__':
    sol = Solution()
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    res = sol.mostCommonWord(paragraph, banned)
    print(res)