class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (grid[i][j] == '1')
                {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs (char[][] grid, int r, int c)
    {
        Queue<int[]> store = new LinkedList<>();
        grid[r][c] = '0';
        store.add(new int[]{r, c});
        while (!store.isEmpty())
        {
            int[] current = store.poll();
            int row = current[0], col = current[1];

            for (int[] dir : directions)
            {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1')
                {
                    store.add(new int[] {nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }

        

    }
}
