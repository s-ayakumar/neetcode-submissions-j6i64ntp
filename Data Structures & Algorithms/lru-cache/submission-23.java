class Node {
    private Node next;
    private Node prev;
    private int val;
    private int key;
}

class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        cache = new HashMap<>(size);
        head = new Node();
        tail = new Node();
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            remove(curr);
            putAtTail(curr);
            return curr.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            curr.val = value;
            remove(curr);
            putAtTail(curr);
        }
        else {
            Node curr = new Node();
            curr.val = value;
            curr.key = key;
            cache.put(key, curr);
            putAtTail(curr);
        }

        if (cache.size() > size) {
            Node currHead = head.next;
            remove(currHead);
            cache.remove(currHead.key);
        }
    }

    private void remove (Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void putAtTail (Node node) {
        Node temp = tail.prev;
        node.next = tail;
        node.prev = temp;
        temp.next = node;
        tail.prev = node;
    }
}
