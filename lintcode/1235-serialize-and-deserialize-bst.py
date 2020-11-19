from TreeNode import *
from collections import deque
class Solution:
    def serialize(self, root):
        if not root:
            return ""
        data = [str(root.val)]
        queue = deque([root])
        while queue:
            new_queue = []
            for node in queue:
                if node.left:
                    new_queue.append(node.left)
                    data.append(str(node.left.val))
                else:
                    data.append("#")
                if node.right:
                    new_queue.append(node.right)
                    data.append(str(node.right.val))
                else:
                    data.append("#")
            queue = new_queue
        while data and data[-1] == "#":
            data.pop()
        return " ".join(data)

    def deserialize(self, data):
        if not data:
            return
        nodes = deque([TreeNode(n) for n in data.split(" ")])
        root = nodes.popleft()
        queue = [root]
        while queue:
            new_queue = []
            for node in queue:
                if nodes:
                    left = nodes.popleft()
                    if left.val != "#":
                        node.left = left
                        new_queue.append(node.left)
                    else:
                        node.left = None
                
                if nodes:
                    right = nodes.popleft()
                    if right.val != "#":
                        node.right = right
                        new_queue.append(node.right)
                    else:
                        node.right = None
            queue = new_queue
        return root

if __name__ == "__main__":
    node1 = TreeNode(2)
    node1.left = TreeNode(1)
    node1.right = TreeNode(3)
    sol = Solution()
    res = sol.deserialize(sol.serialize(node1))
    print(res)
