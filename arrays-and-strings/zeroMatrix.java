import java.util.Arrays;

public class Solution{
		public static void go(int[][] matrix){
				int n = matrix.length;
				int m = matrix[0].length;
				boolean hasZero = false;
				boolean[] i_flags = new boolean[n];
				Arrays.fill(i_flags, false);
				boolean[] j_flags = new boolean[m];
				Arrays.fill(j_flags, false);
				int count = 0;
				for (int i = 0; i < n; i++)
				{
						for (int j = 0; j < m; j++)
						{
								if (i_flags[i] && j_flags[j]){
										continue;
								}
								if (matrix[i][j] == 0){
										i_flags[i] = true;
										j_flags[j] = true;
								}
								count += 1;
						}
				}
				System.out.println("count: "+count);
				for (int i = 0; i < n; i++)
				{
						if (i_flags[i] == true)
						{
								Arrays.fill(matrix[i], 0);
						}
				}
				for (int j = 0; j < m; ++j)
				{
						if (j_flags[j] == true)
								for (int i = 0; i < n; ++i)
								{
										matrix[i][j] = 0;
								}
				}
		}

		public static void go2(int[][] matrix){
				int n = matrix.length;
				int m = matrix[0].length;
				boolean[] i_flags = new boolean[n];
				Arrays.fill(i_flags, false);
				boolean[] j_flags = new boolean[m];
				Arrays.fill(j_flags, false);
				int count = 0;
				boolean hasZero = false;
				for (int i = 0; i < n; ++i)
				// check if i-th line should be erased
				{
						for(int j = 0; j < m; ++j)
						{
								if (matrix[i][j] == 0)
								{
										// i-th line should be erased
										i_flags[i] = true;
										j_flags[j] = true;
										count += 1;
										break;
								}
								count += 1;
						}
				}
				for (int j = 0; j < m; ++j)
				// check if j-th column should be erased
				{
						if (j_flags[j] == true) continue;
						for(int i = 0; i < n; ++i)
						{
								if (matrix[i][j] == 0)
								{
										// j-th column should be erased
										j_flags[j] = true;
										break;
								}
								count += 1;
						}
				}
				System.out.println("count: "+count);
				for (int i = 0; i < n; i++)
				{
						if (i_flags[i] == true)
						{
								Arrays.fill(matrix[i], 0);
						}
				}
				for (int j = 0; j < m; ++j)
				{
						if (j_flags[j] == true)
								for (int i = 0; i < n; ++i)
								{
										matrix[i][j] = 0;
								}
				}
		}

		public static void main(String[] args) {
				int[][] matrix =  new int[20][20];
				int count = 0;
				for (int i = 0; i < 20; i++)
				{
						for (int j = 0; j < 20; j++)
						{
								matrix[i][j] = 1 + count;
								// matrix[i][j] = 0;
								count += 1;
						}
				}

				matrix[2][12] = 1;
				matrix[2][11] = 1;
				matrix[2][10] = 1;
				matrix[2][9] = 1;
				matrix[2][8] = 1;
				matrix[2][7] = 1;
				matrix[8][15] = 1;
				matrix[7][15] = 1;
				matrix[17][8] = 1;
				matrix[15][6] = 1;
				matrix[14][7] = 1;

				matrix[2][12] = 0;
				matrix[2][11] = 0;
				matrix[2][10] = 0;
				matrix[2][9] = 0;
				matrix[2][8] = 0;
				matrix[2][7] = 0;
				matrix[8][15] = 0;
				matrix[7][15] = 0;
				matrix[17][8] = 0;
				matrix[15][6] = 0;
				matrix[14][7] = 0;
				go2(matrix);
				System.out.println(Arrays.deepToString(matrix));
		}
}
