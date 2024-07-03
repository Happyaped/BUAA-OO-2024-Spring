package expr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Expression implements Factor {
    private ArrayList<Term> terms;
    private ArrayList<String> ops;
    private int index;
    private HashMap<Integer, BigInteger> value;

    public Expression() {
        this.terms = new ArrayList<>();
        this.ops = new ArrayList<>();
        this.value = new HashMap<>();
        this.index = 1;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<String> getOps() {
        return ops;
    }

    public ArrayList<Term> getTerms() {
        return terms;
    }

    public void addTerms(Term term) {
        terms.add(term);
    }

    public void addOps(String op) {
        ops.add(op);
    }

    @Override
    public HashMap<Integer, BigInteger> calValue() {
        //初始化value

        value = terms.get(0).calValue();

        if (terms.size() > 1) {
            ExprAddSub();
        }
        if (index == 0) {
            HashMap<Integer, BigInteger> tem = new HashMap<>();
            tem.put(0, BigInteger.ONE);
            return tem;
        } else if (index == 1) {
            return value;
        } else {
            HashMap<Integer, BigInteger> poly = new HashMap<>();
            for (int key : value.keySet()) {
                poly.put(key, value.get(key));
            }
            for (int i = 0; i < index - 1; i++) {
                value = ExprMul(poly, value);
            }
            return value;
        }
    }

    public HashMap<Integer, BigInteger> ExprMul(HashMap<Integer, BigInteger> poly,
                                                HashMap<Integer, BigInteger> temvalue) {
        HashMap<Integer, BigInteger> add = new HashMap<>();
        for (int key1 : poly.keySet()) {
            for (int key2 : temvalue.keySet()) {
                if (!add.containsKey(key1 + key2)) {
                    add.put(key1 + key2, poly.get(key1).multiply(temvalue.get(key2)));
                } else {
                    BigInteger temint = add.get(key1 + key2).add(poly.get(key1).multiply(
                            temvalue.get(key2)));
                    add.remove(key1 + key2);
                    add.put(key1 + key2, temint);
                }
            }
        }
        return add;
    }

    public void ExprAddSub() {
        //遍历terms和ops
        for (int i = 0; i < terms.size() - 1; i++) {
            //i+1开始
            HashMap<Integer, BigInteger> tem = terms.get(i + 1).calValue();
            //先看是不是减号
            //如果是减号
            if (ops.get(i).equals("-")) {
                //遍历tem
                for (int key : tem.keySet()) {
                    if (!value.containsKey(key)) {
                        value.put(key, tem.get(key).negate());
                    } else {
                        BigInteger temint = value.get(key).add(tem.get(key).negate());
                        value.remove(key);//可能有点问题
                        value.put(key, temint);
                    }
                }
            } else {
                //如果是加号
                for (int key : tem.keySet()) {
                    if (!value.containsKey(key)) {
                        value.put(key, tem.get(key));
                    } else {
                        BigInteger temint = value.get(key).add(tem.get(key));
                        value.remove(key);//可能有点问题
                        value.put(key, temint);
                    }
                }
            }
        }
    }

}
