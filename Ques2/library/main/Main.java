package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.ResourceService;
import library.util.InputValidator;

public class Main {

    public static void main(String[] args) {

        LibraryResource.setLibraryName("University Central Library");

        LibraryResource[] resources = new LibraryResource[5];

        resources[0] = new Book(101, "Java Programming", "James Gosling");
        resources[1] = new Book(102, "Data Structures", "Mark Allen");
        resources[2] = new DigitalResource(103, "Java E-Book", "Herbert Schildt");
        resources[3] = new DigitalResource(104, "Online Research Paper", "John Smith");
        resources[4] = new Book(105, "Operating Systems", "Abraham Silberschatz");

        int[] overdueDays = {5, 3, 10, 7, 0};

        System.out.println("==================================");
        System.out.println("     " + LibraryResource.getLibraryName());
        System.out.println("       LIBRARY RESOURCES");
        System.out.println("==================================");

        for (int i = 0; i < resources.length; i++) {

            if (InputValidator.validateResourceId(
                    resources[i].getResourceId())) {

                // Resource details will be displayed by the service class
            } else {
                System.out.println("Invalid Resource ID: "
                        + resources[i].getResourceId());
            }
        }

        ResourceService.displayResources(resources, overdueDays);

        double totalFine = ResourceService.calculateTotalFine(
                resources, overdueDays);

        System.out.println("----------------------------------");
        System.out.println("Total Fine: Rs. " + totalFine);
        System.out.println("----------------------------------");

        LibraryResource.displayTotalResources();
    }
}