package gui;

import admin.Doctor;
import admin.Person;
import admin.WestminsterSkinConsultationManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;

public class ViewDoctorWindow extends JFrame  {
    ArrayList<Doctor> doctorList = WestminsterSkinConsultationManager.getDoctorList();
    public  ViewDoctorWindow(){
        doctorList.sort(Comparator.comparing(Person::getSurname));
        System.out.println(doctorList);
        String[] tableclmns = {"MedicalLicenceNo","FirstName","Surname","MobileNo","DateOfBirth","Specialisation"};
        Object[][] data = new Object[doctorList.size()][6];
        int index = 0;
        for(Doctor doctor :doctorList){
            data[index][0]=doctor.getMedicalLicenceNumber();
            data[index][1]=doctor.getFirstName();
            data[index][2]=doctor.getSurname();
            data[index][3]=doctor.getMobileNumber();
            data[index][4]=doctor.getDob();
            data[index][5]=doctor.getSpecialisation();
            index++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data,tableclmns);
        JTable docTable = new JTable(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(docTable);
        add(jScrollPane);

        setTitle("Doctor List");
        setSize(800,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
