public class IsUnique{
		public static void main(String[] args) {
				String str1 = "abcdefg";
				String str2 = "adbcgfe";
				System.out.println(check(str1, str2));
		}

		static boolean check(String str1, String str2){
				if (str1.length() !=  str2.length()){
						return false;
				}
				int a[] = new int[26];
				int b[] = new int[26];

				for (int i = 0; i < str1.length(); i++){
						int pos = str1.charAt(i) - 'a';
						a[pos] += 1;
				}
				for (int i = 0; i < str2.length(); i++){
						int pos = str2.charAt(i) - 'a';
						a[pos] -= 1;
				}
				for (int i = 0; i < a.length; i++){
						if (a[i] != 0){
						return false;}
				}
				return true;
		}
}
