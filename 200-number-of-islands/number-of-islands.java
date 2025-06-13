class Solution {
    public int numIslands(char[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    findArea(grid,i,j);
                    maxArea++;
                }
            }
        }
        return maxArea;
    }
    private void findArea(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        findArea(grid, row+1, col);
        findArea(grid, row-1, col);
        findArea(grid, row, col+1);
        findArea(grid, row, col-1);
    }
}
