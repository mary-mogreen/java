package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.browser.CustomBrowser;

public class Main extends Application {

    private CustomBrowser customBrowser;
    private Scene mScene;
    private Stage mStage;

    private double dragStartX;
    private double dragStartY;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mStage = primaryStage;
        primaryStage.setTitle("Hello World");

        customBrowser = new CustomBrowser(this);

        changeScene();

    }


    public Stage getStage() {
        return mStage;
    }

    public void changeScene() {
        mScene = new Scene(customBrowser.getGridPane(), 640, 640, Color.TRANSPARENT);
        mScene.getStylesheets().add(getClass().getResource("clock.css").toExternalForm());
        // マウスのドラッグ操作でウィンドウを移動
        mScene.setOnMousePressed(e -> {
            dragStartX = e.getSceneX();
            dragStartY = e.getSceneY();
        });
        mScene.setOnMouseDragged(e -> {
            mStage.setX(e.getScreenX() - dragStartX);
            mStage.setY(e.getScreenY() - dragStartY);
        });
        mStage.setScene(mScene);
        if (mStage.getStyle() != StageStyle.TRANSPARENT)
            mStage.initStyle(StageStyle.TRANSPARENT);
        mStage.getScene().getRoot().setStyle("-fx-background-color: transparent");

        mStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
