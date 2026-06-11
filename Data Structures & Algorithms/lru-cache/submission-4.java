public class Node {
    Node next;
    Node prev;
    int key;
    int value;
}

class LRUCache {
    Node head;
    Node tail;
    private int capacity;
    Map<Integer, Node> storage;
    
    public LRUCache(int capacity) {
        storage = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!storage.containsKey(key)) return -1;
        Node curr = storage.get(key);
        remove(curr);
        insertAtHead(curr);
        return storage.get(key).value;
    }
    
    public void put(int key, int value) {
        if (storage.containsKey(key))
        {
            Node curr = storage.get(key);
            curr.value = value;
            remove(curr);
            insertAtHead(curr);
        }
        else
        {
            Node putVal = new Node();
            putVal.value = value;
            putVal.key = key;
            storage.put(key, putVal);
            insertAtHead(putVal);
            if(storage.size() > capacity)
            {
                Node last = tail.prev;
                storage.remove(last.key);
                remove(last);
            }
        }
        
    }

    private void remove(Node curr)
    {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    private void insertAtHead(Node curr)
    {
        Node temp = head.next;
        head.next = curr;
        temp.prev = curr;
        curr.prev = head;
        curr.next = temp;
    }
}
