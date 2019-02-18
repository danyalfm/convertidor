package com.edu.appswbd.practica.uno.GUI;

import com.edu.appswbd.practica.uno.convertidor.Convertir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    //JPanel p1;
    JTextArea entrada;
    JTextArea salida;
    JButton btnconvertir;
    JComboBox seleccionar;
    JLabel texto1;
    JLabel texto2;
    JLabel texto3;

    public Ventana(){
        setBounds(200,100,780,500);
        setTitle("convertidor");
        setDefaultCloseOperation(3);
        setLayout(null);

        iniciar();
    }

    public void iniciar(){

        texto1 = new JLabel("ingrese texto a convertir:");
        texto2 = new JLabel("seleccione formato a convertir:");
        texto3 = new JLabel("texto convertido:");
        entrada = new JTextArea();
        salida = new JTextArea();
        btnconvertir = new JButton("Convertir");
        btnconvertir.addActionListener(this);
        String[] tipo = {"XML", "JAVA"};
        seleccionar = new JComboBox(tipo);

        entrada.setBounds(20,35,300,300);
        salida.setBounds(450,35,300,300);
        btnconvertir.setBounds(340,150,90,60);
        seleccionar.setBounds(355,360,70,30);
        texto1.setBounds(100,10,200,20);
        texto2.setBounds(310,340,200,20);
        texto3.setBounds(555,10,200,20);

        this.add(entrada);
        this.add(salida);
        this.add(btnconvertir);
        this.add(seleccionar);
        this.add(texto1);
        this.add(texto2);
        this.add(texto3);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String tipo = (String) seleccionar.getSelectedItem();
        String textoEntrada = entrada.getText();
        if(textoEntrada.trim().length()==0){
            JOptionPane.showMessageDialog(
                    this,
                    "No hay texto",
                    "Texto vacio",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            Convertir convertidor = new Convertir();
            String textoConvertido = convertidor.convertirToJson(textoEntrada,tipo);

            if(textoEntrada.charAt(0) != '<' && tipo =="XML"){
                JOptionPane.showMessageDialog(
                        this,
                        "FORMATO XML INCORRECTO",
                        "FORMATO XML",
                        JOptionPane.WARNING_MESSAGE);
            }
            else{
                salida.setText(textoConvertido);
            }
            entrada.setText("");
        }
    }
}
