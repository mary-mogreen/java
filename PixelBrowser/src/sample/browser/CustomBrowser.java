package sample.browser;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import sample.Main;
import sample.clock.Clock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mary-mogreen.
 */
public class CustomBrowser {
    // application(Main)
    private Main app;

    // CustomBrowser の Parent.
    private GridPane gridPane;

    // CustomBrowser が保持する Browser の List
    private List<Browser> browsers;

    // CustomBrowser のいずれかがスクロールされたときの EventHandler
    private EventHandler<ScrollEvent> scrollEventHandler;

    // 各ブラウザが表示する Wrapper HTML の location
    // private String location = getClass().getResource("sample.html").toExternalForm();

    // CustomBrowser の コンテキストメニュー
    private ContextMenu contextMenu;
    // csv の FileChooser
    FileChooser fileChooser = new FileChooser();


    // CustomBrowser のテスト値
    private int[][] shape;

    private final int width = 640;
    private final int height = 640;
    private int col;// = sample.shape.length;
    private int row; //= sample.shape[0].length;

    public CustomBrowser(Main app) {
        //
        this.app = app;

        // browsers の初期化
        browsers = new ArrayList<>();

        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV", "*.csv"),
                new FileChooser.ExtensionFilter("All", "*.*")
        );
        File file = fileChooser.showOpenDialog(app.getStage());
        if (file != null) {
            createGridPane(file.getAbsolutePath());
            createContextMenu();
        }
        // createGridPane(getClass().getResource("square.csv").getFile());
        // createContextMenu();
    }

    public GridPane getGridPane() {
        return gridPane;
    }
    public void createGridPane(String csv) {
        // sample.shape の生成
        shape = getShape(csv);
        if (shape == null)
            return;

        // gridPane の生成
        gridPane = new GridPane();
        gridPane.setPrefWidth((double) width);
        gridPane.setPrefHeight((double) height);

        col = shape.length;
        row = shape[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (shape[r][c] == 1) {
                    createBrowser(c, r);
                } else if (shape[r][c] == 2) {
                     Clock clock = new Clock(width / col / 2);
//                    Circle clock = new Circle();
//                    clock.setRadius(width / col / 2);
//                    clock.setFill(Color.RED);
                    gridPane.add(clock, c, r);
                }
            }
        }
    }

    private void createBrowser(int col, int row) {
        WebView webView = newWebView();
        gridPane.add(webView, col, row);
        Browser browser = new Browser(webView, col, row);
        scrollEventHandler = new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                System.out.println("scrolled. (" + browser.getHScrollValue() + ", " + browser.getVScrollValue() +")");
                int posX = browser.getPosX();
                int posY = browser.getPosY();
                posX = 0;
                // posX -= (int)event.getDeltaX();
                // posY -= (int)event.getDeltaY();
                for (Browser b: browsers) {
                    b.scrollTo(posX, posY);
                }
            }
        };
        browser.setOnScrollFinished(scrollEventHandler);
        // browser.load(location);
        browsers.add(browser);
    }

    private WebView newWebView() {
        WebView webView = new WebView();
        webView.setPrefWidth(width / col);
        webView.setPrefHeight(height / row);
        return webView;
    }

    private Circle newCircle() {
        Circle circle = new Circle();
        circle.setFill(Color.YELLOW);
        circle.setRadius(width / col / 2);
        return circle;
    }

    private void createContextMenu() {

        contextMenu = new ContextMenu();

        MenuItem back = new MenuItem("戻る");
        back.setOnAction(event -> {
            for (Browser browser: browsers) {
                browser.back();
            }
        });

        MenuItem forward = new MenuItem("進む");
        forward.setOnAction(event -> {
            for (Browser browser: browsers) {
                browser.forward();
            }
        });


//        MenuItem square = new MenuItem("四角形");
//        square.setOnAction(event -> {
//            createGridPane(getClass().getResource("square.csv").getFile());
//            createContextMenu();
//            app.changeScene();
//        });
//
//        MenuItem pikachu = new MenuItem("ピカチュウ");
//        pikachu.setOnAction(event -> {
//            createGridPane(getClass().getResource("pikachu.csv").toString());
//            createContextMenu();
//            app.changeScene();
//        });

        // MenuItem Exit
        MenuItem exit = new MenuItem("終了");
        exit.setOnAction(event -> {
            System.exit(0);
        });

        // MenuItem Exit
        MenuItem open = new MenuItem("csvを開く");
        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                fileChooser.setTitle("Open CSV File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("CSV", "*.csv"),
                        new FileChooser.ExtensionFilter("All", "*.*")
                );
                File file = fileChooser.showOpenDialog(app.getStage());
                if (file != null) {
                    createGridPane(file.getAbsolutePath());
                    createContextMenu();
                    app.changeScene();
                    // readCSV(file);
                    // open.setDisable(true);
                }
            }
        });




        Menu searchMenu = new Menu("検索");
        CustomMenuItem customMenuItem = new CustomMenuItem();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(40.0);
        hBox.setPrefWidth(300.0);
        TextField urlField = new TextField();
        urlField.setPrefWidth(200.0);
        urlField.setPromptText("http://");
        hBox.setMargin(urlField, new Insets(0.0, 5.0, 0.0, 0.0));
        Button searchButton = new Button("検索");
        searchButton.setOnAction(event -> {
            for (Browser browser: browsers) {
                browser.load(urlField.getText());
            }
        });
        hBox.setOpaqueInsets(new Insets(0.0, 10.0, 0.0, 10.0));

        hBox.getChildren().addAll(urlField, searchButton);
        customMenuItem.setContent(hBox);
        searchMenu.getItems().addAll(customMenuItem);
        contextMenu.getItems().addAll(searchMenu, open, exit);

        gridPane.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(gridPane, e.getScreenX(), e.getScreenY());
            } else {
                contextMenu.hide();
            }
        });

    }

    private int[][] getShape(String csv) {
        try {
            File f = new File(csv);
            BufferedReader br = new BufferedReader(new FileReader(f));

            List<String[]> rows = new ArrayList<>();
            String line = br.readLine();
            for (int row = 0; line != null; row++) {
                rows.add(line.split(",", 0));
                line = br.readLine();
            }
            br.close();

            int row = rows.size();
            int col = rows.get(0).length;
            int[][] shape = new int[row][col];

            // CSVから読み込んだ配列の中身を表示
            for(int r = 0; r < row; r++) {
                String[] sa = rows.get(r);
                for(int c = 0; c < col; c++) {
                    shape[r][c] = Integer.parseInt(sa[c]);
                }
            }
            System.out.println("sample.shape ok");
            return shape;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
