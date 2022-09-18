"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: root of the given tree
    @return: whether it is a mirror of itself 
    """
    def isSymmetricST(self, left, right):
        if left and not right:
            return False
        if right and not left:
            return False
        if not left and not right:
            return True
        if left.val != right.val:
            return False
        return self.isSymmetricST(left.left, right.right) and self.isSymmetricST(left.right, right.left)

    def isSymmetric(self, root):
        if not root:
            return True
        return self.isSymmetricST(root.left, root.right)
        