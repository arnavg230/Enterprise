import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class Q4_EventManager {
    public static void main(String[] args) {
        String eventName = "College Tech Fest";
        LocalDate eventDate = LocalDate.now().plusDays(5);
        LocalTime startTime = LocalTime.of(10, 30);
        Optional<String> venue = Optional.of("Main Auditorium");

        LocalTime endTime = startTime.plusHours(2);

        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Venue: " + venue.orElse("Venue not specified"));

        LocalDate today = LocalDate.now();
        if (eventDate.isAfter(today)) {
            System.out.println("The event is in the future.");
            System.out.println("Days remaining: " + ChronoUnit.DAYS.between(today, eventDate));
        } else if (eventDate.isEqual(today)) {
            System.out.println("The event is today.");
            System.out.println("Days remaining: 0");
        } else {
            System.out.println("The event is in the past.");
        }

        // Example of an event with no venue
        Optional<String> noVenue = Optional.empty();
        System.out.println("Second event venue: " + noVenue.orElse("Venue not specified"));
    }
}
