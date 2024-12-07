package attestation.cactus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EnterDate {
    public static void main(String[] args) {
        System.out.println("Введите дату последнего полива в формате год-месяц-день(например 2024-12-03):");
        var scanner = new Scanner(System.in);
        LocalDate previousWaterDate = null;
        do {
            try {
                previousWaterDate = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Введен неверный формат даты, попробуйте снова в формате год-месяц-день(например 2024-12-03):");
            }
        } while (previousWaterDate == null);

        var now = LocalDate.now();
        if (now.isBefore(previousWaterDate)) {
            System.out.println("Вы уже полили кактус в будущем.");
            return;
        }

        var humiditySensor = new RandomHumiditySensor();
        var humidity = humiditySensor.getHumidity();

        var waterPlantScheduler = new WaterCactusScheduler();
        var nextWaterDate = waterPlantScheduler.calculateNextWaterDate(previousWaterDate, now, humidity);

        if (nextWaterDate.isPresent()) {
            System.out.println("Дата следующего полива: "
                    + nextWaterDate.get().format(DateTimeFormatter.ISO_DATE));
        } else {
            System.out.println("При текущей дате и влажности полив не требуется, попробуйте позже.");
        }
    }
}
