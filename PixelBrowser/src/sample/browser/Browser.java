package sample.browser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;


/**
 * Created by mary-mogreen.
 */
public class Browser {
    private WebView view;
    private WebEngine engine;
    private double width;
    private double height;
    private int col;
    private int row;
    private WebHistory history;

    public Browser(WebView view, Integer col, Integer row) {
        this.view = view;
        this.engine = view.getEngine();
        this.history = this.engine.getHistory();
        width = view.getPrefWidth();
        height = view.getPrefHeight();
        this.col = col;
        this.row = row;

        this.engine.setUserStyleSheetLocation(getClass().getResource("webView.css").toExternalForm());

        System.out.println("init: width=" + this.width + ", height=" + this.height + ", col=" + this.col + ", row=" + this.row + ".");

        // ロード完了時の処理を記述。スクロール位置を初期位置に戻す。
        engine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                        if (newValue == Worker.State.SUCCEEDED) {
                            System.out.println("loaded.");
                            reset();
                        }
                    }
                }
        );
        this.view.setContextMenuEnabled(false);
        // this.engine.load(getClass().getResource("sample.html").toExternalForm());
        this.engine.loadContent(getIFrameHtml("http://docs.oracle.com/javafx/2/webview/jfxpub-webview.htm"), "text/html");
        // createContextMenu(this.view);
    }

    public void load(String url) {
        System.out.println(url);
        this.engine.loadContent(getIFrameHtml(url), "text/html");
    }

    private void reset() {
        scrollTo(0, 0);
    }

    /**
     * nodeの位置を考慮して補正したx方向の値を返す。
     * @return
     */
    public int getPosX() {
        int posX = getHScrollValue() - (col * (int) width);
        int maxX = getHScrollMax() - ((2 - col) * (int) width * 2);
        if (posX <= 0)
            return 0;
        else if (posX >= maxX)
            return maxX;
        else
            return posX;
    }

    /**
     * nodeの位置を考慮して補正したy方向の値を返す。
     * @return
     */
    public int getPosY() {
        int posY = getVScrollValue() - (row * (int) height);
        int maxY = getVScrollMax() - ((2 - row) * (int) height);
        if (posY <= 0)
            return 0;
        else if (posY >= maxY)
            return maxY;
        else
            return posY;
    }

    /**
     * Scrolls to the specified position.
     * @param x horizontal scroll value
     * @param y vertical scroll value
     */
    public void scrollTo(int x, int y) {
        int w = x + col * (int)width;
        int h = y + row * (int)height;
        System.out.println("scrollTo (" + w + ", " + h + ");");
        engine.executeScript("window.scrollTo(" + w + ", " + h + ")");
        // engine.executeScript("document.getElementById('frame').contentWindow.scrollTo(" + w + ", " + h + ")");
    }

    /**
     * Returns the vertical scroll value, i.e. thumb position.
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getValue().
     * @return vertical scroll value
     */
    public int getVScrollValue() {
        return (Integer) engine.executeScript("document.body.scrollTop");
        // return (Integer) engine.executeScript("document.getElementById('frame').contentWindow.document.body.scrollTop");
        // return (Integer) engine.executeScript("window.pageYOffset");
    }

    /**
     * Returns the horizontal scroll value, i.e. thumb position.
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getValue()}.
     * @return horizontal scroll value
     */
    public int getHScrollValue() {
        return (Integer) engine.executeScript("document.body.scrollLeft");
        // return (Integer) engine.executeScript("document.getElementById('frame').contentWindow.document.body.scrollLeft");
        // return (Integer) engine.executeScript("window.pageXOffset");
    }

    /**
     * Returns the maximum vertical scroll value.
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getMax()}.
     * @return vertical scroll max
     */
    public int getVScrollMax() {
        int vScrollMax = (Integer) engine.executeScript("document.body.scrollHeight");
        // int vScrollMax = (Integer) engine.executeScript("document.getElementById('frame').contentWindow.document.body.height");
        System.out.println("vScrollMax: " + vScrollMax);
        return vScrollMax;
        // return (Integer) engine.executeScript("document.getElementById('frame').contentWindow.document.body.scrollHeight");
    }

    /**
     * Returns the maximum horizontal scroll value.
     * This is equivalent to {@link javafx.scene.control.ScrollBar#getMax()}.
     * @return horizontal scroll max
     */
    public int getHScrollMax() {
        int hScrollMax = (Integer) engine.executeScript("document.body.scrollWidth");
        System.out.println("hScrollMax: " + hScrollMax);
        return hScrollMax;
        // return (Integer) engine.executeScript("document.getElementById('frame').contentWindow.document.body.scrollWidth");
    }

    /**
     * スクロール終了時のハンドラを渡す。
     * @param onScrollFinished
     */
    public void setOnScrollFinished(EventHandler<ScrollEvent> onScrollFinished) {
        view.setOnScroll(onScrollFinished);
    }


    public void back() {
        if (history.getCurrentIndex() > 0)
            history.go(-1);
    }
    public void forward() {
        history.go(1);
    }

    private String getIFrameHtml(String url) {
        return "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "\n" +
                "    <title>The HTML5 Herald</title>\n" +
                "    <meta name=\"description\" content=\"The HTML5 Herald\">\n" +
                "    <meta name=\"author\" content=\"SitePoint\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body style=\"margin:0px;\">\n" +
                "<script>\n" +
                "\n" +
                "</script>\n" +
                "<iframe id=\"frame\" src=\"" + url + "\" scrolling=\"no\" frameborder=\"0\" width=\"600\" height=\"50000\" >\n" +
                "</iframe>\n" +
                "</body>\n" +
                "</html>";
    }
}
