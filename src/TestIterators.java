import java.util.*;

public class TestIterators {

    public static void main(String[] args) {

        IntBag bag = new IntBag();
        bag.add(5);
        bag.add(8);
        bag.add(15);
        bag.add(6);

        Iterator i, j;

        i = bag.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
            j = bag.iterator();
            while (j.hasNext()) {
                System.out.println("--" + j.next());
            }
        }
        IntBag ibag = new IntBag(2);

        for (int k = 0; k < 21; k++) {
            ibag.add(k);
        }
        i = ibag.iterator();

        while(i.hasNext())
        {
            System.out.println(i.next());
        }

    }
}
