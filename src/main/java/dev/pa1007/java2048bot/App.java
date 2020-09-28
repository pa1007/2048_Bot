package dev.pa1007.java2048bot;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private List<Case> cases;


    private Stage stage;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bot");

        cases = List.of(new Case(171, 385), new Case(293, 385), new Case(418, 385), new Case(540, 385),
                        new Case(171, 511), new Case(293, 511), new Case(418, 511), new Case(540, 511),
                        new Case(171, 625), new Case(293, 625), new Case(418, 625), new Case(540, 625),
                        new Case(171, 748), new Case(293, 748), new Case(418, 748), new Case(540, 748)
        );

        WebView webView = new WebView();

        webView.getEngine().load("http://play2048.co");

        Scene scene = new Scene(webView, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
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
                    System.out.println(createGame());
                    break;
            }
        });

        stage = primaryStage;

    }

    public Game createGame() {
        List<Case> sorted = new ArrayList<>();

        for (Case aCase : cases) {
            aCase.setType(bot(aCase));
            sorted.add(aCase);
        }
        return new Game(sorted);
    }

    private Case.Type bot(int s, int s1) {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(stage.getScene().snapshot(null), null);
        int           p             = bufferedImage.getRGB(s, s1);
        int           blue          = p & 0xff;
        int           green         = (p & 0xff00) >> 8;
        int           red           = (p & 0xff0000) >> 16;
        return Case.getType(red, green, blue);
    }

    private Case.Type bot(Case c) {
        return bot(c.getX(), c.getY());
    }

    private void takeStill() throws IOException {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(stage.getScene().snapshot(null), null);
        cases.forEach((c) -> bufferedImage.setRGB(c.getX(), c.getY(), Color.RED.getRGB()));
        File output = new File("Test.png");
        output.createNewFile();
        ImageIO.write(bufferedImage, "png", output);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
