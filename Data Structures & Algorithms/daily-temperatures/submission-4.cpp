class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        std::stack<int> store;
        vector<int> storage(temperatures.size(), 0);

        for (int i = 0; i < temperatures.size(); i++) {
            int counter = 0;
            int left = 0;
            while (!store.empty() && temperatures[store.top()] < temperatures[i]) {
                left = store.top();
                store.pop();
                storage[left] = i - left;
            }
            store.push(i);
        }

        return storage;
    }
};
