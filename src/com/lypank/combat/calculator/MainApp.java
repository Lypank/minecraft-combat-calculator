package com.lypank.combat.calculator;

import com.lypank.combat.calculator.model.Armor;
import com.lypank.combat.calculator.view.CalculatorDisplayController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application
{
    private Stage primaryStage;
    private BorderPane rootLayout;

    /*
     * Sets the primary stage
     * Sets the stage title
     * Initializes the Root Layout
     * Displays the Calculator interface
     */

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Combat Calculator");

        initRootLayout();

        showCalculatorDisplay();
    }

    public void initRootLayout()
    {
        try
        {
            //Create FXMLLoader and set the resource location for the root layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load();

            //Define the scene's root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showCalculatorDisplay()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CalculatorDisplay.fxml"));
            AnchorPane calculatorDisplay = (AnchorPane)loader.load();

            rootLayout.setCenter(calculatorDisplay);

            CalculatorDisplayController controller = loader.getController();
            controller.setMainApp(this);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }



}
