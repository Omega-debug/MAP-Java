package com.example.radio;

import Domain.Piesa;
import Repository.RadioDBRepository;
import Repository.TwiceException;
import Service.PiesaService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class HelloApplication extends Application {

    TextField FormatieTextField = new TextField();
    TextField TitluTextField = new TextField();

    TextField GenMuzicalTextField = new TextField();

    TextField DurataTextField = new TextField();

    List<Piesa> LFiltrata;

    TextField FiltrareTextField = new TextField();
    @Override
    public void start(Stage stage) throws IOException {
        VBox mainVerticalBox = new VBox();
        mainVerticalBox.setPadding(new Insets(10));
        RadioDBRepository repo = new RadioDBRepository();
        PiesaService piesaService = new PiesaService(repo);
        Collection<Piesa> sir = piesaService.getAll();
        List<Piesa> listuta = new ArrayList<>(sir);
        Collections.sort(listuta, new Comparator<Piesa>() {
            @Override
            public int compare(Piesa o1, Piesa o2) {
                int results;
                String formatie1 = o1.getFormatie();
                String titlu1 = o1.getTitlu();

                String formatie2 = o2.getFormatie();
                String titlu2 = o2.getTitlu();

                results = formatie1.compareTo(formatie2);
                if(results == 0){
                    results = titlu1.compareTo(titlu2);
                }
                return results;
            }
        });

        ObservableList<Piesa> piese = FXCollections.observableArrayList(listuta);

        ListView<Piesa> listView = new ListView<Piesa>(piese);
        mainVerticalBox.getChildren().add(listView);
        Scene scene = new Scene(mainVerticalBox, 320, 240);

        GridPane gridPane = new GridPane();

        Label FormatieLabel = new Label();
        FormatieLabel.setText("Formatie: ");
        FormatieLabel.setPadding(new Insets(10,0,10,0));

        Label TitluLabel = new Label();
        TitluLabel.setText("Titlu: ");
        TitluLabel.setPadding(new Insets(10,0,10,0));


        Label GenMuzicalLabel = new Label();
        GenMuzicalLabel.setText("Gen Muzical: ");
        GenMuzicalLabel.setPadding(new Insets(10,0,10,0));

        Label DurataLabel = new Label();
        DurataLabel.setText("Gen Muzical: ");
        DurataLabel.setPadding(new Insets(10,0,10,0));





        gridPane.add(FormatieLabel,0,1);
        gridPane.add(FormatieTextField,1,1);

        gridPane.add(TitluLabel,0,2);
        gridPane.add(TitluTextField,1,2);

        gridPane.add(GenMuzicalLabel,0,3);
        gridPane.add(GenMuzicalTextField,1,3);

        gridPane.add(DurataLabel,0,4);
        gridPane.add(DurataTextField,1,4);




        HBox buttonsHorizontalBox = new HBox();




        Button filterButton = new Button("Filtrare");
        Label FLabel = new Label();
        FLabel.setText("Filtrare");
        FLabel.setPadding(new Insets(10,0,10,0));
        gridPane.add(FLabel,0,0);
        gridPane.add(FiltrareTextField,1,0);

        mainVerticalBox.getChildren().add(gridPane);
        buttonsHorizontalBox.getChildren().add(filterButton);
        mainVerticalBox.getChildren().add(buttonsHorizontalBox);


        filterButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try {
                    String argument = FiltrareTextField.getText();
                    LFiltrata= new ArrayList<>(piesaService.filter(argument));
                } catch (RuntimeException e) {
                    Alert errorPopUp = new Alert(Alert.AlertType.ERROR);
                    errorPopUp.setTitle("Lista e goala");
                    errorPopUp.setContentText(e.getMessage());
                    errorPopUp.show();
                }
                ObservableList<Piesa> ListaFiltrata = FXCollections.observableArrayList(LFiltrata);
                piese.setAll(ListaFiltrata);
            }
        });

        Button ResetButton = new Button("Resetare");
        buttonsHorizontalBox.getChildren().add(ResetButton);
        ResetButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                piese.setAll(piesaService.getAll());
            }
        });


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}