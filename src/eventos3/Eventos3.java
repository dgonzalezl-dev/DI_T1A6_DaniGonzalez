/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos3;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class Eventos3 extends Application {
    Label l1=new Label("Annual Interest Rate:");
    Label l2=new Label("Numbers of Years:");
    Label l3=new Label("Loan Amount:");
    Label l4=new Label("Monthly Payment:");
    Label l5=new Label("Total Payment:");
    Button bt1=new Button("Calculate");
    TextField t1=new TextField();
    TextField t2=new TextField();
    TextField t3=new TextField();
    TextField t4=new TextField();
    TextField t5=new TextField();
    GridPane g=new GridPane();
    
    @Override
    public void start(Stage primaryStage) {
        g.add(l1,0,0);
        g.add(l2,0,1);
        g.add(l3,0,2);
        g.add(l4,0,3);
        g.add(l5,0,4);
        g.add(t1, 1, 0);
        g.add(t2, 1, 1);
        g.add(t3, 1, 2);
        g.add(t4, 1, 3);
        g.add(t5, 1, 4);
        g.add(bt1, 1, 6);
        g.setHgap(5);
        g.setVgap(5);
        bt1.setOnAction(e->{
            calcular();
        });
        Scene scene = new Scene(g, 500, 500);
        primaryStage.setTitle("Eventos2");
        primaryStage.setScene(scene); 
        primaryStage.show();
    }
    
    public void calcular(){
        try{
            double interes=Double.parseDouble(t1.getText());
            double plazo=Double.parseDouble(t2.getText());
            double precio=Double.parseDouble(t3.getText());
            double r=interes/1200;
            double m=(precio*r)/(1-Math.pow((1+r), -(12*plazo)));
            t4.setText(String.format("%.2f", m));
            t5.setText(String.format("%.2f", m*plazo*12));
        }catch(NumberFormatException ev){
            t5.setText("Eso no es un numero");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}