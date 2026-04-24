class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int INF = Integer.MAX_VALUE;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {

                if(grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }

            }
        }

        int distance = 0;
        while(!q.isEmpty()) {
            
            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] poll = q.poll();
                int r = poll[0];
                int c = poll[1];

                if(grid[r][c] == INF) {
                    grid[r][c] = distance;
                }

                int[][] directions = {
                    {r + 1, c}, 
                    {r - 1, c}, 
                    {r, c + 1},
                    {r, c - 1}
                };

                for(int[] dir : directions) {

                    int nextR = dir[0];
                    int nextC = dir[1];

                    if(nextR >= 0 && nextR < ROWS && 
                        nextC >= 0 && nextC < COLS &&
                        grid[nextR][nextC] == INF) {

                        q.offer(dir);
                    }
                    
                }
            }

            distance++;

        }

    }
}
