import java.util.Stack;


public class binary2string {
    int i = 0;
    public static String IntegerToBinary(int num) {
        Stack <String> stack = new Stack<String>();
        int divisor = 2;
        while (num > 0) {
            if (stack.size() > 31){
                return "";
            }
            if (num % divisor == 0) {
                stack.push("0");
            } else {
                stack.push("1");
                num -= divisor/2;
            }
            divisor *= 2;
        }
        // stack to string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static String Decimal2Bianry(double num){
        StringBuilder sb = new StringBuilder();
        num *= 2;
        while (num != 0){
            // if (sb.length() > 31){
            //     System.err.println("ERROR");
            //     return "";
            // }
            if (num >= 1){
                sb.append("1");
                num -= 1;
            }else{
                sb.append("0");
            }
            num *= 2;
        }
        return "0."+sb;
    }
    public static void main(String[] args) {
        // System.out.println(IntegerToBinary(387123693));
        System.out.println(Decimal2Bianry(0.25+.125+0.5+0.125/2));
    }
}
