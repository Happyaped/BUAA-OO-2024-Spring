package expr;

import java.math.BigInteger;
import java.util.HashMap;

public class Variable implements Factor {
    private int index;//指数
    private HashMap<Integer, BigInteger> value;

    public Variable(int index) {
        this.index = index;
        this.value = new HashMap<>();
    }

    @Override
    public HashMap<Integer, BigInteger> calValue() {
        value.put(index, BigInteger.valueOf(1));
        return value;
    }

}
