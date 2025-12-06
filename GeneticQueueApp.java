import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.Alert.*;
import java.util.*;
import javafx.collections.*;
import javafx.scene.control.TableColumn.*;
import javafx.application.*;
public class GeneticQueueApp extends Application
{
    private final GeneticQueue queue = new GeneticQueue();
    public void start(Stage mainStage)
    {
        // Set up main scene
        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root, 500, 500);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Genetic Queue Decoder");
        // VBox to organize elements
        VBox mainLayout = new VBox();
        mainLayout.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setSpacing(30);
        root.setCenter(mainLayout);
        
        // Title Label
        Label titleLabel = new Label("Genetic Queue Decoder");
       titleLabel.setStyle("-fx-font-size: 30; -fx-font-weight: bold;");
        titleLabel.setTextFill(Color.DARKBLUE);
        // Label to hold formatted genetic queue
        Label geneLabel = new Label(queue.toString());
        geneLabel.setStyle("-fx-font-size: 25; -fx-font-weight: bold;");
        geneLabel.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        geneLabel.setTextFill(Color.WHITE);
        mainLayout.getChildren().addAll(titleLabel, geneLabel);
        
        // Button row
        HBox buttonRow = new HBox();
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setSpacing(15);
        buttonRow.setStyle("-fx-font-size: 15");
        mainLayout.getChildren().add(buttonRow);
        
        // Buttons to add/remove bases
        Button addBaseButton = new Button("Add Chemical Base");
        addBaseButton.setOnAction((event)->
        {
            queue.add_input();
            geneLabel.setText(queue.toString());
        });
        Button removeBaseButton = new Button("Remove Chemical Base");
        removeBaseButton.setOnAction((event)->
        {
            queue.poll();
            geneLabel.setText(queue.toString());
        });
        buttonRow.getChildren().addAll(addBaseButton, removeBaseButton);
        
        // Top menu
        MenuBar topMenu = new MenuBar();
        topMenu.setStyle("-fx-font-size: 15;");
        root.setTop(topMenu);
        
        // File menu
        Menu fileMenu = new Menu("File");
        topMenu.getMenus().add(fileMenu);
        
        // Menu Item - mutate
        MenuItem mutateItem = new MenuItem("Mutate Gene");
        mutateItem.setOnAction((event)->
        {
            queue.mutate();
            geneLabel.setText(queue.toString());
        });
        
        // Menu Item - clear
        MenuItem clearItem = new MenuItem("Reset Gene");
        clearItem.setOnAction((event)->
        {
            queue.clear();
            geneLabel.setText(queue.toString());
        });
        
        // Menu item - Quit
        MenuItem quitItem = new MenuItem("Quit");
        quitItem.setOnAction((e->
        {
            mainStage.close();
            System.exit(0);
        }));
        fileMenu.getItems().addAll(mutateItem, clearItem, quitItem);
        
        mainStage.show();
    }
}
