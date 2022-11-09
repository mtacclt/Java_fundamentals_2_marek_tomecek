import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        /*
        1. read command line input
        2. analyze frequency
        3. print char frequency as a horizontal chart

        1. initialize string
        2. send string into string reversal function
        3. print reversed string
         */

        Scanner scanner = new Scanner(System.in);
        String stringToAnalyse = scanner.nextLine();
        stringToAnalyse = stringToAnalyse.toUpperCase();
        stringToAnalyse = stringToAnalyse.replaceAll("[^a-zA-Z]","");
        TreeMap<Character,Integer> frequencies = charCounts(stringToAnalyse);
        printCharFrequency(frequencies);


        String testString ="The sun rises in the east";
        System.out.println(stringWordReversal(testString));
    }

    public static TreeMap<Character,Integer> charCounts(String line){
        TreeMap<Character,Integer> frequencies = new TreeMap<>();
        for (char ch : line.toCharArray())
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        return frequencies;
    }

    public static void printCharFrequency(TreeMap<Character,Integer> frequencies){
        frequencies.forEach((k,v) -> System.out.println(k+" "+new String(new char[v]).replace("\0", "#")));
    }
    public static String stringWordReversal(String line){
        String reversed="";
        for (String part : line.split(" ")) {
            reversed = reversed+(new StringBuilder(part).reverse().toString())+" ";
        }
        return reversed.substring(0, reversed.length() - 1);
    }
}