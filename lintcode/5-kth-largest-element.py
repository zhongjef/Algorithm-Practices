import heapq

class Solution1:
    """
    @param n: An integer
    @param nums: An array
    @return: the Kth largest element
    """
    def kthLargestElement(self, n, nums):
        if not nums or n < 1:
            return None
        for i in range(len(nums)):
            nums[i] = -nums[i]
        heapq.heapify(nums)
        res = None
        for _ in range(n):
            res = heapq.heappop(nums)
        return -res

class Solution:
    """
    @param n: An integer
    @param nums: An array
    @return: the Kth largest element
    """
    def partition(self, nums, left, right):
        pivot = nums[right]
        i = left - 1
        for j in range(left, right):
            if nums[j] > pivot:
                i = i + 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i + 1], nums[right] = nums[right], nums[i + 1]
        return i + 1

    def findk(self, nums, n, left, right):
        k = self.partition(nums, left, right)
        if k == n - 1:
            return nums[k]
        elif k > n - 1:
            return self.findk(nums, n, left, k - 1)
        else:
            return self.findk(nums, n, k + 1, right)

    def kthLargestElement(self, n, nums):
        left, right = 0, len(nums) - 1
        return self.findk(nums, n, left, right)


if __name__ == '__main__':
    n = 1
    nums = [1,3,4,2]
    sol = Solution()
    res = sol.kthLargestElement(n, nums)
    print(res)
    # sol.partition(nums, 0, 3)
    # print(nums)