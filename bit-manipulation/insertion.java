public class insertion {

    // insert m into n
    public static int insert(int n, int m, int i, int j){
        /*
         * 1. Reset the bits to be updated in n.
         * 2. Right shift m to match the position.
         * 3. Do a or operation of the two and that's the answer.
         */
        int m_len = j - i + 1;
        int m_len_1s = (int)Math.pow(2, m_len) - 1;  // 000011
        int mask = ~(m_len_1s << i);  // 110011
        n = n & mask;  // reset n from j to i
        n = n | (m << i);  // insert m into n
        
        return n;
    }
    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(
            insert(0b10000000000, 0b10011, 2, 6)));
    }
}