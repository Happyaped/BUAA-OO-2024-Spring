import java.math.BigInteger;
import java.util.HashMap;

public class Printer {
    private HashMap<Integer, BigInteger> value;

    public Printer(HashMap<Integer, BigInteger> value) {
        this.value = value;
    }

    public void finalprint() {
        StringBuilder sb = new StringBuilder();
        int mark = 0;
        for (int key : value.keySet()) {
            if (!value.get(key).equals(BigInteger.ZERO)) {
                mark = 1;
            }
        }
        if (mark == 0) {
            sb.append("0");
        }
        int flag = 0;
        //指数，系数
        for (int key : value.keySet()) {
            if (key == 1) {
                //指数为1
                if (value.get(key).equals(BigInteger.ZERO)) {
                    continue;
                } else if (value.get(key).compareTo(BigInteger.ZERO) > 0) {
                    //系数大于0
                    if (flag == 0) {
                        sb.append(value.get(key) + "*x");
                    } else {
                        sb.append("+" + value.get(key) + "*x");
                    }
                } else {
                    //系数小于0
                    sb.append(value.get(key) + "*x");
                }
            } else if (key == 0) {
                //指数为0
                if (value.get(key).equals(BigInteger.ZERO)) {
                    continue;
                } else if (value.get(key).compareTo(BigInteger.ZERO) > 0) {
                    //系数大于0
                    if (flag == 0) {
                        sb.append(value.get(key));
                    } else {
                        sb.append("+" + value.get(key));
                    }
                } else {
                    //系数小于0
                    sb.append(value.get(key));
                }
            } else {
                //指数为其他
                if (value.get(key).equals(BigInteger.ZERO)) {
                    continue;
                } else if (value.get(key).compareTo(BigInteger.ZERO) > 0) {
                    //系数大于0
                    if (flag == 0) {
                        sb.append(value.get(key) + "*x^" + key);
                    } else {
                        sb.append("+" + value.get(key) + "*x^" + key);
                    }
                } else {
                    //系数小于0
                    sb.append(value.get(key) + "*x^" + key);
                }
            }
            flag++;
        }
        System.out.println(sb.toString());
    }
}
