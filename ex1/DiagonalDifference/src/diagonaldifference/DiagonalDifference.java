package diagonaldifference;
/*
 Exercise 1 from "Java Programming Exercises" 
 @ Netcracker's selective proccess
 */

/*
Important notes:
    - This exercise was thought with the assumption that every matrix provided
    will be formatted the same way within the input file, and will always be a 
    square matrix.
    - The exercise asks to "provide a class" that solves the problem. So for the 
    sake of simplicity, I chose to write all methods (including 'main()') within
    a single class, while trying to maintain the code as clean and readable as 
    possible.
*/


/* imports */
import java.io.BufferedReader;
import java.io.FileReader;

public class DiagonalDifference {
    

    /* Method to calculate the matrix's diagonals absolute difference */
    public static int calcDiagonalsDiff(String fileName) {

        try {
            
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            
            String line = input.readLine();
            String[] lineContent;
            
            int countLine = 0;
            int sum = 0;
            int size = line.split(" ").length - 1;
            
            
            while (line != null){
                lineContent = line.split(" ");
                sum += Integer.parseInt(lineContent[countLine]) - Integer.parseInt(lineContent[size - countLine]);
                
                countLine ++;
                line = input.readLine();
            }
        
            return Math.abs(sum);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    /* Main method */
    public static void main(String[] args) { 

        /* output */
        System.out.println("Matrix 1 diagonals absolute difference: " + calcDiagonalsDiff("squareMatrix1.txt"));
        System.out.println("Matrix 2 diagonals absolute difference: " + calcDiagonalsDiff("squareMatrix2.txt"));

    }
    
}
