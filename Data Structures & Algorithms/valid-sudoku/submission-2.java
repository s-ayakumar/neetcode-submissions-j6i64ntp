class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] colMap = new HashSet[9];
        Set<Character>[] rowMap = new HashSet[9];
        Set<Character>[] subBox = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            colMap[i] = new HashSet<>();
            rowMap[i] = new HashSet<>();
            subBox[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                char curr = board[i][j];

                if (curr == '.') continue;

                int boxIndex = (i / 3) * 3 + (j / 3);
                
                if (!colMap[j].add(curr) || !rowMap[i].add(curr) || !subBox[boxIndex].add(curr)) {
                    return false;
                }
            }
        }

        return true;
    }

}
