import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static void printLineWhenContainsLargerNumber(String line, ArrayList<Integer> numberArray, int baseLineNumber){
        for( Integer number :numberArray)
        {
            if(number >= baseLineNumber)
            {
                System.out.println(line);
                break;
            }
        }
    }
    static ArrayList<Integer> extractNumbersFromString(String line)
    {
        char[] symbols = line.toCharArray();
        ArrayList<Integer> numbersArray = new ArrayList<>();
        StringBuilder number = new StringBuilder() ;
        for (int i = 0; i < symbols.length; i++)
        {
            if(Character.isDigit(symbols[i]))
                number.append(symbols[i]);
            else if (!number.toString().equals("")) {
                numbersArray.add(Integer.parseInt(number.toString()));
                number.setLength(0);
            }
        }
        //adding last number
        if (!number.toString().equals("")) {
            numbersArray.add(Integer.parseInt(number.toString()));
        }

        return numbersArray;
    }
    public static void main(String[] args) {

        try {
            File file = new File("strings.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                ArrayList<Integer> numbersArray = extractNumbersFromString(data);
                printLineWhenContainsLargerNumber(data, numbersArray, 10);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}