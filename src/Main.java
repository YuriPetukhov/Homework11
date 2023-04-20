import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите год для проверки");
        int year = in.nextInt();
        checkYear(year);

        System.out.println("Задача 2");

        System.out.println("Введите год изготовления телефона");
        int clientDeviceYear = in.nextInt();
        Scanner phone = new Scanner(System.in);
        System.out.println("Выберите операционную систему: Android или iOS");
        String phoneOS = phone.nextLine();

        chooseLink(clientDeviceYear, phoneOS);


        System.out.println("Задача 3");

        System.out.println("Введите дальность доставки");
        int deliveryDistance = in.nextInt();

        if (determineDaysNumbers(deliveryDistance) != -1) {
            System.out.println("Потребуется дней: " + determineDaysNumbers(deliveryDistance));
        } else {
            System.out.println("Доставка не осуществляется");
        }

    }

    public static void checkYear(int year) {

        if (year >= 0) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println(year + " год является високосным");
            } else {
                System.out.println(year + " год не является високосным");
            }
        } else {
            System.out.println("Год не может быть отрицательным");
        }
    }

    public static void chooseLink(int clientDeviceYear, String phoneOS) {


        if (clientDeviceYear == LocalDate.now().getYear()) {
            if (phoneOS.equals("iOS")) {
                System.out.println("Установите версию приложения для iOS по ссылке: ");
            } else if (phoneOS.equals("Android")) {
                System.out.println("Установите версию приложения для Android по ссылке: ");
            } else {
                System.out.println("К сожалению, не удается определить операционную систему!");
            }
        }
        if (clientDeviceYear < LocalDate.now().getYear() && clientDeviceYear >= 0) {
            if (phoneOS.equals("iOS")) {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке: ");
            } else if (phoneOS.equals("Android")) {
                System.out.println("Установите облегченную версию приложения для Android по ссылке: ");
            } else {
                System.out.println("К сожалению, не удается определить операционную систему!");
            }
        }
        else {
            System.out.println("Год не может быть больше текущего или отрицательным");
        }

    }

    public static int determineDaysNumbers(int deliveryDistance) {
        int deliveryTime = 1;
        if (deliveryDistance < 20) {
            return deliveryTime;
        }
        if (deliveryDistance < 60) {
            deliveryTime = deliveryTime + 1;
            return deliveryTime;
        }
        if (deliveryDistance < 100) {
            deliveryTime = deliveryTime + 2;
            return deliveryTime;
        }
        deliveryTime = -1;
        return deliveryTime;
    }
}