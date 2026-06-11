class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        return searchMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    private boolean searchMatrix(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, int target)
    {
        if (matrix.length == 0) return false;
        if (rowStart > rowEnd) return false;

        int midRow = (rowStart + rowEnd) / 2;

        if (target == matrix[midRow][colStart] || target == matrix[midRow][colEnd]) return true;

        else if (target > matrix[midRow][colStart] && target < matrix[midRow][colEnd])
        {
            return searchRow(matrix[midRow], 1, colEnd - 1, target);
        }
        else if (target < matrix[midRow][colStart])
        {
            return searchMatrix(matrix, rowStart, midRow - 1, colStart, colEnd, target);
        }
        else
        {
            return searchMatrix(matrix, midRow + 1, rowEnd, colStart, colEnd, target);
        }
    }

    private boolean searchRow(int[] arr, int start, int end, int target)
    {
        if (start > end) return false;

        int mid = (start + end) / 2;

        if (target == arr[mid]) return true;
        else if (target < arr[mid])
        {
            return searchRow(arr, start, mid - 1, target);
        }
        else
        {
            return searchRow(arr, mid + 1, end, target);
        }
    }
}
