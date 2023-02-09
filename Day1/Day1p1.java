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
        System.out.println(findMax(file));
        
    }
    public static int findMax(File file){
        int sum = 0;
        int max = 0;
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<Integer> list = new ArrayList<Integer>();
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
            //sort list
            list.sort(Comparator.naturalOrder());
            //find max
            max = list.get(list.size()-1);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return max;
    }
}