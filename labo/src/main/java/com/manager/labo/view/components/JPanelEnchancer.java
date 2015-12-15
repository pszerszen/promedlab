package com.manager.labo.view.components;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.manager.labo.utils.ActionCommand;

public final class JPanelEnchancer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JPanelEnchancer.class);

    private JPanel panel;

    public JPanelEnchancer(JPanel panel) {
        this.panel = panel;
    }

    public JPanelEnchancer addAction(String actionCommand, ActionListener actionListener) {
        try {
            for (Field field : panel.getClass().getDeclaredFields()) {
                final ActionCommand actionCommandAnnotation = field.getAnnotation(ActionCommand.class);
                if (actionCommandAnnotation != null && actionCommand.equals(actionCommandAnnotation.value())) {
                    field.setAccessible(true);
                    final Object object = field.get(panel);
                    if (object instanceof JButton) {
                        ((JButton) object).addActionListener(actionListener);
                    } else if (object instanceof JComboBox<?>) {
                        ((JComboBox<?>) object).addActionListener(actionListener);
                    } else {
                        LOGGER.error("Cannot add ActionListener to field {} of type {}", field.getName(), object.getClass().getCanonicalName());
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            LOGGER.error("Error while attaching action:", e);
        }
        return this;
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
        initButtonsActionCommands();

        return this;
    }

    public <C extends JComponent> JPanelEnchancer standardActionsForComponent(Class<C> type, Consumer<C> action) {
        new ImmutableList.Builder<Field>()
                .add(panel.getClass().getSuperclass().getDeclaredFields())
                .add(panel.getClass().getDeclaredFields())
                .build()
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
