class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] canReachAtlantic = new boolean[heights.length][heights[0].length];
        boolean[][] canReachPacific = new boolean[heights.length][heights[0].length];
        List<List<Integer>> finalList = new ArrayList<>();

        for (int r = 0; r < row; r++)
        {
            dfs(heights, r, 0, canReachPacific, heights[r][0]);
            dfs(heights, r, col - 1, canReachAtlantic, heights[r][col - 1]);
        }

        for (int c = 0; c < col; c++)
        {
            dfs(heights, 0, c, canReachPacific, heights[0][c]);
            dfs(heights, row - 1, c, canReachAtlantic, heights[row - 1][c]);
        }

        for (int r = 0; r < row; r++)
        {
            for (int c = 0; c < col; c++)
            {
                if (canReachPacific[r][c] && canReachAtlantic[r][c])
                {
                    List<Integer> position = new ArrayList<>();
                    position.add(r);
                    position.add(c);
                    finalList.add(position);
                }
            }
        }
       

        return finalList;
    }
    private void dfs(int[][] heights, int row, int col, boolean[][] canReach, int prevHeight)
    {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) return;
        if (prevHeight > heights[row][col]) return;
        if (canReach[row][col]) return;

        canReach[row][col] = true;
        for (int[] direction : directions)
        {
            dfs(heights, row + direction[0], col + direction[1], canReach, heights[row][col]);
        }
    }
}
