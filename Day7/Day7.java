package Day7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
public class Day7 {
    public static void main(String[] args)throws FileNotFoundException{
        File file = new File("Day7\\Day7input.txt");
        Scanner inputScanner = new Scanner(file);
        String currentFolder = "/";
        while(inputScanner.hasNextLine()){
            String nl = inputScanner.nextLine();
            String[] split = nl.split(" ");
            if(split[0].equals("$")){
                System.out.println(split[0]);
                if(split[1].equals("ls")){
                    
                }
            }
        }
        System.out.println("Finished");
        inputScanner.close();

    }
}
