package org.parabot.chino.Theif.ui;

import org.parabot.chino.Theif.ICore;
import org.parabot.chino.Theif.data.Stall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UI extends JFrame {

    public UI(final ICore core) {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(250, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        final JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(Stall.values()));
        comboBox.setBounds(6, 6, 238, 27);
        contentPane.add(comboBox);

        final JCheckBox autoProgression = new JCheckBox("Auto Progression");
        autoProgression.setBounds(47, 35, 140, 23);
        contentPane.add(autoProgression);

        final JCheckBox powerLevel = new JCheckBox("Power Level");
        powerLevel.setBounds(47, 65, 140, 23);
        contentPane.add(powerLevel);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                core.getSettings().setStall((Stall) comboBox.getSelectedItem());
                core.getSettings().setAutoProgress(autoProgression.isSelected());
                core.getSettings().setPowerLevel(powerLevel.isSelected());
                setVisible(false);
            }
        });
        submitButton.setBounds(58, 95, 117, 29);
        contentPane.add(submitButton);

        setVisible(true);
    }
}
