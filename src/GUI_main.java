
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI_main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		Image image = new Image("C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\001.jpg", 100, 100, false, true, true);
		ImageView imageView = new ImageView(image);
		borderPane.getChildren().add(imageView);
		borderPane.setBackground(new Background(new BackgroundImage(image, 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null)));
		
		Label lbl1 = new Label("Willkommen bei Ski- und Snowboardverleih AlpineStar!");
		lbl1.setFont(Font.font ("Verdana", 20));
		
		Label lbl2 = new Label("\nBitte geben Sie die gewünschte Ausleihdauer an:");
		
		
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(tf1, tf2);
		
		Button bt1 = new Button("SKI");
		bt1.setPrefSize(120, 60);
		bt1.setTextFill(Color.RED);
		Button bt2 = new Button("SNOWBOARD");
		bt2.setPrefSize(120, 60);
		bt2.setTextFill(Color.RED);
		
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		
		vb1.getChildren().addAll(lbl2, hb1);
		vb2.getChildren().addAll(bt1, bt2);
		
		borderPane.setPrefSize(800, 600);
		borderPane.setTop(lbl1);
		borderPane.setLeft(vb1);
		borderPane.setBottom(vb2);
		
		primaryStage.setScene(new Scene(borderPane));
		primaryStage.setTitle("SKIVERLEIH");
		primaryStage.setResizable(true);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
