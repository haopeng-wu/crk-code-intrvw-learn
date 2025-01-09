import java.Math;

public class conversion {

    /**
     * Returns the largest power of 2 less than or equal to the given number.
     *
     * @param num the number for which to find the largest power of 2
     * @return the largest power of 2 less than or equal to the given number
     */
    private static int get_largest_power(int num){
        int powers = 0;
        while (Math.pow(2, powers) < num){
            powers += 1;
        }
        return powers-1;
    }

    /**
     * Returns the number of bits that must be flipped to convert num1 to num2.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the number of bits that must be flipped to convert num1 to num2
     */
    private static int flips(int num1, int num2){
        int flip_counts = 0;
        int power1 = get_largest_power(num1);
        int power2 = get_largest_power(num2);
        while (power1 > 0 | power2 > 0){
            if (power1 > power2){
                // num1 has a higher order power, subtract the amount from it
                num1 -= Math.pow(2, power1);
                flip_counts += 1;
            }else if(power1 < power2){
                // num2 has a higher order power, subtract that from it
                num2 -= Math.pow(2, power2);
                flip_counts += 1;
            }else{
                // num1 and num2 both have the same order, subtract it from both
                num1 -= Math.pow(2, power1);
                num2 -= Math.pow(2, power2);
            }
            power1 = get_largest_power(num1);
            power2 = get_largest_power(num2);
        }
        return flip_counts;
    }

    public static void main(String[] args) {

        System.out.println(flips(29, 15));
    }
}
