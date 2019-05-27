package id.ac.umn.sistemabsensielektronik;

import com.google.firebase.firestore.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class DataKaryawan implements Serializable{
    //Serializable: To maintain the data in order. Must proclaim in order to pass the data to other classes.
    private String firstName;
    private String lastName;
    private String email;
    private String division;
    private String NIK;
    private String key;

    public DataKaryawan(){
        //Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public DataKaryawan(String firstName, String lastName, String email, String division, String NIK) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.division = division;
        this.NIK = NIK;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key){
        this.key = key;
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
