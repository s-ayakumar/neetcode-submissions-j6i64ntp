class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(nums[i])) {
                store.put(nums[i], store.get(nums[i]) + 1);
            } else {
                store.put(nums[i], 1);
            }
        }

        List<int[]> arr = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++) {
            output[i] = arr.get(i)[1];
        }
        
        return output;
    }
}
