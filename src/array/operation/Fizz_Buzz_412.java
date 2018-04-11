package array.operation;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1, fuzz = 1, buzz = 1; i <= n; i++, fuzz++, buzz++) {
            if (fuzz == 3 && buzz == 5) {
                result.add("fizzBuz");
                fuzz = 0;
                buzz = 0;
            } else if (fuzz == 3) {
                result.add("fizz");
                fuzz = 0;
            } else if (buzz == 5) {
                result.add("buzz");
                buzz = 0;
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
