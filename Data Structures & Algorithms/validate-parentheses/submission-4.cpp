class Solution {
public:
    bool isValid(string s) {
        std::stack<char> store;

        std::string storeClose = "";
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                store.push(s[i]);
            } else if ((!store.empty()) && ( (s[i] == ')' && store.top() == '(') || (s[i] == '}' && store.top() == '{') || (s[i] == ']' && store.top() == '['))) {
                store.pop();
            } else {
                return false;
            }
        }

        

        return store.empty();
    }
};
