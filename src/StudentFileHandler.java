import java.io.*;
import java.util.ArrayList;

public class StudentFileHandler {
    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getFirstName() + "," + s.getLastName() + "," + s.getPhone() + "," + s.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Student(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}

