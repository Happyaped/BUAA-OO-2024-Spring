package expr;

import expr.Standard;

import java.math.BigInteger;
import java.util.ArrayList;

public class Calculation {
    public static ArrayList<Standard> Mul(ArrayList<Standard> list1, ArrayList<Standard> list2) {
        ArrayList<Standard> back = new ArrayList<>();
        for (Standard item1 : list1) {
            for (Standard item2 : list2) {
                BigInteger temint = item1.getCoef().multiply(item2.getCoef());
                BigInteger temindex = item1.getIndex().add(item2.getIndex());
                ArrayList<Standard> temcomindex;
                temcomindex = Add(item1.getComindex(), item2.getComindex());
                Standard temstand = new Standard(temint, temindex);
                temstand.setComindex(temcomindex);
                back = Merge(back, temstand);
            }
        }
        return back;
    }

    public static ArrayList<Standard> Add(ArrayList<Standard> list1, ArrayList<Standard> list2) {
        ArrayList<Standard> back = new ArrayList<>();
        for (Standard item1 : list1) {
            back = Merge(back, item1);
        }
        for (Standard item2 : list2) {
            back = Merge(back, item2);
        }
        //可以考虑合并
        return back;
    }

    public static ArrayList<Standard> Sub(ArrayList<Standard> list1, ArrayList<Standard> list2) {
        ArrayList<Standard> back = new ArrayList<>();
        for (Standard item1 : list1) {
            back = Merge(back, item1);
        }
        for (Standard item2 : list2) {
            item2.reversecoef();
            back = Merge(back, item2);
        }
        return back;
    }

    public static ArrayList<Standard> Indexin(ArrayList<Standard> list, int index) {
        for (Standard item : list) {
            item.mulcoef(index);
        }
        return list;
    }

    public static ArrayList<Standard> Merge(ArrayList<Standard> list, Standard standard) {
        ArrayList<Standard> back = new ArrayList<>();
        for (Standard item : list) {
            back.add(item);
        }
        int mark = -1;
        for (int i = 0; i < list.size(); i++) {
            if (standard.getIndex().equals(list.get(i).getIndex()) &&
                    checkMerge(standard.getComindex(),
                    list.get(i).getComindex())) {
                //System.out.println("!!");
                mark = i;
                break;
            }
        }
        if (mark != -1) {
            BigInteger temint = back.get(mark).getCoef().add(standard.getCoef());
            Standard temstand = new Standard(temint, standard.getIndex());
            temstand.setComindex(standard.getComindex());
            back.remove(mark);
            back.add(temstand);
            return back;
        } else {
            back.add(standard);
            return back;
        }
    }

    public static boolean checkMerge(ArrayList<Standard> list1, ArrayList<Standard> list2) {
        ArrayList<Standard> temlist1 = new ArrayList<>();
        ArrayList<Standard> temlist2 = new ArrayList<>();
        for (Standard item : list1) {
            if (!item.getCoef().equals(0)) {
                temlist1.add(item);
            }
        }
        for (Standard item : list2) {
            if (!item.getCoef().equals(0)) {
                temlist2.add(item);
            }
        }
        if (temlist1.size() == 0 && temlist2.size() == 0) {
            return true;
        } else if (temlist1.size() != temlist2.size()) {
            return false;
        }
        int mark = 0;
        for (Standard item1 : temlist1) {
            int flag = 0;
            for (Standard item2 : temlist2) {
                if (item1.getCoef().equals(item2.getCoef()) &&
                        item1.getIndex().equals(item2.getIndex()) &&
                        checkMerge(item1.getComindex(), item2.getComindex())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                mark = 1;
                break;
            }
        }
        if (mark == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkStandard(Standard standard1, Standard standard2) {
        return true;
    }
}
