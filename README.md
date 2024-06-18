import java.util.*;

// Student class to represent each student
class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

// Attendance class to manage attendance records
class Attendance {
    private Map<String, List<Boolean>> attendanceRecords; // Map of studentId to list of attendance records (true for present, false for absent)

    public Attendance() {
        attendanceRecords = new HashMap<>();
    }

    // Add a student to the attendance system
    public void addStudent(Student student) {
        attendanceRecords.put(student.getStudentId(), new ArrayList<>());
    }

    // Mark a student as present
    public void markPresent(String studentId) {
        List<Boolean> attendanceList = attendanceRecords.get(studentId);
        if (attendanceList != null) {
            attendanceList.add(true);
            System.out.println("Marked present for Student ID: " + studentId);
        } else {
            System.out.println("Student ID not found: " + studentId);
        }
    }

    // Mark a student as absent
    public void markAbsent(String studentId) {
        List<Boolean> attendanceList = attendanceRecords.get(studentId);
        if (attendanceList != null) {
            attendanceList.add(false);
            System.out.println("Marked absent for Student ID: " + studentId);
        } else {
            System.out.println("Student ID not found: " + studentId);
        }
    }

    // Print attendance report
    public void printAttendanceReport() {
        System.out.println("\n--------------- Attendance Report ---------------");
        for (Map.Entry<String, List<Boolean>> entry : attendanceRecords.entrySet()) {
            String studentId = entry.getKey();
            List<Boolean> attendanceList = entry.getValue();
            int totalClasses = attendanceList.size();
            long presentCount = attendanceList.stream().filter(Boolean::booleanValue).count();
            double percentage = (presentCount * 100.0) / totalClasses;

            System.out.println("Student ID: " + studentId + ", Name: " + "Name Here" + ", Attendance Percentage: " + String.format("%.2f", percentage) + "%");
        }
        System.out.println("------------------------------------\n");
    }
}

// Main class to run the attendance management system
public class AttendanceManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Attendance attendance = new Attendance();

        while (true) {
            System.out.println("Enter option:");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance (Present)");
            System.out.println("3. Mark Attendance (Absent)");
            System.out.println("4. Print Attendance Report");
            System.out.println("5. Exit");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Enter Student ID:");
                    String studentId = scanner.nextLine();
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    Student student = new Student(studentId, name);
                    attendance.addStudent(student);
                    break;
                case 2:
                    System.out.println("Enter Student ID to mark present:");
                    studentId = scanner.nextLine();
                    attendance.markPresent(studentId);
                    break;
                case 3:
                    System.out.println("Enter Student ID to mark absent:");
                    studentId = scanner.nextLine();
                    attendance.markAbsent(studentId);
                    break;
                case 4:
                    attendance.printAttendanceReport();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter again.");
            }
        }
    }
}
