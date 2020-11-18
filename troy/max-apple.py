from typing import List

def solution(A):
    curr_weight = A[0]
    weights = A[1:]
    weights.sort()
    apples = 0
    for w in weights:
        if curr_weight + w <= 5000:
            apples += 1
            curr_weight += w
    return apples

if __name__ == '__main__':
    A = [4850, 100, 30, 30, 100, 50, 100]
    print(solution(A))
