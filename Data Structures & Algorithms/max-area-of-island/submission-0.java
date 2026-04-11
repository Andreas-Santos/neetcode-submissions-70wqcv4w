class Solution {
    // 0 -> water
    // 1 -> land 
    // return the size of the biggest island
    
    // edge cases:
    // -> if no islands exists, return 0;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Set<String> visited = new HashSet<>();

        for(int r = 0; r < grid.length; r++) {

            for(int c = 0; c < grid[r].length; c++) {

                if(grid[r][c] == 1 && !visited.contains(r + "," + c)) {
                    int islandArea = verifySizeOfIsland(grid, r, c, visited);

                    maxArea = Math.max(maxArea, islandArea);
                }
            }

        }

        return maxArea;
    }

    public int verifySizeOfIsland(int[][] grid, int r, int c, Set<String> visited) {
        if(Math.min(r, c) < 0 || r >= grid.length || c >= grid[r].length || 
            grid[r][c] == 0 || visited.contains(r + "," + c)) {
            
            return 0;
        }

        int count = 0;

        if(grid[r][c] == 1) {
            visited.add(r + "," + c);
            count++;
        }

        count += verifySizeOfIsland(grid, r + 1, c, visited);
        count += verifySizeOfIsland(grid, r - 1, c, visited);
        count += verifySizeOfIsland(grid, r, c + 1, visited);
        count += verifySizeOfIsland(grid, r, c - 1, visited);

        return count;
    }
}
