public class Solution{
		public static boolean check(String s){
				s = s.toLowerCase();
				char[] s_array = s.toCharArray();
				int[] letters = new int[26];

				for(char c: s_array){
						if (c < 'a' || c > 'z') {continue;}
						letters[(c-'a')] += 1;
				}

				int flag = 0;
				for(int i: letters){
						if (flag == 2){
								return false;
						}
						if (i%2 == 1){
								flag += 1;
						}
				}
				return true;
		}
		public static void main(String[] args) {
				boolean r = check("Tact Coa");
				System.out.println(r);
				r = check("Tact     Coa");
				System.out.println(r);
				r = check("Tact Coatc");
				System.out.println(r);
				r = check("Tactaa Coa");
				System.out.println(r);
				r = check("Tact ttCoa");
				System.out.println(r);
		}
}
