//initialize main class
public class Day1p1 {
    //initialize main method
    public static void main(String[] args) {
        //initialize variables
        int[] input = { 1721, 979, 366, 299, 675, 1456 };
        int sum = 2020;
        int result = 0;
        //loop through input array
        for (int i = 0; i < input.length; i++) {
            //loop through input array
            for (int j = 0; j < input.length; j++) {
                //check if sum of two numbers equals 2020
                if (input[i] + input[j] == sum) {
                    //set result to product of two numbers
                    result = input[i] * input[j];
                }
            }
        }
        //print result
        System.out.println(result);
    }
}