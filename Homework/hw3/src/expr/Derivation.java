package expr;

import java.util.ArrayList;

public class Derivation implements Factor {
    private Expression expression;
    private Integer index;
    private ArrayList<Standard> value;

    public Derivation(Expression expression,Integer index) {
        this.expression = expression;
        this.index = index;
        this.value = new ArrayList<>();
    }

    @Override
    public ArrayList<Standard> calValue() {
        ArrayList<Standard> tem = expression.calValue();
        value = Calculation.deleteDerivation(tem);
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
