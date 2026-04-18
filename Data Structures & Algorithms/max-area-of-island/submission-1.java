class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // iterate throught the all the elements of the grid
        // check using dfs the size of the matrix, compare 
        // with the max size

        int ROWS = grid.length;
        int COLS = grid[0].length;

        int maxSize = 0;
        Set<String> visited = new HashSet<>();

        for(int r = 0; r < ROWS; r++) {

            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    maxSize = Math.max(maxSize, dfs(grid, r, c, visited));
                }
            }
        }

        return maxSize;
    }

    public int dfs(int[][] grid, int r, int c, Set<String> visited) {
        if(Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length
            || grid[r][c] == 0 || visited.contains(r + "," + c)) {

            return 0;
        }

        visited.add(r + "," + c);

        int count = 1;
        count += dfs(grid, r + 1, c, visited);
        count += dfs(grid, r - 1, c, visited);
        count += dfs(grid, r, c + 1, visited);
        count += dfs(grid, r, c - 1, visited);

        return count;
    }
}
