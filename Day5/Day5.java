package Day5;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Day5 {
    public static void main(String[] args)throws Exception{
        File file = new File("Day5\\Day5.txt");
        ArrayList<ArrayList<String>> crates = getCrates(file);
        Scanner inputScanner = new Scanner(file);
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            if(line.contains("move")){
                moveCratesRetainOrder(crates, line);
            }
        }
        inputScanner.close();
        print2dArray(crates);
    }
    public static ArrayList<ArrayList<String>> getCrates(File file)throws Exception{
        ArrayList<ArrayList<String>> crates = new ArrayList<ArrayList<String>>(9);
        for(int i=0; i < 9; i++) {
            crates.add(new ArrayList<String>());
        }
        Scanner inputScanner = new Scanner(file);
        for(int i=0; i<8; i++){
            String line = inputScanner.nextLine();
            String[] lineSplit = line.split("(?<=\\G.{" + 4 + "})");
            for(int j=0; j<lineSplit.length; j++){
                String x = lineSplit[j].substring(1, 2);
                if(!x.equals(" ")){
                    crates.get(j).add(x);
                }
            }
        }
        for(int i=0; i<crates.size(); i++){
            Collections.reverse(crates.get(i));
        }
        inputScanner.close();
        return crates;
    }
    // Method to print out a 2d array with axis inverted
    public static void print2dArray(ArrayList<ArrayList<String>> array){
        for(int i = 0; i < array.size(); i++){
            for(int j = 0; j < array.get(i).size(); j++){
                System.out.print(array.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void moveCrates(ArrayList<ArrayList<String>> crates, String instruction){
        int number = Integer.parseInt(instruction.substring(5, 7).trim());
        int from = Integer.parseInt(instruction.substring(12, 14).trim());
        int to = Integer.parseInt(instruction.substring(instruction.length()-2, instruction.length()).trim());
        for(int i=0; i<number; i++){
            crates.get(to-1).add(crates.get(from-1).get(crates.get(from-1).size()-1)); // Adds last element of from, to to
            crates.get(from-1).remove(crates.get(from-1).size()-1); // Removes last element of from    
        }
    }
    public static void moveCratesRetainOrder(ArrayList<ArrayList<String>> crates, String instruction){
        int number = Integer.parseInt(instruction.substring(5, 7).trim());
        int from = Integer.parseInt(instruction.substring(12, 14).trim());
        int to = Integer.parseInt(instruction.substring(instruction.length()-2, instruction.length()).trim());
        for(int i = 0; i < number; i++) {
            crates.get(to-1).add(crates.get(from-1).get(crates.get(from-1).size()-number+i)); // Adds elements to to, in reverse order from number
        }
        for(int i=0; i<number; i++){
            crates.get(from-1).remove(crates.get(from-1).size()-1); // Removes last element of from    
        }
    }
}
