class Solution {
    // grid image[][]
    // image[i][j] represents the pixel value of the image
    // sr -> starting row pixel
    // sc -> starting col pixel
    // color -> 

    /*
        [[1, 1, 1],
         [1, *1*, 0],
         [1, 0, 1]]

        sr -> 1
        sc -> 1
        color -> 2

        change every original color (1) that is directly adjacent to the new color (2)

        edge case:
            -> if color == original color, return the image matrix without changings
            -> if image is empty return a empty matrix
            -> if sr or sc is greater than the rows size or cols size, 
                or even lesses than 0, return the image matrix
    */

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ROWS = image.length;
        int COLS = image[0].length;
        int originalColor = image[sr][sc];

        if(originalColor == color) return image;

        floodFillHelper(image, sr, sc, color, originalColor);

        return image;
    }

    public void floodFillHelper(int[][] image, int r, int c, int color, int original) {
        int ROWS = image.length;
        int COLS = image[0].length;
        
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || image[r][c] != original) {
            return;
        }

        image[r][c] = color;
        floodFillHelper(image, r + 1, c, color, original);
        floodFillHelper(image, r - 1, c, color, original);
        floodFillHelper(image, r, c + 1, color, original);
        floodFillHelper(image, r, c - 1, color, original);
    }
}