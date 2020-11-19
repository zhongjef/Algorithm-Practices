"""
Definition of TreeNode:
"""
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

    def __str__(self, indent: str="") -> str:
        """
        Return a user-friendly string representing Tree.
        """
        right_tree = self.right.__str__(indent + '    ') if self.right else ''
        left_tree = self.left.__str__(indent + '    ') if self.left else ''
        return right_tree + '{}{}\n'.format(indent, str(self.val)) + left_tree
