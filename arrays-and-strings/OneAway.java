public class Solution{
		public static boolean check(String s1, String s2){
				int len1 = s1.length();
				int len2 = s2.length();
				int flag = 0;

				if (len1 - len2 > 1 || len2 - len2 > 1)
				{
						return false;
				}

				if (len1 == len2){
						for(int i = 0; i < len1; ++i){
								if (flag == 2){ return false;}
								if(s1.charAt(i) == s2.charAt(i)){
										continue;
								}
								flag += 1;
						}
						if(flag < 2){
								return true;
						}
						else{
								return false;
						}
				}

				else if (len1 > len2){
						// subtract the last char
						if(s1.substring(0, len2) == s2){
								return true;
						}
						int i = 0;
						int j = 0;
						for(i = 0, j = 0; i < len2; ++i, ++j){
								if (flag == 2){ return false;}
								if(s1.charAt(i) == s2.charAt(j)){
										continue;
								}
								flag += 1;
								j -= 1;
						}
						if(flag < 2){
								return true;
						}
						else{
								return false;
						}
				}

				else {
						// subtract the last char
						if(s2.substring(0, len1) == s1){
								return true;
						}
						int i = 0;
						int j = 0;
						for(i = 0, j = 0; i < len1; ++i, ++j){
								if (flag == 2){ return false;}
								if(s1.charAt(i) == s2.charAt(j)){
										continue;
								}
								flag += 1;
								j -= 1;
						}
						if(flag < 2){
								return true;
						}
						else{
								return false;
						}
				}
		}

		public static void main(String[] args) {
				boolean r = check("pale", "ple");
				System.out.println(r);
				r = check("pales", "pale");
				System.out.println(r);
				r = check("pale", "bale");
				System.out.println(r);
				r = check("pale", "bake");
				System.out.println(r);
		}
}
