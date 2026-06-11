class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] indices = new int[2];

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                indices[0] = left + 1;
                indices[1] = right + 1;
                break;
            } else if (numbers[right] + numbers[left] > target) {
                right--;
                continue;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
                continue;
            } else {
                right--;
                left++;
            }
        }

        return indices;
    }
}
