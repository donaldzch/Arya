package bit.operation;

import java.util.ArrayList;
import java.util.List;

public class Gray_Code_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int i = 0, code = 0;
        while (i < n) {
            int newCode = code ^ (1 << i);
            if (result.contains(newCode))
                i++;
            else {
                result.add(newCode);
                code = newCode;
                i = 0;
            }
        }
        return result;
    }

    public List<Integer> grayCode1(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >=0; j--)
                list.add(list.get(j) + 1 << i);
        }

        return list;
    }
}
