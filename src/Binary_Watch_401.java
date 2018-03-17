import java.util.ArrayList;
import java.util.List;

public class Binary_Watch_401 {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
}
