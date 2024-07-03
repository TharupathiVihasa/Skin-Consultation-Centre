package admin;

import java.util.ArrayList;

public class Doctor extends Person {
    private String medicalLicenceNumber;
    private String specialisation;

    /**
     *
     * @param firstName of the doctor
     * @param surname of the doctor
     * @param mobileNumber of the doctor
     * @param dob of doctor
     * @param medicalLicenceNumber of doctor
     * @param specialisation of doctor
     */

    public Doctor(String firstName, String surname, String mobileNumber, String dob, String medicalLicenceNumber, String specialisation) {
        super(firstName,surname,mobileNumber,dob);
        this.medicalLicenceNumber= medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    /**
     * This method is used to get the specialisation of the doctor
     * @return specialisation as a String
     */
    public String getSpecialisation() {
        return specialisation;
    }

    /**
     * This method is used to set the specialisation
     * @param specialisation of the doctor passing as a parameter
     */
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    /**
     * This method is used to get the medicalLicenceNumber of the doctor
     * @return medicalLicenceNumber as a String
     */

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    /**
     * This method is used to set the medicalLicenceNumber
     * @param medicalLicenceNumber of the doctor passing as a parameter
     */
    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    /**
     * This method is used to get the details of the Doctor object as a String
     * @return details of the Doctor
     */
    @Override
    public String toString() {
        return "Doctor List  : " + "\n" +
                super.toString() +
                "  Medical Licence Number=" + medicalLicenceNumber + "\n" +
                "  specialisation='" + specialisation + '\'' + " "
                + "\n\n"
                ;
    }

}
