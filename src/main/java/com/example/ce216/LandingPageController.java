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
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.CheckComboBox;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;


public class LandingPageController implements Initializable {

    private final TreeItem treeRoot = new TreeItem();
    private final TreeItem treeRoot2 = new TreeItem();
    Catalog catalog = Catalog.getCatalogInstance();
    Type lastCreated;
    Item lastCreatedItem;
    Type target;
    Attribute targetAtt;
    Item targetItem;
    Attribute targetItemAtt;
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
    private TreeView<Object> treeView2;

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
    @FXML
    private ComboBox typeBox;
    @FXML
    private ComboBox itemBox;
    @FXML
    private ComboBox typeChoice;
    @FXML
    private ComboBox typeChoice2;
    @FXML
    private TextField itemNameInput;
    @FXML
    private TextField attributeNameInput;
    @FXML
    private TextField attributeValueInput;
    @FXML
    private TextField newTypeName;
    @FXML
    private ComboBox typeAttributes;
    @FXML
    private TextField newTypeAttName;
    @FXML
    private TextField newTypeAttValue;
    @FXML
    private TextField newTypeAttribute;
    @FXML
    private ComboBox itemChoice;
    @FXML
    private TextField newItemName;
    @FXML
    private ComboBox itemAttribute;
    @FXML
    private TextField newItemAttName;
    @FXML
    private TextField newItemAttValue;
    @FXML
    private TextField newItemAttName2;
    @FXML
    private TextField newItemAttValue2;
    @FXML
    private TextField tagName;
    @FXML
    private ComboBox tags;
    @FXML
    private TextField searchBar;

    @FXML Region deneme;

    @FXML
    private Button printer;
    @FXML
    private Button export;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        treeMaker();

        tagFilter.setTitle("Tags");

        tagFilter.getItems().addAll(Catalog.tagList);
        tagFilter.getCheckModel().getCheckedItems().addListener(new ListChangeListener<Tag>() {
            @Override
            public void onChanged(Change<? extends Tag> change) {
                filterByTags();
            }
        });

        for (Type type : Catalog.typeList) {
            typeChoice.getItems().add(type);
        }

        for (Tag tag : Catalog.tagList) {
            tags.getItems().add(tag);
        }

