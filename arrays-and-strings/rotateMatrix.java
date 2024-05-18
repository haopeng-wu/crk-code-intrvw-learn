import java.util.Arrays;

public class Solution{
		public static void go(int[][] matrix){
				int n = matrix[0].length;
				int tmp = matrix[0][0];
				int start = 0;
				int end = 0;
				for (int j = 0; j < n/2; j++)
				{
						start = 0+j;
						end = n-1-j;
						for (int i = start; i < end; i++)
						{
								tmp = matrix[start][i];
								// left -> top
								// end-i+start = 2-1+1
								matrix[start][i] = matrix[end-i+start][start];
								// bottom -> left
								matrix[end-i+start][start] = matrix[end][end-i+start];
								// right -> bottom
								matrix[end][end-i+start] = matrix[i][end];
								// top -> right
								matrix[i][end] = tmp;

						}
				}
		}

		public static void main(String[] args) {
				int[][] matrix =  new int[4][4];
				int count = 0;
				for (int i = 0; i < 4; i++)
				{
						for (int j = 0; j < 4; j++)
						{
								matrix[i][j] = 1 + count;
								count += 1;
						}
				}
				go(matrix);
				System.out.println(Arrays.deepToString(matrix));
		}
}
