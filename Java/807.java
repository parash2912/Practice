class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int increase = 0;
        int[] row_max = new int[grid.length];
        int[] col_max = new int[grid[0].length];
        for(int row_index = 0; row_index < grid.length; ++row_index) {
            for(int col_index = 0; col_index < grid[0].length; ++col_index) {
                if(col_index == 0) {
                    row_max[row_index] = grid[row_index][col_index];
                }
                if(row_index == 0) {
                    col_max[col_index] = grid[row_index][col_index];
                }
                if(grid[row_index][col_index] > row_max[row_index]) {
                    row_max[row_index] = grid[row_index][col_index];
                }
                if(grid[row_index][col_index] > col_max[col_index]) {
                    col_max[col_index] = grid[row_index][col_index];
                }
            }
        }
        for(int row_index = 0; row_index < grid.length; ++row_index) {
            for(int col_index = 0; col_index < grid[0].length; ++ col_index) {
                int max_height = Math.min(row_max[row_index], col_max[col_index]);
                if(grid[row_index][col_index] < max_height) {
                    increase += max_height - grid[row_index][col_index];
                }
            }
        }
        return increase;
    }
}
