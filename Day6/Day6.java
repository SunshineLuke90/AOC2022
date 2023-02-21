package Day6;
import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Day6 {
    public static void main(String[] args)throws Exception{
        File file = new File("Day6\\Day6input.txt");
        Scanner inputScanner = new Scanner(file);
        String stream = inputScanner.nextLine();
        String s1 = "bvwbjplbgvbhsrlpgdmjqwftvncz";
        String s2 = "nppdvjthqldpwncqszvftbrmjlhg";
        String s3 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
        String s4 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";
        inputScanner.close();
        System.out.println(findFirstRepeating(s1, 14));
        System.out.println(findFirstRepeating(s2, 14));
        System.out.println(findFirstRepeating(s3, 14));
        System.out.println(findFirstRepeating(s4, 14));
        System.out.println(findFirstRepeating(stream, 14));
    }
    public static int findFirstRepeating(String stream, int length){
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < length; i++){
            set.add(stream.charAt(i));
        }
        int pointer = length;
        while(set.size() < length){
            set.clear();
            pointer++;
            for(int i = 0; i < length; i++){
                set.add(stream.charAt(pointer-i));
            }
        }
        return pointer + 1;
    }
}
