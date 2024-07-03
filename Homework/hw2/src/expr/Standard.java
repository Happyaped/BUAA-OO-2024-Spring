package expr;

import java.math.BigInteger;
import java.util.ArrayList;

public class Standard {
    private BigInteger coef;//系数
    private BigInteger index;//x的指数
    private ArrayList<Standard> comindex;//exp里面的东西

    public Standard(BigInteger coef, BigInteger index) {
        this.coef = coef;
        this.index = index;
        comindex = new ArrayList<>();
    }

    public BigInteger getCoef() {
        return coef;
    }

    public BigInteger getIndex() {
        return index;
    }

    public ArrayList<Standard> getComindex() {
        return comindex;
    }

    public void setComindex(ArrayList<Standard> comindex) {
        this.comindex = comindex;
    }

    public void reversecoef() {
        coef = coef.negate();
    }

    public void setCoef(BigInteger coef) {
        this.coef = coef;
    }

    public void mulcoef(int num) {
        coef = coef.multiply(BigInteger.valueOf(num));
    }
}
