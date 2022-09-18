class Solution:
    def combinationSum2(self, candidates, target):
        candidates.sort()
        result = []
        self.dfs(candidates, 0, [], result, target)
        return result

    def dfs(self, candidates, start, path, result, target):
        if not target:
            result.append(path)
            return

        for i in range(start, len(candidates)):
            if i > start and candidates[i] == candidates[i - 1]:
                continue
            if candidates[i] > target:
                break
            self.dfs(candidates, i + 1, path + [candidates[i]], result, target - candidates[i])
