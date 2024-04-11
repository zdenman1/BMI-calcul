package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {


        JFrame okno = new JFrame("Bmi kalkulačka");
        JLabel hmotnosLabel = new JLabel("Vložte váhu:");
        JTextField hmotnost = new JTextField(20);
        JLabel vyskaLabel = new JLabel("Vlože výšku:");
        JTextField výška = new JTextField(20);

        JButton pocitej = new JButton("počítej");
        JLabel vysledekLabel = new JLabel("Váš výsledek:");
        JLabel novy = new JLabel();

        URL imgUrl;

        try {
            imgUrl = new URI("https://www.rehabilitace.info/wp-content/uploads/2013/10/bmi-index-vypocet.jpg").toURL();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        ImageIcon bmiIndex = new ImageIcon(imgUrl);
        JLabel bmiINdexovani = new JLabel(bmiIndex);


        okno.setLayout(new FlowLayout());
        okno.add(hmotnosLabel);
        okno.add(hmotnost);
        okno.add(vyskaLabel);
        okno.add(výška);
        okno.add(pocitej);
        okno.add(vysledekLabel);
        okno.add(novy);
        okno.add(bmiINdexovani);


        pocitej.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hodnota1 = hmotnost.getText();
                String hodnota2 = výška.getText();
                double vyska = Double.parseDouble(hodnota2);
                double váha = Double.parseDouble(hodnota1);
                double bmi = Math.abs((váha / (vyska * vyska)* 10000));
                DecimalFormat decimal = new DecimalFormat("#.##");
                String bmifinal = decimal.format(bmi);

                novy.setText(String.valueOf(bmifinal));


            }


        });


        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(690, 270);
        okno.setVisible(true);
        okno.setResizable(false);


    }
}
