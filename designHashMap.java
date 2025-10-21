class MyHashMap {
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000000;
    private Node[] buckets = new Node[SIZE];

    private int getBucketIndex(int key) {
        return key % SIZE;
    }

    // Put key-value
    public void put(int key, int value) {
        int index = getBucketIndex(key);
        Node head = buckets[index];

        // Check if key exists, update
        while (head != null) {
            if (head.key==key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node at head
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // Get value by key
    public int get(int key) {
        int index = getBucketIndex(key);
        Node head = buckets[index];
        while (head != null) {
            if (head.key==key) return head.value;
            head = head.next;
        }
        return -1;
    }

    // Remove key
    public void remove(int key) {
        int index = getBucketIndex(key);
        Node head = buckets[index];
        Node prev = null;

        while (head != null) {
            if (head.key==key) {
                if (prev != null) prev.next = head.next;
                else buckets[index] = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
}
