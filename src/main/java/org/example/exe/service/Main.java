package org.example.exe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.exe.models.Util;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Main {

    public static void main(String[] args) {
        System.out.println("Thank You Jesus");

        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("GET SHARD HEADER AND REVERSED SID");
            frame.setSize(1000, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel instanceLabel = new JLabel("Instance ID: ");
            instanceLabel.setPreferredSize(new Dimension(400, 25));

            JTextField instanceField = new JTextField("cm-dev-custom-sandbox");
            instanceField.setPreferredSize(new Dimension(400, 25));
            instanceField.setToolTipText("Enter your instance ID here. e.g. cm-dev-custom-sandbox");

            JLabel databaseLabel = new JLabel("Database ID: ");
            databaseLabel.setPreferredSize(new Dimension(400, 25));

            JTextField databaseField = new JTextField();
            databaseField.setPreferredSize(new Dimension(400, 25));
            databaseField.setToolTipText("Enter your database ID here. e.g. hmaryt-db");

            JLabel shardIdLabel = new JLabel("Shard ID: ");
            shardIdLabel.setPreferredSize(new Dimension(400, 25));

            JTextField shardIdField = new JTextField("121101");
            shardIdField.setPreferredSize(new Dimension(400, 25));
            shardIdField.setToolTipText("Shard ID is sent from MCP to CMS, and passed down to CMDG e.g. 121101");

            JLabel sidLabel = new JLabel("SID: ");
            sidLabel.setPreferredSize(new Dimension(400, 25));

            JTextField sidField = new JTextField();
            sidField.setPreferredSize(new Dimension(400, 25));
            sidField.setToolTipText("Enter your SID here. e.g. 77");

            JLabel buttonLabel = new JLabel("");
            buttonLabel.setPreferredSize(new Dimension(600, 25));

            JButton button = new JButton("Get Shard Header");
            button.setPreferredSize(new Dimension(200, 25));
            button.setToolTipText("Click to get your shard header");

            JLabel outputLabel = new JLabel("Your shard header is: \"x-comms-shard-info\"");
            outputLabel.setPreferredSize(new Dimension(800, 25));

            JTextArea outputField = new JTextArea();
            outputField.setPreferredSize(new Dimension(800, 50));
            outputField.setEditable(false);
            outputField.setLineWrap(true);

            JLabel styleLabel = new JLabel("");
            styleLabel.setPreferredSize(new Dimension(800, 25));

            JTextField sidField2 = new JTextField();
            sidField2.setPreferredSize(new Dimension(400, 25));
            sidField2.setToolTipText("Enter your SID here. e.g. 77");

            JLabel sidLabel2 = new JLabel("SID: ");
            sidLabel2.setPreferredSize(new Dimension(400, 25));

            JLabel buttonLabel2 = new JLabel("");
            buttonLabel2.setPreferredSize(new Dimension(600, 25));

            JButton button2 = new JButton("Get Reversed SID");
            button2.setPreferredSize(new Dimension(200, 25));
            button2.setToolTipText("Click to get your reversed sid");
            button2.setToolTipText("Click to get the reversed sid");

            JLabel outputLabel2 = new JLabel("Your reversed sid is: ");
            outputLabel2.setPreferredSize(new Dimension(800, 25));

            JTextArea outputField2 = new JTextArea();
            outputField2.setPreferredSize(new Dimension(800, 50));
            outputField2.setEditable(false);
            outputField2.setLineWrap(true);

            button.addActionListener(e->{
                String sid = sidField.getText();
                String instance = instanceField.getText();
                String database = databaseField.getText();
                String shardId = shardIdField.getText();

                String shardHeader = null;
                try {
                    shardHeader = Util.getShardHeader(instance, database, Integer.parseInt(shardId), Long.parseLong(sid));
                    outputField.setText(shardHeader);
                } catch (JsonProcessingException ex) {
                    System.out.println("Exception: "+ex.getMessage());
                }
                System.out.println("shardHeader: "+shardHeader);
            });

            button2.addActionListener(e->{
                String sid = sidField2.getText();
                try{
                    String reversedSid = Util.getReversedSid(Long.parseLong(sid));
                    outputField2.setText(reversedSid);
                    System.out.println("reversedSid: "+reversedSid);
                }catch (Exception ex) {
                    System.out.println("Exception: "+ex.getMessage());
                }
            });

            JPanel panel = new JPanel();
            panel.add(instanceLabel);
            panel.add(instanceField);
            panel.add(databaseLabel);
            panel.add(databaseField);
            panel.add(shardIdLabel);
            panel.add(shardIdField);
            panel.add(sidLabel);
            panel.add(sidField);
            panel.add(buttonLabel);
            panel.add(button);
            panel.add(outputLabel);
            panel.add(outputField);
            panel.add(styleLabel);
            panel.add(sidLabel2);
            panel.add(sidField2);
            panel.add(buttonLabel2);
            panel.add(button2);
            panel.add(outputLabel2);
            panel.add(outputField2);

            panel.setLayout(new FlowLayout());

            frame.setContentPane(panel);
            frame.setVisible(true);
        });


    }
}
