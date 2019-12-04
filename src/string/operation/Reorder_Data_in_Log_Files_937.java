package string.operation;

import java.util.Comparator;

class Reorder_Data_in_Log_Files_937 {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {

            Arrays.sort(logs, (log1, log2) -> {
                String[] str1 = log1.split(" ", 2);
                String[] str2 = log2.split(" ", 2);

                boolean isDigital1 = Character.isDigital(str1[1].charAt[0]);
                boolean isDigital2 = Character.isDigital(str2[1].charAt[0]);

                if (!isDigital1 && !isDigital2) {
                    int result = str1[1].compareTo(str2[1]);
                    if (result != 0) {
                        return result;
                    }
                    return str1[0].compareTo(str2[0]);
                }

                if (isDigital1) {
                    if (isDigital2) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return -1;
                }
            });

            return logs;
        }
    }
}