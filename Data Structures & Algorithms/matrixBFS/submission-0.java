class Solution {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) return -1;

        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[2]);

        int lengthShortest = 0;
        while(!q.isEmpty()) {
            int queueSize = q.size();
            
            for(int i = 0; i < queueSize; i++) {
                int[] current = q.poll();
                int row = current[0];
                int col = current[1];

                if(row == ROWS - 1 && col == COLS - 1) {
                    return lengthShortest;
                }

                if(Math.min(row, col) < 0 || row >= ROWS || col >= COLS ||
                    visited.contains(row + "," + col) || grid[row][col] == 1) {
                    
                    continue;
                }

                visited.add(row + "," + col);
                int[][] directions = 
                    {{row + 1, col}, {row - 1, col}, 
                    {row, col + 1}, {row, col - 1}};

                for(int[] dir : directions) {
                    int nextR = dir[0];
                    int nextC = dir[1];

                    q.add(new int[]{nextR, nextC});
                }
            }

            lengthShortest++;
        }

        return -1;
    }
}
