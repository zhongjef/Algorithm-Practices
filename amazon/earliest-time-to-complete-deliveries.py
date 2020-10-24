from typing import *

class Solution:

    def earliestTime(self, numOfBuildings: int, buildingOpenTime: List[int], offloadTime: List[int]) -> int:
        buildingOpenTime.sort()
        offloadTime.sort()
        finish = 0
        for i in range(numOfBuildings):
            finish = max(finish, buildingOpenTime[i] + offloadTime[4 * numOfBuildings - 4 * i - 1])
        return finish


if __name__ == "__main__":
    sol = Solution()
    numOfBuildings = 2
    buildingOpenTime = [8, 10]
    offloadTime = [2, 2, 3, 1, 8, 7, 4, 5]
    res = sol.earliestTime(numOfBuildings, buildingOpenTime, offloadTime)
    print(res)




