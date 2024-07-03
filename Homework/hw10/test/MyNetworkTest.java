import com.oocourse.spec2.exceptions.EqualPersonIdException;
import com.oocourse.spec2.main.Person;
import static org.junit.Assert.*;

public class MyNetworkTest {
    MyNetwork network = new MyNetwork();
    MyNetwork network1 = new MyNetwork();
    @org.junit.Test
    public void queryCoupleSum() {
        try {
            network.addPerson(new MyPerson(1, "aa", 10));
            network.addPerson(new MyPerson(2, "bb", 20));
            network.addPerson(new MyPerson(3, "cc", 30));
            network.addPerson(new MyPerson(4, "dd", 40));
            network.addPerson(new MyPerson(5, "ee", 50));
            network.addPerson(new MyPerson(6, "ff", 60));
            network.addPerson(new MyPerson(7, "gg", 70));
            network.addPerson(new MyPerson(8, "hh", 80));
            network.addPerson(new MyPerson(9, "ii", 90));
            network.addPerson(new MyPerson(10, "jj", 100));
            network.addPerson(new MyPerson(11, "kk", 110));
            network.addPerson(new MyPerson(12, "ll", 120));
            network.addPerson(new MyPerson(13, "aa", 10));
            network.addPerson(new MyPerson(14, "bb", 20));
            network.addPerson(new MyPerson(15, "cc", 30));

            network1.addPerson(new MyPerson(1, "aa", 10));
            network1.addPerson(new MyPerson(2, "bb", 20));
            network1.addPerson(new MyPerson(3, "cc", 30));
            network1.addPerson(new MyPerson(4, "dd", 40));
            network1.addPerson(new MyPerson(5, "ee", 50));
            network1.addPerson(new MyPerson(6, "ff", 60));
            network1.addPerson(new MyPerson(7, "gg", 70));
            network1.addPerson(new MyPerson(8, "hh", 80));
            network1.addPerson(new MyPerson(9, "ii", 90));
            network1.addPerson(new MyPerson(10, "jj", 100));
            network1.addPerson(new MyPerson(11, "kk", 110));
            network1.addPerson(new MyPerson(12, "ll", 120));
            network1.addPerson(new MyPerson(13, "aa", 10));
            network1.addPerson(new MyPerson(14, "bb", 20));
            network1.addPerson(new MyPerson(15, "cc", 30));
        } catch (EqualPersonIdException e) {
            throw new RuntimeException(e);
        }
        try {            network.modifyRelation(13, 13, -867); network1.modifyRelation(13, 13, -867);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 11, -856); network1.addRelation(9, 11, -856);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 8, -706); network1.addRelation(5, 8, -706);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 4, -554); network1.modifyRelation(11, 4, -554);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 6, -930); network1.addRelation(15, 6, -930);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 12, -307); network1.addRelation(8, 12, -307);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 15, -148); network1.addRelation(9, 15, -148);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 5, -293); network1.addRelation(14, 5, -293);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 6, -875); network1.addRelation(9, 6, -875);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 4, -492); network1.addRelation(15, 4, -492);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 7, -789); network1.addRelation(8, 7, -789);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 15, -578); network1.modifyRelation(12, 15, -578);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 6, -719); network1.addRelation(13, 6, -719);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 10, -748); network1.modifyRelation(5, 10, -748);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 8, -318); network1.addRelation(9, 8, -318);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 15, -340); network1.addRelation(13, 15, -340);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(8, 15, -926); network1.modifyRelation(8, 15, -926);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 12, -157); network1.addRelation(11, 12, -157);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 13, -223); network1.addRelation(7, 13, -223);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 3, -906); network1.modifyRelation(5, 3, -906);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 6, -115); network1.addRelation(3, 6, -115);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 8, -247); network1.modifyRelation(11, 8, -247);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 10, -121); network1.addRelation(13, 10, -121);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(7, 7, -261); network1.modifyRelation(7, 7, -261);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 1, -309); network1.modifyRelation(5, 1, -309);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 9, -323); network1.addRelation(13, 9, -323);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 12, -550); network1.modifyRelation(4, 12, -550);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 2, -288); network1.addRelation(5, 2, -288);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 3, -39); network1.addRelation(1, 3, -39);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 5, -562); network1.addRelation(13, 5, -562);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 4, -207); network1.modifyRelation(4, 4, -207);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 11, -714); network1.addRelation(14, 11, -714);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 4, -736); network1.addRelation(1, 4, -736);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 13, -37); network1.modifyRelation(12, 13, -37);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 7, -131); network1.addRelation(5, 7, -131);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 9, -285); network1.addRelation(1, 9, -285);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 13, -227); network1.addRelation(10, 13, -227);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 12, -422); network1.addRelation(9, 12, -422);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 13, -646); network1.modifyRelation(10, 13, -646);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 9, -857); network1.addRelation(7, 9, -857);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 5, -967); network1.modifyRelation(14, 5, -967);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 14, -780); network1.addRelation(8, 14, -780);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 14, -678); network1.modifyRelation(2, 14, -678);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 8, -424); network1.addRelation(1, 8, -424);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(3, 1, -535); network1.modifyRelation(3, 1, -535);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 11, -362); network1.addRelation(13, 11, -362);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 1, -863); network1.addRelation(11, 1, -863);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 10, -819); network1.addRelation(2, 10, -819);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 2, -722); network1.addRelation(2, 2, -722);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 1, -537); network1.addRelation(7, 1, -537);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 2, -327); network1.addRelation(6, 2, -327);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 2, -203); network1.modifyRelation(2, 2, -203);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 4, -170); network1.modifyRelation(5, 4, -170);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 9, -816); network1.modifyRelation(10, 9, -816);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 8, -633); network1.modifyRelation(12, 8, -633);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 7, 0); network1.addRelation(7, 7, 0);        } catch (Exception e) {
            System.out.println();        }
        try {            network.addRelation(13, 11, 0); network1.addRelation(13, 11, 0);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 14, -25); network1.modifyRelation(15, 14, -25);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 5, -798); network1.modifyRelation(9, 5, -798);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 1, -156); network1.modifyRelation(1, 1, -156);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 11, -765); network1.addRelation(5, 11, -765);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 15, -558); network1.addRelation(10, 15, -558);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 4, -390); network1.addRelation(13, 4, -390);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 2, -304); network1.addRelation(9, 2, -304);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 5, -458); network1.modifyRelation(13, 5, -458);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 8, -239); network1.modifyRelation(6, 8, -239);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 4, -162); network1.modifyRelation(12, 4, -162);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 12, -21); network1.modifyRelation(15, 12, -21);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 5, -768); network1.addRelation(8, 5, -768);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 3, -261); network1.modifyRelation(5, 3, -261);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 10, -380); network1.modifyRelation(11, 10, -380);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 12, -67); network1.addRelation(13, 12, -67);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(3, 2, -640); network1.modifyRelation(3, 2, -640);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 13, -906); network1.addRelation(14, 13, -906);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 1, -381); network1.addRelation(6, 1, -381);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 5, -804); network1.addRelation(5, 5, -804);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 9, -747); network1.addRelation(10, 9, -747);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 1, -173); network1.addRelation(5, 1, -173);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 8, -740); network1.addRelation(3, 8, -740);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 5, -432); network1.addRelation(11, 5, -432);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 11, -674); network1.modifyRelation(14, 11, -674);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 12, -953); network1.addRelation(6, 12, -953);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 2, -301); network1.modifyRelation(15, 2, -301);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 5, -481); network1.addRelation(15, 5, -481);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 9, -158); network1.addRelation(5, 9, -158);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 9, -742); network1.addRelation(6, 9, -742);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 8, -262); network1.addRelation(1, 8, -262);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 4, -976); network1.addRelation(2, 4, -976);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(7, 9, -808); network1.modifyRelation(7, 9, -808);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 13, -349); network1.modifyRelation(5, 13, -349);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 15, -586); network1.addRelation(4, 15, -586);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 11, -534); network1.modifyRelation(11, 11, -534);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 4, -809); network1.addRelation(10, 4, -809);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 9, -152); network1.modifyRelation(9, 9, -152);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 12, -786); network1.addRelation(3, 12, -786);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 4, -852); network1.addRelation(5, 4, -852);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(7, 1, -177); network1.modifyRelation(7, 1, -177);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 14, -30); network1.addRelation(9, 14, -30);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 12, -558); network1.addRelation(10, 12, -558);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 5, -178); network1.addRelation(1, 5, -178);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 5, -395); network1.addRelation(10, 5, -395);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 10, -858); network1.addRelation(9, 10, -858);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 12, -576); network1.addRelation(1, 12, -576);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 8, -105); network1.addRelation(2, 8, -105);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 14, -503); network1.addRelation(1, 14, -503);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 12, -668); network1.addRelation(15, 12, -668);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 3, -120); network1.modifyRelation(5, 3, -120);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 12, -132); network1.modifyRelation(14, 12, -132);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 1, -197); network1.modifyRelation(14, 1, -197);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 6, -517); network1.addRelation(15, 6, -517);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 4, -711); network1.addRelation(6, 4, -711);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 1, -594); network1.addRelation(3, 1, -594);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 12, -160); network1.addRelation(14, 12, -160);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 8, -975); network1.modifyRelation(4, 8, -975);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(3, 5, -599); network1.modifyRelation(3, 5, -599);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 7, -621); network1.addRelation(14, 7, -621);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 8, -151); network1.modifyRelation(6, 8, -151);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 6, -57); network1.addRelation(11, 6, -57);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 9, -696); network1.addRelation(3, 9, -696);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 5, -374); network1.addRelation(13, 5, -374);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 3, -877); network1.addRelation(11, 3, -877);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 4, -326); network1.addRelation(5, 4, -326);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 1, -140); network1.addRelation(4, 1, -140);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 8, -69); network1.addRelation(6, 8, -69);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 4, -777); network1.addRelation(8, 4, -777);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 4, -910); network1.modifyRelation(12, 4, -910);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 5, -619); network1.addRelation(10, 5, -619);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 2, -540); network1.modifyRelation(10, 2, -540);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 1, -965); network1.addRelation(12, 1, -965);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 4, -675); network1.addRelation(10, 4, -675);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 5, -775); network1.modifyRelation(4, 5, -775);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 11, -404); network1.addRelation(2, 11, -404);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 8, -483); network1.addRelation(9, 8, -483);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 15, -476); network1.modifyRelation(2, 15, -476);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 1, -456); network1.addRelation(2, 1, -456);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 4, -389); network1.addRelation(11, 4, -389);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 4, -162); network1.addRelation(4, 4, -162);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 8, -636); network1.addRelation(8, 8, -636);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 3, -888); network1.addRelation(4, 3, -888);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 1, -593); network1.addRelation(9, 1, -593);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 9, -260); network1.modifyRelation(2, 9, -260);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 1, -890); network1.addRelation(9, 1, -890);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 2, -999); network1.addRelation(9, 2, -999);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 3, -721); network1.modifyRelation(9, 3, -721);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 14, -786); network1.modifyRelation(6, 14, -786);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 9, -866); network1.addRelation(7, 9, -866);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 14, -982); network1.addRelation(5, 14, -982);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 5, -37); network1.addRelation(7, 5, -37);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 11, -293); network1.addRelation(3, 11, -293);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 1, -562); network1.addRelation(7, 1, -562);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 7, -695); network1.addRelation(14, 7, -695);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 1, -840); network1.addRelation(4, 1, -840);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 2, -278); network1.addRelation(5, 2, -278);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 12, -524); network1.modifyRelation(2, 12, -524);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 15, -219); network1.addRelation(6, 15, -219);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 9, -177); network1.addRelation(15, 9, -177);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 5, -279); network1.modifyRelation(11, 5, -279);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 13, -866); network1.modifyRelation(9, 13, -866);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 3, -649); network1.addRelation(1, 3, -649);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 11, -785); network1.addRelation(10, 11, -785);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 15, -198); network1.addRelation(2, 15, -198);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 12, -972); network1.addRelation(5, 12, -972);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 10, -805); network1.modifyRelation(1, 10, -805);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 6, -651); network1.addRelation(5, 6, -651);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 7, -871); network1.modifyRelation(2, 7, -871);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 13, -683); network1.modifyRelation(2, 13, -683);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 5, -246); network1.addRelation(4, 5, -246);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 6, -334); network1.modifyRelation(11, 6, -334);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 11, -226); network1.addRelation(4, 11, -226);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 11, -72); network1.addRelation(12, 11, -72);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 14, -373); network1.addRelation(8, 14, -373);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 14, -603); network1.addRelation(10, 14, -603);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 12, -544); network1.addRelation(13, 12, -544);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 10, -629); network1.modifyRelation(6, 10, -629);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 15, -59); network1.addRelation(4, 15, -59);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 5, -997); network1.modifyRelation(5, 5, -997);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 4, -394); network1.addRelation(14, 4, -394);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 12, -193); network1.modifyRelation(9, 12, -193);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 5, -675); network1.modifyRelation(5, 5, -675);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 1, -683); network1.addRelation(8, 1, -683);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 10, -657); network1.addRelation(5, 10, -657);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 7, -55); network1.addRelation(5, 7, -55);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 15, -483); network1.modifyRelation(11, 15, -483);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 8, -559); network1.addRelation(11, 8, -559);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 10, -389); network1.addRelation(13, 10, -389);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 9, -975); network1.addRelation(15, 9, -975);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 15, -510); network1.addRelation(9, 15, -510);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 5, -41); network1.modifyRelation(1, 5, -41);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(3, 10, -921); network1.modifyRelation(3, 10, -921);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 1, -818); network1.addRelation(3, 1, -818);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 2, -565); network1.addRelation(14, 2, -565);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 15, -4); network1.addRelation(4, 15, -4);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 7, -716); network1.addRelation(1, 7, -716);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 4, -722); network1.addRelation(14, 4, -722);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 5, -640); network1.addRelation(5, 5, -640);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 13, -799); network1.modifyRelation(10, 13, -799);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 10, -169); network1.modifyRelation(5, 10, -169);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 8, -279); network1.addRelation(14, 8, -279);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 15, -704); network1.modifyRelation(14, 15, -704);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 15, -355); network1.addRelation(2, 15, -355);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 1, -535); network1.addRelation(12, 1, -535);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 11, -777); network1.modifyRelation(14, 11, -777);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 11, -103); network1.addRelation(8, 11, -103);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 14, -811); network1.modifyRelation(4, 14, -811);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 11, -889); network1.addRelation(5, 11, -889);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 15, -996); network1.addRelation(1, 15, -996);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 3, -653); network1.addRelation(11, 3, -653);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 5, -70); network1.addRelation(14, 5, -70);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 6, -590); network1.addRelation(1, 6, -590);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 10, -758); network1.addRelation(9, 10, -758);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 6, -132); network1.addRelation(8, 6, -132);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 15, -205); network1.modifyRelation(4, 15, -205);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 8, -617); network1.addRelation(15, 8, -617);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 4, -569); network1.addRelation(9, 4, -569);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 10, -284); network1.modifyRelation(15, 10, -284);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 3, -179); network1.modifyRelation(6, 3, -179);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 10, -49); network1.modifyRelation(14, 10, -49);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 1, -711); network1.modifyRelation(2, 1, -711);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 8, -543); network1.addRelation(4, 8, -543);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 10, -79); network1.addRelation(2, 10, -79);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 11, -544); network1.addRelation(4, 11, -544);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 2, -800); network1.addRelation(5, 2, -800);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 10, -125); network1.modifyRelation(9, 10, -125);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 13, -611); network1.addRelation(8, 13, -611);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 14, -127); network1.modifyRelation(4, 14, -127);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 5, -957); network1.modifyRelation(10, 5, -957);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 1, -735); network1.addRelation(15, 1, -735);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 1, -31); network1.addRelation(8, 1, -31);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 14, -752); network1.addRelation(5, 14, -752);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 11, -527); network1.addRelation(4, 11, -527);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 6, -287); network1.addRelation(14, 6, -287);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 15, -870); network1.modifyRelation(6, 15, -870);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 11, -698); network1.addRelation(1, 11, -698);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 9, -552); network1.modifyRelation(5, 9, -552);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(3, 14, -302); network1.modifyRelation(3, 14, -302);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 1, -399); network1.addRelation(4, 1, -399);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 8, -903); network1.modifyRelation(9, 8, -903);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 12, -792); network1.addRelation(15, 12, -792);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 2, -236); network1.modifyRelation(15, 2, -236);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 4, -891); network1.modifyRelation(14, 4, -891);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 7, -752); network1.addRelation(1, 7, -752);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 2, -823); network1.modifyRelation(15, 2, -823);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 8, -114); network1.modifyRelation(13, 8, -114);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 11, -253); network1.addRelation(2, 11, -253);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 7, -14); network1.addRelation(3, 7, -14);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 9, -137); network1.addRelation(15, 9, -137);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 10, -90); network1.modifyRelation(15, 10, -90);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 6, -884); network1.modifyRelation(2, 6, -884);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 14, -634); network1.addRelation(4, 14, -634);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 13, -532); network1.modifyRelation(14, 13, -532);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 6, -4); network1.addRelation(12, 6, -4);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 1, -938); network1.addRelation(10, 1, -938);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 12, -525); network1.addRelation(6, 12, -525);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 11, -610); network1.addRelation(6, 11, -610);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 7, -554); network1.modifyRelation(13, 7, -554);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 14, -791); network1.addRelation(6, 14, -791);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 3, -39); network1.modifyRelation(12, 3, -39);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 12, -477); network1.modifyRelation(12, 12, -477);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 11, -852); network1.addRelation(1, 11, -852);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 15, -765); network1.addRelation(8, 15, -765);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 11, -459); network1.addRelation(10, 11, -459);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 2, -997); network1.addRelation(12, 2, -997);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 6, -988); network1.addRelation(3, 6, -988);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 6, -293); network1.modifyRelation(1, 6, -293);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 6, -89); network1.addRelation(8, 6, -89);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 10, -195); network1.addRelation(11, 10, -195);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 14, -658); network1.modifyRelation(6, 14, -658);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 13, -784); network1.modifyRelation(13, 13, -784);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 12, -426); network1.modifyRelation(12, 12, -426);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 11, -817); network1.addRelation(14, 11, -817);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 8, -567); network1.addRelation(12, 8, -567);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 2, -342); network1.addRelation(12, 2, -342);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(7, 1, -718); network1.modifyRelation(7, 1, -718);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 4, -190); network1.modifyRelation(12, 4, -190);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 7, -845); network1.addRelation(9, 7, -845);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 2, -777); network1.addRelation(9, 2, -777);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 14, -224); network1.addRelation(2, 14, -224);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 6, -325); network1.addRelation(13, 6, -325);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 6, -357); network1.addRelation(4, 6, -357);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 5, -90); network1.addRelation(9, 5, -90);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 6, -984); network1.addRelation(7, 6, -984);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 10, -238); network1.modifyRelation(1, 10, -238);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 14, -655); network1.addRelation(15, 14, -655);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 2, -569); network1.addRelation(11, 2, -569);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 12, -470); network1.addRelation(13, 12, -470);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 9, -50); network1.modifyRelation(15, 9, -50);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(3, 1, -76); network1.modifyRelation(3, 1, -76);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 2, -193); network1.addRelation(7, 2, -193);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 4, -828); network1.addRelation(13, 4, -828);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 5, -82); network1.modifyRelation(9, 5, -82);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(3, 2, -446); network1.modifyRelation(3, 2, -446);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 10, -416); network1.addRelation(11, 10, -416);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 11, -132); network1.addRelation(2, 11, -132);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 15, -720); network1.addRelation(7, 15, -720);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 12, -261); network1.addRelation(9, 12, -261);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 3, -578); network1.modifyRelation(2, 3, -578);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 10, -549); network1.modifyRelation(6, 10, -549);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 9, -740); network1.addRelation(12, 9, -740);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 1, -699); network1.addRelation(6, 1, -699);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 10, -382); network1.modifyRelation(14, 10, -382);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 2, -602); network1.addRelation(9, 2, -602);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 1, -103); network1.addRelation(9, 1, -103);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 5, -336); network1.addRelation(1, 5, -336);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 4, -606); network1.addRelation(10, 4, -606);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 11, -330); network1.modifyRelation(15, 11, -330);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 6, -426); network1.addRelation(8, 6, -426);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 9, -550); network1.modifyRelation(4, 9, -550);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 4, -427); network1.addRelation(3, 4, -427);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 2, -87); network1.addRelation(7, 2, -87);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 10, -166); network1.modifyRelation(13, 10, -166);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 5, -845); network1.addRelation(15, 5, -845);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 5, -213); network1.addRelation(10, 5, -213);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 4, -706); network1.addRelation(2, 4, -706);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 10, -629); network1.addRelation(12, 10, -629);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 9, -950); network1.addRelation(4, 9, -950);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 4, -622); network1.modifyRelation(4, 4, -622);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 7, -452); network1.modifyRelation(10, 7, -452);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 14, -151); network1.addRelation(7, 14, -151);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 11, -683); network1.addRelation(6, 11, -683);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 6, -999); network1.addRelation(10, 6, -999);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 10, -566); network1.addRelation(1, 10, -566);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 3, -573); network1.modifyRelation(12, 3, -573);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 4, -509); network1.modifyRelation(15, 4, -509);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 15, -168); network1.addRelation(7, 15, -168);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 7, -146); network1.modifyRelation(4, 7, -146);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 1, -496); network1.addRelation(6, 1, -496);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 15, -636); network1.addRelation(8, 15, -636);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 12, -836); network1.modifyRelation(2, 12, -836);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 1, -687); network1.modifyRelation(6, 1, -687);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 10, -217); network1.addRelation(5, 10, -217);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 10, -649); network1.addRelation(12, 10, -649);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 8, -609); network1.addRelation(7, 8, -609);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 9, -502); network1.addRelation(2, 9, -502);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 1, -450); network1.modifyRelation(11, 1, -450);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 6, -70); network1.addRelation(4, 6, -70);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 11, -867); network1.addRelation(6, 11, -867);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 9, -962); network1.addRelation(11, 9, -962);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 10, -794); network1.modifyRelation(10, 10, -794);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 12, -219); network1.addRelation(3, 12, -219);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 8, -385); network1.addRelation(14, 8, -385);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 2, -979); network1.modifyRelation(5, 2, -979);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 5, -460); network1.modifyRelation(4, 5, -460);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 2, -10); network1.addRelation(12, 2, -10);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(6, 13, -669); network1.modifyRelation(6, 13, -669);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 10, -410); network1.addRelation(6, 10, -410);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 11, -969); network1.addRelation(6, 11, -969);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 9, -651); network1.addRelation(8, 9, -651);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 6, -512); network1.modifyRelation(5, 6, -512);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 12, -616); network1.addRelation(15, 12, -616);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 1, -944); network1.addRelation(9, 1, -944);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 11, -600); network1.addRelation(7, 11, -600);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 4, -858); network1.modifyRelation(15, 4, -858);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 2, -861); network1.addRelation(1, 2, -861);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 9, -212); network1.addRelation(3, 9, -212);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 5, -265); network1.addRelation(10, 5, -265);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 15, -437); network1.addRelation(13, 15, -437);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 15, -108); network1.addRelation(11, 15, -108);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 2, -124); network1.addRelation(5, 2, -124);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 12, -799); network1.modifyRelation(5, 12, -799);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 3, -18); network1.addRelation(8, 3, -18);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(8, 12, -109); network1.modifyRelation(8, 12, -109);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 10, -195); network1.modifyRelation(2, 10, -195);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 9, -964); network1.modifyRelation(5, 9, -964);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 6, -882); network1.addRelation(1, 6, -882);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(8, 14, -504); network1.modifyRelation(8, 14, -504);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 13, -658); network1.addRelation(9, 13, -658);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 8, -225); network1.addRelation(10, 8, -225);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 9, -5); network1.addRelation(8, 9, -5);        } catch (Exception e) {
            System.out.println();        }
        try {            network.addRelation(11, 4, -224); network1.addRelation(11, 4, -224);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 6, -96); network1.addRelation(4, 6, -96);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 14, -309); network1.addRelation(4, 14, -309);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 15, -301); network1.modifyRelation(11, 15, -301);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 9, -972); network1.addRelation(12, 9, -972);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 14, -472); network1.addRelation(13, 14, -472);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 11, -612); network1.addRelation(13, 11, -612);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 8, -874); network1.modifyRelation(13, 8, -874);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 1, -935); network1.addRelation(14, 1, -935);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 8, -826); network1.addRelation(1, 8, -826);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 14, -213); network1.addRelation(2, 14, -213);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 8, -655); network1.addRelation(6, 8, -655);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 8, -800); network1.addRelation(9, 8, -800);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(8, 2, -999); network1.modifyRelation(8, 2, -999);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 9, -49); network1.addRelation(3, 9, -49);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 10, -955); network1.addRelation(9, 10, -955);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 11, -857); network1.addRelation(15, 11, -857);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 12, -568); network1.addRelation(8, 12, -568);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 11, -937); network1.modifyRelation(11, 11, -937);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 2, -871); network1.addRelation(7, 2, -871);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 1, -860); network1.addRelation(9, 1, -860);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 4, -870); network1.addRelation(2, 4, -870);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 8, -744); network1.addRelation(14, 8, -744);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 6, -542); network1.addRelation(12, 6, -542);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 6, -656); network1.addRelation(15, 6, -656);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 10, -939); network1.addRelation(15, 10, -939);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 3, -636); network1.addRelation(13, 3, -636);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 13, -615); network1.modifyRelation(2, 13, -615);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 1, -215); network1.addRelation(6, 1, -215);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 11, -759); network1.modifyRelation(15, 11, -759);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 9, -24); network1.addRelation(10, 9, -24);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 10, -972); network1.addRelation(9, 10, -972);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 13, -954); network1.addRelation(4, 13, -954);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 11, -131); network1.addRelation(4, 11, -131);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(5, 6, -581); network1.modifyRelation(5, 6, -581);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 8, -357); network1.addRelation(11, 8, -357);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 8, -210); network1.addRelation(8, 8, -210);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 6, -536); network1.modifyRelation(13, 6, -536);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 1, -339); network1.addRelation(11, 1, -339);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 2, -12); network1.addRelation(14, 2, -12);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 4, -425); network1.modifyRelation(13, 4, -425);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 10, -231); network1.addRelation(3, 10, -231);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 12, -627); network1.addRelation(15, 12, -627);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 3, -466); network1.modifyRelation(9, 3, -466);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 1, -846); network1.addRelation(6, 1, -846);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 6, -346); network1.addRelation(10, 6, -346);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 1, -255); network1.modifyRelation(15, 1, -255);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 9, -704); network1.addRelation(5, 9, -704);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 7, -858); network1.addRelation(14, 7, -858);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 7, -905); network1.modifyRelation(1, 7, -905);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 13, -287); network1.addRelation(14, 13, -287);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 13, -886); network1.addRelation(10, 13, -886);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 3, -776); network1.addRelation(9, 3, -776);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 4, -301); network1.addRelation(8, 4, -301);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 10, -461); network1.addRelation(3, 10, -461);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 13, -822); network1.addRelation(1, 13, -822);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(13, 15, -472); network1.modifyRelation(13, 15, -472);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(8, 7, -15); network1.modifyRelation(8, 7, -15);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 5, -657); network1.addRelation(6, 5, -657);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 4, -761); network1.addRelation(4, 4, -761);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 10, -707); network1.addRelation(13, 10, -707);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 15, -553); network1.addRelation(2, 15, -553);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 15, -461); network1.addRelation(4, 15, -461);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 1, -416); network1.modifyRelation(9, 1, -416);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 7, -530); network1.addRelation(14, 7, -530);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 6, -930); network1.addRelation(4, 6, -930);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 14, -489); network1.addRelation(5, 14, -489);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 4, -203); network1.addRelation(14, 4, -203);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 9, -766); network1.addRelation(10, 9, -766);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 5, -917); network1.addRelation(9, 5, -917);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 5, -719); network1.modifyRelation(2, 5, -719);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 12, -732); network1.addRelation(12, 12, -732);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 10, -951); network1.addRelation(11, 10, -951);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 1, -986); network1.addRelation(14, 1, -986);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 10, -119); network1.addRelation(8, 10, -119);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 13, -131); network1.addRelation(11, 13, -131);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 11, -896); network1.addRelation(11, 11, -896);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 9, -19); network1.addRelation(2, 9, -19);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 14, -978); network1.addRelation(4, 14, -978);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 8, -522); network1.addRelation(11, 8, -522);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 1, -8); network1.addRelation(8, 1, -8);        } catch (Exception e) {
            System.out.println();        }
        try {            network.addRelation(8, 13, -559); network1.addRelation(8, 13, -559);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 8, -2); network1.addRelation(11, 8, -2);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 3, -666); network1.addRelation(8, 3, -666);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 15, -698); network1.addRelation(5, 15, -698);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 13, -217); network1.modifyRelation(10, 13, -217);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 15, -407); network1.modifyRelation(15, 15, -407);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 1, -276); network1.addRelation(12, 1, -276);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(5, 10, -862); network1.addRelation(5, 10, -862);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(9, 12, -225); network1.modifyRelation(9, 12, -225);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 13, -251); network1.modifyRelation(11, 13, -251);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 9, -432); network1.addRelation(6, 9, -432);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 5, -124); network1.modifyRelation(2, 5, -124);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 3, -304); network1.modifyRelation(12, 3, -304);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 15, -527); network1.modifyRelation(10, 15, -527);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(2, 2, -520); network1.addRelation(2, 2, -520);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(11, 11, -22); network1.modifyRelation(11, 11, -22);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(10, 3, -295); network1.modifyRelation(10, 3, -295);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(9, 14, -26); network1.addRelation(9, 14, -26);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 7, -789); network1.modifyRelation(4, 7, -789);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 14, -246); network1.addRelation(6, 14, -246);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(12, 6, -416); network1.modifyRelation(12, 6, -416);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 7, -440); network1.addRelation(1, 7, -440);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 7, -448); network1.modifyRelation(4, 7, -448);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 15, -123); network1.addRelation(12, 15, -123);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 13, -890); network1.addRelation(1, 13, -890);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(15, 12, -679); network1.addRelation(15, 12, -679);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 14, -65); network1.addRelation(6, 14, -65);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 15, -255); network1.addRelation(8, 15, -255);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 13, -584); network1.addRelation(11, 13, -584);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 3, -674); network1.addRelation(12, 3, -674);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 14, -58); network1.addRelation(13, 14, -58);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(6, 9, -147); network1.addRelation(6, 9, -147);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(11, 11, -794); network1.addRelation(11, 11, -794);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 2, -610); network1.modifyRelation(1, 2, -610);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(2, 9, -395); network1.modifyRelation(2, 9, -395);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(14, 9, -465); network1.modifyRelation(14, 9, -465);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 4, -882); network1.addRelation(7, 4, -882);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(4, 5, -343); network1.addRelation(4, 5, -343);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(7, 7, -319); network1.addRelation(7, 7, -319);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(1, 8, -968); network1.addRelation(1, 8, -968);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(14, 6, -63); network1.addRelation(14, 6, -63);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 2, -642); network1.addRelation(3, 2, -642);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(10, 14, -581); network1.addRelation(10, 14, -581);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(4, 10, -538); network1.modifyRelation(4, 10, -538);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(3, 2, -348); network1.addRelation(3, 2, -348);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(13, 8, -677); network1.addRelation(13, 8, -677);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 14, -934); network1.addRelation(8, 14, -934);        } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(15, 10, -576); network1.modifyRelation(15, 10, -576);       } catch (Exception e) {            System.out.println();        }
        try {            network.modifyRelation(1, 4, -25); network1.modifyRelation(1, 4, -25);       } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(8, 11, -185); network1.addRelation(8, 11, -185);        } catch (Exception e) {            System.out.println();        }
        try {            network.addRelation(12, 12, -997); network1.addRelation(12, 12, -997);        } catch (Exception e) {            System.out.println();        }
        try {
            network.addPerson(new MyPerson(16, "aa", 10));
            network1.addPerson(new MyPerson(16, "aa", 10));
            network.addPerson(new MyPerson(17, "aa", 10));
            network1.addPerson(new MyPerson(17, "aa", 10));
            network.addPerson(new MyPerson(18, "aa", 10));
            network1.addPerson(new MyPerson(18, "aa", 10));
            network.addPerson(new MyPerson(19, "aa", 10));
            network1.addPerson(new MyPerson(19, "aa", 10));
            network.addPerson(new MyPerson(20, "aa", 10));
            network1.addPerson(new MyPerson(20, "aa", 10));
            network.addPerson(new MyPerson(21, "aa", 10));
            network1.addPerson(new MyPerson(21, "aa", 10));
            network.addPerson(new MyPerson(22, "aa", 10));
            network1.addPerson(new MyPerson(22, "aa", 10));
            network.addPerson(new MyPerson(23, "aa", 10));
            network1.addPerson(new MyPerson(23, "aa", 10));
        } catch (Exception e){
            System.out.println();
        }
        try {
            network.addRelation(16,17,-1);
            network1.addRelation(16,17,-1);
            network.addRelation(18,19,-1);
            network1.addRelation(18,19,-1);
        } catch (Exception e){
            System.out.println();
        }
        int sum = 0;
        Person[] oldPeople=network.getPersons();
        for (int i = 0; i < oldPeople.length; i++) {
            for (int j = i+1; j < oldPeople.length; j++) {
                int tem1 = -1;
                int tem2 = -1;
                int mark = 0;
                try {
                    tem1 = network.queryBestAcquaintance(oldPeople[i].getId());
                } catch (Exception e){
                    mark = 1;
                }
                try {
                    tem2 = network.queryBestAcquaintance(oldPeople[j].getId());
                } catch (Exception e){
                    mark = 1;
                }
                if (mark == 1){
                    continue;
                }
                if (tem1 == oldPeople[j].getId() && tem2 == oldPeople[i].getId()){
                    sum++;
                }
            }
        }

        assertEquals(sum,network1.queryCoupleSum());
        Person[] people1=network1.getPersons();
        assertEquals(oldPeople.length,people1.length);
        for(int i=0;i<oldPeople.length;i++){
            Boolean a=((MyPerson)oldPeople[i]).strictEquals(people1[i]);
            assertEquals(a,true);
        }
    }
}