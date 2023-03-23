package com.example.demo2;

import javafx.application.Application;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo2.*;
public class MainApplication extends Application {

    int index;
    double resConversion;

    @Override
    public void start(Stage stage)  {

//Menu principal seleccion
        List<String> opciones = new ArrayList<>();
        opciones.add("Convertidor de divisas");
        opciones.add("Convertidor de temperatura");


        ChoiceDialog<String> dialogoEleccion = new ChoiceDialog<String>("Seleccione convertidor", opciones);
        dialogoEleccion.setTitle("Challenge - Alura 2023");
        dialogoEleccion.setHeaderText("Convertidor");
        dialogoEleccion.setContentText("Seleccione una opción de conversion");
        dialogoEleccion.showAndWait();

        //Obtengo el valor del index seleccionado
        index = dialogoEleccion.getItems().indexOf(dialogoEleccion.getSelectedItem());
        if (index == 0) {
            menuDivisas();
        } else if (index == 1) {
            menuTemperatura();
        }
        else{
            salir();
        }

    }

    private void menuDivisas(){
        List<String> opciones = new ArrayList<>();
        opciones.add("De Pesos MXN a Dólar");
        opciones.add("De Pesos MXN a Euro");
        opciones.add("De Pesos MXN a Libras");
        opciones.add("De Pesos MXN a Yen");
        opciones.add("De Pesos MXN a Won Coreano");
        opciones.add("De Dólar a Pesos Mexicanos");
        opciones.add("De Euro a Pesos Mexicanos");
        opciones.add("De Libras a Pesos Mexicanos");
        opciones.add("De Yen a Pesos Mexicanos");
        opciones.add("De Won Coreno a Pesos Mexicanos");

        ChoiceDialog<String> dialogoEleccion = new ChoiceDialog<String>("Seleccione divisa", opciones);
        dialogoEleccion.setTitle("Challenge - Alura 2023");
        dialogoEleccion.setHeaderText("SELECCION DE DIVISA");
        dialogoEleccion.setContentText("Eija la moneda a la que deseas convertir tu dinero");
        dialogoEleccion.showAndWait();

        //Obtengo el valor del index seleccionado
        index = dialogoEleccion.getItems().indexOf(dialogoEleccion.getSelectedItem());

        //Switch de conversion
        switch (index){
            case 0:
                convertir("Dólares americanos", index);
            case 1:
                convertir("Euros", index);
            case 2:
                convertir("Libras", index);
            case 3:
                convertir("Yen", index);
            case 4:
                convertir("Yen", index);
            case 5:
                revertir("Dólares americanos", index);
            case 6:
                revertir("Euros", index);
            case 7:
                revertir("Libras", index);
            case 8:
                revertir("Yen", index);
            case 9:
                revertir("Won Coreanos", index);

                break;
        }

    }
   private void menuTemperatura() {
       List<String> opciones = new ArrayList<>();
       opciones.add("Celsius a Fahrenheit");
       opciones.add("Celsius a Kelvin");

       ChoiceDialog<String> dialogoEleccion = new ChoiceDialog<String>("Celsius a Fahrenheit", opciones);
       dialogoEleccion.setTitle("Challenge - Alura 2023");
       dialogoEleccion.setHeaderText("SELECCION DE TEMPERATURA");
       dialogoEleccion.setContentText("Eija la escala de temperatura a convertir");
       dialogoEleccion.showAndWait();

       //Obtengo el valor del index seleccionado
       index = dialogoEleccion.getItems().indexOf(dialogoEleccion.getSelectedItem());

       //Switch de conversion
       switch (index) {
           case 0:
               convertirTemperatura("Celsius", index);
           case 1:
               convertirTemperatura("Euros", index);
       }
   }

    private void convertirTemperatura(String nameTemperatura, int index) {
        TextInputDialog dialogoTextual = new TextInputDialog();
        dialogoTextual.getDialogPane().setStyle("-fx-background-color:gray;");
        dialogoTextual.setTitle("Convertidor de celcius " + nameTemperatura);
        dialogoTextual.setHeaderText("Ingrese los grados a convertir");
        dialogoTextual.setContentText("C");
        dialogoTextual.initStyle(StageStyle.UTILITY);
        dialogoTextual.showAndWait();
    }

