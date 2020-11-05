import java.util.Iterator;
public class IntBagStepIterator implements Iterator{
    //properties
    private IntBag aBag;
    private int step;
    private int index;
    IntBagStepIterator(IntBag bag, int m )
    {
        aBag = bag;
        step = m;
        index = 0;
    }

    /**
     * a method to convert next value of the array to object
     * @return obj the next int
     */
    @Override
    public Object next()
    {
       Object obj = aBag.showValue(index);
       index = step + index;
       return obj;
    }

    /**
     * a method to check if there is next int or not
     * @return boolean after checking
     */
    @Override
    public boolean hasNext() {
        if( index + step <= aBag.calculateSize())
            return true;
        return false;
    }
}
