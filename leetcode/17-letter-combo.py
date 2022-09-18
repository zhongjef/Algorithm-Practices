from typing import List
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        self.mapping = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        solutions = []
        self.dfs("", digits, solutions)
        
    def dfs(self, path, digits, solutions):
        if len(digits) == 0:
            solutions.append(path)
            return
        cur = digits[0]
        rest = digits[1:]
        new_path = path + cur
        for char in self.mapping[int(cur)]:
            self.dfs(new_path, rest, solutions)
        
if __name__ == '__main__':
    digits = "23"
    sol = Solution()
    res = sol.letterCombinations(digits)
    print(res)