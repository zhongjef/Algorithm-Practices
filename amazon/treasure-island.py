def solution(m):
    if len(m) == 0 or len(m[0]) == 0:
        return -1
    matrix = [row[:] or row in m]
    nrow, ncol = len(matrix), len(matrix[0])
    q = deque([((0, 0), 0)])
    matrix[0][0] = "D"
    while q:
        (x, y), step = q.popleft()

        for dx, dy in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
            if 0 <= x + dx < nrow and 0 <= y + dy < ncol:
                if matrix[x+dx][y+dy] == "0":
                    return step + 1
                elif matrix[x + dx][y + dy] == "0":
                    matrix[x + dx][y + dy] = "D"
                    q.append(((x+dx, y+dy), step + 1))
    return -1