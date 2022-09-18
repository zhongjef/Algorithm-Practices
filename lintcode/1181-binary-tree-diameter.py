"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: a root of binary tree
    @return: return a integer
    """
    def __init__(self):
        self.max = 0
    
    def maxDepth(self, root):
        if not root:
            return 0
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        # did not left + right + 1 since we count path not number of nodes along path 
        self.max = max(self.max, left + right)
        return max(left, right) + 1
    
    def diameterOfBinaryTree(self, root):
        self.maxDepth(root)
        return self.max
