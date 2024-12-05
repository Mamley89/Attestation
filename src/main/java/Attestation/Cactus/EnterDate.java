package Attestation.Cactus;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EnterDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сегодняшнюю дату:");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        String DataNow = scanner.nextLine();

    }
}
