package string;

public class WordSearch {
     
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (DFS(board, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, String word, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(0)) {
            return false;
        } else if (word.length() == 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean result = DFS(board, word.substring(1), i + 1, j)
                || DFS(board, word.substring(1), i - 1, j)
                || DFS(board, word.substring(1), i, j + 1)
                || DFS(board, word.substring(1), i, j - 1);
        board[i][j] = tmp;
        return result;
    }

    public static void main(String[] args) {
        char[][] board={{'a', 'a'}};
        System.out.println(new WordSearch().exist(board, "aa"));
    }

}
