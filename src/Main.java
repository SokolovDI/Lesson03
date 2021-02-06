import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        doTaskOne();
        doTaskTwo();
    }
    /**
     * 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,чем загаданное, или меньше.
     * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
     */
    static void doTaskOne() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Я загадал число от 0 до 9. У тебя три попытки, что бы угадать! Играем...\n");
        int guessNumber = (int) (Math.random() * 10);

        for (int i = 1; i < 4; i++) {
            System.out.println("Попытка №" + i + ". Введите число от 0 до 9");
            int answer = scan.nextInt();
            if (guessNumber == answer) {
                System.out.println("Угадал\n");
                break;
            } else if (guessNumber < answer) {
                System.out.println("Много");
            } else System.out.println("Мало");
            if (i == 3) {
                System.out.println("Не угадал! Это - " + guessNumber);
            }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        repeatDoTaskOne();
    }

    static void repeatDoTaskOne() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a == 1)
            doTaskOne();
        if (a != 0 && a != 1) {
            System.out.println("Введено не корректное число! Повторить игру еще раз? 1 – да / 0 – нет");
            repeatDoTaskOne();
        }
    }

    /**
     * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
     * "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
     * "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно можно пользоваться:
     * String str = "apple";
     * char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово.
     * Используем только маленькие буквы.
     */
    static void doTaskTwo() {
        Scanner scan = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};

        String riddle = words[(int) (Math.random() * words.length)];
        System.out.println("Загадано слово. Угадай...");

        while (true) {
            String userAnswer = scan.next();
            if (userAnswer.equals(riddle)) {
                System.out.println("Угадал. Это - " + riddle);
                break;
            } hideRiddle(riddle, userAnswer);
        }
    }
    static void hideRiddle (String riddle, String userAnswer) {
        String res = "";
        userAnswer = userAnswer + "***************";
        for (int i = 0; i < riddle.length(); i++) {
            if (riddle.charAt(i) == userAnswer.charAt(i)){
                res +=riddle.charAt(i);
            } else {
                res += "*";
            }
        }
        for (int i = res.length(); i <15 ; i++) {
            res +="*";
        }
        System.out.println(res + "\nНе угадал. Еще раз...");
    }
}

