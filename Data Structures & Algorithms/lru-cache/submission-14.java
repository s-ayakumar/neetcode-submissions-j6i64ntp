class Node {
    private int value;
    private int key;
    private Node next;
    private Node prev;
    
}

class LRUCache {
    private int size;
    private Map<Integer, Node> cacheHelp;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        size = capacity;
        cacheHelp = new HashMap<>(size);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // O(1) retrieval
        if (cacheHelp.containsKey(key)) {
            remove(cacheHelp.get(key));
            addToTail(cacheHelp.get(key));
            return cacheHelp.get(key).value;
        } 
        else return -1;

    }
    
    public void put(int key, int value) {
        if (cacheHelp.containsKey(key)) {
            Node curr = cacheHelp.get(key);
            curr.value = value;
            remove(curr);
            addToTail(curr);
            cacheHelp.put(key, curr);
        }
        else {
            Node curr = new Node();
            curr.value = value;
            curr.key = key;
            addToTail(curr);
            cacheHelp.put(key, curr);
        }

        if (cacheHelp.size() > size) {
            Node currHead = head.next;
            Node nextHead = currHead.next;
            head.next = nextHead;
            nextHead.prev = head;
            cacheHelp.remove(currHead.key);
        }
    }

    private void remove (Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail (Node node) {
        Node currTail = tail.prev;
        currTail.next = node;
        node.prev = currTail;
        tail.prev = node;
        node.next = tail;
    }
}
