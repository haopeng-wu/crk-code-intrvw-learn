public class Solution{
		public static String check(String s){
				int len = s.length();
				StringBuilder r = new StringBuilder("");
				char prev = '_';
				char c = '_';
				Integer counter = 0;

				for (int i = 0; i < len; ++i){
						c = s.charAt(i);
						if (c == prev)
						{
								counter += 1;
						}
						else
						{
								if (prev == '_')
								{
										r.append(c);
										counter += 1;
										prev = c;
								}
								else
								{
										r.append(counter.toString());
										counter = 0;
										r.append(c);
										counter += 1;
										prev = c;
								}
						}
				}
				r.append(counter.toString());
				if (r.length() < s.length())
						return r.toString();
				else
						return s;
		}

		public static void main(String[] args) {
				String s = "aabcccccaaa";
				String r = check(s);
				System.out.println(r);
		}
}
