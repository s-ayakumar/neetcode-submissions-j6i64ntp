class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        std::stack<int> store;
        int output = 0;

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/") {
                store.push(std::stoi(tokens[i]));
            }
            else if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "/" || tokens[i] == "*") {
                int a = store.top();
                store.pop();
                int b = store.top();
                store.pop();
                if (tokens[i] == "+") {
                    output = b + a;
                } else if (tokens[i] == "-") {
                    output = b - a;
                } else if (tokens[i] == "*") {
                    output = b * a;
                } else {
                    output = b / a;
                }
                store.push(output);
                output = 0;
            }
        }
        return store.top();
    };
};
