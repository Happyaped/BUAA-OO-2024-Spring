package expr;

import java.util.ArrayList;

public class Term {
    private ArrayList<Factor> factors;
    private ArrayList<Standard> value;

    public Term() {
        this.factors = new ArrayList<>();
        this.value = new ArrayList<>();
    }

    public void addFactors(Factor factor) {
        factors.add(factor);
    }

    public ArrayList<Standard> calValue() {
        value = factors.get(0).calValue();
        if (factors.size() == 1) {
            return value;
        } else {
            for (int i = 1; i < factors.size(); i++) {
                value = Calculation.Mul(value, factors.get(i).calValue());
            }
            return value;
        }
    }
}
