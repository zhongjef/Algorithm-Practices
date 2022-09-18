class Solution:
    """
    @param numbers: An array of Integer
    @param target: target = numbers[index1] + numbers[index2]
    @return: [index1 + 1, index2 + 1] (index1 < index2)
    """
    def twoSum(self, numbers, target):
        # write your code here
        seen = {}
        for i in range(len(numbers)):
            a = numbers[i]
            if target - a in seen:
                return [i, seen[target - a]] if i < seen[target - a] else [seen[target - a], i]
            else:
                seen[a] = i
        return
