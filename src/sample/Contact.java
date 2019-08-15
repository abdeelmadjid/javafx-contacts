package sample;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
    private SimpleStringProperty fname=new SimpleStringProperty("");
    private SimpleStringProperty lname=new SimpleStringProperty("");
    private SimpleStringProperty number=new SimpleStringProperty("");
    private SimpleStringProperty note=new SimpleStringProperty("");

    public Contact(){

    }


    public Contact(String fname, String lname, String number, String note) {
        this.fname.set(fname);
        this.lname.set(lname);
        this.number.set(number);
        this.note.set(note);
    }

    public String getFname() {
        return fname.get();
    }



    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getLname() {
        return lname.get();
    }



    public void setLname(String lname) {
        this.lname.set(lname);
    }

    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getNote() {
        return note.get();
    }

    public void setNote(String note) {
        this.note.set(note);
    }
}
