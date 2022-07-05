package hust.soict.hedspi.gui.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class JavaFXCounter extends Application {
	private final TextField tfCount;
	private int count = 0;

//	@Override
	public JavaFXCounter() {
		tfCount = new TextField("0");
		tfCount.setEditable(false);
		Button btnCount = new Button("Count");

		btnCount.setOnAction(evt -> tfCount.setText(++count + ""));

		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(15, 12, 15, 12)); // top, right, bottom, left
		flow.setVgap(10); // Vertical gap between nodes in pixels

		flow.setHgap(10); // Horizontal gap between nodes in pixels
		flow.setAlignment(Pos.CENTER); // Alignment
		flow.getChildren().addAll(new Label("Count: "), tfCount, btnCount);

        Stage primaryStage = null;
		assert false;
		primaryStage.setScene(new Scene(flow, 400, 80));
		primaryStage.setTitle("JavaFX Counter");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) {
		// TODO Auto-generated method stub
	}
}