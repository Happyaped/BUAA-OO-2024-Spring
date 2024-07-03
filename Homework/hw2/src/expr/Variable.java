package expr;

import java.math.BigInteger;
import java.util.ArrayList;

public class Variable implements Factor {
    private int index;
    private ArrayList<Standard> value;

    public Variable(int index) {
        this.index = index;
        this.value = new ArrayList<>();
    }

    @Override
    public ArrayList<Standard> calValue() {
        Standard standard = new Standard(BigInteger.ONE, BigInteger.valueOf(index));
        value.add(standard);
        return value;
    }
}
