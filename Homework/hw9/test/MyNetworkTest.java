import com.oocourse.spec1.exceptions.EqualPersonIdException;
import com.oocourse.spec1.main.Network;
import com.oocourse.spec1.main.Person;

import static org.junit.Assert.*;

public class MyNetworkTest {

    MyNetwork network = new MyNetwork();

    @org.junit.Test
    public void queryTripleSum() {
        try {
            network.addPerson(new MyPerson(1, "aa", 111));
            network.addPerson(new MyPerson(2, "bb", 222));
            network.addPerson(new MyPerson(3, "cc", 333));
            network.addPerson(new MyPerson(4, "dd", 444));
            network.addPerson(new MyPerson(5, "ee", 555));
            network.addPerson(new MyPerson(6, "ff", 666));
            network.addPerson(new MyPerson(7, "gg", 777));
            network.addPerson(new MyPerson(8, "hh", 888));
            network.addPerson(new MyPerson(9, "ii", 999));
            network.addPerson(new MyPerson(10, "jj", 1000));
            network.addPerson(new MyPerson(11, "kk", 1100));
            network.addPerson(new MyPerson(12, "ll", 1100));
        } catch (EqualPersonIdException e) {
            throw new RuntimeException(e);
        }
        try {
            network.addRelation(7, 10, -997);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 4, -486);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 10, -130);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 3, -467);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 5, -126);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 6, -261);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(10, 4, -420);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 7, -685);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 10, -613);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 4, -437);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(9, 5, -976);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(5, 4, -731);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 7, -558);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 2, -532);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 8, -471);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 9, -926);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 2, -821);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 2, -169);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(3, 8, -21);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 1, -605);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 5, -298);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(5, 1, -123);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(3, 2, -175);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 2, -533);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 6, -633);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 7, -255);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 9, -269);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 10, -569);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 7, -171);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 1, -339);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 4, -859);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 12, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(1, 7, -666);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 6, -322);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 10, -363);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 4, -98);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(5, 3, -330);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 3, -441);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 1, -134);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 2, -696);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 5, -283);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(10, 7, -511);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 7, -102);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(9, 9, -803);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 8, -924);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 9, -888);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(7, 9, -533);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 9, -530);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 3, -349);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 5, -351);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(5, 2, -290);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(7, 10, -408);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 3, -258);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 8, -978);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 10, -507);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 9, -924);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 1, -474);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 3, -32);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 5, -75);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 8, -235);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 10, -877);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 4, -864);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 3, -729);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 10, -970);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(5, 4, -145);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(5, 8, -318);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 5, -199);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(1, 2, -427);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 3, -386);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 2, -170);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(3, 7, -214);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 2, -600);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 7, -566);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 2, -4);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 2, -830);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(10, 6, -358);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 1, -789);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(5, 8, -709);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 2, -585);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 3, -622);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(10, 9, -805);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(1, 1, -569);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 6, -644);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 7, -935);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(1, 4, -552);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 7, -894);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 10, -979);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(5, 9, -171);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 5, -225);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 2, -949);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(1, 2, -909);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 10, -312);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(1, 1, -285);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 6, -557);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 10, -401);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(9, 4, -1);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(1, 8, -429);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 2, -168);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 1, -54);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 1, -540);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(7, 1, -896);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 9, -356);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(10, 10, -6);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(7, 9, -510);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 10, -166);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(9, 7, -301);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 3, -621);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 9, -694);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(10, 12, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 2, -458);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(3, 4, -503);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 7, -802);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(10, 2, -350);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 2, -87);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 10, -531);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 10, -998);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 8, -486);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 12, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(3, 3, -938);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(10, 1, -794);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 3, -626);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(1, 6, -771);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 12, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 4, -973);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 3, -919);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 6, -336);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 4, -239);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(9, 1, -462);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 12, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 6, -76);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(1, 4, -64);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(4, 10, -342);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(5, 8, -565);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(10, 6, -382);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 9, -410);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 10, -887);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 4, -497);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(1, 12, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 1, -12);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 10, -157);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(9, 10, -36);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(5, 1, -193);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 7, -184);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(5, 10, -629);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(11, 3, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(10, 8, -853);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 10, -869);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 3, -648);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 4, -921);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 9, -722);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 1, -466);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(1, 6, -239);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 1, -287);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(11, 2, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(5, 7, -626);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 8, -170);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(4, 2, -810);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 7, -264);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 9, -137);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(6, 4, -222);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 3, -623);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(11, 1, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 4, -388);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(10, 5, -2);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(1, 10, -547);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 9, -314);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(2, 8, -933);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(10, 1, -395);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 2, -929);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(11, 12, -996);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(3, 7, -126);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 6, -552);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(3, 6, -478);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(7, 3, -215);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(8, 7, -353);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(8, 3, -181);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(2, 5, -727);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(6, 7, -477);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(7, 7, -110);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.modifyRelation(7, 3, -163);
        } catch (Exception e) {
            System.out.println();
        }
        try {
            network.addRelation(3, 6, -854);
        } catch (Exception e) {
            System.out.println();
        }
        int sum = 0;
        Person[] oldPeople=network.getPersons();
        for (int i = 0; i < oldPeople.length; i++) {
            for (int j = i + 1; j < oldPeople.length; j++) {
                for (int k = j + 1; k < oldPeople.length; k++) {
                    if (oldPeople[i].isLinked(oldPeople[j]) &&
                            oldPeople[j].isLinked(oldPeople[k]) &&
                            oldPeople[k].isLinked(oldPeople[i])) {
                        sum++;
                    }
                }
            }
        }
        assertEquals(sum,network.queryTripleSum());
        Person[] people1=network.getPersons();
        for(int i=0;i<oldPeople.length;i++){
            Boolean a=((MyPerson)oldPeople[i]).strictEquals(people1[i]);
            assertEquals(a,true);
        }
    }
}