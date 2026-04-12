class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // [r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1],
        // [r - 1, c - 1], [r - 1, c + 1], [r + 1, c - 1], [r + 1, c + 1]

        if(grid[0][0] == 1) return -1;

        int ROWS = grid.length;
        int COLS = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[2]);

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int length = 0;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                if(row == ROWS - 1 && col == COLS - 1) {
                    return length+1;
                }

                int[][] directions = 
                    {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1},
                    {row - 1, col - 1}, {row - 1, col + 1}, {row + 1, col - 1}, {row + 1, col + 1}};

                for(int[] dir : directions) {
                    int nextR = dir[0];
                    int nextC = dir[1];
                    if(Math.min(nextR, nextC) < 0 || nextR >= ROWS || nextC >= COLS ||
                        visited.contains(nextR + "," + nextC) || grid[nextR][nextC] == 1) {
                        
                        continue;
                    }

                    queue.offer(new int[]{nextR, nextC});
                    visited.add(nextR + "," + nextC);
                }
            }
            
            length++;
        }

        return -1;
    }
}   