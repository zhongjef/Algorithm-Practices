class Solution:
    def numIslands(self, grid):
        if not grid or not grid[0]:
            return 0
        row, col = len(grid), len(grid[0])
        count = 0
        
        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1:
                    count += 1
                    self.flooding(grid, i, j)
        return count

    def flooding(self, grid, i, j):
        row_len = len(grid)
        col_len = len(grid[0])
        if grid[i][j] == 1:
            grid[i][j] = 0
            for row, col in [(i+1, j), (i-1, j), (i, j-1), (i, j+1)]:
                if 0 <= row < row_len and 0 <= col < col_len:
                    self.flooding(grid, row, col)

if __name__ == "__main__":
    grid = [[1,1,0,0,0],
            [0,1,0,0,1],
            [0,0,0,1,1],
            [0,0,0,0,0],
            [0,0,0,0,1]]
    sol = Solution()
    res = sol.numIslands(grid)
    print(res)