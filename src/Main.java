import java.util.InputMismatchException;
import java.util.Scanner;

class StringTooLongException extends Exception  //https://stackoverflow.com/questions/8423700/how-to-create-a-custom-exception-type-in-java
{
    // Parameterless Constructor
    public StringTooLongException() {}

    // Constructor that accepts a message
    public StringTooLongException(String message)
    {
        super(message);
    }
}

public class Main
{
    public static void main(String[] args) throws StringTooLongException {
        Scanner myObj = new Scanner(System.in);
        int linesAmount = 0;

        System.out.println("Введіть кількість строк");
        try
        {
            linesAmount = myObj.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("вибачте, але Ви не ввели ціле число");

            // halt this process
            Runtime.getRuntime().halt(1);
        }

        for (int i = 1; i <= linesAmount; i++)
        {
            System.out.println("введіть строку номер " + i);
            myObj = new Scanner(System.in); //без створення нового об'єкта не спрацьовує перший раз ввод nextLine, тому в циклі створюємо його щоразу
            String line = myObj.nextLine();

            try
            {
                if(line.length() > 20)
                {
                    throw new StringTooLongException("вибачте, але Ви ввели занадто довгу строку");
                }
            }
            catch (StringTooLongException e)
            {
                System.out.println("вибачте, але Ви ввели занадто довгу строку");
            }

            System.out.println("введено строку: " + line);
        }

        System.out.println("I'm here");
    }
}