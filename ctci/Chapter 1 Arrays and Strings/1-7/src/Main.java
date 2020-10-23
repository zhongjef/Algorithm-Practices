import java.util.Arrays;

class Solution {
    /***
     * Rotate the matrix right by 90 degrees.
     * @param matrix the matrix
     */
    void rotate(int[][] matrix) {
        // Must be square non-empty matrix
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int N = matrix.length;
        for (int layer = 0; layer < (double) N / 2; layer++) {
            int first = layer;
            int last = N - 1 - layer;
            for (int offset = 0; offset < last - first; offset++) {
                int temp = matrix[first][first + offset];
                // left -> top
                matrix[first][first + offset] = matrix[last - offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[first + offset][last];
                // top -> right
                matrix[first + offset][last] = temp;
            }
        }

    }

    void initMat(int[][] matrix, int size) {
        int num = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = num++;
            }
        }
    }

    String printMat(int[][] matrix) {
        StringBuilder out = new StringBuilder();
        for (int[] row : matrix) {
            out.append(Arrays.toString(row));
            out.append(System.lineSeparator());
        }
        out.append(System.lineSeparator());
        return out.toString();
    }

}


public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int N = 5;
        int[][] matrix = new int[N][N];
        sol.initMat(matrix, N);
        System.out.println(sol.printMat(matrix));
        sol.rotate(matrix);
        System.out.println(sol.printMat(matrix));
    }

}
