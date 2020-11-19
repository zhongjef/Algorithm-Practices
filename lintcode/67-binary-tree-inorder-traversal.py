from TreeNode import *

class Solution:
    """
    @param root: A Tree
    @return: Inorder in ArrayList which contains node values.
    """
    def inorderTraversal(self, root):
        # write your code here
        if not root:
            return []
        return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)

if __name__ == '__main__':
    node1 = TreeNode(2)
    node1.left = TreeNode(1)
    node1.right = TreeNode(3)
    sol = Solution()
    res = sol.inorderTraversal(node1)
    print(res)
