public class SudokuGenerator {
    public void solve(int[][] board, int row, int col) {
        if (row == 9) {
            return; 
        }
        int nextRow = row;
        int nextCol = col + 1;
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        }
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        
        for (int num : numbers) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                solve(board, nextRow, nextCol);
                if (board[8][8] != 0) {
                    return; 
                }
                board[row][col] = 0;
            }
        }
    }
    
    public boolean isValid(int[][] board, int row, int col, int number) {
        return checkGrid(board, row, col, number) && 
               checkCol(board, col, number) && 
               checkRow(board, row, number);
    }
    
    public boolean checkGrid(int[][] board, int row, int col, int number) {
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkCol(int[][] board, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }
        return true;
    }
    
    public boolean checkRow(int[][] board, int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }
        return true;
    }
    
    public String toString(int[][] board) {
        String use = "";
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) use += "+-------+-------+-------+\n";
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) use += "| ";
                use += board[i][j] + " ";
            }
            use += "|\n";
        }
        use += "+-------+-------+-------+\n";
        return use;
    }
}

