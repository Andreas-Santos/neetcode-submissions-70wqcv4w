class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board.length == 0) return false;

        int ROWS = board.length;
        int COLS = board[0].length;

        char firstChar = word.charAt(0);
        Set<String> seen = new HashSet<>();

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {

                if(board[r][c] == firstChar && dfs(board, r, c, word, 0, seen)) {
                    return true;
                }

            }
        }

        return false;
    }
    
    public boolean dfs(char[][] board, int r, int c, String word, int i, Set<String> seen) {
        if(i == word.length()) return true;
        
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }

        if(word.charAt(i) != board[r][c] || seen.contains(r + "," + c)) {
            return false;
        }

        seen.add(r + "," + c);

        boolean found = 
                dfs(board, r + 1, c, word, i + 1, seen) ||
                dfs(board, r - 1, c, word, i + 1, seen) ||
                dfs(board, r, c + 1, word, i + 1, seen) ||
                dfs(board, r, c - 1, word, i + 1, seen);

        seen.remove(r + "," + c);

        return found;
    }
}
