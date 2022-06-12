package com.example.ce216;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class LandingPageController implements Initializable {

    @FXML
    private VBox root;

    @FXML
    private StackPane stackPane;

    @FXML
    private VBox vBox;

    @FXML
    private Button button;

    @FXML
    private Button button2;

    @FXML
    private Button contact;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button delete;

    @FXML
    private Button search;

    @FXML
    private Region region;

    @FXML
    private Button nextPage;

    @FXML
    private Button nextPage2;

    @FXML
    private Button prevPage;

    @FXML
    private Button prevPage2;


    @FXML
    private ImageView next;

    @FXML
    private ImageView prev;

    @FXML
    private Pane helpPane;

    @FXML
    private Pane helpPane2;


    @FXML
    private HBox hBoxClose;

    @FXML
    private Label mailLabel;

    @FXML
    private Pane generalHelp;

    @FXML
    private Pane addHelp;

    @FXML
    private Pane editHelp;

    @FXML
    private Pane deleteHelp;

    @FXML
    private Pane treeViewPane;

    @FXML
    private VBox vBox2;

    @FXML
    private Pane searchPane;

    @FXML
    private Pane addPane;

    @FXML
    private Pane editPane;

    @FXML
    private Pane deletePane;

    @FXML
    private StackPane stackPane2;

    @FXML
    private Pane generalAddPane;

    @FXML
    private Pane typeAddPane;

    @FXML
    private Pane itemAddPane;

    @FXML
    private Pane generalEditPane;

    @FXML
    private Pane itemEditPane1;

    @FXML
    private Pane itemEditPane2;

    @FXML
    private StackPane stackPane3;

    @FXML
    private Pane typeEdit;

    @FXML
    private TreeView<Object> treeView;

    @FXML
    private TextField typeNameInput;

    @FXML
    private TextField typeDefaultAttributeNameInput;
    @FXML
    private TextField typeDefaultAttributeValueInput;
    @FXML
    private Label name;
    @FXML
    private Label typeName;
    @FXML
    private Label itemTags;
    @FXML
    private Label itemAttributes;
    @FXML
    private Pane typePane;
    @FXML
    private Pane itemPane;
    @FXML
    private Label typeDefaultAttribute;
    @FXML
    private Label typeItems;

    @FXML
    private StackPane stackPaneClose;

    @FXML
    private Button getStarted;

    @FXML
    private CheckComboBox tagFilter;


    Catalog catalog = Catalog.getCatalogInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        treeMaker();


        tagFilter.setTitle("Tags");

        tagFilter.getItems().addAll(catalog.tagList);
        tagFilter.getCheckModel().getCheckedItems().addListener(new ListChangeListener<Tag>() {
            @Override
            public void onChanged(Change<? extends Tag> change) {
                filterByTags();
            }
        });

    }

    @FXML
    public void starter() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), vBox);
        translateTransition.setToX(-root.getPrefWidth() / 2 + vBox.getWidth() / 2);
        translateTransition.play();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), vBox2);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();


        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), pane1);
        fadeTransition2.setFromValue(1);
        fadeTransition2.setToValue(0);
        fadeTransition2.play();

        FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(0.6), pane2);
        fadeTransition3.setFromValue(1);
        fadeTransition3.setToValue(0);
        fadeTransition3.play();

        pane3.setVisible(true);
        FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(0.6), pane3);
        fadeTransition4.setFromValue(0);
        fadeTransition4.setToValue(1);
        fadeTransition4.play();


        button.setVisible(false);
        button2.setVisible(false);

        add.setVisible(true);
        edit.setVisible(true);
        delete.setVisible(true);
        search.setVisible(true);

        treeViewPane.setVisible(true);
        FadeTransition fadeTransition6 = new FadeTransition(Duration.seconds(1.5), treeViewPane);
        fadeTransition6.setFromValue(0);
        fadeTransition6.setToValue(1);
        fadeTransition6.play();


    }


    @FXML
    public void nextPage() {
        if (pane1.isVisible()) {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), pane1);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();
            pane1.setVisible(false);

            pane2.setVisible(true);
            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), pane2);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(1);
            fadeTransition2.play();

            button.setStyle("-fx-background-radius: 100; -fx-background-color: white; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
            button2.setStyle("-fx-background-radius: 100; -fx-background-color: black; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");

            pane2.toFront();
        }
    }

    @FXML
    public void previousPage() {
        if (pane2.isVisible()) {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), pane2);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.play();
            pane2.setVisible(false);


            pane1.setVisible(true);
            FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.6), pane1);
            fadeTransition2.setFromValue(0);
            fadeTransition2.setToValue(1);
            fadeTransition2.play();

            pane1.toFront();

            button.setStyle("-fx-background-radius: 100; -fx-background-color: black; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
            button2.setStyle("-fx-background-radius: 100; -fx-background-color: white; -fx-border-color: black;-fx-border-radius:100; -fx-border-width:3");
        }
    }

    public void setLandingPage(ActionEvent actionEvent) {
        Stage stage = (Stage) pane1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LandingPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }

    public void onHoverColor() {
        nextPage.setVisible(false);
        nextPage2.setVisible(true);
    }

    public void onHoverColorExit() {
        nextPage.setVisible(true);
        nextPage2.setVisible(false);
    }


    public void onHoverColor2() {
        prevPage.setVisible(false);
        prevPage2.setVisible(true);
    }

    public void onHoverColorExit2() {
        prevPage.setVisible(true);
        prevPage2.setVisible(false);
    }


    public void contact() {
        contact.setVisible(false);
        mailLabel.setVisible(true);
    }

    public void contact2() {
        contact.setVisible(true);
        mailLabel.setVisible(false);
    }

    public void closeAllHelp() {
        generalHelp.setVisible(false);
        addHelp.setVisible(false);
        editHelp.setVisible(false);
        deleteHelp.setVisible(false);
        stackPane3.toBack();
        editPane.toBack();
        helpPane.toBack();
    }

    public void closeHelp() {
        vBox.setVisible(true);
        stackPane3.toBack();
        editPane.toBack();
        hBoxClose.setOpacity(1);
        hBoxClose.setOpacity(1);

        getStarted.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                starter();
            }
        });


        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), helpPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
    }

    public void generalHelp() {
        closeAllHelp();
        helpPane.toFront();
        generalHelp.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), generalHelp);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void addHelp() {
        closeAllHelp();
        helpPane.toFront();
        addHelp.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), addHelp);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void editHelp() {
        closeAllHelp();
        helpPane.toFront();
        editHelp.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), editHelp);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void deleteHelp() {
        closeAllHelp();
        helpPane.toFront();
        deleteHelp.setVisible(true);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), deleteHelp);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void searchPane() {
        searchPane.setVisible(true);
        searchPane.toFront();
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), searchPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }


    public void addPane() {
        vBox.setVisible(false);
        addPane.setVisible(true);
        editPane.setVisible(false);
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(false);
        addPane.toFront();
        stackPaneClose.setOpacity(0.35);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), addPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        editPane.setVisible(false);
        deletePane.setVisible(false);
    }

    public void closeAddPane() {
        vBox.setVisible(true);
        addPane.setVisible(false);
        stackPaneClose.setOpacity(1);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), vBox);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        generalAddPane.setVisible(true);
        typeAddPane.setVisible(false);
        itemAddPane.setVisible(false);
    }


    public void editPane() {
        vBox.setVisible(false);
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(false);
        editPane.setVisible(true);
        stackPane3.toFront();
        editPane.toFront();
        stackPaneClose.setOpacity(0.35);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), editPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        addPane.setVisible(false);
        deletePane.setVisible(false);
        typeChoice2.getItems().clear();

        for(Type type: Catalog.typeList){
            typeChoice2.getItems().add(type);
        }


    }

    public void closeEditPane() {
        vBox.setVisible(true);
        generalEditPane.setVisible(true);
        typeEdit.setVisible(false);
        editPane.setVisible(false);
        stackPane3.toBack();
        editPane.toBack();
        stackPaneClose.setOpacity(1);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), vBox);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    @FXML private ComboBox typeBox;
    @FXML private ComboBox itemBox;
    public void deletePane() {
        vBox.setVisible(false);
        deletePane.setVisible(true);
        deletePane.toFront();
        stackPaneClose.setOpacity(0.35);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), deletePane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        addPane.setVisible(false);
        editPane.setVisible(false);
        typeBox.getItems().clear();
        itemBox.getItems().clear();
        typeBox.getItems().addAll(Catalog.typeList);
        itemBox.getItems().addAll(Catalog.itemList);
    }

    public void closeDeletePane() {
        vBox.setVisible(true);
        deletePane.setVisible(false);
        stackPaneClose.setOpacity(1);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), vBox);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void help() {
        addPane.setVisible(false);
        editPane.setVisible(false);
        deletePane.setVisible(false);
        helpPane.setVisible(true);
        helpPane.toFront();


        getStarted.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
            }
        });


        hBoxClose.setOpacity(0.35);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), helpPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

    }

    public void typeAdd() {
        generalAddPane.setVisible(false);
        typeAddPane.setVisible(true);
    }

    public void itemAdd() {
        generalAddPane.setVisible(false);
        itemAddPane.setVisible(true);
    }

    public void itemEditClose() {
        stackPane3.toBack();
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(false);
        generalEditPane.setVisible(true);
        vBox.setVisible(true);
        generalEditPane.setVisible(true);
        typeEdit.setVisible(false);
        editPane.setVisible(false);
        hBoxClose.setOpacity(1);
        stackPaneClose.setOpacity(1);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), vBox);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void typeEdit() {
        generalEditPane.setVisible(false);
        typeEdit.setVisible(true);
    }

    public void itemEdit() {
        editPane.setVisible(false);
        itemEditPane1.setVisible(true);
        itemChoice.getItems().clear();

        for(Item item : Catalog.itemList){
            itemChoice.getItems().add(item);
        }

    }

    public void itemEditNextPage() {
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(true);
    }

    public void itemEditPrevPage() {
        itemEditPane2.setVisible(false);
        itemEditPane1.setVisible(true);
    }

    public void treeMaker() {
        TreeItem<Object> treeRoot = new TreeItem<>("Types");
        treeView.setRoot(treeRoot);
        treeRoot.setExpanded(true);
        treeView.setShowRoot(true);

        for (Type type : Catalog.typeList) {
            TreeItem<Object> treeTypeItem = new TreeItem<>(type);
            treeRoot.getChildren().add(treeTypeItem);
            treeTypeItem.setExpanded(true);
            for (Item item : type.getItems()) {
                treeTypeItem.getChildren().add(new TreeItem<>(item));
            }
        }
    }


    @FXML
    private ComboBox typeChoice;
    @FXML
    private ComboBox typeChoice2;

    Type lastCreated;

    public void createTypeButtonAction(ActionEvent event) {
        boolean checker = true;

        if (Catalog.typeList.size() != 0) {
            for (Type type : Catalog.typeList) {
                if (typeNameInput.getText().equalsIgnoreCase(type.getName())) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("A type with the same name is already defined.");
                    a.show();
                    checker = false;
                    break;
                }
            }
        }
        if ((Catalog.typeList.size() == 0 || checker) && !typeNameInput.getText().isBlank()) {
            Type t = new Type(typeNameInput.getText());
            lastCreated = t;
            catalog.createType(t);
            typeNameInput.clear();

            typeChoice.getItems().add(t);
            typeChoice2.getItems().add(t);
            treeMaker();
        }
    }

    @FXML
    private TextField itemNameInput;


    Item lastCreatedItem;

    @FXML
    public void createItemButtonAction(ActionEvent event) throws IOException {
        boolean checker = true;

        if (catalog.itemList.size() != 0) {
            for (Item type : catalog.itemList) {
                if (itemNameInput.getText().equals(type.getName())) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("An item with the same name is already defined.");
                    a.show();
                    checker = false;
                    break;
                }
            }
            treeMaker();
        }
        if ((catalog.itemList.size() == 0 || checker) && !itemNameInput.getText().isBlank()) {
            Item item = new Item(itemNameInput.getText(), (Type) typeChoice.getValue());
            lastCreatedItem = item;
            catalog.createItem(item);
            TreeItem<Object> treeItem = new TreeItem<>(item.toString());
            item.getType().getItems().add(item);

            for (Attribute attribute : item.getType().getDefaultAttributes()) {
                item.getAttributes().add(attribute);
            }
            itemChoice.getItems().add(item);
            treeMaker();
        }
    }

    @FXML
    private TextField attributeNameInput;
    @FXML
    private TextField attributeValueInput;

    public void addAttributeButtonAction(ActionEvent event) {

        if (lastCreatedItem.getAttributes().toString().contains(attributeNameInput.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("An attribute with the same name is already defined.");
            a.show();
        }
        else{
            Attribute att = new Attribute(attributeNameInput.getText(), attributeValueInput.getText());
            lastCreatedItem.addAttribute(att);
            attributeNameInput.clear();
        }
    }


    public void createDefaultAttributeAction(ActionEvent event) {
        if (!Catalog.typeList.isEmpty()) {
            lastCreated.addDefaultAttributes(
                    new Attribute(typeDefaultAttributeNameInput.getText(), typeDefaultAttributeValueInput.getText()));
            typeDefaultAttributeNameInput.clear();
            typeDefaultAttributeValueInput.clear();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("There must be an Item selected priorly (last created Item is selected) in order to create any attributes.");
            a.show();
        }
    }

    public void onSelect() {
        TreeItem<Object> o = treeView.getSelectionModel().getSelectedItem();
        if (o != null) {
            if (o.getValue().getClass().getName().equals("com.example.ce216.Type")) {
                itemPane.setVisible(false);
                typePane.setVisible(true);
                Type t = (Type) o.getValue();
                name.setText(t.getName());
                typeDefaultAttribute.setText(t.getDefaultAttributes().toString());
                typeItems.setText(t.getItems().toString());
            } else if (o.getValue().getClass().getName().equals("com.example.ce216.Item")) {
                typePane.setVisible(false);
                itemPane.setVisible(true);
                Item i = (Item) o.getValue();
                typeName.setText(i.getName());
                itemAttributes.setText(i.getAttributes().toString());
                itemTags.setText(i.getTags().toString());
            }
        }
    }

    Type target;

    @FXML
    private TextField newTypeName;
    @FXML
    private ComboBox typeAttributes;

    public void typeToEdit() {
        target = (Type) typeChoice2.getValue();
        typeAttributes.getItems().clear();
        if (target != null) {
            for (Attribute attribute : target.getDefaultAttributes()) {
                typeAttributes.getItems().addAll(attribute);
            }
        }
    }

    public void newTypeName() {
        typeChoice2.getItems().remove(target);
        target.setName(newTypeName.getText());

        treeMaker();
        typeChoice2.getItems().add(target);

    }

    Attribute targetAtt;
    @FXML
    private TextField newTypeAttName;
    @FXML
    private TextField newTypeAttValue;

    public void changeTypeAttNameAndValue() {
        targetAtt = (Attribute) typeAttributes.getValue();

        typeAttributes.getItems().remove(targetAtt);
        if (!newTypeAttName.getText().isBlank())
            targetAtt.setName(newTypeAttName.getText());

        targetAtt.setValue(newTypeAttValue.getText());
        treeMaker();
        typeAttributes.getItems().add(targetAtt);
    }

    @FXML
    private TextField newTypeAttribute;

    public void newTypeAttribute() {

        if (target.getDefaultAttributes().toString().contains(newTypeAttribute.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("An attribute with the same name is already defined.");
            a.show();
        } else {
            Attribute att = new Attribute(newTypeAttribute.getText(), "");
            target.addDefaultAttributes(att);
            typeAttributes.getItems().add(att);

            for(Item item : target.getItems()){
                item.addAttribute(att);
            }
        }

    }

    Item targetItem;
    @FXML
    private ComboBox itemChoice;

    public void itemToEdit() {
        targetItem = (Item) itemChoice.getValue();
        itemAttribute.getItems().clear();
        for(Attribute attribute : targetItem.getAttributes()) {
            itemAttribute.getItems().add(attribute);
        }
    }

    @FXML
    private TextField newItemName;

    public void newItemName() {
        if (targetItem != null) {
            itemChoice.getItems().remove(targetItem);
            targetItem.setName(newItemName.getText());
            treeMaker();
            itemChoice.getItems().add(targetItem);

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an Item to edit.");
            a.show();
        }
    }

    @FXML private ComboBox itemAttribute;
    @FXML private TextField newItemAttName;
    @FXML private TextField newItemAttValue;
    Attribute targetItemAtt;

    public void attributeToEdit(){

    }
    public void itemDefaultAttributeEdit(){
        targetItemAtt.setName(newItemAttName.getText());
    }

    public void changeItemAttNameAndValue() {
        targetItemAtt =(Attribute) itemAttribute.getValue();

        itemAttribute.getItems().remove(targetItemAtt);
        if (!newItemAttName.getText().isBlank())
            targetItemAtt.setName(newItemAttName.getText());

        if (targetItemAtt != null) {
            targetItemAtt.setValue(newItemAttValue.getText());
            treeMaker();
            itemAttribute.getItems().add(targetItemAtt);
        }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an Attribute to edit.");
            a.show();
        }
    }


    @FXML
    private TextField newItemAttName2;

    @FXML
    private TextField newItemAttValue2;
    public void newItemAttribute() {

        if (targetItem.getAttributes().toString().contains(newItemAttName2.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("An attribute with the same name is already defined.");
            a.show();
        } else {
            Attribute att = new Attribute(newItemAttName2.getText(), newItemAttValue2.getText());
            targetItem.addAttribute(att);
            itemAttribute.getItems().add(att);
        }
    }

@FXML private TextField tagName;
    @FXML private ComboBox tags;

    public void addTag(){

        if (targetItem.getTags().toString().contains(tagName.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("A tag with the same name is already defined.");
            a.show();
        } else {
            boolean checker = true;
            for (Tag tag : Catalog.tagList) {
                if (tagName.getText().equals(tag.getName())) {
                    checker = false;
                    targetItem.addTag(tag);
                    tag.addAttachedItems(targetItem);
                    break;
                }
            }
            if (checker == true) {
                Tag tag = new Tag(tagName.getText());
                targetItem.addTag(tag);
                tags.getItems().add(tag);
                Catalog.tagList.add(tag);
                tag.addAttachedItems(targetItem);
                tagFilter.getItems().add(tag);
            }

        }
    }

    public void deleteTag(){
            targetItem.removeTag((Tag)tags.getValue());
            tags.getItems().remove(tags.getValue());
    }

    public void deleteType(){
        Catalog.typeList.remove(typeBox.getValue());
        Type type = (Type) typeBox.getValue();
        for( Item i: type.getItems()){
            Catalog.itemList.remove(i);
        }

        typeBox.getItems().remove(typeBox.getValue());
        treeMaker();
    }

    public void deleteItem(){
        Item item = (Item) itemBox.getValue();
        Catalog.itemList.remove(itemBox.getValue());
        item.getType().deleteItem(item);

        itemBox.getItems().remove(itemBox.getValue());
        treeMaker();
    }

    public void deleteTypeAttribute(){

        Attribute attribute = (Attribute) typeAttributes.getValue();

        target.removeAttribute(attribute);
        typeAttributes.getItems().remove(attribute);
    }

    public void deleteItemAttribute(){
        Attribute attribute = (Attribute) itemAttribute.getValue();
        targetItem.removeAttribute(attribute);
        itemAttribute.getItems().remove(attribute);
    }

    @FXML private TextField searchBar;
    public void search(KeyEvent event) {

        if (searchBar.getText().isBlank()) {
            treeMaker();
        } else {
            String search = searchBar.getText();

            searchTreeMaker(search);
        }
    }

    private TreeItem treeRoot = new TreeItem();

    public void searchTreeMaker(String s) {

        treeView.setRoot(treeRoot);
        treeView.setShowRoot(false);
        treeRoot.getChildren().clear();
        for (Type type : catalog.typeList) {
            if (type.getName().contains(s)) {
                TreeItem treeTypeItem = new TreeItem<>(type);
                treeRoot.getChildren().add(treeTypeItem);
            }
            for (Item item : type.getItems()) {
                if (item.getName().contains(s)) {
                    TreeItem treeTypeItem = new TreeItem<>(item);
                    treeRoot.getChildren().add(treeTypeItem);
                }
            }
            for (Tag tag : catalog.tagList) {
                if (tag.getName().contains(s)) {
                    TreeItem treeTypeItem = new TreeItem<>(tag);
                    treeRoot.getChildren().add(treeTypeItem);
                }
            }
        }
    }


    private void filterByTags() {
        ObservableList<Tag> l = tagFilter.getCheckModel().getCheckedItems();
        if (l.size() != 0) {
            TreeItem<Object> root = new TreeItem<>();
            treeView.setRoot(root);
            treeView.setShowRoot(false);

            for (Tag tag : l) {
                for (Item item : tag.getAttachedItems()) {
                    boolean isFound = false;
                    if (item.getTags().containsAll(l)) {
                        TreeItem<Object> newItem = new TreeItem<>(item);

                        for (TreeItem t : root.getChildren()) {
                            Item i = (Item) t.getValue();
                            if (item.getName().equals(i.getName())) {
                                isFound = true;
                                break;
                            }
                        }
                        if (!isFound)
                            root.getChildren().add(newItem);
                    }
                }
            }
        } else
            treeMaker();

    }


}
