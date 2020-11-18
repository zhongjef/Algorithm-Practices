class Solution:
    """
    @param A: an integer array
    @param target: An integer
    @param k: An integer
    @return: an integer array
    """
    # Find the greatest element <= target  
    def findFloor(self, A, target):
        left, right = 0, len(A) - 1
        while left + 1 < right:
            mid = left + (right - left) // 2
            print(left, right, mid)
            if A[mid] < target:
                left = mid
            elif A[mid] > target:
                right = mid
            else:
                return mid
        if A[left] == target:
            return left
        if A[right] == target:
            return right
        if A[left] < target < A[right]:
            return left
        if A[left] > target:
            return left
        # A[right] < target
        else:
            return right

    def diff(self, m, n, target):
        return abs(m - target) - abs(n - target) 
    
    def kClosestNumbers(self, A, target, k):
        left = self.findFloor(A, target)
        right = left + 1
        nums = []
        for _ in range(k):
            if left < 0:
                nums.append(A[right])
                right += 1
                continue
            if right > len(A) - 1:
                nums.append(A[left])
                left -= 1
                continue
            if self.diff(A[left], A[right], target) > 0:
                nums.append(A[right])
                right += 1
            else:
                nums.append(A[left])
                left -= 1
        return nums

if __name__ == "__main__":
    A = [1,10,15,25,35,45,50,59]
    target = 30
    k = 7
    sol = Solution()
    res = sol.kClosestNumbers(A, target, k)
    print(res)