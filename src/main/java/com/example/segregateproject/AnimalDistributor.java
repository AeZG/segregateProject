package com.example.segregateproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;

public class AnimalDistributor extends Application {

    static public void segregate(Collection<? extends Chordata> srcCollection,
                                 Collection<? super RegularHedgehog> Collection1,
                                 Collection<? super PallasCat> Collection2,
                                 Collection<? super Lynx> Collection3) {
        for (Chordata animal : srcCollection) {
            if (animal instanceof RegularHedgehog) {
                Collection1.add((RegularHedgehog) animal);
            }
            if (animal instanceof PallasCat) {
                Collection2.add((PallasCat) animal);
            }
            if (animal instanceof Lynx) {
                Collection3.add((Lynx) animal);
            }
        }
    }

    public void start(Stage primaryStage) {

        // UI components
        Button segregateButton = new Button("Segregate Animals");
        TextArea outputArea = new TextArea();

        segregateButton.setOnAction(event -> {
            StringBuilder output = new StringBuilder();

            // Demonstration 1: segregate(Mammals, Hedgehogs, Felidae, Carnivores)
            Collection<Chordata> srcCollection1 = new ArrayList<>();
            Collection<RegularHedgehog> Collection1_1 = new ArrayList<>();
            Collection<Felidae> Collection2_1 = new ArrayList<>();
            Collection<Carnivores> Collection3_1 = new ArrayList<>();

            srcCollection1.add(new RegularHedgehog());
            srcCollection1.add(new RegularHedgehog());
            srcCollection1.add(new PallasCat());
            srcCollection1.add(new PallasCat());
            srcCollection1.add(new PallasCat());
            srcCollection1.add(new Lynx());
            srcCollection1.add(new Lynx());
            srcCollection1.add(new Lynx());
            srcCollection1.add(new Lynx());

            segregate(srcCollection1, Collection1_1, Collection2_1, Collection3_1);
            output.append("Demonstration 1:\n")
                    .append("Collection1 Hedgehogs: ").append(Collection1_1.size()).append("\n")
                    .append("Collection2 Felidae: ").append(Collection2_1.size()).append("\n")
                    .append("Collection3 Carnivores: ").append(Collection3_1.size()).append("\n\n");

            // Demonstration 2: segregate(Carnivores, Chordata, Pallas' cat, Felidae)
            Collection<Carnivores> srcCollection2 = new ArrayList<>();
            Collection<Chordata> Collection1_2 = new ArrayList<>();
            Collection<PallasCat> Collection2_2 = new ArrayList<>();
            Collection<Felidae> Collection3_2 = new ArrayList<>();

            srcCollection2.add(new PallasCat());
            srcCollection2.add(new Lynx());
            srcCollection2.add(new Lynx());

            segregate(srcCollection2, Collection1_2, Collection2_2, Collection3_2);
            output.append("Demonstration 2:\n")
                    .append("Collection1 (Chordata): ").append(Collection1_2.size()).append("\n")
                    .append("Collection2 (Pallas' cat): ").append(Collection2_2.size()).append("\n")
                    .append("Collection3 (Felidae): ").append(Collection3_2.size()).append("\n\n");

            // Demonstration 3: segregate(Hedgehogs, Insectivores, Carnivores, Carnivores)
            Collection<RegularHedgehog> srcCollection3 = new ArrayList<>();
            Collection<Insectivores> Collection1_3 = new ArrayList<>();
            Collection<Carnivores> Collection2_3 = new ArrayList<>();
            Collection<Carnivores> Collection3_3 = new ArrayList<>();

            srcCollection3.add(new RegularHedgehog());

            segregate(srcCollection3, Collection1_3, Collection2_3, Collection3_3);
            output.append("Demonstration 3:\n")
                    .append("Collection1 (Insectivores): ").append(Collection1_3.size()).append("\n")
                    .append("Collection2 (Carnivores): ").append(Collection2_3.size()).append("\n")
                    .append("Collection3 (Carnivores): ").append(Collection3_3.size()).append("\n");

            outputArea.setText(output.toString());
        });

        // Layout and scene
        VBox root = new VBox(20, segregateButton, outputArea);
        Scene scene = new Scene(root, 400, 300);  // Adjusted width for better view

        primaryStage.setTitle("Animal Distributor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
