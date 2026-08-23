class Node {
    Node next;
    Node prev;
    int key;
    int value;
}
class LRUCache {

    private Node head;
    private Node tail;
    private int size;
    private Map<Integer, Node> storage;


    public LRUCache(int capacity) {
        size = capacity;
        storage = new HashMap<>(size);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        if (storage.containsKey(key)) {
            Node curr = storage.get(key);
            remove(curr);
            addToTail(curr);
            return curr.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (storage.containsKey(key)) {
            Node curr = storage.get(key);
            curr.value = value;
            curr.key = key;
            remove(curr);
            addToTail(curr);
        }
        else {
            Node curr = new Node();
            curr.value = value;
            curr.key = key;
            storage.put(key, curr);
            addToTail(curr);
        }

        if (storage.size() > size) {
            Node lru = head.next;
            Node newHead = lru.next;
            int headKey = lru.key;
            head.next = newHead;
            newHead.prev = head;
            storage.remove(headKey);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node node) {
        Node prevTail = tail.prev;
        tail.prev.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;
    }
}
