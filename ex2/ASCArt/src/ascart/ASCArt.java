package ascart;
/*
 Exercise 2 from "Java Programming Exercises" 
 @ Netcracker's selective proccess
 */

/* imports */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ASCArt {
    
    /* Method to read the input txt file and return a  */
    public static String toArt(String fileName) {
        try {
            ArrayList<ArrayList<String>> referenceArt = new ArrayList<>();
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            
            /* Reads the first 3 lines of the input file */
            int letterLength = Integer.parseInt(input.readLine());
            int letterHeight = Integer.parseInt(input.readLine());
            String inputText = input.readLine();
            
            /* Reads first line of art reference */
            String line = input.readLine();
            
            /*Loops through the remaining lines of the input 
            to get ASCII Art letters*/
            while(line != null){
                ArrayList<String> letterArt = new ArrayList<>();
                String[] lineContent = line.split("");
                
                String temp = "";
                int counter = 1;
                for (int i=0; i<lineContent.length; i++){
                   temp += lineContent[i];
                   if (counter == letterLength){
                       letterArt.add(temp);
                       temp = "";
                       counter = 1;  
                   }
                   else {
                       counter++;
                   }
                }
                referenceArt.add(letterArt);
                line = input.readLine();
            }
            
            /* Gets the position of each letter in the input string 
            ("NETCRACKER") at the alphabet art provided */
            int[] indexes = getIndex(inputText);

            
            ArrayList<String> artArray = new ArrayList<>();
            String temp = "";
            for(int i=0; i<letterHeight; i++){
               for(int j=0; j<indexes.length; j++){
                   temp += referenceArt.get(i).get(indexes[j]);
               }
               artArray.add(temp);
               temp = "";
            }
            
            /* Forms a string containing the final art */
            String ascArt = "";
            for(int i=0; i<letterHeight; i++){
                ascArt += artArray.get(i) + "\n";
            }
            
            return ascArt;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null; 
    }
    
    /* Method to "convert" a given string into an array of indexes in relation 
    to reference "alphabet" string */
    public static int[] getIndex(String input){
        int[] values = new int[input.length()];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";
        
        for(int i=0; i<input.length(); i++){
            values[i] = alphabet.indexOf(input.charAt(i));
        }
        
        return values;
    }

    /* Main method which calls the method toArt */
    public static void main(String[] args) {
        System.out.println(toArt("ASCIIArt1.txt"));
        System.out.println(toArt("ASCIIArt2.txt"));
    }
    
}
