import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static void printLineWhenContainsLargerNumber(String line, ArrayList<String> numberArray, int number){
        for( String stringNumber :numberArray)
        {
            int parsedNumber = Integer.parseInt(stringNumber);
            if(parsedNumber >= number)
            {
                System.out.println(line);
                break;
            }
        }
    }
    static ArrayList<String> extractNumbersFromString(char[] symbols)
    {
        ArrayList<String> numbersArray = new ArrayList<>();
        StringBuilder digit = new StringBuilder() ;
        for (int i = 0; i < symbols.length; i++)
        {
            if(Character.isDigit(symbols[i]))
                digit.append(symbols[i]);
            else if (!digit.toString().equals("")) {
                numbersArray.add(digit.toString());
                digit.setLength(0);
            }
        }
        //adding last number
        if (!digit.toString().equals("")) {
            numbersArray.add(digit.toString());
        }
        return numbersArray;
    }
    public static void main(String[] args) {
        try {
            File file = new File("strings.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                char[] symbols = data.toCharArray();
                ArrayList<String> numbersArray = extractNumbersFromString(symbols);
                printLineWhenContainsLargerNumber(data, numbersArray, 10);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}