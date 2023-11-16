public class TicTacToe {

    // Функція для друку ігрового поля
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Приклад використання
        char[][] exampleBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };

        printBoard(exampleBoard);
    }
}
