
public class Lexer {
    private String input;
    private String curtoken;
    private int pos;

    public Lexer(String input) {
        this.input = input;
        pos = 0;
    }

    public void initOperate() {
        input = input.replaceAll("\\s", "");
        input = input.replaceAll("\\t", "");//去掉空格和制表符
        input = input.replaceAll("---","-");
        input = input.replaceAll("--\\+","+");
        input = input.replaceAll("-\\+-","+");
        input = input.replaceAll("-\\+\\+","-");
        input = input.replaceAll("\\+--","+");
        input = input.replaceAll("\\+-\\+","-");
        input = input.replaceAll("\\+\\+-","-");
        input = input.replaceAll("\\+\\+\\+","+");
        input = input.replaceAll("--", "+");
        input = input.replaceAll("\\+-", "-");
        input = input.replaceAll("-\\+", "-");
        input = input.replaceAll("\\+\\+", "+");//去掉多余符号
        input = input.replaceAll("\\*\\+", "*");
        input = input.replaceAll("\\(\\+", "(");
        input = input.replaceAll("\\^\\+", "^");
        input = input.replaceAll("-","-1*");
        if (input.charAt(0) == '-' || input.charAt(0) == '+') {
            input = "0" + input;
        }
        //System.out.println("!"+input);
        this.next();
        //todo


    }

    public String getInput() {
        return input;
    }

    public void next() {
        if (pos == input.length()) {
            return;
        }

        char c = input.charAt(pos);
        if (Character.isDigit(c)) {
            curtoken = getNumber();
        } else if (isSignal(c)) {
            pos += 1;
            curtoken = String.valueOf(c);
        }
    }

    private String getNumber() {
        StringBuilder sb = new StringBuilder();
        while (pos < input.length() && Character.isDigit(input.charAt(pos))) {
            sb.append(input.charAt(pos));
            ++pos;
        }

        return sb.toString();
    }

    private boolean isSignal(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '^' || c == '(' || c == ')' || c == 'x') {
            return true;
        } else {
            return false;
        }
    }

    public String peek() {
        return this.curtoken;
    }
}
