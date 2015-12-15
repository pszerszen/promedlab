package com.manager.labo.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import com.manager.labo.utils.ActionCommands;
import com.manager.labo.view.components.JPanelEnchancer;
import com.manager.labo.view.components.LaboTableModel;

public abstract class ListPanel<T> extends JPanel {

    private static final long serialVersionUID = -3579109254796950348L;

    private static final String SEE = "See";
    
    private static final String RELOAD = "Reload";

    private JTable table;

    protected LaboTableModel<T> tableModel;

    protected JButton action;

    private JButton reload;

    private JButton back;

    public ListPanel() {
        super();
        
        setSize(new Dimension(1000, 570));
        setMinimumSize(new Dimension(1000, 570));
        setLayout(null);

        initTableModel();

        table = new JTable();
        table.setModel(tableModel);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 11, 980, 458);
        add(scrollPane);

        action = new JButton(getActionButtonText());
        action.setBackground(new Color(51, 204, 0));
        action.setBounds(671, 513, 170, 57);
        action.setActionCommand(getTypePrefix() + SEE);
        add(action);

        reload = new JButton("Przeładuj");
        reload.setIcon(new ImageIcon(ListPanel.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
        reload.setBackground(new Color(255, 0, 0));
        reload.setBounds(851, 513, 139, 57);
        reload.setActionCommand(getTypePrefix() + RELOAD);
        add(reload);
        
        back = new JButton("Wróć");
        back.setBackground(new Color(0, 153, 255));
        back.setIcon(new ImageIcon(ListPanel.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
        back.setBounds(10, 513, 89, 57);
        back.setActionCommand(ActionCommands.BACK);
        add(back);
        
        new JPanelEnchancer(this).standardActions();
    }

    protected abstract void initTableModel();

    protected abstract String getTypePrefix();

    protected abstract String getActionButtonText();

    public T getCurrentModel() {
        return tableModel.getRowAsModel(table.getSelectedRow());
    }

    public void reloadTable(List<T> models) {
        tableModel.setRowCount(0);
        tableModel.addRows(models);
    }
}
