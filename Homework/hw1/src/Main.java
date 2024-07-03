import expr.Expression;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Lexer lexer = new Lexer(input);
        lexer.initOperate();
        Parser parser = new Parser(lexer);
        Expression expr = parser.parseExpr();
        HashMap<Integer, BigInteger> value = expr.calValue();
        Printer printer = new Printer(value);
        printer.finalprint();
    }
}
