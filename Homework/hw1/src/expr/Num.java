package expr;

import java.math.BigInteger;
import java.util.HashMap;

public class Num implements Factor {
    private BigInteger num;//系数
    private HashMap<Integer, BigInteger> value;

    public Num(BigInteger num) {
        this.num = num;
        this.value = new HashMap<>();
    }

    @Override
    public HashMap<Integer, BigInteger> calValue() {
        value.put(0, num);
        return value;
    }

}
