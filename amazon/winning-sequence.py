from typing import List

class Solution:
    def winningSequence(self, num: int, lowerEnd: int, upperEnd: int) -> List[int]:
        if (num < 3 or num > 2 * upperEnd - 2 * lowerEnd + 1 or upperEnd - lowerEnd <= 0):
            return [-1]
        
        winSeq = []
        peek = upperEnd
        low = lowerEnd
        if (num > upperEnd - lowerEnd + 1):
            afterPeekNum = upperEnd - lowerEnd
            prePeekNum = num -  (upperEnd -  lowerEnd + 1)

            for i in range(afterPeekNum):
                winSeq.append(lowerEnd)
                lowerEnd += 1
            
            winSeq.append(lowerEnd)
            lowerEnd -= 1

            for j in range(prePeekNum):
                winSeq.append(lowerEnd)
                lowerEnd -= 1
        else:
            winSeq.append(peek - 1)
            for i in range(1, num):
                winSeq.append(peek)
                peek -= 1
        return winSeq

if __name__ == "__main__":
    
    num = 5
    lowerEnd = 3
    upperEnd = 10
    sol = Solution()
    res = sol.winningSequence(num, lowerEnd, upperEnd)
    print(res)
