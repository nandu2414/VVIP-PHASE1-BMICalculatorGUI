import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BMICalculatorGUI extends Application {
    public static double calculateBMI(double weight, double height){
        double bmi= weight/(height*height);
        return bmi;
    }
    public static String determineHealthCategory(double bmi){
        if(bmi<18.5){
            return ("You are Underweight");
        }
        else if(bmi<24.9){
            return ("You are Normal");
        }
        else if(bmi<29.9){
            return ("You are Overweight");
        }
        else{
            return ("You are Obese");
        }
    }


    @Override
    public void start(Stage primaryStage) {
        // Create GUI components
        Label weightLabel = new Label("Enter your weight (kg):");
        TextField weightInput = new TextField();
        Label heightLabel = new Label("Enter your height (m):");
        TextField heightInput = new TextField();
        Button calculateButton = new Button("Calculate BMI");
        Label resultLabel = new Label("BMI: ");
        Label categoryLabel = new Label("Category: ");

        // Set up event handling for the button
        calculateButton.setOnAction(event -> {
            double weight = Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText());

            double bmi = BMICalculatorGUI.calculateBMI(weight, height);
            String healthCategory = BMICalculatorGUI.determineHealthCategory(bmi);

            resultLabel.setText("BMI: " + bmi);
            categoryLabel.setText("Category: " + healthCategory);
        });

        // Create a layout for the components
        VBox root = new VBox(weightLabel, weightInput, heightLabel, heightInput, calculateButton, resultLabel, categoryLabel);

        // Create a scene and set it in the primary stage
        Scene scene = new Scene(root, 350, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BMI Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}