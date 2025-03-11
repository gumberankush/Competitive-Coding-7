// Time Complexity: O(klogm) where m is the number of rows in the matrix
// Space Complexity: O(min(m, k)) where m is the number of rows in the matrix

import java.util.PriorityQueue;

class KSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        int m = matrix.length;
        int n = matrix[0].length;

        for(int r = 0; r < Math.min(m, k); r++){
            pq.offer(new int[]{matrix[r][0], r, 0});
        }

        while(k > 1){
            int[] elem = pq.poll();
            int val = elem[0];
            int row = elem[1];
            int col = elem[2];

            if(col < n-1){
                pq.offer(new int[]{matrix[row][col+1], row, col+1});
            }
            k--;
        }

        return pq.peek()[0];
    }
}