    public void convertir(String nameDivisa, int tipoDivisa) {

            TextInputDialog dialogoTextual = new TextInputDialog();
            dialogoTextual.getDialogPane().setStyle("-fx-background-color:gray;");
            dialogoTextual.setTitle("Convertidor de pesos a " + nameDivisa);
            dialogoTextual.setHeaderText("Ingrese la cantidad a convertir");
            dialogoTextual.setContentText("Pesos MXN $");
            dialogoTextual.initStyle(StageStyle.UTILITY);
            dialogoTextual.showAndWait();


        //Generamos un acortador de decimales
        DecimalFormat valorDecimal = new DecimalFormat("#.00");

        //Verificamos que el campo no esté vacio
        try{
            if(dialogoTextual.resultProperty().getValue().isEmpty()) {
                errorVacio();
                dialogoTextual.showAndWait();
            }
        }catch (Exception e){

        }
            switch (index){
                case 0:
                    try {
                        resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) / 18.85;
                    }
                    catch (NumberFormatException e) {
                        errorFormato();
                        dialogoTextual.showAndWait();

                    }
                    catch (Exception exception){
                        System.exit(0);
                    }
                    break;
                case 1:
                    try {
                        resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) / 21;
                    }
                    catch (NumberFormatException e) {
                        errorFormato();
                        dialogoTextual.showAndWait();

                    }
                    catch (Exception exception){
                        System.exit(0);
                    }
                    break;
                case 2:
                    try {
                        resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) / 22.83;
                    }
                    catch (NumberFormatException e) {
                        errorFormato();
                        dialogoTextual.showAndWait();
                    }
                    catch (Exception exception){
                        System.exit(0);
                    }
                    break;
                case 3:
                    try {
                        resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) * 7.04;
                    }
                    catch (NumberFormatException e) {
                        errorFormato();
                        dialogoTextual.showAndWait();

                    }
                    catch (Exception exception){
                        System.exit(0);
                    }
                    break;
                case 4:
                    try {
                        resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) * 69.38;
                    }
                    catch (NumberFormatException e) {
                        errorFormato();
                        dialogoTextual.showAndWait();


                    }
                    catch (Exception exception){
                        System.exit(0);
                    }
                    break;


            }

        //Resultado final de resConversion con dos decimales
        try{
            resConversion = Double.parseDouble(valorDecimal.format(resConversion));
            print(Double.valueOf(dialogoTextual.resultProperty().getValue()), nameDivisa);
        }
        catch (Exception e){

        }

    }

    public void revertir(String nameDivisa, int tipoDivisa) {

        TextInputDialog dialogoTextual = new TextInputDialog();
        dialogoTextual.getDialogPane().setStyle("-fx-background-color:gray;");
        dialogoTextual.setTitle("Convertidor de " + nameDivisa + " a pesos mexicanos");
        dialogoTextual.setHeaderText("Ingrese la cantidad a convertir");
        dialogoTextual.setContentText(nameDivisa);
        dialogoTextual.initStyle(StageStyle.UTILITY);
        dialogoTextual.showAndWait();


        //Generamos un acortador de decimales
        DecimalFormat valorDecimal = new DecimalFormat("#.000");

        //Verificamos que el campo no esté vacio
        try{
            if(dialogoTextual.resultProperty().getValue().isEmpty()) {
                errorVacio();
                dialogoTextual.showAndWait();
            }
        }catch (Exception e){

        }
        switch (index){
            case 5:
                try {
                    resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) * 18.85;
                }
                catch (NumberFormatException e) {
                    errorFormato();
                    dialogoTextual.showAndWait();

                }
                catch (Exception exception){
                    System.exit(0);
                }
                break;
            case 6:
                try {
                    resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) * 21;
                }
                catch (NumberFormatException e) {
                    errorFormato();
                    dialogoTextual.showAndWait();

                }
                catch (Exception exception){
                    System.exit(0);
                }
                break;
            case 7:
                try {
                    resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) * 22.83;
                }
                catch (NumberFormatException e) {
                    errorFormato();
                    dialogoTextual.showAndWait();
                }
                catch (Exception exception){
                    System.exit(0);
                }
                break;
            case 8:
                try {
                    resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) / 7.04;
                }
                catch (NumberFormatException e) {
                    errorFormato();
                    dialogoTextual.showAndWait();

                }
                catch (Exception exception){
                    System.exit(0);
                }
                break;
            case 9:
                try {
                    resConversion = Double.valueOf(dialogoTextual.resultProperty().getValue()) / 69.38;
                }
                catch (NumberFormatException e) {
                    errorFormato();
                    dialogoTextual.showAndWait();


                }
                catch (Exception exception){
                    System.exit(0);
                }
                break;

        }

        //Resultado final de resConversion con dos decimales
        try{
            resConversion = Double.parseDouble(valorDecimal.format(resConversion));
            print(Double.valueOf(dialogoTextual.resultProperty().getValue()), nameDivisa);
        }
        catch (Exception e){

        }

    }
    public double print(double cantidad, String nameDivisa){
        if(index < 4){
            Alert msj= new Alert(Alert.AlertType.INFORMATION);
            msj.setContentText( "$"+cantidad+" pesos mexicanos es igual a $"+resConversion+" "+ nameDivisa);
            msj.setHeaderText("Conversión exitosa!!!");
            msj.setTitle("Pesos mexicanos a " + nameDivisa);
            msj.showAndWait();
            nuevaConversion();
        }
        else {
            Alert msj= new Alert(Alert.AlertType.INFORMATION);
            msj.setContentText( "$"+cantidad+ " "+ nameDivisa+" "+ " es igual $"+resConversion+ " pesos mexicanos");
            msj.setHeaderText("Conversión exitosa!!!");
            msj.setTitle(nameDivisa+ " " + " a Pesos mexicanos ");
            msj.showAndWait();
            nuevaConversion();
        }
        return cantidad;
    }
    void errorFormato(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("ATENCION");
        alert.setHeaderText("Error de formato");
        alert.setContentText("Solo valores numéricos o con un solo punto decimal");
         alert.showAndWait();
    }
