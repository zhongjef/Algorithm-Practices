from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for i in range(m)]
        
        for j in range(n):
            dp[0][j] = matrix[0][j]    
        for i in range(m):
            dp[i][0] = matrix[i][0]
        
        max_side = 0
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 1:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
                    max_side = max(dp[i][j], max_side)

        if max_side == 0:
            max_side = max(matrix[0])
            for i in range(m):
                max_side = max(max_side, matrix[i][0])
        return max_side * max_side

if __name__ == '__main__':
    mat = [[0, 1, 1, 1, 0],
            [1, 0, 0, 0, 0],
            [0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0]]

    sol = Solution()
    res = sol.maximalSquare(mat)
    print(res)
