import expr.Expression;
import expr.Num;
import expr.Term;
import expr.Variable;
import expr.Factor;

import java.math.BigInteger;

public class Parser {
    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public Expression parseExpr() {
        Expression expr = new Expression();
        expr.addTerms(parseTerm());
        while ("+-".contains(lexer.peek())) {
            expr.addOps(lexer.peek());
            lexer.next();
            expr.addTerms(parseTerm());
        }
        return expr;
    }

    public Term parseTerm() {
        Term term = new Term();
        term.addFactors(parseFactor());
        while (lexer.peek().equals("*")) {
            lexer.next();
            term.addFactors(parseFactor());
        }
        return term;
    }

    public Factor parseFactor() {
        if (lexer.peek().equals("(")) {
            lexer.next();
            Factor expr = parseExpr();
            lexer.next();
            if (lexer.peek().equals("^")) {
                lexer.next();
                if (expr instanceof Expression) {
                    ((Expression) expr).setIndex(Integer.parseInt(lexer.peek()));
                }
                lexer.next();
            }
            return expr;
        } else if (lexer.peek().equals("x")) {
            int index = 1;
            lexer.next();
            if (lexer.peek().equals("^")) {
                lexer.next();
                index = Integer.parseInt(lexer.peek());
                lexer.next();
            }
            return new Variable(index);

        } else {
            //System.out.println("!"+lexer.peek());
            if (lexer.peek().equals("-")) {
                lexer.next();
                String s = "-" + lexer.peek();
                //System.out.println(s+"!");
                BigInteger number = new BigInteger(s);
                lexer.next();
                return new Num(number);
            } else {
                //System.out.println("!"+lexer.peek());
                BigInteger number = new BigInteger(lexer.peek());
                lexer.next();
                System.out.println("!"+lexer.peek());
                return new Num(number);
            }
        }
    }
}
