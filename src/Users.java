import java.util.Scanner;

public class Users {
    String nameOne;
    String nameTwo;

    public void name() {
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Введите имя первого игрока");
        nameOne = scanner.nextLine();
        System.out.println("Введите имя второго игрока");
        nameTwo = scanner.nextLine();
        System.out.println(nameOne + "\n" + nameTwo);
        scanner.close();
    }

}
