import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainApp {
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // عناصر الواجهة
        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(firstNameLabel);
        formPanel.add(firstNameField);
        formPanel.add(lastNameLabel);
        formPanel.add(lastNameField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(addButton);
        formPanel.add(updateButton);

        frame.add(formPanel, BorderLayout.NORTH);

        // جدول عرض البيانات
        String[] columns = {"ID", "First Name", "Last Name", "Phone", "Address"};
        JTable table = new JTable(new String[0][5], columns);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // أحداث الأزرار
        addButton.addActionListener(e -> {
            Student student = new Student(
                    idField.getText(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    phoneField.getText(),
                    addressField.getText()
            );
            studentList.add(student);
            StudentFileHandler.saveStudents(studentList);
            refreshTable(table);
        });

        updateButton.addActionListener(e -> {
            // تحديث بيانات الطالب
        });

        deleteButton.addActionListener(e -> {
            // حذف بيانات الطالب
        });

        searchButton.addActionListener(e -> {
            // البحث عن طالب
        });

        frame.setVisible(true);
    }

    private static void refreshTable(JTable table) {
        String[][] data = new String[studentList.size()][5];
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            data[i] = new String[]{s.getId(), s.getFirstName(), s.getLastName(), s.getPhone(), s.getAddress()};
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"ID", "First Name", "Last Name", "Phone", "Address"}));
    }
}

