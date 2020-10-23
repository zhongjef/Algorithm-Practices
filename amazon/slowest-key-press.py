from typing import *

class Solution:

    def slowestKey(self, keyTimes: List[List[int]]) -> str:
        if not keyTimes or not keyTimes[0]:
            return ""
        max_key = keyTimes[0][0]
        max_t = keyTimes[0][1]
        for i in range(1, len(keyTimes)):
            curr_key = keyTimes[i][0]
            curr_t = keyTimes[i][1] - keyTimes[i - 1][1]
            if curr_t > max_t:
                max_key = curr_key
                max_t = curr_t
        return chr(ord('a') + max_key)


if __name__ == "__main__":
    sol = Solution()
    keyTimes = [[0, 2], [1, 5], [0, 9], [2, 15]]
    res = sol.slowestKey(keyTimes)
    print(res)
