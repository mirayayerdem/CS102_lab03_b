/* A class to store and change a collection of positive integers
 * @author : Miray Ayerdem
 * @version : 06/10/2020
 * */
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
public class IntBag {

    //instances
    private int[] bag;
    private int m;
    //Constructor

    IntBag() {
        bag = new int[4]; //create an array contains 4 elements initially
        bag[0] = -1;
    }
    IntBag(int step)
    {
      m = step;
      bag = new int[1];
      bag[0] = -1;
    }
    public class IntBagIterator implements Iterator
    {
        //properties
        private IntBag aBag;
        private int index;

        //constructor
        public IntBagIterator(IntBag bag)
        {
            aBag = bag;
            index = 0;
        }
        //methods
        public Object next()
        {
            Object obj = aBag.showValue(index);
            index++;
            return obj;
        }
        public boolean hasNext()
        {
            return (index < aBag.calculateSize());
        }

    }


    //accessor method
    public int[] getBag()
    {
        return bag;
    }

    /* This method can add a number to array
     * @param int num to be added
     * */
    public void add(int num) {
        if(num > 0)
        {
            if(this.calculateSize() + 1 == bag.length) // if a there is no room array will be expanded
            {
                bag = Arrays.copyOf(bag, bag.length * 2);
            }
            bag[this.calculateSize() + 1] = -1; //the array finish with -1
            bag[this.calculateSize()] = num;
        }
    }
    /* This method can add a number to specific index
     * @param num to be added
     * @param index is the specific location for number which will be added
     * @return boolean if the process is successful
     * @return false if the process is not successful
     * */

    public boolean addFromIndex(int num, int index)
    {

        if(index > this.calculateSize()-1 || num <= 0) //checks if given index is okay or not
            return false;

        if(this.calculateSize() + 1 == bag.length) // if there is no available room, the array is expanded
            bag = Arrays.copyOf(bag, bag.length * 2);
        for(int i = calculateSize() + 1 ; i >= index + 1 ; i--) //change location of values
        {
            bag[i] = bag[i-1];
        }
        bag[index] = num; //add given number

        return true;
    }

    /* This method can remove a number
     * @param index the location of the number removed
     * @return true if the process is successful
     * @return false if the process is not successful
     * */
    public boolean removeElement (int index) {

        int size;
        size = 0;
        if(index >= this.calculateSize())
            return false;

        for(int i = 0 ; i < this.calculateSize() ; i++)
        {
            if(i == index)
            {
                bag[i] = bag[this.calculateSize()-1];
                bag[this.calculateSize()-1] =   bag[this.calculateSize()];
            }
        }

        return true;
    }


    /* This method can test if the array contains the num or not
     * @param num to be tested
     * @return true if the array contains the num
     * @return false if the array does not contain the num
     * */
    public boolean testValue(int num)
    {
        for(int i = 0 ; i < bag.length ; i++)
        {
            if(bag[i] == num)
            {
                System.out.println("The array contains " + num);
                return true;
            }
        }
        System.out.println("The array does not contain the value!");
        return false;
    }

    /* This method show a collection of numbers
     * @return print the colection of array
     * */
    public String toString()
    {
        String print;
        print = "{ " + bag[0];

        for(int i = 1 ; i < this.calculateSize() ; i++) //prints the array
        {
            print = print + ", " + bag[i];
        }
        print = print + " }";
        return print;
    }


    /* This method can calculate the size of the array
     * @return count the size of the array
     * */
    public int calculateSize()
    {
        int count;
        count = 0;
        while(bag[count] != -1) //calculate the size of the array until -1
        {
            count++;
        }
        for(int i = count + 2 ; i < bag.length ; i++) // there must be only one -1 value so other -1 values changed
        {
            bag[i] = 0;
        }
        return count;
    }


    /* This method can show the value of given index
     * @param index the location of the number to be showed
     * @return bag[index] the value of array
     * */
    public int showValue(int index)
    {
        for(int i = 0 ; i < this.calculateSize() ; i++)
        {
            if(i == index)
                return bag[index];
        }
        return -1;

    }

    /* This method can remove all elements of array if they are given num
     * @param num the value removed
     * @return false if the process is not successful
     * */
    public boolean removeAll(int num)
    {
        int check;
        check = 0;

        for(int i = 0 ; i < this.calculateSize() ; i++)
        {
            for(int j = 0 ; j < this.calculateSize() ; j++)
            {
                if(bag[j] == num ) //checks values to find given number
                {
                    check++;
                    for(int k = j ; k < this.calculateSize()-1 ; k++) // loop for shifting the location of values
                    {
                        bag[k] = bag[k+1];
                    }
                    bag[this.calculateSize()-1] = -1;
                }
            }

        }
        if(check == 0)
            return false;
        else
            return true;
    }
    public Iterator iterator()
    {
        if(m == 0)
        {
            return new IntBagIterator(this);
        }
        return new IntBagStepIterator(this,m);
    }

}
