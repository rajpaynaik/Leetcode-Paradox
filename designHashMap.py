class MyHashMap:
    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.next = None

    def __init__(self):
        self.SIZE = 1000000
        self.buckets = [None] * self.SIZE

    def _get_bucket_index(self, key):
        return key % self.SIZE

    # Put key-value
    def put(self, key: int, value: int) -> None:
        index = self._get_bucket_index(key)
        head = self.buckets[index]

        # Check if key exists, update
        curr = head
        while curr:
            if curr.key == key:
                curr.value = value
                return
            curr = curr.next

        # Insert new node at head
        new_node = self.Node(key, value)
        new_node.next = head
        self.buckets[index] = new_node

    # Get value by key
    def get(self, key: int) -> int:
        index = self._get_bucket_index(key)
        curr = self.buckets[index]
        while curr:
            if curr.key == key:
                return curr.value
            curr = curr.next
        return -1

    # Remove key
    def remove(self, key: int) -> None:
        index = self._get_bucket_index(key)
        curr = self.buckets[index]
        prev = None

        while curr:
            if curr.key == key:
                if prev:
                    prev.next = curr.next
                else:
                    self.buckets[index] = curr.next
                return
            prev = curr
            curr = curr.next

