class MinStack {
public:
    std::stack<int> store;
    std::stack<int> minStore;    
    MinStack() {

    }
    
    void push(int val) {
        store.push(val);
        if (minStore.empty() || val <= minStore.top()) {
            minStore.push(val);
        } 
    }
    
    void pop() {
        if (store.top() == minStore.top()) {
            store.pop();
            minStore.pop();
        } else {
            store.pop();
        }
    }
    
    int top() {
        return store.top();
    }
    
    int getMin() {
        return minStore.top();
    }
};
