package dev.pa1007.java2048bot;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class App extends Application {

    private List<Case> cases;


    private Stage stage;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bot");

        cases = List.of(new Case(171,385), new Case(293,385), new Case(418,385), new Case(540,385),
                        new Case(171,511), new Case(293,511), new Case(418,511), new Case(540,511),
                        new Case(171,625), new Case(293,625), new Case(418,625), new Case(540,625),
                        new Case(171,748), new Case(293,748), new Case(418,748), new Case(540,748)
        );

        WebView webView = new WebView();

        webView.getEngine().load("http://play2048.co");

        Scene scene = new Scene(webView, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
        //        Robot         robot         = new Robot();
        //        WritableImage writableImage = new WritableImage(800, 800);
        //        writableImage = robot.getScreenCapture(writableImage, new Rectangle2D(0, 0, 800, 800));
        primaryStage.getScene().setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case P:
                    try {
                        takeStill();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case N:
                case H:




                    break;
            }
        });

        stage = primaryStage;

    }

    private String bot(int s, int s1) throws IOException {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(stage.getScene().snapshot(null), null);

        bufferedImage.setRGB(s, s1, Color.red.getRGB());
        File output = new File("Test.png");
        output.createNewFile();
        ImageIO.write(bufferedImage, "png", output);
        //        // get red
        //        int r = (p>>16) & 0xff;
        //
        //        // get green
        //        int g = (p>>8) & 0xff;
        //
        //        // get blue
        //        int a = p & 0xff;

    }

    private void takeStill() throws IOException {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(stage.getScene().snapshot(null), null);
        File          output        = new File("Test.png");
        output.createNewFile();
        ImageIO.write(bufferedImage, "png", output);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
