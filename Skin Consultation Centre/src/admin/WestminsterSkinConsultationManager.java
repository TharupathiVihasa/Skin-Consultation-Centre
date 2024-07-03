package admin;

import gui.Login;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;


public  class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public static ArrayList<Doctor> doctorList = new ArrayList<>(10);

    /**
     * This method is used to get the List of doctors.
     * @return doctors List
     */
    public static ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
    public static ArrayList<Consultation> consultationList = new ArrayList<>(10);
    String firstName, surname, mobileNumber, dob, specialisation;
    String medicalLicenceNumber;


    public static void main(String args[]) throws IOException {

        WestminsterSkinConsultationManager westMinsterManager = new WestminsterSkinConsultationManager();
/**
* Read File Method is to display the doctors stored in the arrayList
*/
      westMinsterManager.readFile();

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("""
                    How should you want to proceed?---- #Manager #User
                        1. Manager
                        2. User
                    """);
            String selection = String.valueOf(input.next().toUpperCase().charAt(0));

            if (selection.equals("1")) {
                while (true) {
                    System.out.println("Add a new  Doctor          :    A   ");
                    System.out.println("Delete a  Doctor           :    B   ");
                    System.out.println("Print the List of Doctors  :    C   ");
                    System.out.println("Save in a File             :    D   ");
                    System.out.println("To stop                    :    Z   ");
                    System.out.print("Add your Option :  ");

                    String option = input.next();
                    if (option.equalsIgnoreCase("A")) {
                        westMinsterManager.addDoctor();
                    } else if (option.equalsIgnoreCase("B")) {
                        westMinsterManager.deleteDoctor();
                    } else if (option.equalsIgnoreCase("C")) {
                        westMinsterManager.printDoctorList();
                    } else if (option.equalsIgnoreCase("D")) {
                        westMinsterManager.saveDoctorList();
                    } else if (option.equalsIgnoreCase("R")) {
                        westMinsterManager.readFile();
                    } else if (option.equalsIgnoreCase("Z")) {
                        break;
                    } else {
                        System.out.println("Invalid Format");
                    }
                }
            }
            if (selection.equals("2")) {
                new Login();

            }
        }
    }
/**
* addDoctor method is used to add a new Doctor to the centre.
*/
    @Override
    public void addDoctor() {
        Scanner input = new Scanner(System.in);

        if (doctorList.size() == 10) {
            System.out.println("Doctors are full");

        } else {
            System.out.print("Enter the first name of the Doctor    : ");
            firstName = input.next();
            while (!Pattern.matches("[a-zA-Z ]+", firstName)) {
                System.out.println("Enter a valid name between a-z or A-Z");
                firstName = input.next();
            }
            System.out.print("Enter the Sur name of the Doctor      : ");
            surname = input.next();
            while (!Pattern.matches("[a-zA-Z ]+", surname)) {
                System.out.println("Enter a valid surname between a-z or A-Z");
                surname = input.next();
            }
            System.out.print("Enter the date of birth of the Doctor(yyyy-mm-d) : ");
            dob = input.next();
            while (!Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", dob)) {
                System.out.println("Enter a valid date of birth");
                dob = input.next();
            }
            System.out.print("Enter the Mobile Number of the Doctor : ");
            mobileNumber = input.next();
            while (!Pattern.matches("\\d{3}-\\d{7}+", mobileNumber)) {
                System.out.println("Enter a valid Mobile Number between 0-10");
                mobileNumber = input.next();
            }
            System.out.print("Enter the Medical Licence Number     : ");
            medicalLicenceNumber = input.next();
            while (!Pattern.matches("\\d{3}-[a-zA-Z ]+", medicalLicenceNumber)) {
                System.out.println("Enter a valid Mobile Number between \\d{3}-[a-zA-Z ]");
                medicalLicenceNumber = input.nextLine();
            }
            System.out.print("Enter the Specialisation              : ");
            specialisation = input.next();

            doctorList.add(new Doctor(firstName, surname, mobileNumber, dob, medicalLicenceNumber, specialisation));
            System.out.println(doctorList);
        }
    }
/**
* deleteDoctor Method is to Delete a specific Doctor according to the licence number
*/
    @Override
    public void deleteDoctor() throws IOException {

        Scanner input = new Scanner(System.in);
        if (doctorList.size() == 0) {
            System.out.println("------------- No Doctors are available -------------");
        } else {
            System.out.print("Delete a doctor by medical Licence Number : ");
            medicalLicenceNumber = input.nextLine();
            while (!Pattern.matches("\\d{3}-[a-zA-Z ]+", medicalLicenceNumber)) {
                System.out.println("Enter a valid medical Licence Number between \\d{3}-[a-zA-Z ]");
                medicalLicenceNumber = input.nextLine();
            }
            for (Doctor doctor : doctorList) {
                if (doctor.getMedicalLicenceNumber().equals(medicalLicenceNumber)) {
                    System.out.println("The doctor with the medical licence number" + doctor + "is going to remove");
                    doctorList.remove(doctor);
                    System.out.println("The doctor with the " + medicalLicenceNumber + " is removed successfully");
                    System.out.println("Now there are " + doctorList.size() + " doctors available in the centre");
                    //saveDoctorList();
                    break;
                }
            }
        }
    }

/**
* printDoctorList Method is to print the list of Doctors each with relevant information.
* The Doctors are printed alphabetically according the surname.
*/
    @Override
    public void printDoctorList() {
        doctorList.sort(Comparator.comparing(Person::getSurname));
        if (doctorList.size() == 0) {
            System.out.println("-----------Doctors are empty----------");

        } else {
            for (Doctor doctor : doctorList) {
                System.out.println(
                        "The first Name:" + doctor.getFirstName() + "   - " +
                                "The second Name:" + doctor.getSurname() + "    - " +
                                "The medical Licence Number:" + doctor.getMedicalLicenceNumber() + "    - " +
                                "The date of birth:" + doctor.getDob() + "    - " +
                                "The mobile Number:" + doctor.getMobileNumber() + "    - " +
                                "The specialisation:" + doctor.getSpecialisation());
            }
        }
    }
/**
* saveDoctorList Method is to save the list of Doctors each with relevant information in the file.
*/
    @Override
    public void saveDoctorList() throws IOException {

        ObjectOutputStream objectoutputstream = new ObjectOutputStream(new FileOutputStream("DoctorList.txt"));
        try {
            for (Doctor doctor : doctorList) {
                objectoutputstream.writeObject(doctor);
            }
            objectoutputstream.close();
            System.out.println("--------------Data saved Successfully----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        objectoutputstream.close();
    }
/**
* readFile method is to read back and load information that have been stored in the file and stores data to a
* doctor List at the time of programme get started
* File name - DoctorList.txt
*/
    @Override
    public void readFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("DoctorList.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        while (true) {
            try {
                Doctor doctor = (Doctor) objectInputStream.readObject();
                doctorList.add(doctor);
                System.out.println(doctorList);
            } catch (IOException | ClassNotFoundException ex) {
                break;
            }
        }

    }
}




