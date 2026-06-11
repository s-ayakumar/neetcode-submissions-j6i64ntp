class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        std::stack<double> store;
        vector<pair<int, int>> cars;
        int num_cars = position.size();
        for (int i = 0; i < num_cars; i++) cars.push_back({position[i], speed[i]});
        sort(cars.rbegin(), cars.rend());


        int num_fleets = 0;
        for (int i = 0; i < num_cars; i++) {
            double time = double(target - cars[i].first) / cars[i].second;
            if (store.empty()) {
                store.push(time);
                num_fleets++;
            }
            if (!store.empty() && store.top() < time) {
                store.push(time);
                num_fleets++;
            }
        }

        return num_fleets;

    }
};
