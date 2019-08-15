package sample.addContact;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import sample.Contact;

public class AddContact {
    @FXML
    private TextField fnameF;

    @FXML
    private TextField lnameF;

    @FXML
    private TextField numberF;

    @FXML
    private TextField noteF;

    public void updateContact(ObservableList<Contact> contacts,Contact contact){
        contacts.get(contacts.indexOf(contact)).setFname(fnameF.getText());
        contacts.get(contacts.indexOf(contact)).setLname(lnameF.getText());
        contacts.get(contacts.indexOf(contact)).setNumber(numberF.getText());
        contacts.get(contacts.indexOf(contact)).setNote(noteF.getText());



    }


    public void showEditContact(Contact contact){
        setFnameF(contact.getFname());
        setLnameF(contact.getLname());
        setNumberF(contact.getNumber());
        setNoteF(contact.getNote());



    }

    private void setFnameF(String fnameF) {
        this.fnameF.setText(fnameF);
    }

    private void setLnameF(String lnameF) {
        this.lnameF.setText(lnameF);
    }

    private void setNumberF(String numberF) {
        this.numberF.setText(numberF);
    }

    private void setNoteF(String noteF) {
        this.noteF.setText(noteF);
    }

    public Contact getContact(){
        Contact contact=new Contact();
        contact.setFname(fnameF.getText());
        contact.setLname(lnameF.getText());
        contact.setNumber(numberF.getText());
        contact.setNote(noteF.getText());
        return contact;
    }


}
