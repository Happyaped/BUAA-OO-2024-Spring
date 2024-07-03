import java.util.ArrayList;
import java.util.HashMap;

public class Lexer {
    private String input;
    private String curtoken;
    private int pos;
    private HashMap<String, Function> function;

    public Lexer(String input, HashMap<String, Function> function) {
        this.input = input;
        this.function = function;
        pos = 0;
    }

    public void initOperate() {
        input = input.replaceAll("\\s", "");
        input = input.replaceAll("\\t", "");//去掉空格和制表符
        input = input.replaceAll("---", "-");
        input = input.replaceAll("--\\+", "+");
        input = input.replaceAll("-\\+-", "+");
        input = input.replaceAll("-\\+\\+", "-");
        input = input.replaceAll("\\+--", "+");
        input = input.replaceAll("\\+-\\+", "-");
        input = input.replaceAll("\\+\\+-", "-");
        input = input.replaceAll("\\+\\+\\+", "+");
        input = input.replaceAll("--", "+");
        input = input.replaceAll("\\+-", "-");
        input = input.replaceAll("-\\+", "-");
        input = input.replaceAll("\\+\\+", "+");//去掉多余符号
        input = input.replaceAll("\\*\\+", "*");
        input = input.replaceAll("\\(\\+", "(");
        input = input.replaceAll("\\^\\+", "^");
        //input = input.replaceAll("-", "-1*");
        input = input.replaceAll(",\\+", ",");
        while (input.contains("f") || input.contains("g") || input.contains("h")) {
            input = deleteFunc(input);
        }
        //System.out.println("!" + input);
        input = input.replaceAll("\\s", "");
        input = input.replaceAll("\\t", "");//去掉空格和制表符
        input = input.replaceAll("---", "-");
        input = input.replaceAll("--\\+", "+");
        input = input.replaceAll("-\\+-", "+");
        input = input.replaceAll("-\\+\\+", "-");
        input = input.replaceAll("\\+--", "+");
        input = input.replaceAll("\\+-\\+", "-");
        input = input.replaceAll("\\+\\+-", "-");
        input = input.replaceAll("\\+\\+\\+", "+");
        input = input.replaceAll("--", "+");
        input = input.replaceAll("\\+-", "-");
        input = input.replaceAll("-\\+", "-");
        input = input.replaceAll("\\+\\+", "+");//去掉多余符号
        input = input.replaceAll("\\*\\+", "*");
        input = input.replaceAll("\\(\\+", "(");
        input = input.replaceAll("\\^\\+", "^");
        input = input.replaceAll("-", "-1*");
        //input = input.replaceAll("\\(","((");
        //input = input.replaceAll("\\)","))");
        //System.out.println("!!"+input);
        input = furtherinit(input);
        if (input.charAt(0) == '-' || input.charAt(0) == '+') {
            input = "0" + input;
        }
        //System.out.println("!!" + input);
        this.next();
    }

    public String furtherinit(String input) {
        String s = input;
        int mark1 = 0;
        int mark2;
        int num = -1;
        int type = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' && type == 0) {
                if (s.charAt(i + 2) == '(') {
                    type = 0;
                } else {
                    type = 1;
                    num++;
                    mark1 = i;
                }
                continue;
            }
            if (type == 1 && s.charAt(i) == '(') {
                num++;
            } else if (type == 1 && s.charAt(i) == ')') {
                num--;
            }
            if (type == 1 && num == 0) {
                mark2 = i;
                s = s.substring(0, mark1 + 1) + "(" +
                        s.substring(mark1 + 1, mark2) + ")" + s.substring(mark2);
                type = 0;
                num = -1;
                i = mark1;
            }
        }
        return s;
    }

    public String deleteFunc(String input) {
        if (!input.contains("f") && !input.contains("g") && !input.contains("h")) {
            return input;
        }
        String s = input;
        while (s.contains("f") || s.contains("g") || s.contains("h")) {
            int start = 0;//函数名的位置f g h
            int end = 0;//函数结尾的位置)
            int mark = 0;
            int mark1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i) == 'f' || s.charAt(i) == 'g' ||
                        s.charAt(i) == 'h') && mark == 0) {
                    mark = 1;
                    start = i;
                }
                if (s.charAt(i) == '(' && mark == 1) {
                    mark1++;
                }
                if (mark == 1 && s.charAt(i) == ')') {
                    mark1--;
                    if (mark1 == 0) {
                        end = i;
                        break;
                    }
                }
            }
            //System.out.println("!!!"+s);
            String fun = s.substring(start + 2, end);//函数调用括号内的部分
            //System.out.println("!"+fun);
            int flag = 0;
            int start1 = 0;
            int end1 = 0;
            ArrayList<String> groups = new ArrayList<>();//用来存储替换的字符串
            if (fun.contains(",")) {
                for (int i = 0; i < fun.length(); i++) {
                    if (fun.charAt(i) == '(') {
                        flag++;                    }
                    if (fun.charAt(i) == ')') {
                        flag--;                    }
                    if (fun.charAt(i) == ',' && flag == 0) {
                        end1 = i;
                        String tem = fun.substring(start1, end1);
                        //System.out.println(tem);
                        tem = deleteFunc(tem);
                        groups.add(tem);
                        start1 = end1 + 1;                    }
                    if (i == fun.length() - 1) {
                        String tem = fun.substring(start1);
                        tem = deleteFunc(tem);
                        groups.add(tem);                    }
                }
            } else {
                groups.add(deleteFunc(fun));            }
            Function tem = function.get(s.substring(start, start + 1));
            String funexpr = tem.getFuncExpr();
            for (int i = 0; i < tem.getVarNum(); i++) {
                String temexpr = "_" + tem.getVars().charAt(i);
                funexpr = funexpr.replaceAll(temexpr, groups.get(i));            }

            s = s.substring(0, start) + "(" + funexpr + ")" +
                    s.substring(end + 1);        }
        return s;
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
        if (c == '+' || c == '-' || c == '*' || c == '^' || c == '('
        ) {
            return true;
        } else if (c == ')' || c == 'x' || c == 'e' || c == 'p' || c == 'd') {
            return true;
        } else {
            return false;
        }
    }

    public String peek() {
        return this.curtoken;
    }
}
