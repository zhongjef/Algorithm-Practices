from typing import *

class Solution:

    def cutOffRank(self, rank: int, num: int, scores: List[int]) -> int:
        scores.sort(reverse=True)
        cutoff = scores[rank - 1]
        if cutoff != 0:
            while(rank < num and scores[rank] == cutoff):
                rank += 1
        else:
            while(rank >= 0 and scores[rank - 1] == 0):
                rank -= 1
        return rank

if __name__ == "__main__":
    sol = Solution()
    scores = [100, 50, 50, 25]
    res = sol.cutOffRank(3, scores)
    print(res)
