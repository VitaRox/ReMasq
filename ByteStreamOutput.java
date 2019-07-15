package csc143.file_io;

import java.io.*;

/**
 * This is an example of writing to a byte stream.
 */
public class ByteStreamOutput {
    
    /**
     * The application method
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        
        /*
         * set up some data
         * 
         * This data was somewhat carefully chosen to 
         * highlight the way that byte streams work.
         * 
         * The char value 'A' has the numerical value 65.
         * The char is 2 bytes; the int, 4 bytes.
         * The short is 2 bytes; the long, 8 bytes.
         * The format used by writeUTF begins with two bytes
         * which given the length of the data which follows.
         * Notice that the string is 52 characters long and that
         * in UTF-8 encoding of Unicode, the ASCII characters
         * are expressed in a single byte.
         */
        boolean b = true;
        char c = 'A';
        int i = 65;
        float f = 1.618f;
        short h = 52;
        long l = 52;
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + 
                   "abcdefghijklmnopqrstuvwxyz";
        double d = Math.PI;
        
        // declare stream references
        FileOutputStream fos;
        DataOutputStream dos;
        
        // try block for opening the file
        try {
            // The FileOutputStream constructor will open the named
            // file and associate in output stream with the file.
            // This constructor may throw a check exception.
            fos = new FileOutputStream("bytestream.dat");
        } catch(FileNotFoundException e) {
            System.err.println("Error opening file to write");
            // If the constructor throws the exception the file
            // was not opened. There is nothing to do, so the 
            // return is used to exit main, ending the application.
            return;
        }
        
        // This constructor simply wraps a "filter" around an existing
        // output stream. The purpose of this filter is to convert
        // standard Java data types into bytes for output
        dos = new DataOutputStream(fos);
        
        // try block for writing to the file
        try {
            // Notice the methods are not overloaded. Each name specifies
            // the data type to be written so the corresponding number of
            // bytes are put into the output stream.
            dos.writeBoolean(b);
            dos.writeChar(c);
            dos.writeInt(i);
            dos.writeFloat(f);
            dos.writeShort(h);
            dos.writeLong(l);
            dos.writeUTF(s);
            dos.writeDouble(d);
        } catch(IOException e) {
            System.err.println("Error writing to the file");
        }
        
        // try block for closing the file
        try {
            fos.close();
        } catch(IOException e) {
            System.err.println("Error closing the file");
        }
        
    }
    
}
