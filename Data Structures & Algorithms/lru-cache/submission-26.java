class LRUCache {
    class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
    }

    private Node head;
    private Node tail;
    private int size;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        size = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node curr = cache.get(key);
        // remove from current spot
        remove(curr);
        // add to tail (update as most recently used)
        addToTail(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node curr = cache.get(key);
            curr.value = value;
            remove(curr);
            addToTail(curr);
        }
        else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addToTail(newNode);
        }

        if (cache.size() > size) {
            Node curr = head.next;
            remove(curr);
            cache.remove(curr.key);
        }
    }

    private void remove (Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    private void addToTail (Node curr) {
        Node prevTail = tail.prev;
        prevTail.next = curr;
        curr.prev = prevTail;
        tail.prev = curr;
        curr.next = tail;

    }

}
