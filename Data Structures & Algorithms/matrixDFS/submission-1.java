class Solution {
    public int countPaths(int[][] grid) {
        Set<String> visited = new HashSet<>();

        return helper(grid, 0, 0, visited);
    }

    public int helper(int[][] grid, int r, int c, Set<String> visited) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(Math.min(r, c) < 0 || r == ROWS || c == COLS || 
            visited.contains(r + "," + c) || grid[r][c] == 1) {
            return 0;
        }

        if(r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        visited.add(r + "," + c);

        int count = 0;
        count += helper(grid, r + 1, c, visited);
        count += helper(grid, r - 1, c, visited);
        count += helper(grid, r, c + 1, visited);
        count += helper(grid, r, c - 1, visited);

        visited.remove(r + "," + c);
        return count;
    }
}
