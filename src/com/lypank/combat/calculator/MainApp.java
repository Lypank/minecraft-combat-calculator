package com.lypank.combat.calculator;

import com.lypank.combat.calculator.model.Armor;
import com.lypank.combat.calculator.model.Blocking;
import com.lypank.combat.calculator.model.Protection;
import com.lypank.combat.calculator.model.Resistance;
import com.lypank.combat.calculator.view.CalculatorDisplayController;
import com.lypank.combat.calculator.view.CalculatorResultsController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;

public class MainApp extends Application
{
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Armor> armorData = FXCollections.observableArrayList();

    /*
     * Adds basic sample data
     */

    public MainApp()
    {
        armorData.add(new Armor(new BigDecimal(0.04), new BigDecimal(0.12), new BigDecimal(0.08), new BigDecimal(0.04)));
        armorData.add(new Armor(new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.12), new BigDecimal(0.04)));
        armorData.add(new Armor(new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.16), new BigDecimal(0.04)));
        armorData.add(new Armor(new BigDecimal(0.08), new BigDecimal(0.24), new BigDecimal(0.20), new BigDecimal(0.08)));
        armorData.add(new Armor(new BigDecimal(0.12), new BigDecimal(0.32), new BigDecimal(0.24), new BigDecimal(0.12)));
    }

    public ObservableList<Armor> getArmorData()
    {
        return armorData;
    }

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

    private void initRootLayout()
    {
        try
        {
            //Create FXMLLoader and set the resource location for the root layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

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

    private void showCalculatorDisplay()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CalculatorDisplay.fxml"));
            AnchorPane calculatorDisplay = loader.load();

            rootLayout.setCenter(calculatorDisplay);

            CalculatorDisplayController controller = loader.getController();
            controller.setMainApp(this);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showCalculatorResults(Armor armor, Protection protection, Resistance resistance, Blocking stance)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CalculatorResults.fxml"));
            AnchorPane page = loader.load();

            Stage resultsStage = new Stage();
            resultsStage.setTitle("Combat Results");
            resultsStage.initModality(Modality.WINDOW_MODAL);
            resultsStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            resultsStage.setScene(scene);

            CalculatorResultsController controller = loader.getController();
            controller.setResultsStage(resultsStage);
            controller.setDR(armor);
            controller.setEnchantmentDR(protection);
            controller.setResistanceDR(resistance);
            controller.setBlockingDR(stance);
            controller.setTotalDR(armor, protection, resistance, stance);

            resultsStage.showAndWait();
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
