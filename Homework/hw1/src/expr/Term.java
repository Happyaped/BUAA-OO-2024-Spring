package expr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Term {
    private ArrayList<Factor> factors;//因子
    private HashMap<Integer, BigInteger> value;//指数，系数

    public Term() {
        this.factors = new ArrayList<>();
        this.value = new HashMap<>();
    }

    public void addFactors(Factor factor) {
        factors.add(factor);
    }

    public HashMap<Integer, BigInteger> calValue() {
        //初始化value
        value = factors.get(0).calValue();
        if (factors.size() == 1) {
            return value;
        } else {
            TermMul();
            return value;
        }
    }

    public void TermMul() {
        //遍历factors
        for (int i = 0; i < factors.size() - 1; i++) {
            //i+1开始
            HashMap<Integer, BigInteger> tem = factors.get(i + 1).calValue();
            HashMap<Integer, BigInteger> add = new HashMap<>();//存放更新结果
            //遍历value和tem
            for (int key1 : value.keySet()) {
                for (int key2 : tem.keySet()) {
                    if (!add.containsKey(key1 + key2)) {
                        add.put(key1 + key2, value.get(key1).multiply(tem.get(key2)));
                    } else {
                        BigInteger temint = add.get(key1 + key2).add(value.get(key1).multiply(
                                tem.get(key2)));
                        add.remove(key1 + key2);//可能有点问题
                        add.put(key1 + key2, temint);
                    }
                }
            }
            value = add;
        }
    }
}
