package Day2;
import java.io.File;
import java.util.Scanner;
public class Day2 {
    public static void main(String[] args) throws Exception{
        // read the file into the array
        File file = new File("Day2\\Day2.txt");
        System.out.println("The final score using our assumed method: " + calculateFinalScore(cheatSheetToArray(file)));
        System.out.println("The final score using the actual method: " + calculateFinalScorePart2(cheatSheetToArray(file)));
    }
    public static String[][] cheatSheetToArray(File file) throws Exception{
        String[][] array = new String[2500][2];
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            for(int i = 0; i < array.length; i++){
                String[] line = sc.nextLine().split(" ");
                for(int j = 0; j < line.length; j++){
                    array[i][j] = line[j];
                }
            }
        }
        sc.close();
        return array;
    }
    public static int calculateFinalScore(String[][] array){
        int finalScore = 0;

        // convert the array into a 2D array of integers
        int[][] intArray = new int[array.length][2];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < 2; j++){
                if(array[i][j].equals("A") || array[i][j].equals("X")){
                    intArray[i][j] = 1;
                }
                else if(array[i][j].equals("B") || array[i][j].equals("Y")){
                    intArray[i][j] = 2;
                }
                else if(array[i][j].equals("C") || array[i][j].equals("Z")){
                    intArray[i][j] = 3;
                }
            }
        }

        // calculate the final score
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i][0] == intArray[i][1]){
                finalScore += 3 + intArray[i][1];
            }
            else if(intArray[i][0] == 1 && intArray[i][1] == 2 || intArray[i][0] == 2 && intArray[i][1] == 3 || intArray[i][0] == 3 && intArray[i][1] == 1){
                finalScore += 6 + intArray[i][1];
            }
            else{
                finalScore += 0 + intArray[i][1];
            }
        }
        return finalScore;
    }
    public static int calculateFinalScorePart2(String[][] array){
        int finalScore = 0;

        // convert the array into a 2D array of integers
        int[][] intArray = new int[array.length][2];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < 2; j++){
                if(array[i][j].equals("A") || array[i][j].equals("X")){
                    intArray[i][j] = 1;
                }
                else if(array[i][j].equals("B") || array[i][j].equals("Y")){
                    intArray[i][j] = 2;
                }
                else if(array[i][j].equals("C") || array[i][j].equals("Z")){
                    intArray[i][j] = 3;
                }
            }
        }

        // calculate the final score
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i][1] == 2){
                finalScore += 3 + intArray[i][0];
            }
            else if(intArray[i][1] == 3){
                if(intArray[i][0] == 3){
                    finalScore += 7;
                }
                else{
                    finalScore += 7 + intArray[i][0];
                }
            }
            else{
                if(intArray[i][0] == 1){
                    finalScore += 3;
                }
                else{
                    finalScore += -1 + intArray[i][0];
                }
            }
        }
        return finalScore;
    }
}