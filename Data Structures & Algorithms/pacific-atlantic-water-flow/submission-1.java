class Solution {

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] reachPacific = new boolean[ROWS][COLS];
        boolean[][] reachAtlantic = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, reachPacific, heights[0][c]);
            dfs(heights, ROWS - 1, c, reachAtlantic, heights[ROWS-1][c]);
        }

        for(int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, reachPacific, heights[r][0]);
            dfs(heights, r, COLS - 1, reachAtlantic, heights[r][COLS-1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(reachPacific[r][c] && reachAtlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] visit, int prevHeight) {
        if(Math.min(r, c) < 0 || r >= heights.length || c >= heights[r].length ||
            visit[r][c] || heights[r][c] < prevHeight) {
            
            return;
        }
        
        visit[r][c] = true;
        dfs(heights, r + 1, c, visit, heights[r][c]);
        dfs(heights, r - 1, c, visit, heights[r][c]);
        dfs(heights, r, c + 1, visit, heights[r][c]);
        dfs(heights, r, c - 1, visit, heights[r][c]);
    }
}
