import java.util.Iterator;
public class IntBagStepIterator implements Iterator{
    private IntBag aBag;
    private int step;
    private int index;
    IntBagStepIterator(IntBag bag, int m )
    {
        aBag = bag;
        step = m;
        index = 0;
    }
    @Override
    public Object next()
    {
       Object obj = aBag.showValue(index);
       index = step + index;
       return obj;
    }

    @Override
    public boolean hasNext() {
        if( index + step <= aBag.calculateSize())
            return true;
        return false;
    }
}
