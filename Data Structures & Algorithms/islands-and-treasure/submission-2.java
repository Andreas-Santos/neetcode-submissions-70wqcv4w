class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int INF = 2147483647;

        // -1 -> A water  
        // 0  -> Treasure
        // INF -> cell that can be traversed

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                    visited[r][c]= true;
                }
            }
        }  

        int count = 0;
        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                visited[r][c] = true;
                
                if(grid[r][c] == INF) {
                    grid[r][c] = count;
                }

                int[][] directions = new int[][]{{r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}};
 
                for(int[] dir : directions) {
                    int nextR = dir[0];
                    int nextC = dir[1];
                    
                    if(nextR < 0 || nextR >= ROWS || nextC < 0 || nextC >= COLS ||
                        visited[nextR][nextC] || grid[nextR][nextC] != INF) {

                        continue;
                    }

                    q.add(dir);
                }
            }

            count++;
        }
    }   
}
