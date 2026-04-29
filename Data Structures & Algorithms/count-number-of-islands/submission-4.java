class Solution {
    public int numIslands(char[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        int islands = 0;
        boolean[][] visited = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {

                if(visited[r][c] || grid[r][c] == '0') {
                    continue;
                }

                islands++;
                dfs(grid, r, c, visited);
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int r, int c, boolean[][] visited) {

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
            || visited[r][c] || grid[r][c] == '0') {

            return;
        }

        visited[r][c] = true;
        dfs(grid, r + 1, c, visited);
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c + 1, visited);
        dfs(grid, r, c - 1, visited);
    }
}
