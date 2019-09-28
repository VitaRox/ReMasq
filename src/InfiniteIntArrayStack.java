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

    /**
     * O(n)
     * A default constructor, creates underlying array
     * with 10 elements.
     * @param int capacity, the number of elements it can contain.
     */
    public InfiniteIntArrayStack(int capacity) {
            this.capacity = capacity;
            intArray = new int[capacity];
    }

    public InfiniteIntArrayStack() {
            this.capacity = 100;
            intArray = new int[capacity];
    }

    /**
     * Push adds the int in question, o, to the top of the stack.
     * O(n^2)
     * @param int value
     */
    void push(int value){
        
        if(hasSpace()) {
            intArray[getSize()] = value;
        }else{    
            //Temporary variable to hold new array with shifted elements.
            int[] newArray = new int[getCapacity() * 2];

            // Populates new array with elements of intArray,
            for (int i = 1; i < intArray.length; i++) {
                newArray[i] = value;
            }
        intArray = newArray;
        }
    }

    int getCapacity() {
        return this.capacity;
    }

    /**
     * Pop removes the last int added to the stack.
     * O(n^2)
     * @param None
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
     * @param None
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

        for (int i=0; i < intArray.length; i++){
            if (intArray[i] == 0) {  // note to self: this will always eval to True; but do we need this
                return true;                     // in order for it/Remasque to work? Focus on essentials, not weeds.
            }
        }
        return false;
    }

    /**
     * Checks to see whether the stack has had any elements added to it.
     * O(n^2)
     * @param
     * @return boolean
     */
    public boolean hasContents() {

        for (int i = 0; i < intArray.length; i++){
            if(intArray[i] == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * O(k)
     * @param
     * @return The number of elements that are currently stored in the structure
     */
    public int getSize() {

        // Tracks the number of elements that aren't null (empty).
        int count = 0;

        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] != 0){
                count++;
            }
        }
        return count;
    }
}
