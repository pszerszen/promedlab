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

import com.manager.labo.utils.ActionCommand;

public final class JPanelEnchancer {

    private JPanel panel;

    public JPanelEnchancer(JPanel panel) {
        this.panel = panel;
    }

    public JPanelEnchancer initButtonsActionCommands() {
        Arrays.asList(panel.getClass().getDeclaredFields())
                .stream()
                .filter(field -> field.getType().equals(JButton.class) && field.isAnnotationPresent(ActionCommand.class))
                .forEach(buttonField -> {
                    try {
                        buttonField.setAccessible(true);
                        JButton button = (JButton) buttonField.get(panel);
                        button.setActionCommand(buttonField.getAnnotation(ActionCommand.class).value());
                    } catch (Exception e) {
                        // TODO remove action
                        e.printStackTrace();
                    }
                });

        return this;
    }

    public JPanelEnchancer addListeners(ActionListener actionListener, KeyListener keyListener) {
        standardActionsForComponent(JButton.class, button -> {
            button.addActionListener(actionListener);
            button.addKeyListener(keyListener);
        });

        return this;
    }

    public JPanelEnchancer standardActions() {
        final Font calibriPlain14 = new Font("Calibri", Font.PLAIN, 14);
        standardActionsForComponent(JButton.class, jButton -> {
            jButton.setFont(calibriPlain14);
            jButton.setFocusable(false);
        });
        standardActionsForComponent(JLabel.class, label -> {
            label.setFont(calibriPlain14);
        });

        return this;
    }

    public <C extends JComponent> JPanelEnchancer standardActionsForComponent(Class<C> type, Consumer<C> action) {
        Arrays.asList(panel.getClass().getDeclaredFields())
                .stream()
                .filter(field -> field.getType().equals(type))
                .forEach(componentField -> {
                    try {
                        componentField.setAccessible(true);
                        @SuppressWarnings("unchecked")
                        C comp = (C) componentField.get(panel);
                        action.accept(comp);
                    } catch (Exception e) {
                        // TODO remove action
                        e.printStackTrace();
                    }
                });

        return this;
    }
}
