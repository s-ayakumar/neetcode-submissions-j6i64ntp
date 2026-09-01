class Node {
    private int key;
    private int value;
    private Node next;
    private Node prev;

}

class LRUCache {
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        size = capacity;
        cache = new HashMap<>(size);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            remove(curr);
            addToTail(curr);
            return curr.value;
        }
        else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            curr.value = value;
            remove(curr);
            addToTail(curr);
        }
        else {
            Node newVal = new Node();
            newVal.key = key;
            newVal.value = value;
            addToTail(newVal);
            cache.put(key, newVal);
        }

        if (cache.size() > size) {
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
    
    private void remove (Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    private void addToTail(Node curr) {
        Node currTail = tail.prev;
        currTail.next = curr;
        curr.prev = currTail;
        curr.next = tail;
        tail.prev = curr;
    }
}
