
import java.util.NoSuchElementException;



public class InfiniteStringArrayQueue {


    // fields:

    private String[] stringArray;
    private int capacity;

    private InfiniteStringArrayQueue() {
        this.capacity = 100;
        stringArray = new String[capacity];
    }

    private int getSize() {

        int size = 0;
        while(stringArray[size] != null) {
            size++;
        }
        return size;
    }

    // returns True if it has anything in it.
    public boolean hasContents() {
        for(String item : stringArray) {
            if(item != null) {
                return true;
            }
        }
        return false;
    }

    // @return boolean, True if it has room for more elements in its current form,
    // False if otherwise.
    private boolean hasRoom() {
        if(capacity > getSize()) {
            return true;
        } else {
            return false;
        }
    }

    // adds element to the end of the queue
    // @return boolean, True if something
    // successfully added, false otherwise.
    public boolean add(String addition) {
        if(hasRoom()) {
            stringArray[getSize()] = addition;
            return true;
        } else {
            return false;
        }
    }

    // remember: FIFO
    public String remove() throws NoSuchElementException {

        String item ="";
        try {
            item = stringArray[0];
            int size = getSize();

            // shifts the elems of our array down one index position.
            for(int i = 0; i < size; i++) {
                String temp = stringArray[i + 1];
                stringArray[i] = temp;
            }
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }
        return item;
    }

    // returns the item at the head of the queue
    public String peek() {
        return stringArray[0];
    }

    // returns string version of our queue
    public String toString() {

        String ourString= "";

        for(int i = 0; i < getSize(); i++) {
            ourString += remove() + ", ";
        }
        ourString += (stringArray[getSize()] + ".");
        return ourString;
    }

    public static void main(String[] args) {
        InfiniteStringArrayQueue ourQueue = new InfiniteStringArrayQueue();
        String[] testArray = {"Apple","Banana","Cameltoe","Dogwood"};
        for(int i = 0; i < testArray.length; i++) {
            ourQueue.add(testArray[i]);
        }
        System.out.println(ourQueue.toString());
    }




}
