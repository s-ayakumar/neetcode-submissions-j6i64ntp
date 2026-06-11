class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {        
        int windowMax = 0;
        int currWindow = 0;
        int maxesIndex = 0;
        std::vector<int> maxesStore;
        std::deque<int> maxes;

        for (int rightIndex = 0; rightIndex < nums.size(); rightIndex++) {
            while (!maxes.empty() && maxes.front() < rightIndex - k + 1) {
                maxes.pop_front();
            }
            
            while (!maxes.empty() && nums[maxes.back()] < nums[rightIndex]) {
                maxes.pop_back();
            }

            maxes.push_back(rightIndex);

            if (rightIndex >= k - 1) {
                maxesStore.push_back(nums[maxes.front()]);

            }
        }
        return maxesStore;
    }
};
