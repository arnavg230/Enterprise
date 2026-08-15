package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class ResourceService {

    public static void displayResources(LibraryResource[] resources, int[] overdueDays) {

        for (int i = 0; i < resources.length; i++) {

            if (InputValidator.validateFineDays(overdueDays[i])) {

                Printable p = (Printable) resources[i];
                p.printDetails();

                System.out.println("Overdue Days: " + overdueDays[i]);

                double fine = resources[i].calculateFine(overdueDays[i]);

                System.out.println("Fine: Rs. " + fine);
            }
        }
    }

    public static double calculateTotalFine(
            LibraryResource[] resources, int[] overdueDays) {

        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {

            if (InputValidator.validateFineDays(overdueDays[i])) {
                totalFine = totalFine
                        + resources[i].calculateFine(overdueDays[i]);
            }
        }

        return totalFine;
    }
}