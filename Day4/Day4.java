package Day4;
import java.io.File;
import java.util.Scanner;
public class Day4 {
    public static void main(String[] args) throws Exception{
        // Read input file
        File file = new File("Day4\\Day4.txt");  
        System.out.println("The total number of complete overlaps is: " + findTotalOverlaps(readInput(file))); 
        System.out.println("The total number of partial overlaps is: " + findAnyOverlaps(readInput(file)));
    }
    public static int[][] readInput(File file)throws Exception{
        int[][] outputArray = new int[4][1000];
        Scanner inputScanner = new Scanner(file);
        int i = 0;
        int j = 0;
        while(inputScanner.hasNextLine()){
            String line = inputScanner.nextLine();
            String[] lineSplit = line.split(",");
            
            for(String x: lineSplit){
                String[] xSplit = x.split("-");
                outputArray[j][i] = Integer.parseInt(xSplit[0]);
                j++;
                outputArray[j][i] = Integer.parseInt(xSplit[1]);
                j++;
            }
            j = 0;
            i++;
        }
        inputScanner.close();
        return outputArray;
    }
    public static int findTotalOverlaps(int[][] inputArray){
        int totalOverlaps = 0;
        for(int i = 0; i <inputArray[0].length; i++){
            if(inputArray[0][i] <= inputArray[2][i] && inputArray[1][i] >= inputArray[3][i] || inputArray[0][i] >= inputArray[2][i] && inputArray[1][i] <= inputArray[3][i]){
                totalOverlaps++;
            }
        }
        return totalOverlaps;
    }
    public static int findAnyOverlaps(int[][] inputArray){
        int totalOverlaps = 0;
        for(int i = 0; i <inputArray[0].length; i++){
            if(inputArray[0][i]>=inputArray[2][i] && inputArray[0][i]<=inputArray[3][i] || inputArray[1][i]>=inputArray[2][i] && inputArray[1][i]<=inputArray[3][i]){
                totalOverlaps++;
            }
            else if(inputArray[2][i]>=inputArray[0][i] && inputArray[2][i]<=inputArray[1][i] || inputArray[3][i]>=inputArray[0][i] && inputArray[3][i]<=inputArray[1][i]){
                totalOverlaps++;
            }
        }
        return totalOverlaps;
    }
    //Create method to print out a 2d array with axis inverted
    public static void print2dArray(int[][] array){
        for(int i = 0; i < array[0].length; i++){
            for(int j = 0; j < array.length; j++){
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
    }


}
