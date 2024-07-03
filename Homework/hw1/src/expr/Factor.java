package expr;

import java.math.BigInteger;
import java.util.HashMap;

public interface Factor {
    public HashMap<Integer, BigInteger> calValue();
}
