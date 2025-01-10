public class pairWiseSwap {
    /**
     * Generates a mask for even bits.
     * 
     * This method returns a 32-bit integer where all even bits are set to 1 
     * and all odd bits are set to 0. The binary representation of the mask is 
     * 0x55555555, which corresponds to the pattern 01010101010101010101010101010101.
     * 
     * @return an integer mask with even bits set to 1.
     */
    private static int get_even_mask(){
        return 0x55555555; // Mask for even bits: 10101010...
    }
    /**
     * Returns a bitmask with all odd bits set to 1.
     * 
     * The bitmask is represented by the hexadecimal value 0xAAAAAAAA, 
     * which corresponds to the binary pattern 10101010101010101010101010101010.
     * This pattern ensures that all odd-positioned bits (1st, 3rd, 5th, etc.) are set to 1.
     *
     * @return an integer bitmask with all odd bits set to 1.
     */
    private static int get_odd_mask(){
        return 0xAAAAAAAA; 
    }
    private static int pair_wise_swap(int num){
        int even_mask = get_even_mask();
        int odd_mask = get_odd_mask();
        return ((num & even_mask) << 1) + ((num & odd_mask) >>> 1);
    }

    public static void main(String[] args) {
        System.out.println(pair_wise_swap(47));
    }
}
