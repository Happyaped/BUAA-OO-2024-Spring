package expr;

import java.math.BigInteger;
import java.util.ArrayList;

public class Expression implements Factor {
    private ArrayList<Term> terms;
    private ArrayList<String> ops;
    private int index;
    private ArrayList<Standard> value;

    public Expression() {
        this.terms = new ArrayList<>();
        this.ops = new ArrayList<>();
        this.value = new ArrayList<>();
        this.index = 1;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void addTerms(Term term) {
        terms.add(term);
    }

    public ArrayList<Term> getTerms() {
        return terms;
    }

    public void addOps(String op) {
        ops.add(op);
    }

    @Override
    public ArrayList<Standard> calValue() {
        value = terms.get(0).calValue();
        if (terms.size() > 1) {
            for (int i = 0; i < terms.size() - 1; i++) {
                if (ops.get(i).equals("-")) {
                    value = Calculation.Sub(value, terms.get(i + 1).calValue());
                } else {
                    value = Calculation.Add(value, terms.get(i + 1).calValue());
                }
            }
        }
        if (index == 0) {
            ArrayList<Standard> tem = new ArrayList<>();
            Standard temstand = new Standard(BigInteger.ONE, BigInteger.ZERO);
            tem.add(temstand);
            return tem;
        } else if (index == 1) {
            return value;
        } else {
            ArrayList<Standard> poly = new ArrayList<>();
            for (Standard item : value) {
                poly.add(item);
            }
            for (int i = 0; i < index - 1; i++) {
                value = Calculation.Mul(value, poly);
            }
            return value;
        }
    }
}
