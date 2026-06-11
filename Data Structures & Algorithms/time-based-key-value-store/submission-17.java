class Pair
{
    int timestamp;
    String value;
}
class TimeMap {
    private Map<String, List<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        Pair curr = new Pair();
        curr.timestamp = timestamp;
        curr.value = value;

        if (store.containsKey(key))
        {
            store.get(key).add(curr);
        }
        else
        {
            store.put(key, new ArrayList<Pair>());
            store.get(key).add(curr);
        }

    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";

        List<Pair> curr = store.get(key);
        
        if (curr.get(curr.size() - 1).timestamp <= timestamp) return curr.get(curr.size() - 1).value;

        int lastValid = binarySearch(curr, 0, curr.size() - 1, timestamp);
        if (lastValid == -1) return "";

        Pair currPair = curr.get(lastValid);

        return currPair.value;
    }

    private int binarySearch(List<Pair> curr, int start, int end, int timestamp)
    {
        if (start > end) return -1;
        
        int mid = (start + end) / 2;

        if (curr.get(mid).timestamp <= timestamp) 
        {
            int max = curr.get(mid).timestamp;
            int maxIndex = mid;
            int store = binarySearch(curr, mid + 1, end, timestamp);
            if (store == -1) return mid;
            if (max < curr.get(store).timestamp)
            {
                max = curr.get(store).timestamp;
            }
            return store;
        }
        else 
        {
            return binarySearch(curr, start, mid - 1, timestamp);
        }
    }
}
