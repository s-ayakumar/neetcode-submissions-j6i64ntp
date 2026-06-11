class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++)
        {
            if (board[r][0] == 'O')
            {
                dfs(board, r, 0);
            }
            if (board[r][cols - 1] == 'O')
            {
                dfs(board, r, cols - 1);
            }
        }

        for (int c = 0; c < cols; c++)
        {
            if (board[0][c] == 'O')
            {
                dfs(board, 0, c);    
            }
            if (board[rows - 1][c] == 'O')
            {
                dfs(board, rows - 1, c);
            }
        }


        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (board[r][c] == 'O')
                {
                    board[r][c] = 'X';
                }
                else if (board[r][c] == '#')
                {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private static void dfs (char[][] board, int r, int c)
    {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        if (board[r][c] == '#') return;
        if (board[r][c] == 'X') return;

        board[r][c] = '#';

        for (int[] direction : directions)
        {
            dfs(board, r + direction[0], c + direction[1]);
        }
    }
}
