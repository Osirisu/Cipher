import Alphabet.*;
import Cipher.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cipher();
        System.out.println("Конец выполнения программы!!!");
    }

    private static void cipher(){
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.print("Выберите язык 1-английски 2-русский: ");
            int language = checkString(scanner.nextLine());

            IAlphabet alphabet = null;
            switch (language){
                case 1 -> alphabet = new Alphabet(Language.ENGLISH);
                case 2 -> alphabet = new Alphabet(Language.RUSSIAN);
            }
            if (alphabet == null)
                continue;

            System.out.println("Вы выбпали [" + alphabet.getNameAlphabet() + "] язык.");
            System.out.print("Введите текст: ");
            String text = scanner.nextLine().
                    replace("ё","ѐ");
            text = text.replace("Ё","ѐ");

            Cipher cipher = new TrithemiusCipher(text, alphabet);

            System.out.print("Выберите операция 1-шифрование 2-дешифрование: ");
            int operation = checkString(scanner.nextLine());

            String result;
            if (operation == 1){
                result = cipher.encryption();
            }else {
                result = cipher.decryption();
            }

            System.out.println("Результат операции: " + result);
            System.out.print("Выйти? 1-Да: ");
            System.out.println();
        } while (checkString(scanner.nextLine()) != 1);
    }

    private static int checkString(String checking){
        try {
            return Integer.parseInt(checking);
        }catch (NumberFormatException exception){
            return 1;
        }
    }
}