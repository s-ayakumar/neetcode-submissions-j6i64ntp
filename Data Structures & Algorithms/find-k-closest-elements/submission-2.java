class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = left + k - 1;

        for (int i = left + k; i < arr.length; i++) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[i] - x)){
                left++;
                right = right + 1;
            } 
        }

        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}