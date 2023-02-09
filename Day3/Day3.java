package Day3;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Day3 {
    public static void main(String[] args)throws Exception{
        File file = new File("Day3\\input.txt");
        System.out.println("The sum of the priorities of item types in both sections of each rucksack is: " + sumParcels(findDuplicates(readInput(file))));
        System.out.println("The sum of the priorities of item types in groups of 3 rucksacks is: " + sumParcels(findDuplicatesGroups(readInput(file))));
    }
    public static List<String> readInput(File file)throws Exception{
        List<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        sc.close();
        return list;
    }
    public static List<Character> findDuplicates(List<String> list){
        List<Character> duplicates = new ArrayList<Character>();
        
        for(String x: list){
            Set<Character> set1 = new HashSet<Character>();
            Set<Character> set2 = new HashSet<Character>();
            for(int j = 0; j < x.length() + 1; j++){
                if(j < (x.length()/2)){
                    set1.add(x.charAt(j));
                }
                else if(j >= (x.length()/2) && j < x.length()){
                    set2.add(x.charAt(j));
                }
                else if(j == x.length()){
                    set1.retainAll(set2);
                    List<Character> y = new ArrayList<Character>(set1);
                    duplicates.add(y.get(0));
                }
                
            }
        }
        return duplicates;
    }
    public static List<Character> findDuplicatesGroups(List<String> list){
        List<Character> duplicates = new ArrayList<Character>();
        int counter = 0;
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        Set<Character> set3 = new HashSet<Character>();
        for(String x: list){
            for(int j = 0; j < x.length(); j++){
                if(counter == 0){
                    set1.add(x.charAt(j));
                }
                else if(counter ==1){
                    set2.add(x.charAt(j));
                }
                else if(counter == 2){
                    set3.add(x.charAt(j));
                }
            }
            counter++;
            if(counter == 3){
                set1.retainAll(set2);
                set1.retainAll(set3);
                List<Character> y = new ArrayList<Character>(set1);
                duplicates.add(y.get(0));
                set1.clear();
                set2.clear();
                set3.clear();
                counter = 0;
            }
        }
        return duplicates;
    }
    public static int sumParcels(List<Character> list){
        int sum = 0;
        for(Character x: list){
            if((int)x < 91 && (int)x > 64){
                sum += (int)x - 64 + 26;
            }
            else if((int)x < 123 && (int)x > 96){
                sum += (int)x - 96;
            }
        }
        return sum;
    }
}
