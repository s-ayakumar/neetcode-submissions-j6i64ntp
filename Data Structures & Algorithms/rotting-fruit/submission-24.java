class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, bfs(grid));
        return min;
    }

    private int bfs (int[][] grid) {
        int minutes = 0;
        int freshFruit = 0;
        Queue<int[]> rottenQ = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottenQ.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshFruit++;
                }
            }
        }

        while (!rottenQ.isEmpty() && freshFruit > 0) {
            int currRottenTomatoes = rottenQ.size();

            for (int i = 0; i < currRottenTomatoes; i++) {
                int[] currRotten = rottenQ.poll();

                for (int j = 0; j < directions.length; j++) {
                    if ((currRotten[0] + directions[j][0] < 0 || currRotten[0] + directions[j][0] >= grid.length) || (currRotten[1] + directions[j][1] < 0 || currRotten[1] + directions[j][1] >= grid[0].length)) continue;
                    if (grid[currRotten[0] + directions[j][0]][currRotten[1] + directions[j][1]] == 1) {
                        grid[currRotten[0] + directions[j][0]][currRotten[1]+ directions[j][1]] = 2;
                        rottenQ.add(new int[]{currRotten[0] + directions[j][0], currRotten[1] + directions[j][1]});
                        freshFruit--;
                    } 
                }
            }
            minutes++;
        }

        if (freshFruit > 0) return -1;

        return minutes;


    }

    
}
