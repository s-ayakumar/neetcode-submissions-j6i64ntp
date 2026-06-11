class Solution {
    private static final int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;
        int min = Integer.MAX_VALUE;

        min = Math.min(min, bfs(grid));
        return min;
    }

    private int bfs (int[][] grid)
    {
        Queue<int[]> store = new LinkedList<>();
        int freshCounter = 0;
        int minutes = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 2)
                {
                    store.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) freshCounter++;
            }
        }

        while (!store.isEmpty() && freshCounter > 0)
        {
            int currentWaveSize = store.size();
            for (int i = 0; i < currentWaveSize; i++)
            {
                int[] currentRottenPosition = store.poll();
                int rottenX = currentRottenPosition[0];
                int rottenY = currentRottenPosition[1];

                for (int[] direction : directions)
                {
                    int nr = rottenX + direction[0];;
                    int nc = rottenY + direction[1];
                    if (nr >= 0 & nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1)
                    {
                        store.add(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        freshCounter--;
                    }
                }
            }

            minutes++;
        }
        if (freshCounter == 0) return minutes;
        if (freshCounter > 0) return -1;
        return minutes;
    }
}
