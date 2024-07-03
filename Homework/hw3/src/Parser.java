import expr.Num;
import expr.Term;
import expr.Factor;
import expr.Variable;
import expr.Exponent;
import expr.Derivation;
import expr.Expression;

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
            int index = 1;
            while (lexer.peek().equals("^")) {
                lexer.next();
                if (expr instanceof Expression) {
                    index = index * Integer.parseInt(lexer.peek());
                    ((Expression) expr).setIndex(index);                }
                lexer.next();            }
            return expr;        } else if (lexer.peek().equals("x")) {
            int index = 1;
            lexer.next();
            while (lexer.peek().equals("^")) {
                lexer.next();
                index = index * Integer.parseInt(lexer.peek());
                lexer.next();            }
            return new Variable(index);
        } else if (lexer.peek().equals("e")) {
            int index = 1;
            lexer.next();//指向x
            lexer.next();//指向p
            lexer.next();//指向(
            lexer.next();
            Factor factor = parseFactor();
            lexer.next();
            while (lexer.peek().equals("^")) {
                lexer.next();
                index = index * Integer.parseInt(lexer.peek());
                lexer.next();            }
            return new Exponent(factor, index);
        } else if (lexer.peek().equals("d")) {
            return parseDerivation();        } else {
            //System.out.println("!"+lexer.peek());
            if (lexer.peek().equals("-")) {
                int index = 1;
                lexer.next();
                String s = "-" + lexer.peek();
                //System.out.println(s+"!");
                BigInteger number = new BigInteger(s);
                lexer.next();
                while (lexer.peek().equals("^")) {
                    lexer.next();
                    index = index * Integer.parseInt(lexer.peek());
                    lexer.next();
                }
                return new Num(number, index);
            } else {
                int index = 1;
                //System.out.println("!"+lexer.peek());
                BigInteger number = new BigInteger(lexer.peek());
                lexer.next();
                while (lexer.peek().equals("^")) {
                    lexer.next();
                    index = index * Integer.parseInt(lexer.peek());
                    lexer.next();
                }
                return new Num(number, index);
            }
        }
    }

    public Derivation parseDerivation() {
        int index = 1;
        lexer.next();//指向x
        lexer.next();//指向(
        lexer.next();
        Expression expression;
        expression = parseExpr();
        lexer.next();
        while (lexer.peek().equals("^")) {
            lexer.next();
            index = index * Integer.parseInt(lexer.peek());
            lexer.next();
        }
        Derivation derivation = new Derivation(expression, index);
        return derivation;
    }
}