        deneme.mouseTransparentProperty().set(true);

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
        treeViewPane.toFront();


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
    @FXML
    private void exportItem() {
        FileChooser fileChooser = new FileChooser();
        File pathFile = fileChooser.showSaveDialog(pane1.getScene().getWindow());
        Item item = (Item) o.getValue();

        try {
            File f;
            if (pathFile != null) {
                f = !pathFile.getAbsolutePath().contains(".") ? new File(pathFile.toPath() + ".html") : pathFile;
                Files.writeString(f.toPath(), item.exportItem(), StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void printPDF() {

        Item printItem = (Item) o.getValue();
        AnchorPane pane  = new AnchorPane();
        WebView webView = new WebView();
        pane.getChildren().add(webView);

        Stage stage = (Stage) pane1.getScene().getWindow();
        printItem.printFile();
        WebEngine webEngine = webView.getEngine();
        File f = new File("src/main/resources/Files/template.html");
        if (f.exists()) {
            try {
                webEngine.load(f.toURI().toURL().toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("There is no printer in your device. Please add a printer to your device.");
            a.show();

        }
        else if(job.showPrintDialog(stage)) {
            boolean success = job.printPage(pane);
            if (success)
                job.endJob();
        }
    }

    public void setLandingPage(ActionEvent actionEvent) {
        Stage stage = (Stage) pane1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LandingPage.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),root.getWidth(), root.getHeight());
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
        typeEdit.setVisible(false);
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(false);
        generalEditPane.setVisible(true);
        generalAddPane.setVisible(true);
        typeAddPane.setVisible(false);
        itemAddPane.setVisible(false);
        addPane.toFront();
        typeChoice.getItems().clear();
        for(Type type : Catalog.typeList){
            typeChoice.getItems().add(type);
        }

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
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), vBox);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        generalAddPane.setVisible(true);
        typeAddPane.setVisible(false);
        itemAddPane.setVisible(false);
        itemNameInput.clear();
        typeChoice.getSelectionModel().clearSelection();
        attributeNameInput.clear();
        attributeValueInput.clear();
        addPane.toBack();
    }

    public void editPane() {
        vBox.setVisible(false);
        generalEditPane.setVisible(true);
        typeEdit.setVisible(false);
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(false);
        editPane.setVisible(true);
        typeAddPane.setVisible(false);
        itemAddPane.setVisible(false);
        generalAddPane.setVisible(true);
        stackPane3.toFront();
        editPane.toFront();
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), editPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        addPane.setVisible(false);
        deletePane.setVisible(false);
        typeChoice2.getItems().clear();

        for (Type type : Catalog.typeList) {
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
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), vBox);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public void deletePane() {
        vBox.setVisible(false);
        deletePane.setVisible(true);
        typeAddPane.setVisible(false);
        itemAddPane.setVisible(false);
        generalAddPane.setVisible(true);
        typeEdit.setVisible(false);
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(false);
        generalEditPane.setVisible(true);
        deletePane.toFront();
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
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.6), vBox);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        deletePane.toBack();
    }

    public void help() {
        addPane.setVisible(false);
        editPane.setVisible(false);
        deletePane.setVisible(false);
        itemEditPane1.setVisible(false);
        itemEditPane2.setVisible(false);
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

        for (Item item : Catalog.itemList) {
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

    public void treeMaker2() {
        TreeItem<Object> treeRoot2 = new TreeItem<>("Types");
        treeView2.setRoot(treeRoot2);
        treeRoot2.setExpanded(true);
        treeView2.setShowRoot(true);

        for (Type type : Catalog.typeList) {
            TreeItem<Object> treeTypeItem2 = new TreeItem<>(type);
            treeRoot2.getChildren().add(treeTypeItem2);
            treeTypeItem2.setExpanded(true);
            for (Item item : type.getItems()) {
                treeTypeItem2.getChildren().add(new TreeItem<>(item));
            }
        }
    }



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
    public void createItemButtonAction(ActionEvent event) throws IOException {
        boolean checker = true;

        if (itemNameInput.getText().isBlank() || typeChoice.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Item name can not be blank and every item must belong to a type.");
            a.show();
        } else {
            if (Catalog.itemList.size() != 0) {
                for (Item type : Catalog.itemList) {
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
            if ((Catalog.itemList.size() == 0 || checker) && !itemNameInput.getText().isBlank()) {
                Item item = new Item(itemNameInput.getText(), (Type) typeChoice.getValue());
                lastCreatedItem = item;
                catalog.createItem(item);
                item.getType().getItems().add(item);

                for (Attribute attribute : item.getType().getDefaultAttributes()) {
                    item.getAttributes().add(attribute);
                }
                itemChoice.getItems().add(item);
                itemNameInput.clear();
                typeChoice.getSelectionModel().clearSelection();
                treeMaker();
            }
        }
    }

    public void addAttributeButtonAction(ActionEvent event) throws IOException {

        if (attributeNameInput.getText().isBlank()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Name can not be blank.");
            a.show();
        } else {
            if (lastCreatedItem != null && !lastCreatedItem.getAttributes().toString().contains(attributeNameInput.getText())) {
                {
                    if (!itemNameInput.getText().isBlank() && typeChoice.getValue() != null) {
                        createItemButtonAction(event);
                        Attribute att = new Attribute(attributeNameInput.getText(), attributeValueInput.getText());
                        lastCreatedItem.addAttribute(att);
                    } else {
                        Attribute att = new Attribute(attributeNameInput.getText(), attributeValueInput.getText());
                        lastCreatedItem.addAttribute(att);
                        attributeNameInput.clear();
                    }
                }
            }
        }
    }

    public void createDefaultAttributeAction(ActionEvent event) {

        if (!typeNameInput.getText().isBlank()) createTypeButtonAction(event);


        if (!Catalog.typeList.isEmpty()) {
            if (lastCreated == null) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("There must be an Item selected priorly (last created Item is selected) in order to create any attributes.");
                a.show();
            } else if (typeDefaultAttributeNameInput.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("The attribute name can not be blank.");
                a.show();
            } else {
                if (lastCreated.getDefaultAttributes().toString().contains(typeDefaultAttributeNameInput.getText())) {
                } else {
                    lastCreated.addAttribute(new Attribute(typeDefaultAttributeNameInput.getText(), typeDefaultAttributeValueInput.getText()));
                    typeDefaultAttributeNameInput.clear();
                    typeDefaultAttributeValueInput.clear();
                }
            }
        }
    }

    TreeItem<Object> o;
    public void onSelect() {
        o = treeView.getSelectionModel().getSelectedItem();
        if (o != null) {
            if (o.getValue().getClass().getName().equals("com.example.ce216.Type")) {
                itemPane.setVisible(false);
                typePane.setVisible(true);
                printer.setVisible(false);
                export.setVisible(false);
                Type t = (Type) o.getValue();
                name.setText(t.getName());
                typeDefaultAttribute.setText(t.getDefaultAttributes().toString());
                typeItems.setText(t.getItems().toString());
            } else if (o.getValue().getClass().getName().equals("com.example.ce216.Item")) {
                typePane.setVisible(false);
                itemPane.setVisible(true);
                printer.setVisible(true);
                export.setVisible(true);
                Item i = (Item) o.getValue();
                typeName.setText(i.getName());
                itemAttributes.setText(i.getAttributes().toString());
                itemTags.setText(i.getTags().toString());
            }
        } else if(Catalog.typeList.size()==0) {
            typePane.setVisible(false);
            itemPane.setVisible(false);
            name.setText("");
        }
    }

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
        target = (Type) typeChoice2.getValue();
        if (target != null) {
            if (newTypeName.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Type name can not be blank.");
                a.show();
            } else {
                typeChoice2.getItems().remove(target);
                target.setName(newTypeName.getText());

                treeMaker();
                typeChoice2.getItems().add(target);

            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select a Type to edit.");
            a.show();
        }
    }


    public void changeTypeAttNameAndValue() {
        target = (Type) typeChoice2.getValue();
        targetAtt = (Attribute) typeAttributes.getValue();
        if (target != null) {
            if (newTypeAttName.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Attribute name can not be blank.");
                a.show();
            } else {
                if (targetAtt != null) {
                    typeAttributes.getItems().remove(targetAtt);
                    targetAtt.setName(newTypeAttName.getText());
                    targetAtt.setValue(newTypeAttValue.getText());
                    treeMaker();
                    typeAttributes.getItems().add(targetAtt);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Select an attribute to edit.");
                    a.show();
                }
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select a Type to edit.");
            a.show();
        }
    }

    public void newTypeAttribute() {
        target = (Type) typeChoice2.getValue();

        if (target != null) {
            if (newTypeAttribute.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Attribute name can not be blank.");
                a.show();
            } else {
                if (target.getDefaultAttributes().toString().contains(newTypeAttribute.getText())) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("An attribute with the same name is already defined.");
                    a.show();
                } else {
                    Attribute att = new Attribute(newTypeAttribute.getText(), "");
                    target.addAttribute(att);
                    typeAttributes.getItems().add(att);

                    for (Item item : target.getItems()) {
                        item.addAttribute(att);
                    }
                }
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select a Type to edit.");
            a.show();
        }
    }

    public void itemToEdit() {
        if (itemChoice.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Choose an item to edit");
            a.show();
        } else {
            targetItem = (Item) itemChoice.getValue();
            itemAttribute.getItems().clear();
            for (Attribute attribute : targetItem.getAttributes()) {
                itemAttribute.getItems().add(attribute);
            }
        }
    }

    public void newItemName() {
        if (targetItem != null) {
            if (!newItemName.getText().isBlank()) {
                itemChoice.getItems().remove(targetItem);
                targetItem.setName(newItemName.getText());
                treeMaker();
                itemChoice.getItems().add(targetItem);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("New name of the item can not be blank");
                a.show();
            }

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an Item to edit.");
            a.show();
        }
    }


    public void changeItemAttNameAndValue() {


        targetItemAtt = (Attribute) itemAttribute.getValue();
        if (targetItemAtt == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an Attribute to edit.");
            a.show();
        } else {
            if (newItemAttName.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("New name of the attribute can not be blank");
                a.show();
            } else {
                targetItemAtt.setName(newItemAttName.getText());
                targetItemAtt.setValue(newItemAttValue.getText());
                treeMaker();
                itemAttribute.getItems().remove(targetItemAtt);
                itemAttribute.getItems().add(targetItemAtt);
            }
        }
    }


    public void newItemAttribute() {

        if (targetItem != null) {
            if (newItemAttName2.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Name of an attribute can not be blank.");
                a.show();
            } else {
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
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an Item to edit.");
            a.show();
        }
    }

    public void addTag() {

        if (targetItem != null) {
            if (tagName.getText().isBlank()) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("A tag name can not be blank.");
                a.show();
            } else {
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
                        tagName.clear();
                    }

                }
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an Item to edit.");
            a.show();

        }
    }

    public void deleteTag() {
        if (targetItem != null) {
            if (tags.getSelectionModel().getSelectedIndex() == -1) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Select a Tag to delete.");
                a.show();
            } else {
                Catalog.tagList.remove(tags.getValue());
                targetItem.removeTag((Tag) tags.getValue());
                tags.getItems().remove(tags.getValue());
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an Item to edit.");
            a.show();

        }
    }

    public void deleteType() {
        if (typeBox.getValue() != null) {
            Catalog.typeList.remove(typeBox.getValue());
            Type type = (Type) typeBox.getValue();
            for (Item i : type.getItems()) {
                Catalog.itemList.remove(i);
                itemBox.getItems().remove(i);
            }

            typeBox.getItems().remove(typeBox.getValue());
            treeMaker();
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select a type to delete.");
            a.show();

        }
    }

    public void deleteItem() {
        if (itemBox.getValue() != null) {
        Item item = (Item) itemBox.getValue();
        Catalog.itemList.remove(itemBox.getValue());
        item.getType().deleteItem(item);

        itemBox.getItems().remove(itemBox.getValue());
        treeMaker();
    }
        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Select an item to delete.");
            a.show();

        }
    }

    public void deleteTypeAttribute() {

        Attribute attribute = (Attribute) typeAttributes.getValue();

        target.removeAttribute(attribute);
        typeAttributes.getItems().remove(attribute);

        for (Item item : target.getItems()) {
            item.removeAttribute(attribute);
        }
    }

    public void deleteItemAttribute() {

        if (targetItem == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Choose an item to edit.");
            a.show();
        } else if (itemAttribute.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Choose an attribute to edit.");
            a.show();
        } else {

            Attribute attribute = (Attribute) itemAttribute.getValue();
            targetItem.removeAttribute(attribute);
            itemAttribute.getItems().remove(attribute);
        }
    }

    public void search(KeyEvent event) {

        if (searchBar.getText().isBlank()) {
            treeView2.setRoot(null);
        } else {
            String search = searchBar.getText();

            searchTreeMaker(search);
        }
    }



    public void searchTreeMaker(String s) {

        s = s.toLowerCase();

        treeView2.setRoot(treeRoot2);
        treeView2.setShowRoot(false);
        treeRoot2.getChildren().clear();
        for (Type type : Catalog.typeList) {
            if (type.getName().toLowerCase().contains(s)) {
                TreeItem treeTypeItem = new TreeItem<>(type);
                treeRoot2.getChildren().add(treeTypeItem);
            }
            for (Item item : type.getItems()) {
                if (item.getName().toLowerCase().contains(s)) {
                    TreeItem treeTypeItem = new TreeItem<>(item);
                    treeRoot2.getChildren().add(treeTypeItem);
                }
            }
            for (Tag tag : Catalog.tagList) {
                if (tag.getName().toLowerCase().contains(s)) {
                    TreeItem treeTypeItem = new TreeItem<>(tag);
                    treeRoot2.getChildren().add(treeTypeItem);
                }
            }
        }
    }


    private void filterByTags() {
        ObservableList<Tag> l = tagFilter.getCheckModel().getCheckedItems();
        if (l.size() != 0) {
            TreeItem<Object> root = new TreeItem<>();
            treeView2.setRoot(root);
            treeView2.setShowRoot(false);

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
                        if (!isFound) root.getChildren().add(newItem);
                    }
                }
            }
        } else treeView2.setRoot(null);

    }
}
