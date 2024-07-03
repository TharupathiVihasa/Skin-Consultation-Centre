package gui;

import admin.Consultation;
import admin.Doctor;
import admin.Patient;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static admin.WestminsterSkinConsultationManager.consultationList;
import static admin.WestminsterSkinConsultationManager.doctorList;



public class AddConsultation extends JFrame {

    private Patient patient;
    private Doctor doctor;
    private JPanel jPanel;
    private JPanel datePanel;
    private JLabel firstnamelbl, surnamelbl, datelbl, daylbl, timelbl, doblbl, mobilenolbl,
            costlbl, patientidlbl, booking, describecost, notelbl, doctorlistlbl;
    private JTextField firstnametxt, surnametxt,dobtxt, costtxt, mobilenotxt, patientidtxt, notetxt;
    private JComboBox monthbox, datebox, doctorlistbox, timebox;
    private JButton mainbutton;

    public AddConsultation() {

        booking = new JLabel("Booking a Consultation");
        booking.setBackground(Color.black);
        booking.setForeground(Color.white);
        booking.setBounds(300, 10, 350, 30);
        booking.setFont(new Font("Verdana", Font.BOLD, 16));
        booking.setOpaque(true);

        firstnamelbl = new JLabel("First Name");
        firstnamelbl.setBackground(Color.black);
        firstnamelbl.setForeground(Color.white);
        firstnamelbl.setBounds(50, 70, 250, 30);
        firstnamelbl.setFont(new Font("Verdana", Font.BOLD, 14));
        firstnamelbl.setOpaque(true);

        surnamelbl = new JLabel("Surname");
        surnamelbl.setBackground(Color.black);
        surnamelbl.setForeground(Color.white);
        surnamelbl.setBounds(50, 110, 250, 30);
        surnamelbl.setFont(new Font("Verdana", Font.BOLD, 14));
        surnamelbl.setOpaque(true);

        datelbl = new JLabel("Date Allocation-Month");
        datelbl.setBackground(Color.black);
        datelbl.setForeground(Color.white);
        datelbl.setBounds(350, 110, 200, 30);
        datelbl.setFont(new Font("Verdana", Font.BOLD, 14));
        datelbl.setOpaque(true);

        daylbl = new JLabel("Day");
        daylbl.setBackground(Color.black);
        daylbl.setForeground(Color.white);
        daylbl.setBounds(780, 110, 70, 30);
        daylbl.setFont(new Font("Verdana", Font.BOLD, 14));
        daylbl.setOpaque(true);

        timelbl = new JLabel("Time");
        timelbl.setBackground(Color.black);
        timelbl.setForeground(Color.white);
        timelbl.setBounds(1030, 110, 40, 30);
        timelbl.setFont(new Font("Verdana", Font.BOLD, 14));
        timelbl.setOpaque(true);

        doctorlistlbl = new JLabel("Doctor List");
        doctorlistlbl.setBackground(Color.black);
        doctorlistlbl.setForeground(Color.white);
        doctorlistlbl.setBounds(350, 150, 250, 30);
        doctorlistlbl.setFont(new Font("Verdana", Font.BOLD, 14));
        doctorlistlbl.setOpaque(true);

        describecost = new JLabel("For only the first booking - £15" + " , " + "For normal booking - £25");
        describecost.setBackground(Color.black);
        describecost.setForeground(Color.white);
        describecost.setBounds(350, 190, 600, 30);
        describecost.setFont(new Font("Verdana", Font.BOLD, 14));
        describecost.setOpaque(true);

        doblbl = new JLabel("Date of Birth");
        doblbl.setBackground(Color.black);
        doblbl.setForeground(Color.white);
        doblbl.setBounds(50, 150, 250, 30);
        doblbl.setFont(new Font("Verdana", Font.BOLD, 14));
        doblbl.setOpaque(true);

        costlbl = new JLabel("Add the Cost");
        costlbl.setBackground(Color.black);
        costlbl.setForeground(Color.white);
        costlbl.setBounds(350, 230, 250, 30);
        costlbl.setFont(new Font("Verdana", Font.BOLD, 14));
        costlbl.setOpaque(true);

        notelbl = new JLabel("Note");
        notelbl.setBackground(Color.black);
        notelbl.setForeground(Color.white);
        notelbl.setBounds(350, 270, 350, 30);
        notelbl.setFont(new Font("Verdana", Font.BOLD, 14));
        notelbl.setOpaque(true);

        mobilenolbl = new JLabel("Mobile No");
        mobilenolbl.setBackground(Color.black);
        mobilenolbl.setForeground(Color.white);
        mobilenolbl.setBounds(50, 190, 250, 30);
        mobilenolbl.setFont(new Font("Verdana", Font.BOLD, 14));
        mobilenolbl.setOpaque(true);

        patientidlbl = new JLabel("Patient ID");
        patientidlbl.setBackground(Color.black);
        patientidlbl.setForeground(Color.white);
        patientidlbl.setBounds(50, 230, 250, 30);
        patientidlbl.setFont(new Font("Verdana", Font.BOLD, 14));
        patientidlbl.setOpaque(true);


        firstnametxt = new JTextField();
        firstnametxt.setBounds(200, 70, 100, 30);

        surnametxt = new JTextField();
        surnametxt.setBounds(200, 110, 100, 30);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};

