package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
//initialize main class
public class Day1p1 {
    //initialize main method
    public static void main(String[] args) {
        //initialize file object
        File file = new File("Day1\\Day1p1.txt");
        // Print each row in file by line
        System.out.println(findMax(ListSumsFromFile(file)));
        System.out.println(findSumTop(ListSumsFromFile(file), 3));
    }
    public static ArrayList<Integer> ListSumsFromFile(File file){
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String check = scanner.nextLine();
                if(check == ""){
                    list.add(sum);
                    sum = 0;
                    continue;
                }
                int line = Integer.parseInt(check);
                sum += line;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int findMax(ArrayList<Integer> list){
        list.sort(Comparator.naturalOrder());
        return list.get(list.size()-1);
    }
    public static int findSumTop(ArrayList<Integer> list, int topX){
        list.sort(Comparator.naturalOrder());
        int sum = 0;
        for(int i = 0; i < topX; i++){
            sum += list.get(list.size()-1-i);
        }
        return sum;
    }
}