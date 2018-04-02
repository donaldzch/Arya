package bit.operation;

public class _1_bit_and_2_bit_Characters_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1)
                i += 2;
            else
                i += 1;
        }
        return i == bits.length - 1;
    }
}
