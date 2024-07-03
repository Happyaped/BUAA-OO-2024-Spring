import expr.Standard;

import java.math.BigInteger;
import java.util.ArrayList;

public class Printer {
    public String finalPrint(ArrayList<Standard> value) {
        StringBuilder sb = new StringBuilder();
        int mark = 0;
        for (Standard item : value) {
            if (!item.getCoef().equals(BigInteger.ZERO)) {
                mark = 1;
            }
        }
        if (mark == 0) {
            sb.append("0");
        }
        for (Standard item : value) {
            if (item.getComindex().size() == 0) {
                if (item.getCoef().equals(BigInteger.ZERO)) {
                    continue;
                } else if (item.getCoef().compareTo(BigInteger.ZERO) > 0) {
                    sb.append("+" + item.getCoef() + "*x^" + item.getIndex());
                    //System.out.println("!"+finalPrint(item.getComindex()));
                } else {
                    sb.append(item.getCoef() + "*x^" + item.getIndex());
                }
            } else {
                //comindex.size不为0
                if (item.getCoef().equals(BigInteger.ZERO)) {
                    continue;
                } else if (item.getCoef().compareTo(BigInteger.ZERO) > 0) {
                    sb.append("+" + item.getCoef() + "*x^" + item.getIndex() +
                            "*exp((" + finalPrint(item.getComindex()) + "))");
                    //System.out.println("!!"+finalPrint(item.getComindex()));
                } else {
                    sb.append(item.getCoef() + "*x^" + item.getIndex() +
                            "*exp((" + finalPrint(item.getComindex()) + "))");
                }
            }
        }
        if (sb.charAt(0) == '+') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
