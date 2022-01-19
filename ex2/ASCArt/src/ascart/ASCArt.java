package ascart;
/*
 Exercise 2 from "Java Programming Exercises" 
 @ Netcracker's selective proccess
 */

/* imports */
import java.io.BufferedReader;
import java.io.FileReader;

public class ASCArt {
    
//     Method to read the input txt file and convert input text into ASCII art 
    public static String toArt(String fileName) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            
            /* Reads the first 3 lines of the input file */
            int letterLength = Integer.parseInt(input.readLine());
            input.readLine(); //skips 'letter height' line which won't be used
            String inputText = input.readLine(); //text to be converted to art
            
            /* Gets the position of each letter in the input string 
            "inputText" at the alphabet order provided; E.g. index [2] is "C" */
            int[] indexes = getIndexes(inputText);
            
            /* Reads remaining lines of provided ASCII art reference */
            String line = input.readLine();
            String art = "";
            while (line != null){
                String temp = "";
                for (int i=0; i<inputText.length(); i++){
                    temp += line.substring(indexes[i]*letterLength, ((indexes[i]+1)*letterLength));
                }
                art += temp + "\n";
                line = input.readLine();
            }
   
            return art;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null; 
    }
    
//     Method to "convert" a given string into an array of indexes in relation 
//    to reference "alphabet" string 
    public static int[] getIndexes(String input){
        int[] values = new int[input.length()];

        for(int i=0; i<input.length(); i++){
            values[i] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?".indexOf(input.charAt(i));
        }
        
        return values;
    }

//     Main method which calls the method toArt 
    public static void main(String[] args) {
        System.out.println(toArt("ASCIIArt1.txt"));
        System.out.println(toArt("ASCIIArt2.txt"));
    }
    
}
