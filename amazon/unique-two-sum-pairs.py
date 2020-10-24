from typing import List

class Solution:
    def uniqueTwoSumPairs(self, num: int, itemValues: List[int], target: int) -> int:
        num_pool = set()
        pairs = set()
        for m in itemValues:
            n = target - m
            if n in num_pool:
                if (m, n) not in pairs:
                    pairs.add((m, n))
                    pairs.add((n, m))
            else:
                num_pool.add(m)
        return len(pairs) // 2

if __name__ == "__main__":
    
    itemValues = [1, 5, 1, 5]
    num = len(itemValues)
    target = 6
    sol = Solution()
    res = sol.uniqueTwoSumPairs(num, itemValues, target)
    print(res)
