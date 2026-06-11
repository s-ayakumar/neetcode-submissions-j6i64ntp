class Solution {
    private static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        bfs(grid);
    }

    private void bfs (int[][] grid)
    {
        Queue<int[]> store = new LinkedList<>();

        for (int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 0)
                {
                    store.add(new int[]{i, j});
                }
            }
        }

        while (!store.isEmpty())
        {
            int[] curr = store.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] direction : directions)
            {
                int nRow = row + direction[0];
                int nCol = col + direction[1];

                if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == 2147483647)
                {
                    grid[nRow][nCol] = grid[row][col] + 1;
                    store.add(new int[]{nRow, nCol});
                }
            }    
        }

    }
}
