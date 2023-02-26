import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //  инициализируем переменные для ввода с консоли
        int n = 0;
        String b = "";
        String s = "";
        // запускаем первый сканер для числа
        Scanner scan_n = new Scanner(System.in);
        System.out.print("Введите n - число букв в названии: ");
        if (scan_n.hasNextInt()) {
            n = scan_n.nextInt();
        }
        // запускаем второй сканер для ввода слов названия отдела Тинькофф
        Scanner scan_s = new Scanner(System.in);
        System.out.print("Введите строку s - название отдела: ");
        if (scan_s.hasNextLine()) {
            s = scan_s.nextLine();
        }
        // все слова разделены пробелом кроме последнего - добавим пробел и распилим фразу на слова
        // слова поместим в массив
        String[] words = (s + " ").split(" ");
        int number = words.length; // запомним в переменную количество слов в названии

        // новый сканер для ввода цветов раскраски названия
        Scanner scan_b = new Scanner(System.in);
        System.out.print("Введите строку b из " + n + " символов Y/B для обозначения цвета краски: ");
        if (scan_b.hasNextLine()) {
            b = scan_b.nextLine();
        }

        int badWord = 0; // счетчик некрасивых слов
        int start = 0;   // счетчик начала цикла по строке b

        String[] colourArray = new String[number]; // массив для букв YB - шаблон покраски
        // каждому слову в названии сопоставим шаблон с покраской - такой же длины слово типа YBYYBB
        for (int i = 0; i < number; i++) {  // цикл по шаблонам покраски
            colourArray[i] = ""; // создали пустую строку
            for (int j = 0; j < words[i].length(); j++) {
                colourArray[i] = colourArray[i] + b.charAt(j + start); // добавили в строку символ из b
            }
            start = start + words[i].length(); // передвинули начало для следующего цикла
            System.out.println(colourArray[i] + " - так красим " + (i + 1) + " слово");
        }
        // переберем в цикле по i каждый шаблон покраски
        for (int i = 0; i < number; i++) {
            if (colourArray[i].length() > 1) { // если слово из 1 буквы - оно красивое и проверка не нужна
                int j = 1; // если слово из 2 и более букв - пройдем по буквам шаблона и сравним их
                while (j < colourArray[i].length()) {
                    if (colourArray[i].charAt(j - 1) == colourArray[i].charAt(j)) {
                        badWord += 1; // если буквы покрашениы одинаково то добавляем счетчик некрасивых слов
                        System.out.println(colourArray[i] + " - не красиво! ");
                        break; // дальше уже не надо проверять буквы - выходим из цикла
                    }
                    j++; // буквы разные по цвету - тогда плюсуем счетчик и переходим на следующую букву
                }
            }
        }
        System.out.println("Некрасивых слов в названии = " + badWord);
    }
}
