import java.util.Stack;
public class flipBitToWin {
    private static boolean is_bit_equal(int n1, int n2){
        return (n1 ^ n2) == 0;
    }
    private static void print_bit(int n){
        Stack<Integer> stack = new Stack<Integer>();
        int num_bytes = 1;

        for (int i=0; i < Integer.BYTES * num_bytes; ++i){
            if ((n & 1) == 1){
                System.out.print(1);
                stack.push(1);
            }else{
                stack.push(0);
            }
            n >>>= 1;
        }
        for (int i=0; i < Integer.BYTES * num_bytes; ++i){
            System.out.print(stack.pop());
        }
    }
    public static void main(String[] args) {
        // System.out.println(-127 & 2);
        print_bit(3);
        // System.out.println(is_bit_equal(0, -0));
    }
}
// 2 ^ 8 = 256
// 2 ^ 7 = 128
// 7 = 111
// -7 = 121
// -0