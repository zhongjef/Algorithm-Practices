
class Solution:
    """
    @param nums: A set of numbers
    @return: A list of lists
    """
    # recursively
    def subsets(self, nums):
        # write your code here
        self.result = []
        nums.sort()
        self.search(nums, 0, [])
        return self.result
            
    def search(self, nums, index, re):
        if index == len(nums):
            self.result.append(re)
            return
        
        self.search(nums, index + 1, re)
        self.search(nums, index + 1, re + [nums[index]])


class Solution:
    """
    @param: nums: A list of integers.
    @return: A list of permutations.
    """
    def permute(self, nums):
        if not nums:
            return [[]]
            
        permutations = []
        self.dfs(nums, [], set(), permutations)
        return permutations

    def dfs(self, nums, permutation, visited, permutations):
        if len(nums) == len(permutation):
            permutations.append(list(permutation))
            return
        
        for num in nums:
            if num in visited:
                continue
            permutation.append(num)
            visited.add(num)
            self.dfs(nums, permutation, visited, permutations)
            visited.remove(num)
            permutation.pop()