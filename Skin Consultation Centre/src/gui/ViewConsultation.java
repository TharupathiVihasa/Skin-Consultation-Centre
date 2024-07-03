package gui;

import admin.Consultation;
import admin.Doctor;
import admin.Person;
import admin.WestminsterSkinConsultationManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class ViewConsultation extends JFrame {
    Consultation consultation;
    ArrayList<Consultation> consultationList = WestminsterSkinConsultationManager.consultationList;
    public ViewConsultation(){
        String[] tableclmns = {"FirstName","Surname","DateOfBirth","MobileNo","MedicalLicenceNo"};
        Object[][] data = new Object[consultationList.size()][5];
        int index = 0;
        for(Consultation consultation :consultationList){
            data[index][0]=consultation.getPatient().getFirstName();
            data[index][1]=consultation.getPatient().getSurname();
            data[index][2]=consultation.getPatient().getDob();
            data[index][3]=consultation.getPatient().getMobileNumber();
            data[index][4]=consultation.getDoctor().getMedicalLicenceNumber();
            index++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data,tableclmns);
        JTable consultationTable = new JTable(defaultTableModel);
        JScrollPane jScrollPane = new JScrollPane(consultationTable);
        add(jScrollPane);

        setTitle("Consultation List");
        setSize(800,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
