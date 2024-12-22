import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setLayout( null );
        frame.setSize(800, 550);
        frame.setLocationRelativeTo( null );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton cancel = new JButton(" Cancel ");
        JCheckBox show = new JCheckBox(" Show password ");
        JLabel loginForm = new JLabel(" Login Form ");
        JPanel panel = new JPanel( null );
        panel.add( loginForm );

        panel.setBounds( 0 , 0 , 800 , 140 );
        loginForm.setBounds( 330 , 50 , 200 , 40 );
        userLabel.setBounds( 150 , 200 , 100 , 35 );
        passLabel.setBounds( 150 , 260 , 125 , 20 );
        userField.setBounds( 250 , 200 , 350 , 35 );
        passField.setBounds( 250 , 250 , 350 , 35 );
        loginButton.setBounds( 250 , 330 , 150 , 35 );
        cancel.setBounds( 450 , 330 , 150 , 35 );
        show.setBounds( 620 , 250 , 100 , 35 );


        panel.setBackground( Color.DARK_GRAY );
        frame.getContentPane().setBackground( Color.DARK_GRAY );
        loginForm.setFont( new Font ( " NewTimesRoman " , Font.BOLD , 32)  );
        loginForm.setForeground( Color.WHITE );
        userLabel.setForeground( Color.WHITE );
        passLabel.setForeground( Color.WHITE );
        show.setBackground( Color.DARK_GRAY );
        show.setForeground( Color.WHITE );



        frame.add( panel );
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(new JLabel());
        frame.add(loginButton);
        frame.add( cancel );
        frame.add( show );

        frame.setVisible(true);


        show.addActionListener( e -> {
            if ( e.getSource() == show ){
                if ( show.isSelected() ){
                    passField.setEchoChar( '\0' );
                    show.setText(" Hide Password");
                }else{
                    passField.setEchoChar( '*' );
                    show.setText(" Show Password ");
                }
        }

        });

        

        cancel.addActionListener( e -> {
            if ( e.getSource() == cancel ){
                int c = JOptionPane.showConfirmDialog( null , " Do You Want Exit " , " Choose ", JOptionPane.YES_NO_OPTION );
                if ( c == 0 ){
                    System.exit( 0 );
                }
        }
        });












        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                frame.dispose();
                MainApp.main(null); // فتح نافذة إدارة الطلاب
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid login credentials!");
            }
        });


    }
}
