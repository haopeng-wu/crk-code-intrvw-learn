public class Solution{
		public static void main(String[] args) {
				String str1 = "ab cd efg    ";
				System.out.println(urlify(str1, 9));
		}

		static char[] urlify(String str, int length){
				int len = length;
				char[] array = str.toCharArray();
				int i = 0;
				while (i < len){
						if (array[i] != ' '){
								i+=1;
								continue;
						}
						for (int j = len-1; j > i; --j){
								array[j+2] = array[j];
						}
						len += 2;
						array[i] = '%';
						array[i+1] = '2';
						array[i+2] = '0';
						i += 3;
				}
				return array;
		}
}
