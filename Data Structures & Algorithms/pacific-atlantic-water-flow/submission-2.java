class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++) {
            dfs(0, c, heights, pacific);
            dfs(ROWS - 1, c, heights, atlantic);
        }

        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, heights, pacific);
            dfs(r, COLS - 1, heights, atlantic);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c  < COLS; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    resultList.add(Arrays.asList(r, c));
                }
            }
        }

        return resultList;
    }

    public void dfs(int r, int c, int[][] heights, boolean[][] visited) {
        if(visited[r][c]) return;

        visited[r][c] = true;
        int[][] directions = {{r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}};

        for(int[] dir : directions) {
            int nextR = dir[0];
            int nextC = dir[1];

            if(nextR < 0 || nextC < 0 || nextR >= heights.length ||
                nextC >= heights[0].length || visited[nextR][nextC] ||
                heights[nextR][nextC] < heights[r][c]) {
                
                continue;
            }

            dfs(nextR, nextC, heights, visited);
        }
    }
}
