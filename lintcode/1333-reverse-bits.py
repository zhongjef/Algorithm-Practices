class Solution:
    """
    @param n: an integer
    @return: return an integer
    """
    def reverseBits(self, n):
        # write your code here
        res = 0
        for i in range(32):
            res = res << 1
            res += n & 1
            n = n >> 1
        return res

if __name__ == '__main__':
    sol = Solution()
    n = 1
    print(sol.reverseBits(n))
