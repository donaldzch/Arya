import java.util.Stack;

public class Baseball_Game_682 {
    public int calPoints(String[] ops) {
        Stack<Integer> points = new Stack<>();

        for (String op: ops) {
            if (op.equals("C")) {
                points.pop();
            } else if (op.equals("D")) {
                points.push(2 * points.peek());
            } else if (op.equals("+")) {
                int top = points.pop();
                int nextTop = points.peek();
                points.push(top);
                points.push(top + nextTop);
            } else {
                points.push(Integer.valueOf(op));
            }
        }

        int result = 0;
        for (Integer point : points)
            result += point;
        return result;
    }
}
