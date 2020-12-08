package se.monstermaria.medialibrary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import se.monstermaria.medialibrary.model.LibraryModel;
import se.monstermaria.medialibrary.model.Media;

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

        Scene scene = new Scene(root, 500, 100);
        scene.setFill(Color.PINK);

        return scene;
    }

    private void setupTable(TableView<Media> table) {

    }
}
