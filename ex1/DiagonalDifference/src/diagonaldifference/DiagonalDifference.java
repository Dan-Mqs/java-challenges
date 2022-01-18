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
import java.util.ArrayList;

public class DiagonalDifference {
    
    /* Method to read the input txt file and return a matrix from its values */
    public static ArrayList<ArrayList<Integer>> readInputAsMatrix(String fileName) {
        try {
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String line = input.readLine();

            while(line != null){
               ArrayList<Integer> matrixLine = new ArrayList<>();
               String[] values = line.split(" ");
               for(int i=0; i<values.length; i++){
                       matrixLine.add(Integer.parseInt(values[i]));
               }
               matrix.add(matrixLine);
               line = input.readLine();
            }
            return matrix;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    } 
    
    /* Method to calculate the matrix's diagonals absolute difference */
    public static int calcDiagonalsDiff(ArrayList<ArrayList<Integer>> matrix) {
        int matrixOrder = matrix.size();
        int primDiagonal = 0;
        int secDiagonal = 0;
        
        try {
            for (int i=0; i<matrixOrder; i++){
                for (int j=0; j<matrixOrder; j++){

                    /* checks if item belongs to the primary diagonal */
                    if (i == j){ 
                        primDiagonal += matrix.get(i).get(j);
                    }

                    /* checks if item belongs to the secondary diagonal */
                    if ((i+j+2) == (matrixOrder + 1)){

                        secDiagonal += matrix.get(i).get(j);
                    }
                }
            }
        
            return Math.abs(primDiagonal - secDiagonal);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    /* Main method */
    public static void main(String[] args) { 
        
        /* reads files */
        ArrayList<ArrayList<Integer>> matrix_1 = readInputAsMatrix("squareMatrix1.txt");
        ArrayList<ArrayList<Integer>> matrix_2 = readInputAsMatrix("squareMatrix2.txt");
        
        
        /* output */
        System.out.println("Matrix 1 diagonals absolute difference: " + calcDiagonalsDiff(matrix_1));
        System.out.println("Matrix 2 diagonals absolute difference: " + calcDiagonalsDiff(matrix_2));

    }
    
}
