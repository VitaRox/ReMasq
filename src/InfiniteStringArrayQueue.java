
import java.util.*;
import java.lang.*;



public class InfiniteStringArrayQueue {


    // fields:

    private String[] stringArray;

    /*
     * @field int capacity, the initial size of the underlying array
     * being used to implement this Queue.
     */
    private int capacity;

    public InfiniteStringArrayQueue(int capacity) {
        this.capacity = capacity;
        stringArray = new String[capacity];
    }

    public InfiniteStringArrayQueue() {
        this.capacity = 100;
        stringArray = new String[capacity];
    }

    int getSize() {

        int size = 0;
        while(stringArray[size] != null) {
            size++;
        }
        return size;
    }

    // returns True if it has anything in it.
    boolean hasContents() {
        for(String item : stringArray) {
            if(item != null) {
                return true;
            }
        }
        return false;
    }

    // @return boolean, True if it has room for more elements in its current form,
    // False if otherwise.
    boolean hasRoom() {
        return capacity > getSize();
    }

    // adds element to the end of the queue
    // @return boolean, True if something
    // successfully added, false otherwise.
    boolean add(String addition) {
        if(hasRoom()) {
            stringArray[getSize()] = addition;
            return true;
        } else {
            return false;
        }
    }

    // remember: FIFO
    String remove() throws NoSuchElementException {

        String item ="";
        try {
            if (!this.hasContents()) {
                return " ";
            } else {
                item = stringArray[0];
                int size = getSize();

                // shifts the elems of our array down one index position.
                for(int i = 0; i < size; i++) {
                    String temp = stringArray[i + 1];
                    stringArray[i] = temp;
                }
            }
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
        return item;
    }

    // returns the item at the head of the queue
    String peek() {
        return stringArray[0];
    }

    // returns string version of our queue
    public String toString() {

        String ourString= "";

        for(int i = 0; i < getSize() - 1; i++) {
              ourString += stringArray[i] + ", ";
        }
        ourString += stringArray[getSize() - 1];
        return ourString;
    }

    public static void main(String[] args) {

        InfiniteStringArrayQueue ourQueue1 = new InfiniteStringArrayQueue();
        String[] testArray = {"Apple","Banana","Cameltoe","Dogwood"};

        InfiniteStringArrayQueue ourQueue2 = new InfiniteStringArrayQueue(5);
        String[] testArray2 = {"alpha","beta","delta","gamma"};

        for(int i = 0; i < testArray.length; i++) {
            ourQueue1.add(testArray[i]);
        }

        for(int i = 0; i < testArray2.length; i++) {
            ourQueue2.add(testArray[i]);
        }

        System.out.println(ourQueue2.toString());
        System.out.println("howdy howdy howdy");
        System.out.println(ourQueue1.toString());
    }




}
