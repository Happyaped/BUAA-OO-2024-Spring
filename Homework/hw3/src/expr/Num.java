package expr;

import java.math.BigInteger;
import java.util.ArrayList;

public class Num implements Factor {
    private BigInteger num;
    private Integer index;
    private ArrayList<Standard> value;

    public Num(BigInteger num, Integer index) {
        this.num = num;
        this.index = index;
        this.value = new ArrayList<>();
    }

    @Override
    public ArrayList<Standard> calValue() {
        BigInteger temint = num;
        for (int i = 0; i < index - 1; i++) {
            temint = temint.multiply(num);
        }
        Standard standard = new Standard(temint, BigInteger.ZERO);
        value.add(standard);
        return value;
    }
}
