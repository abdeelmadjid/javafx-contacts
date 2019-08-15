package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.addContact.AddContact;
import sun.plugin2.jvm.RemoteJVMLauncher;

import java.util.Arrays;
import java.util.Optional;

public class Controller {
    @FXML
    private BorderPane mainUi;
    @FXML
    private TableView<Contact> mtable;
    @FXML
    public MenuItem deleteM;
    @FXML
    public MenuItem editM;
    @FXML
    public MenuItem addM;
    private ContactData data;

    @FXML
    public void initialize(){
        data=new ContactData();
        mtable.setItems(data.getContacts());
        mtable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        //this is a nother way to add on action
        deleteM.setOnAction((event) -> {

            Contact contact=mtable.getSelectionModel().getSelectedItem();
            if (contact!=null){
                Alert confirm=new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setHeaderText("are you sure u want to delete this contact");
                confirm.setTitle("delete "+contact.getFname());
                Optional<ButtonType> res=confirm.showAndWait();
                if (res.isPresent()&& res.get()==ButtonType.OK){
                    data.deleteContact(contact);
                    data.saveContacts();
                }

            }


        });
        editM.setOnAction(event -> {
            try {
                addMenu(event);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

    }

    public void addMenu(ActionEvent event) throws Exception{

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainUi.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("addContact/addContactUi.fxml"));

        dialog.getDialogPane().setContent(fxmlLoader.load());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        if (event.getSource()==addM){
            dialog.setTitle("add Contact");
            AddContact controller = fxmlLoader.getController();
            Optional<ButtonType> resault = dialog.showAndWait();

            if (resault.isPresent() && resault.get()==ButtonType.OK){
                data.addContact(controller.getContact());
                data.saveContacts();
            }
        }else if (event.getSource()==editM){
            dialog.setTitle("edit "+mtable.getSelectionModel().getSelectedItem().getFname());
            AddContact controller = fxmlLoader.getController();
            controller.showEditContact(mtable.getSelectionModel().getSelectedItem());
            Optional<ButtonType> resault = dialog.showAndWait();

            if (resault.isPresent()&&resault.get()==ButtonType.OK){
                controller.updateContact(data.getContacts(),mtable.getSelectionModel().getSelectedItem());
                mtable.refresh();
                data.saveContacts();
            }

        }



    }

}
