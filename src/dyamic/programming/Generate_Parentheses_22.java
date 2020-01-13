package dyamic.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Generate_Parentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        
        result.add(Collections.singletonList(""));

        for (int i = 1; i <= n; i++) {
            List<String> temp = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                for (String first : result.get(j)) {
                    for (String second : result.get(i - j - 1)) {
                        temp.add("(" + first + ")" + second);
                    }
                }
            }
            result.add(temp);
        }

        return result.get(result.size() - 1);
    }
}