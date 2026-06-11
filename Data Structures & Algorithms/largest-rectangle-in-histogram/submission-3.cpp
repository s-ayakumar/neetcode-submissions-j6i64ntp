class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        int max_area = 0;
        stack<int> stack;

        for(int i = 0; i <= n; i++)
        {
            while (!stack.empty() && (i == n || heights[stack.top()] >= heights[i]))
            {
                int height = heights[stack.top()];
                stack.pop();
                int width = stack.empty() ? i : i - stack.top() - 1;
                max_area = max(max_area, height * width);
            }
            stack.push(i);
        }
        return max_area;
    }

};
