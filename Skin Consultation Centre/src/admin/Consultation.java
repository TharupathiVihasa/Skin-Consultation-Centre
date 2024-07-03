package admin;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

public class Consultation implements Serializable {

    Doctor doctor;
    Patient patient;
    private String date;
    private String time;
    private  String month;


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private Double cost;
    private String notes;
    private String[] consultation;


    public Consultation(Doctor doctor, Patient patient, String date, String time, Double cost, String notes) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
    }

    public Consultation() {

    }

    public String[] getConsultation() {
        return consultation;
    }

    public void setConsultation(String[] consultation) {
        this.consultation = consultation;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Serial
    private void writeObject(ObjectOutputStream os) throws Exception {
        StringBuilder finalC = new StringBuilder();
        os.defaultWriteObject();
        char [] chars = notes.toCharArray();
        for (char c : chars){
            c += 5;
            finalC.append(c);
        }
        System.out.println(finalC);
        os.writeObject(finalC.toString());
    }

    @Serial
    private void readObject(ObjectInputStream is)throws Exception{
        StringBuilder finalC = new StringBuilder();
        is.defaultReadObject();
        String before = (String) is.readObject();
        char [] chars = before.toCharArray();
        for (char c : chars){
            c -= 5;
            finalC.append(c);
        }
        notes = String.valueOf(finalC);
    }

    @Override
    public String toString() {
        return "AddConsultation{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", cost=" + cost +
                ", notes='" + notes + '\'' +
                '}';
    }
}
