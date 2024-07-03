package expr;

import java.math.BigInteger;
import java.util.ArrayList;

public class Exponent implements Factor {
    private Factor factor;
    private int index;
    private ArrayList<Standard> value;

    public Exponent(Factor factor, int index) {
        this.factor = factor;
        this.index = index;
        this.value = new ArrayList<>();
    }

    @Override
    public ArrayList<Standard> calValue() {
        Standard standard = new Standard(BigInteger.ONE, BigInteger.ZERO);
        standard.setComindex(Calculation.Indexin(factor.calValue(), index));
        value.add(standard);
        return value;
    }
}
