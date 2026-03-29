class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> s = new TreeSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.')
                    continue;
                    
                int box = ((row / 3) * 3) + (col / 3);
                String rowKey = String.format("r%d-%c", row, board[row][col]),
                colKey = String.format("c%d-%c", col, board[row][col]),
                boxKey = String.format("b%d-%c", box, board[row][col]);

                if (s.contains(rowKey) || s.contains(colKey) || s.contains(boxKey)) {
                    return false;
                }

                s.add(rowKey); s.add(colKey); s.add(boxKey);
            }
        }

        return true;
    }
}
