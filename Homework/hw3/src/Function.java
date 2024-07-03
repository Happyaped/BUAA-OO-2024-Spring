public class Function {
    private int varNum;//存储自变量的数目
    private String vars;//存储函数自变量的名字，按照定义的先后顺序存储“yx”
    private String funcExpr;//输入的函数等号右边的表达式
    private String funcName;//函数名

    public Function(String s) {
        funcName = s.substring(0, 1);
        int equalindex = s.indexOf("=");
        funcExpr = s.substring(equalindex + 1);
        String tem = s.substring(1, equalindex);//等号前面
        tem = tem.replaceAll("\\(", "");
        tem = tem.replaceAll("\\)", "");
        tem = tem.replaceAll(",", "");
        tem = tem.replaceAll("\\s", "");
        tem = tem.replaceAll("\\t", "");
        vars = tem;
        varNum = tem.length();
    }

    public void InitFunction() {
        funcExpr = funcExpr.replaceAll("x", "_x");
        funcExpr = funcExpr.replaceAll("y", "_y");
        funcExpr = funcExpr.replaceAll("z", "_z");
        funcExpr = funcExpr.replaceAll("e_", "e");
    }

    public int getVarNum() {
        return varNum;
    }

    public String getVars() {
        return vars;
    }

    public String getFuncExpr() {
        return funcExpr;
    }
}
