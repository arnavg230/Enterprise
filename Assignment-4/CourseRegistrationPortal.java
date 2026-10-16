import java.util.*;

class Course {
    String courseCode;
    int capacity;
    HashSet<String> enrolledStudents;
    ArrayList<String> prerequisites;
    LinkedList<String> waitlist;

    Course(String courseCode, int capacity, ArrayList<String> prerequisites) {
        this.courseCode = courseCode;
        this.capacity = capacity;
        this.prerequisites = prerequisites;
        enrolledStudents = new HashSet<>();
        waitlist = new LinkedList<>();
    }

    boolean hasSeat() {
        return enrolledStudents.size() < capacity;
    }
}

public class CourseRegistrationPortal {
    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<String, HashSet<String>> completedCourses = new HashMap<>();

    public void addCourse(String code, int capacity, ArrayList<String> prerequisites) {
        courses.put(code, new Course(code, capacity, prerequisites));
    }

    public void addCompletedCourse(String studentId, String courseCode) {
        completedCourses.putIfAbsent(studentId, new HashSet<>());
        completedCourses.get(studentId).add(courseCode);
    }

    private boolean prerequisitesMet(String studentId, Course course) {
        HashSet<String> completed = completedCourses.getOrDefault(studentId, new HashSet<>());
        return completed.containsAll(course.prerequisites);
    }

    public void registerStudent(String studentId, String courseCode) {
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course " + courseCode + " does not exist.");
            return;
        }

        if (course.enrolledStudents.contains(studentId)) {
            System.out.println(studentId + " is already enrolled in " + courseCode + ".");
            return;
        }

        if (!prerequisitesMet(studentId, course)) {
            System.out.println("Registration denied for " + studentId +
                    ": prerequisites not completed for " + courseCode + ".");
            return;
        }

        if (course.hasSeat()) {
            course.enrolledStudents.add(studentId);
            System.out.println(studentId + " successfully registered in " + courseCode + ".");
        } else if (!course.waitlist.contains(studentId)) {
            course.waitlist.addLast(studentId);
            System.out.println(courseCode + " is full. " + studentId + " added to waitlist.");
        } else {
            System.out.println(studentId + " is already on the waitlist for " + courseCode + ".");
        }
    }

    public void dropCourse(String studentId, String courseCode) {
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course " + courseCode + " does not exist.");
            return;
        }

        if (course.enrolledStudents.remove(studentId)) {
            System.out.println(studentId + " dropped " + courseCode + ".");
            promoteFromWaitlist(course);
        } else if (course.waitlist.remove(studentId)) {
            System.out.println(studentId + " removed from the waitlist of " + courseCode + ".");
        } else {
            System.out.println(studentId + " is not enrolled or waitlisted in " + courseCode + ".");
        }
    }

    private void promoteFromWaitlist(Course course) {
        while (course.hasSeat() && !course.waitlist.isEmpty()) {
            String nextStudent = course.waitlist.removeFirst();

            if (prerequisitesMet(nextStudent, course)) {
                course.enrolledStudents.add(nextStudent);
                System.out.println(nextStudent + " promoted from waitlist to " + course.courseCode + ".");
            } else {
                System.out.println(nextStudent + " skipped because prerequisites are not met.");
            }
        }
    }

    public void showCourseDetails(String courseCode) {
        Course course = courses.get(courseCode);

        if (course == null) {
            System.out.println("Course " + courseCode + " does not exist.");
            return;
        }

        System.out.println("\nCourse: " + course.courseCode);
        System.out.println("Capacity: " + course.capacity);
        System.out.println("Enrolled students: " + course.enrolledStudents);
        System.out.println("Prerequisites: " + course.prerequisites);
        System.out.println("Waitlist: " + course.waitlist);
    }

    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();

        portal.addCourse("CS101", 2, new ArrayList<>());
        portal.addCourse("CS201", 2, new ArrayList<>(Arrays.asList("CS101")));

        portal.addCompletedCourse("S101", "CS101");
        portal.addCompletedCourse("S102", "CS101");
        portal.addCompletedCourse("S103", "CS101");
        portal.addCompletedCourse("S104", "CS101");

        portal.registerStudent("S101", "CS201");
        portal.registerStudent("S102", "CS201");
        portal.registerStudent("S103", "CS201");
        portal.registerStudent("S104", "CS201");

        portal.showCourseDetails("CS201");

        System.out.println("\nDropping S101 from CS201...");
        portal.dropCourse("S101", "CS201");

        portal.showCourseDetails("CS201");
    }
}
