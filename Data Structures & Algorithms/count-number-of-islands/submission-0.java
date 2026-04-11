class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();

        int count = 0;
        for(int r = 0; r < grid.length; r++) {

            for(int c = 0; c < grid[r].length; c++) {
                if(visited.contains(r + "," + c)) continue;

                if(grid[r][c] == '1') {
                    mapIsland(grid, visited, r, c);
                    count++;
                }
            }

        }

        return count;
    }

    public void mapIsland(char[][] grid, Set<String> visited, int r, int c) {
        if(Math.min(r, c) < 0 || r >= grid.length || c >= grid[r].length || visited.contains(r + "," + c) || grid[r][c] == '0') {
            return;
        }

        visited.add(r + "," + c);

        mapIsland(grid, visited, r + 1, c);
        mapIsland(grid, visited, r - 1, c);
        mapIsland(grid, visited, r, c + 1);
        mapIsland(grid, visited, r, c - 1);
    }
}
