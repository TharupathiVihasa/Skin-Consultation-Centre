package admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public interface SkinConsultationManager {

    void addDoctor();
    void deleteDoctor() throws IOException;
    void printDoctorList();
    void saveDoctorList()throws IOException;
    void readFile() throws IOException;


}
