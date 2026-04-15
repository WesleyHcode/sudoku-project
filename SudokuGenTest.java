public class SudokuGenTest {
    public static void main(String[] args) {
        int[][] board1 = new int[9][9];
        SudokuGenerator game1 = new SudokuGenerator();
        game1.solve(board1, 0, 0);
        System.out.println(game1.toString(board1));
        
        int[][] board2 = new int[9][9];
        SudokuGenerator game2 = new SudokuGenerator();
        game2.solve(board2, 0, 0);
        System.out.println(game2.toString(board2));
        
        int[][] board3 = new int[9][9];
        SudokuGenerator game3 = new SudokuGenerator();
        game3.solve(board3, 0, 0);
        System.out.println(game3.toString(board3));
        
        int[][] board4 = new int[9][9];
        SudokuGenerator game4 = new SudokuGenerator();
        game3.solve(board4, 0, 0);
        System.out.println("BEFORE TEST");
        System.out.println(game4.toString(board3));
        board4[1][2] = 0;
        board4[3][4] = 0;
        board4[5][6] = 0;
        game3.solve(board4, 0, 0);
        System.out.println("AFTER TEST");
        System.out.println(game4.toString(board3));
    }
}
