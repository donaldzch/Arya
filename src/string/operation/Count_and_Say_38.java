package string.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Count_and_Say_38 {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        for (int i = 2; i <= n; i++) {
            int k = queue.size();
            int value = queue.poll();
            int count = 1;
            if (!queue.isEmpty()) {
                for (int j = 1; j < k; j++) {
                    int current = queue.peek();
                    if (value == current) {
                        count++;
                        queue.poll();
                    } else {
                        queue.add(count);
                        queue.add(value);
                        value = queue.poll();
                        count = 1;
                    }
                    if (j == k - 1) {
                        queue.add(count);
                        queue.add(value);
                    }
                }
            } else {
                queue.add(count);
                queue.add(value);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            String ret = new Count_and_Say_38().countAndSay(n);

            String out = (ret);

            System.out.print(out);
        }
    }
}