void errorVacio(){
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("ATENCION");
    alert.setHeaderText("Tienes que ingresar una cantidad");
    alert.setContentText("Intente de nuevo, solo números");
    alert.showAndWait();

}
    void salir() {
        Alert dialogoConfirmacionPerso = new Alert(Alert.AlertType.CONFIRMATION);
        dialogoConfirmacionPerso.setTitle("Diálogo de confirmación");
        dialogoConfirmacionPerso.setHeaderText("Cabecera del cuadro de diálogo de confirmación personalizado");
        dialogoConfirmacionPerso.setContentText("¿Seguro que desea salir? seleccione Cancelar / Salir'");
        ButtonType boton1 = new ButtonType("Cancelar");
        ButtonType boton2 = new ButtonType("Salir");

        dialogoConfirmacionPerso.getButtonTypes().setAll(boton1, boton2);
        Optional<ButtonType> opciones = dialogoConfirmacionPerso.showAndWait();
        if (opciones.get() == boton1) {
            start(new Stage());
        } else if (opciones.get() == boton2) {
            System.exit(0);
        }
    }

    void nuevaConversion() {
        Alert dialogoConfirmacionPerso = new Alert(Alert.AlertType.CONFIRMATION);
        dialogoConfirmacionPerso.setTitle("Challenge Alura 2023");
        dialogoConfirmacionPerso.setHeaderText("Continuar?");
        dialogoConfirmacionPerso.setContentText("¿Desea realizar otra conversión? seleccione SI o NO'");
        ButtonType boton1 = new ButtonType("Sí");
        ButtonType boton2 = new ButtonType("No");

        dialogoConfirmacionPerso.getButtonTypes().setAll(boton1, boton2);
        Optional<ButtonType> opciones = dialogoConfirmacionPerso.showAndWait();
        if (opciones.get() == boton1) {
            menuDivisas();
        } else if (opciones.get() == boton2) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}