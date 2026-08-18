class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


        int n = matrix.length;
        int m  = matrix[0].length;

        int sX = 0;
        int sY = m - 1;


        while(sX >= 0 && sX < n && sY >= 0 && sY < m) {

            System.out.println(matrix[sX][sY]+" ");


            if(matrix[sX][sY]== target)
              return true;

            else if(matrix[sX][sY] > target) {
                sY--;
            } 
            else {
                sX++;
            } 
        }

        return false;



        
    }
}
