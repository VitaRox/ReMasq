public class InfiniteArrayQueue {

    // fields:

    // dataType differentiates the type of underlying array to make
    String dataType;

    private String[] stringArray;
    private double[] doubleArray;
    private int[] intArray;


    public InfiniteArrayQueue(String dataType){
        if (dataType.equals("String")) {
            stringArray = new String[100];
        }

    }
}
