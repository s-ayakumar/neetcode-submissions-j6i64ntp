class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";

        Set<String> deadend = new HashSet<>();

        for (int i = 0; i < deadends.length; i++)
        {
            deadend.add(deadends[i]);
        }

        if (deadend.contains(start)) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> storeQ = new LinkedList<>();
        storeQ.add(start);
        int turns = 0;

        while (!storeQ.isEmpty())
        {
            int size = storeQ.size();
            for(int j = 0; j < size; j++)
            {
                String store = storeQ.poll();
                if (store.equals(target)) return turns;

                char[] storeArr = store.toCharArray();
                for (int i = 0; i < 4; i++)
                {
                    char og = storeArr[i];
                    storeArr[i] = (char)((og - '0' + 1) % 10 + '0');
                    String storeUp = new String(storeArr);
                    if (!visited.contains(storeUp) && !deadend.contains(storeUp))
                    {
                        storeQ.add(storeUp);
                        visited.add(storeUp);
                    }

                    storeArr[i] = (char)((og - '0' - 1 + 10) % 10 + '0');
                    String storeDown = new String(storeArr);
                    if (!visited.contains(storeDown) && !deadend.contains(storeDown))
                    {
                        storeQ.add(storeDown);
                        visited.add(storeDown);
                    }

                    storeArr[i] = og;
                }
            }
            turns++;
        }
        
        return -1;
    }
}