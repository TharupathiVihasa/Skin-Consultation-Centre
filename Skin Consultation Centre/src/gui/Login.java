package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame  {
    private ViewDoctorWindow doctorWindow;
    private JButton veiwDoctors;
    private JButton addconsultation;
    private JButton viewConsultation;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane jScrollPane;
    private JTable docTable;
    private JPanel panel1;
    private JFrame jFrame;
    public Login() {

        setTitle("West Minster AddConsultation");
        setSize(new Dimension(500, 600));
        setBounds(800, 500, 700, 500);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(800, 500, 600, 300);
        panel.setLocation(800, 500);
        panel.setBackground(Color.black);

        panel.setLayout(null);
        JLabel photolabel = new JLabel(new ImageIcon("consulation.png"));
        Dimension size = photolabel.getPreferredSize();
        photolabel.setBounds(100, -120, 500, 400);

        veiwDoctors = new JButton("Sort");
        veiwDoctors.setBounds(300, 170, 100, 30);

        addconsultation = new JButton("Add");
        addconsultation.setBounds(300,230,100,30);

        viewConsultation = new JButton("View");
        viewConsultation.setBounds(300,290,100,30);


        label1 = new JLabel("Doctors in The Centre");
        label1.setBackground(Color.black);
        label1.setForeground(Color.white);
        label1.setBounds(70, 170, 250, 30);
        label1.setFont(new Font("Verdana", Font.BOLD, 14));
        label1.setOpaque(true);

        label2 = new JLabel("Add Consultation");
        label2.setBackground(Color.black);
        label2.setForeground(Color.white);
        label2.setBounds(70, 230, 250, 30);
        label2.setFont(new Font("Verdana", Font.BOLD, 14));
        label2.setOpaque(true);

        label3 = new JLabel("View Consultation");
        label3.setBackground(Color.black);
        label3.setForeground(Color.white);
        label3.setBounds(70, 290, 250, 30);
        label3.setFont(new Font("Verdana", Font.BOLD, 14));
        label3.setOpaque(true);

        panel.add(photolabel);
        panel.add(veiwDoctors);
        panel.add(addconsultation);
        panel.add(viewConsultation);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        getContentPane().add(panel);

        getContentPane().add("Center", panel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonHandler buttonHandler = new ButtonHandler();
        veiwDoctors.addActionListener(buttonHandler);
        addconsultation.addActionListener(buttonHandler);
        viewConsultation.addActionListener(buttonHandler);
    }
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == veiwDoctors) {
                ViewDoctorWindow vw = new ViewDoctorWindow();
            } else if (e.getSource()==addconsultation) {
                AddConsultation addcon=new AddConsultation();
            } else if(e.getSource()==viewConsultation) {
                ViewConsultation viewtecon = new ViewConsultation();
            }
        }
    }
}
