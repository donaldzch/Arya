package number.operation;

public class Excel_Sheet_Column_Title_168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.append((char)('A' + (n % 26)));
            n = n / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
