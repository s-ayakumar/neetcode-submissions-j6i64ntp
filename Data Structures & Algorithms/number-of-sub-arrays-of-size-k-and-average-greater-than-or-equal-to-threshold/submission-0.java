class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++)
        {
            sum += arr[i];
        }

        int left = 0;
        int count;

        if (sum / k >= threshold) count = 1;
        else count = 0;

        for (int i = left + k; i < arr.length; i++)
        {
            sum += arr[i];
            while (i - left + 1 > k) 
            {
                sum -= arr[left];
                left++;
            }
            if (sum / k >= threshold) count++;
            
        }

        return count;

    }
}