package csc143.file_io;

import java.io.*;

/**
 * This is a quick application showing how to read from a byte 
 * stream. The most important thing to remember is that virtually
 * any bit pattern can be a valid value for most of the primitive
 * data types.
 */
public class ByteStreamInput {
    
    /**
     * The main method
     * @param args The command-line arguments
     */
    public static void main(String[] args) {

        // For expedience, all of the potential exceptions are gropuged
        // together into a single try block. This is reasonable in this
        // case, because there is nothing really that could be done to
        // work with partial data. 
        try {
            
            // create an input stream to hear from a file
            // This constructor may throw a check exception.
            FileInputStream fis = new FileInputStream("bytestream.dat");
            
            // wrap that stream in a class that will translate from bytes
            // into "programmer-friendly" data types
            // This constructor will not throw a checked exception
            DataInputStream dis = new DataInputStream(fis);
            
            // read the data and print it out
            // it is critical that the types and order are correct
            System.out.println("boolean: " + dis.readBoolean());
            System.out.println("char: " + dis.readChar());
            System.out.println("int: " + dis.readInt());
            System.out.println("float: " + dis.readFloat());
            System.out.println("short: " + dis.readShort());
            System.out.println("long: " + dis.readLong());
            System.out.println("String: " + dis.readUTF());
            System.out.println("double: " + dis.readDouble());
            
            // when done, it is reasonable to close the stream. 
            // there is only one stream, the two Java objects both access
            // the same byte stream, so either object could be used to
            // close the stream
            fis.close();
            
        } catch(IOException e) {
            
            // print out an error message
            System.err.println("Error reading the stream");
            
        }
        
    }
    
}
