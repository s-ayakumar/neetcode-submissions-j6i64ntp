class Solution {
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (grid[r][c] == 1)
                {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        if (maxArea == 0) return 0;

        return maxArea;

    }

    private int dfs(int[][] grid, int r, int c)
    {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) return 0;

        grid[r][c] = 0;

        int currArea = 1;
        currArea += dfs(grid, r + directions[0][0], c + directions[0][1]);
        currArea += dfs(grid, r + directions[1][0], c + directions[1][1]);
        currArea += dfs(grid, r + directions[2][0], c + directions[2][1]);
        currArea += dfs(grid, r + directions[3][0], c + directions[3][1]);


        return currArea;
    }
}
