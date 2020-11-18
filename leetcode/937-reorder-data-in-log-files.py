from typing import List
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        alphas = []
        digits = []
        for log in logs:
            word1 = log.split()[1]
            if word1.isalpha():
                alphas.append(log)
            else:
                digits.append(log)
        alphas.sort(key = lambda x: (x.split()[1:], x.split()[0]))
        return alphas + digits

if __name__ == '__main__':
    logs = ["dig1 8 1 5 1", "let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    sol = Solution()
    res = sol.reorderLogFiles(logs)
    print(res)
    print((1, 1) < (1, 2))