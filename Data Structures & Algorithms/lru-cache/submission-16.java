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
            Node curr = new Node();
            curr.value = value;
            curr.key = key;
            addToTail(curr);
            cache.put(key, curr);
        }

        if (cache.size() > size) {
            Node lru = head.next;
            int lruKey = lru.key;
            remove(lru);
            cache.remove(lruKey);
        }
    }

    private void addToTail(Node curr) {
        Node temp = tail.prev;
        curr.next = tail;
        curr.prev = temp;
        temp.next = curr;
        tail.prev = curr;
    }

    private void remove (Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
}
