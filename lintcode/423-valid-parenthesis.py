class Solution:
    """
    @param s: A string
    @return: whether the string is a valid parentheses
    """
    
    def isValidParentheses(self, s):
        LEFT_BRACKETS = ['{', '[', '(']
        # write your code here
        stack = []
        for p in s:
            if (p in LEFT_BRACKETS):
                stack.append(p)
            else:
                if not stack:
                    return False
                if p == '}' and stack[-1] != '{':
                    return False
                elif p == ']' and stack[-1] != '[':
                    return False
                elif p == ')' and stack[-1] != '(':
                    return False
                stack.pop()
        return True if len(stack) == 0 else False
