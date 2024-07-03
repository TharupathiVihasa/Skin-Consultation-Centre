package admin;

public class Patient extends Person {

   private int patientId;

    /**
     *
     * @param firstName of the patient
     * @param surname of the patient
     * @param dob of consultation
     * @param mobileNumber of the patient
     */



    public Patient(String firstName, String surname, String mobileNumber,String dob) {
        super(firstName, surname,mobileNumber,dob);
        this.patientId = patientId;

    }

    /**
     * This method is used to get the patientId
     * @return patientId as an int
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * This method is used to set the patientId
     * @param patientId of the patient passing as a parameter
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * This method is used to get the details of the patient object as a String
     * @return details of the patient
     */

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                '}';
    }
}
