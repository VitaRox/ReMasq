import java.io.*;
import java.util.*;


/**
 * @author Mx. Vita Harvey I
 * @version 1.0.00
 *   A class which reads the textual input from a DAT file,
 *   reverses it, and thereby produces a "backmasked" or "unbackmasked" audio file.
 **/
public class ReMasque {

    // Fields:
    // Create new input file, read from input file using Scanner.io or something
    // Declare only, take out initialization
    private File inFile;
    //PrintWriter or PrintStream for output file (written to)
    private File outFile;

    /**
     * Class constructor.
     * Will do the "work" of reversing the appropriate info from the source
     * file and writing it to the output file.
     * Returns a "backwards" version of the .dat file we originally input.
     * @param File inFile, the file to be opened and read from.
     * @param File outFile, the file to be created and written to from input.
     * @return A new .dat file with the displacement info written in opposite order
     */
    public ReMasque(File inFile, File outFile)
            throws IOException {

        // Get input file (to be read from)
        inFile = new File("" + inFile + "");
        FileReader fr=new FileReader(inFile);
        BufferedReader br = new BufferedReader(fr);
        Scanner scan = new Scanner(inFile);

        // Open input file
        // Create output file (to be written to)
        outFile = new File("" + outFile + "");
        PrintWriter output = new PrintWriter(outFile);

        // Write headers from inFile to outFile directly
        FileWriter fw = new FileWriter(outFile);
        BufferedWriter bw = new BufferedWriter(fw);

        // Reads first header line.
        String header1 = new String(br.readLine());
        // Console output for debugging
        System.out.println(header1);
        // Reads second header line.
        String header2 = new String(br.readLine());
        // Console output for debugging
        System.out.println(header2);

        br.close();

        // We write each header line on its own line in outFile.
        bw.write(header1);
        bw.newLine();

        bw.write(header2);
        bw.newLine();

        bw.flush();
        bw.close();

        // Create an UnboundedArrayQueue to keep the content of time column.
        InfiniteIntArrayQueue timeQ = new InfiniteIntArrayQueue(100);
        // Create an UnboundedArrayStack to keep the content of displacement column.
        UnboundedArrayStack dispStack = new UnboundedArrayStack(100);

        // lines is the number of elements stored in each data structures.
        int lines = 0;

        String time = scan.next();
        // Puts data from input file into data structures
        while(scan.hasNextLine()) {
            time = scan.next();
            String disp = scan.next();
            timeQ.add(time);
            dispStack.push(disp);
            lines++;
            scan.nextLine();
        }

        // Print the appropriate data from our structures into output file
        while(lines > 0) {
            // Write left-aligned, 13-char-wide string of first thing added
            // to timeQ queue.
            output.printf("%-13s", timeQ.peek());
            // Take off that item so peek refers to next one next time around.
            timeQ.remove();
            // Write right-aligned, 12-char-wide string of last thing added
            // to dispStack stack.
            output.printf("%13s", dispStack.peek());
            dispStack.pop();
            // Advance to the next line of the outFile.
            output.println();
            lines--;
        }
        // Console output for debugging: should display contents of outFile
        System.out.println(outFile);
        // Flush resources, close input file (don't forget)
        output.flush();
        output.close();
    }

    /**
     * Will accept user input into args array,
     * use these Strings to specify an input file to read from
     * and an output file to write to, then uses these
     * files as arguments "in" and "out" to the class
     * constructor's respective "inFile" and "outFile" params.
     */
    public static void main(String[] args)
            throws IllegalArgumentException {

        File in;
        File out;

        // Main report errors
        if (args.length != 2) {
            throw new IllegalArgumentException("Only accepts two arguments.");
        }else{
            in = new File(args[0]);
            out = new File(args[1]);
            try {
                new ReMasque(in, out);
                System.out.println("File backmasking successful.");
                return;
            }catch(IOException e){

                System.err.println("Useage: UnBackMasker " + in + " " + out
                        + " " + e.getMessage());
                return;
            }
        }
    }
}
}
