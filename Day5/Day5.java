package Day5;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class Day5 {
    public static void main(String[] args)throws Exception{
        File file = new File("Day5\\Day5.txt");
        print2dArray(getCrates(file));
    }
    public static ArrayList<ArrayList<String>>[][] getCrates(File file)throws Exception{
        ArrayList<ArrayList<String>>[][] crates = new ArrayList[9][1];
        Scanner inputScanner = new Scanner(file);
        for(int i=0; i<9; i++){
            String line = inputScanner.nextLine();
            String[] lineSplit = line.split("(?<=\\G.{" + 4 + "})");
            for(int j=0; j<lineSplit.length; j++){
                String x = lineSplit[j].substring(1, 2);
                crates[8-i][j].add(x);
            }
        }
        inputScanner.close();
        return crates;
    }
    // Method to print out a 2d array with axis inverted
    public static void print2dArray(ArrayList<String>[][] array){
        for(int i = 0; i < array[0].length; i++){
            for(int j = 0; j < array.length; j++){
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
    }
    public static void moveCrates(ArrayList<String>[][] crates, String instruction){
        int number = Integer.parseInt(instruction.substring(5, 7));
        int from = Integer.parseInt(instruction.substring(13, 15));
        int to = Integer.parseInt(instruction.substring(18, 20));
        for(int i=0; i<number; i++){

            //crates[to][crates[to].length].add(crates[from].length-1, crates[from][crates[from].length-1]);
            crates[from][crates[from].length-1].remove(crates[from].length-1);
        }
    }
}
