import java.util.*;

public class InfiniteIntArrayQueue {

    // fields

    // our underlying implementation is an Array,
    private int[] intArray;

    // capacity is basically the length of the underlying int structure,
    // since can't contain null values, and is used to get at length since
    // length can't be used on this object itself, but it's underlying array.
    private int capacity;

    public InfiniteIntArrayQueue(int capacity) {
        this.capacity = capacity;
        intArray = new int[capacity];
    }

    public InfiniteIntArrayQueue() {
        this.capacity = 100;
        intArray = new int[capacity];
    }

    int getCapacity() {
        return intArray.length;
    }

    int getSize() {

        int size = 0;
        for(int item : intArray) {
            if(item != 0) {
                size++;
            }
        }
        return size;
    }

    // returns True if it has any non-zero values in it.
    boolean hasContents() {
        if(getSize() > 0){
            return true;
        }
        return false;
    }

    // @return boolean, True if queue has room for more elements in its current form,
    // False if otherwise.
    // A common check would be if(this.hasRoom(testArray.length, this.getCapacity))
    // or something like that.
    boolean hasRoom(int numberOfElemsToBeAdded, int capacity) {
        this.capacity = capacity;
        return numberOfElemsToBeAdded < capacity;
    }

    // adds element to the end of the queue
    // @return boolean, True if something
    // successfully added, false otherwise.
    boolean add(int addition) {
        if(hasRoom(1, getCapacity())) {
            intArray[getSize()] = addition;
            return true;
        } else {
            return false;
        }
    }

    // remember: FIFO
    int remove() throws NoSuchElementException {

        int item = 0;
        try {

                item = intArray[0];
                int[] tempArray = new int[capacity];
                int size = getSize();

                // shifts the elems of our array down one index position.
                for(int i = 0; i < intArray.length; i++) {
                    tempArray[i] = intArray[i + 1];
                }
                intArray = tempArray;
                return item;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
        return item;
    }

    // returns the item at the head of the queue
    int peek() {
        return intArray[0];
    }

    // returns string version of our queue
    public String toString() {

        String ourString= "";

        for(int i = 0; i < getSize() - 1; i++) {
            ourString += intArray[i] + ", ";
        }
        ourString += intArray[getSize() - 1];
        return ourString;
    }

    public static void main(String[] args) {

        InfiniteIntArrayQueue ourQueue = new InfiniteIntArrayQueue();
        int[] testArray = {0,1,2,3};

        for(int i = 0; i < testArray.length; i++) {
            ourQueue.add(testArray[i]);
        }

        System.out.println("howdy howdy howdy");
        System.out.println(ourQueue.toString());
    }


}
