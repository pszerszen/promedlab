package com.manager.labo.view.components;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class JPanelEnchancer {

    private JPanel panel;

    public JPanelEnchancer(JPanel panel) {
        this.panel = panel;
    }

    public void addListeners(ActionListener actionListener, KeyListener keyListener) {
        Arrays.asList(getClass().getDeclaredFields())
                .stream()
                .filter(field -> field.getType().equals(JButton.class))
                .forEach(buttonField -> {
                    try {
                        final JButton button = (JButton) buttonField.get(panel);
                        button.addActionListener(actionListener);
                        button.addKeyListener(keyListener);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public void standardActions() {
        final Font calibriPlain14 = new Font("Calibri", Font.PLAIN, 14);
        standardActionsForComponent(JButton.class, jButton -> {
            jButton.setFont(calibriPlain14);
            jButton.setFocusable(false);
        });
        standardActionsForComponent(JLabel.class, label -> {
            label.setFont(calibriPlain14);
        });
    }

    public <C extends JComponent> void standardActionsForComponent(Class<C> type, Consumer<C> action) {
        Arrays.asList(getClass().getDeclaredFields())
                .stream()
                .filter(field -> field.getType().equals(type))
                .forEach(componentField -> {
                    try {
                        @SuppressWarnings("unchecked")
                        C comp = (C) componentField.get(panel);
                        action.accept(comp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
