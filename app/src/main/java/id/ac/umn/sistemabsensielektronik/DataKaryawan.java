package id.ac.umn.sistemabsensielektronik;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
public class DataKaryawan {

    public String firstName;
    public String lastName;
    public String email;
    public String division;
    public String NIK;

    public DataKaryawan(){
    }

    public DataKaryawan(String firstName, String lastName, String email, String division, String NIK) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setDivision(division);
        this.setNIK(NIK);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }
}
