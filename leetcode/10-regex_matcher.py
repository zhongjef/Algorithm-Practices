class RegexMatcher:
    # depth first search + memorization
    def match(self, input: str, pattern: str) -> bool:
        return self.match_helper(input, 0, pattern, 0, {})

    # return whether input's suffix from i can match pattern's suffix from j
    def match_helper(self, input, i, pattern, j, memo):
        if (i, j) in memo:
            return memo[(i, j)]
        # input is empty
        if len(input) == i:
            return self.is_empty(pattern[j:])
        if len(pattern) == j:
            return False
        if j + 1 < len(pattern) and pattern[j + 1] == '*':
            matched = self.match_char(input[i], pattern[j]) and \
                      self.match_helper(input, i + 1, pattern, j, memo) or \
                      self.match_helper(input, i, pattern, j + 2, memo)
        else:
            matched = self.match_char(input[i], pattern[j]) and \
                      self.match_helper(input, i + 1, pattern, j + 1, memo)
        memo[(i, j)] = matched
        return matched

    def match_char(self, input, pattern):
        return input == pattern or pattern == '.'

    def is_empty(self, pattern):
        if len(pattern) % 2 == 1:
            return False

        for i in range(len(pattern) // 2):
            if pattern[i * 2 + 1] != '*':
                return False
        return True


if __name__ == '__main__':
    matcher = RegexMatcher()
    my_input = "*****....."
    pattern = ".*"
    print(matcher.match(my_input, pattern))
