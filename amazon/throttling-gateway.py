from typing import List
from collections import Counter


class Solution:
    def droppedRequests2(self, requestTime):
        # Write your code here
        ans = 0
        for i in range(3, len(requestTime)):
            if requestTime[i - 3] == requestTime[i]:
                ans += 1
                continue
            if i > 19 and requestTime[i] - requestTime[i - 20] < 10:
                ans += 1
                continue
            if i > 59 and requestTime[i] - requestTime[i - 60] < 60:
                ans += 1
                continue
        return ans

    def throttlingGateway(self, requestTime: List[int]) -> int:
        ptr_one = ptr_ten = ptr_min = 0
        num_dropped = 0
        for i, t in enumerate(requestTime):
            while t - requestTime[ptr_min] >= 60:
                ptr_min += 1
            while t - requestTime[ptr_ten] >= 10:
                ptr_ten += 1
            if t != requestTime[ptr_one]:
                ptr_one = i
            if i - ptr_min >= 60 or i - ptr_ten >= 20 or i - ptr_one >= 3:
                num_dropped += 1
        return num_dropped
    # def throttlingGateway(self, requestTime: List[int]) -> int:
    #     if not requestTime:
    #         return 0
    #
    #     dropped_total = 0
    #     req_counter = Counter(requestTime)
    #     dropped_counter = Counter()
    #     bound = max(requestTime)
    #
    #     # First pass to check each second's requests
    #     left = 1
    #     while left <= bound:
    #         # checking seconds
    #         if req_counter[left] > 3:
    #             should_drop = req_counter[left] - 3
    #             dropped_total += should_drop
    #             dropped_counter[left] = should_drop
    #         left += 1
    #
    #     # Second pass to check each 10 seconds
    #     left = 1
    #     rightOfTenSec = 1
    #     sumOfTenSec = 0
    #     while left <= bound:
    #         # check 10 seconds
    #         sumOfTenSec -= req_counter[left - 1]
    #         while rightOfTenSec < min(left + 10, bound + 1):
    #             if rightOfTenSec not in req_counter:
    #                 rightOfTenSec += 1
    #                 continue
    #             sumOfTenSec += req_counter[rightOfTenSec]
    #             if sumOfTenSec > 20:
    #                 should_drop = sumOfTenSec - 20 - dropped_counter[rightOfTenSec]
    #                 if should_drop > 0:
    #                     dropped_total += should_drop
    #                     dropped_counter[rightOfTenSec] += should_drop
    #             rightOfTenSec += 1
    #         left += 1
    #
    #     # Third pass to check each minute
    #     left = 1
    #     rightOfMin = 1
    #     sumOfMin = 0
    #     prevSumOfMin = 0
    #     while left <= bound - 59:
    #         # check 10 seconds
    #         sumOfMin -= req_counter[left - 1]
    #         while rightOfMin < min(left + 60, bound + 1):
    #             if rightOfMin not in req_counter:
    #                 rightOfMin += 1
    #                 continue
    #             sumOfMin += req_counter[rightOfMin]
    #             if sumOfMin > 60:
    #                 should_drop = sumOfMin - 60 - dropped_counter[rightOfMin]
    #                 if should_drop > 0:
    #                     dropped_total += should_drop
    #                     dropped_counter[rightOfMin] += should_drop
    #             rightOfMin += 1
    #         left += 1
    #
    #     print(req_counter)
    #     print("dropped", dropped_counter)
    #     return dropped_total


if __name__ == "__main__":
    requestTime = []
    for i in range(1, 15 + 1):
        requestTime.append(i)
        requestTime.append(i)
        requestTime.append(i)
        requestTime.append(i)
    # requestTime = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11]
    sol = Solution()
    res = sol.droppedRequests2(requestTime)
    print(res)
    # counter = Counter(requestTime)
    # counter[7] = 1
    # print(counter[7])
