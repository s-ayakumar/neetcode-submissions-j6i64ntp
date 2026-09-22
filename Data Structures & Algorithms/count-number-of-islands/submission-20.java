class Solution {

    private final int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs (char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        for (int k = 0; k < directions.length; k++) {
            dfs(grid, i + directions[k][0], j + directions[k][1]);
        }
    }
}
