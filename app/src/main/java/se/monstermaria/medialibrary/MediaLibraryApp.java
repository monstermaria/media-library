package se.monstermaria.medialibrary;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.monstermaria.medialibrary.model.LibraryModel;
import se.monstermaria.medialibrary.model.Media;

import java.util.List;

public class MediaLibraryApp extends Application {

    private LibraryModel model;

    @Override
    public void start(Stage stage) {
        model = new LibraryModel();

        stage.setTitle("Media Library");
        stage.setScene(setupScene());
        stage.show();
    }

    public Scene setupScene() {

        // greeting
        Text hello = new Text(10,20,"Hello World!");
        Font font = new Font(20);
        hello.setFont(font);
        hello.setFill(Color.BLACK);

        // control bar
        Text searchLabel = new Text("Search:");
        TextField searchInput = new TextField();
        Text loggedIn = new Text("You are not logged in");
        Button loginButton = new Button("Login");

        HBox searchAndMenu = new HBox(10, searchLabel, searchInput, loggedIn, loginButton);

        // media table
        TableView<Media> mediaTable = new TableView<>();
        setupTable(mediaTable);

        // put it all together
        VBox root = new VBox(10, hello, searchAndMenu, mediaTable);

        Scene scene = new Scene(root, 1100, 500);
        scene.setFill(Color.PINK);

        return scene;
    }

    private void setupTable(TableView<Media> table) {
        List<Media> mediaFromModel = model.getMedia();
        ObservableList<Media> media = FXCollections.observableArrayList(mediaFromModel);

        TableColumn<Media, Integer> idColumn = new TableColumn<>("Media ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Media, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Media, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Media, String> personsColumn = new TableColumn<>("Author/Actors");
        personsColumn.setCellValueFactory(new PropertyValueFactory<>("personList"));

        TableColumn<Media, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Media, String> availableColumn = new TableColumn<>("Available");
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

        table.setItems(media);
        table.getColumns().setAll(idColumn, typeColumn, titleColumn, personsColumn, yearColumn, availableColumn);
    }
}
