from typing import List
from collections import deque

class Node:
    def __init__(self, val=None):
        self.val = val
        self.prev = None
        self.next = None

class DoubleLinkedList:
    def __init__(self, capacity: int):
        # using two dummy node as head and tail
        self.capacity = capacity
        self.size = 0
        self.head = Node()
        self.tail = Node()
        self.head.prev = None
        self.head.next = self.tail
        self.tail.prev = self.head
        self.tail.next = None
    
    def append(self, node: Node) -> None:
        if self.isFull():
            return
        oldright = self.tail.prev
        oldright.next = node
        node.prev = oldright
        node.next = self.tail
        self.tail.prev = node
        self.size += 1

    def remove(self, node: Node) -> None:
        node.prev.next = node.next
        node.next.prev = node.prev
        self.size -= 1

    def popleft(self) -> Node:
        node = self.head.next
        self.remove(node)
        return node

    def isFull(self) -> bool:
        return self.capacity == self.size

class LRUCache:
    def __init__(self, maxSize: int):
        # map a key to corresponding node
        self.keymap = dict()
        self.linkedList = DoubleLinkedList(maxSize)
        self.miss = 0

    def put(self, key):
        if key in self.keymap:
            self.get(key)
        else:
            if self.isFull():
                self.evict()
            node = Node(key)
            self.keymap[key] = node
            self.linkedList.append(node)

    def evict(self):
        node = self.linkedList.popleft()
        del self.keymap[node.val]
    
    def get(self, key) -> int:
        if key in self.keymap:
            node = self.keymap[key]
            self.linkedList.remove(node)
            self.linkedList.append(node)
            return node.val
        else:
            self.miss += 1
            self.put(key)

    def isFull(self):
        return self.linkedList.isFull()

    def getMiss(self):
        return self.miss


class Solution:
    def lruCacheMisses(self, num: int, pages: List[int], maxCacheSize: int) -> int:
        lru = LRUCache(maxCacheSize)
        for i in range(num):
            lru.get(pages[i])
        return lru.getMiss()

if __name__ == "__main__":
    num = 6
    pages = [1, 1, 3, 4, 5, 1]
    maxCacheSize = 2
    sol = Solution()
    res = sol.lruCacheMisses(num, pages, maxCacheSize)
    print(res)