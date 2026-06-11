class Solution {
public:
    vector<string> generateParenthesis(int n) {
        int close = 0;
        int open = 0;
        vector<string> result;
        backtrack(close, open, n, result, "");
        return result;
    }

    void backtrack (int close, int open, int n, vector<string>& res, string curr) {
        if (curr.length() == 2 * n) {
            res.push_back(curr);
            return;
        }
        if (open < n) {
            backtrack(close, open + 1, n, res, curr + "(");
        }
        if (close < open) {
            backtrack(close + 1, open, n, res, curr + ")");
        }
    }
};
