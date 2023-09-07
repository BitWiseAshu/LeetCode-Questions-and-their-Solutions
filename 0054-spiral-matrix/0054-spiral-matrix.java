class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return list;
        }

        int minr = 0;
        int minc = 0;
        int maxr = matrix.length-1;
        int maxc = matrix[0].length-1;
        int totalElement = matrix.length * matrix[0].length;
        int count = 0;

        while(count < totalElement){
            // top
            for(int i = minr, j = minc; j <= maxc && count < totalElement; j++){
                list.add(matrix[i][j]);
                count ++;
            }
            minr ++;

            // right
            for(int i = minr, j = maxc; i <= maxr && count < totalElement; i++){
                list.add(matrix[i][j]);
                count ++;
            }
            maxc --;

            // bottom
            for(int i = maxr, j = maxc; j >= minc && count < totalElement; j--){
                list.add(matrix[i][j]);
                count ++;
            }
            maxr --;

            // left
            for(int i = maxr, j = minc; i >= minr && count < totalElement; i--){
                list.add(matrix[i][j]);
                count ++;
            }
            minc ++;

        }
        return list;
        
        
    }
}