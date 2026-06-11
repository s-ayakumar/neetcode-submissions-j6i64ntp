class Solution {
    private static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) { 
        boolean check = false;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    if(dfs(board, i, j, word.substring(1))) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word)
    {
        if (board[i][j] == '#') return false;
        char temp = board[i][j];
        board[i][j] = '#';
        if (word.length() == 0) return true;


        for (int[] direction : directions)
        {
            int nRow = i + direction[0];
            int nCol = j + direction[1];

            if (nRow >= 0 && nCol >= 0 && nRow < board.length && nCol < board[0].length && board[nRow][nCol] == word.charAt(0))
            {
                if(dfs(board, nRow, nCol, word.substring(1))) return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
