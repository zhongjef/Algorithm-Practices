"""
Definition of TreeNode:
"""
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


class Solution:
    def __init__(self):
        self.data = ""
    def serialize(self, root):
        if not root:
            return ""
        self.data += str(root.val)
        if root.left:
            self.data += root

    def deserialize(self, data):
