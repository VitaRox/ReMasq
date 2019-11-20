import java.util.*;
import java.lang.*;

public class InfiniteIntArrayStack {

    // Fields:

    // intArray is our underlying array int.
    private int[] intArray;

    // Capacity is the number of elements that can be
    // contained in intArray.
    // zero time op
    private int capacity;

    // The number of elements the structure contains;
    private int size;

    /**
     * O(n)
     * A default constructor, creates underlying array
     * with 100 elements.
     */
    public InfiniteIntArrayStack() {
            this.capacity = 100;
            intArray = new int[capacity];
    }

    public InfiniteIntArrayStack(int capacity) {
        this.capacity = capacity;
        intArray = new int[capacity];
    }

    /**
     * Push adds the int in question, o, to the top of the stack.
     * O(n^2)
     * @param value
     */
    void push(int value){
        
        if(hasSpace()) {
            intArray[getSize()] = value;
            this.size++;
        }else{    
            //Temporary variable to hold new array with shifted elements.
            int[] newArray = new int[getCapacity() * 2];

            // Populates new array with elements of intArray,
            for (int i = 1; i < intArray.length; i++) {
                newArray[i] = value;
            }
        this.size++;
        intArray = newArray;
        }
    }

    int getCapacity() {
        return this.capacity;
    }

    /**
     * Pop removes the last int added to the stack.
     * O(n^2)
     * @param
     * @return int popped, the int removed from the top of stack (last index).
     * @throws NullPointerException
     */
    int pop(){

        int popped;
        try {
            // Remove element on the "top" of the stack (i.e. LIFO,
            // the last element), assigned to "popped".
            popped = intArray[intArray.length - 1];
            // Return a new copy of array with last element removed.
            intArray = Arrays.copyOf(intArray, intArray.length - 1);
            // Decrement the size of the stack.
            size--;
        }catch(NullPointerException e) {
            throw new NullPointerException("Stack contains no elements.");
        }catch(NegativeArraySizeException f) {
            throw new NegativeArraySizeException("Array can't be negative in size.");
        }
        return popped;
    }

    /**
     * Peek lets the user see what the most-recently-added element in the stack is.
     * O(n)
     * @param
     * @throws NegativeArraySizeException
     * @return Last int added to the stack.
     */
     int peek() {
        try {
            return intArray[intArray.length - 1];
        }catch (NegativeArraySizeException e) {
            throw new NegativeArraySizeException("Array can't be negative in size.");
        }catch (EmptyStackException es) {
            throw new EmptyStackException();
        }
    }

    /**
     * Checks to see whether the current version
     * of the stack has capacity to add more elements.
     * O(n^2)
     * @param
     * @return boolean
     */
    public boolean hasSpace() {

        return this.getCapacity() - this.getSize() > 0;
    }

    /**
     * Checks to see whether the stack has had any elements added to it.
     * O(n^2)
     * @param
     * @return boolean
     */
    public boolean hasContents() {

        return getSize() > 0;
    }

    /**
     * O(k)
     * @param
     * @return The number of elements that are currently stored in the structure
     */
    public int getSize() {

        return this.size;
    }
}