        monthbox = new JComboBox<>(months);
        monthbox.setBounds(600, 110, 150, 30);

        String[] dates = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30", "31"};

        datebox = new JComboBox<>(dates);
        datebox.setBounds(850, 110, 150, 30);


        String[] timeSlots = {"9.00a.m - 10.00a.m", "10.30a.m - 11.30a.m",
                "11.30a.m - 12.30p.m", "1.30p.m - 2.30p.m", "2.30p.m - 3.30p.m",
                "3.30p.m - 4.30p.m", "4.30p.m - 5.30p.m"};

        timebox = new JComboBox<>(timeSlots);
        timebox.setBounds(1100, 110, 150, 30);

        doctorlistbox = new JComboBox<>();
        doctorlistbox.setBounds(600, 150, 200, 30);
        for(Doctor doctor:doctorList){
            doctorlistbox.addItem(doctor.getFirstName()+" "+ doctor.getSurname());
        }

        dobtxt = new JTextField();
        dobtxt.setBounds(200, 150, 100, 30);

        costtxt = new JTextField();
        costtxt.setBounds(600, 230, 100, 30);

        notetxt = new JTextField();
        notetxt.setBounds(600, 270, 300, 30);

        mobilenotxt = new JTextField();
        mobilenotxt.setBounds(200, 190, 100, 30);

        patientidtxt = new JTextField();
        patientidtxt.setBounds(200, 230, 100, 30);

        mainbutton = new JButton();
        mainbutton.setText("Book");
        mainbutton.setBounds(400, 400, 200, 40);

        JPanel panel1 = new JPanel();
        panel1.setBounds(800, 500, 600, 300);
        panel1.setLocation(800, 500);
        panel1.setBackground(Color.BLACK);
        panel1.setLayout(null);

        add(firstnamelbl);
        add(surnamelbl);
        add(doblbl);
        add(datelbl);
        add(monthbox);
        add(daylbl);
        add(timelbl);
        add(doctorlistlbl);
        add(describecost);
        add(mobilenolbl);
        add(notelbl);
        add(costlbl);
        add(patientidlbl);
        add(booking);

        add(firstnametxt);
        add(surnametxt);
        add(datebox);
        add(timebox);
        add(doctorlistbox);
        add(dobtxt);
        add(notetxt);
        add(mobilenotxt);
        add(costtxt);
        add(patientidtxt);

        add(mainbutton);

        getContentPane().add(panel1);
        getContentPane().add("Center", panel1);

        setTitle("Consultation");
        setSize(1400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ButtonHandler buttonHandler1 = new ButtonHandler();
        mainbutton.addActionListener(buttonHandler1);

    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mainbutton) {

                String firstnamelbl = firstnametxt.getText();
                String surnamelbl = surnametxt.getText();
                String doblbl = String.valueOf(dobtxt);
                String mobilenolbl = mobilenotxt.getText();
                String costlbl =costtxt.getText();
                String notelbl = notetxt.getText();
                String timelbl = Objects.requireNonNull(timebox.getSelectedItem()).toString();

                Patient patient =  new Patient(firstnamelbl,surnamelbl,mobilenolbl,doblbl);
                for (Doctor value : doctorList) {
                    String fullName = value.getFirstName() + " " + value.getSurname();
                    if (fullName.equals(doctorlistbox.getSelectedItem())) {
                        doctor = value;
                        break;
                    }
                }
                Consultation consultation = new Consultation();
                consultation.setDate(String.valueOf(datebox));
                consultation.setTime(String.valueOf(timebox));
                consultation.setMonth(String.valueOf(monthbox));
                consultation.setDoctor(doctor);

                consultation.setPatient(patient);
                consultation.setCost(Double.valueOf(costlbl));
                consultation.setNotes(notelbl);
                consultationList.add(consultation);

                System.out.println(consultation);
                dispose();
                ViewConsultation vw = new ViewConsultation();
                }
            }
    }
}
