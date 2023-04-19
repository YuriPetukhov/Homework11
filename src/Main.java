import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите год для проверки");
        int year = in.nextInt();
        if (checkYear(year)) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }

        System.out.println("Задача 2");

        System.out.println("Введите год изготовления телефона");
        int clientDeviceYear = in.nextInt();

        System.out.println("Выберите операционную систему: 0 = Android или 1 = iOS: ");
        int clientOS = in.nextInt();

        if (determineManufactureYear(clientDeviceYear)) {
            if (determineOS(clientOS) == 1) {
                System.out.println("Установите версию приложения для iOS по ссылке: ");
            } else if (determineOS(clientOS) == 0) {
                System.out.println("Установите версию приложения для Android по ссылке: ");
            } else {
                System.out.println("К сожалению, не удается определить операционную систему!");
            }
        }
        if (!determineManufactureYear(clientDeviceYear)) {
            if (determineOS(clientOS) == 1) {
                System.out.println("Установите облегченную версию приложения для iOS по ссылке: ");
            } else if (determineOS(clientOS) == 0) {
                System.out.println("Установите облегченную версию приложения для Android по ссылке: ");
            } else {
                System.out.println("К сожалению, не удается определить операционную систему!");
            }
        }

        System.out.println("Задача 3");

        System.out.println("Введите дальность доставки");
        int deliveryDistance = in.nextInt();

        if (determineDaysNumbers(deliveryDistance) != -1) {
            System.out.println("Потребуется дней: " + determineDaysNumbers(deliveryDistance));
        } else {
            System.out.println("Доставка не осуществляется");
        }

    }

    public static boolean checkYear(int year) {

        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static int determineOS(int oS) {

        if (oS == 1) {
            return 1;
        } else if (oS == 0) {
            return 0;
        } else {
            return 3;
        }
    }

    public static boolean determineManufactureYear(int manufactureYear) {
        return manufactureYear == LocalDate.now().getYear();
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