import expr.Expression;
import expr.Standard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        //System.out.println("!!"+num);
        HashMap<String, Function> function = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String s = scanner.nextLine();
            //System.out.println("!"+s);
            Function tem = new Function(s);
            tem.InitFunction();
            function.put(s.substring(0, 1), tem);
        }
        String input = scanner.nextLine();
        Lexer lexer = new Lexer(input, function);
        lexer.initOperate();
        Parser parser = new Parser(lexer);
        Expression expr = parser.parseExpr();
        //System.out.println("!!!"+expr.getTerms().size());
        ArrayList<Standard> value = expr.calValue();
        //System.out.println("!!");
        Printer printer = new Printer();
        System.out.println(printer.finalPrint(value));
    }
}
