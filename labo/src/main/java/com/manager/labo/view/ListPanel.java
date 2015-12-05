package com.manager.labo.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import com.manager.labo.utils.ActionCommand;
import com.manager.labo.view.components.JPanelEnchancer;
import com.manager.labo.view.components.LaboTableModel;

public abstract class ListPanel<T> extends JPanel {

    private static final long serialVersionUID = -3579109254796950348L;

    private static final String EXIT = "Exit";

    private static final String ADD = "Add";

    private static final String EDIT = "Edit";

    private static final String DEL = "Del";

    private static final String SEE = "See";

    private JTable table;

    protected LaboTableModel<T> tableModel;

    protected JButton btnSee;

    protected JButton btnAdd;

    protected JButton btnDel;

    protected JButton btnEdit;

    @ActionCommand(EXIT)
    private JButton btnClose;

    public ListPanel() {
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

        btnAdd = new JButton("Dodaj");
        btnAdd.setBackground(new Color(0, 204, 102));
        btnAdd.setBounds(379, 513, 89, 23);
        btnAdd.setActionCommand(getTypePrefix() + ADD);
        add(btnAdd);

        btnDel = new JButton("Usuń");
        btnDel.setBackground(new Color(255, 51, 51));
        btnDel.setBounds(705, 513, 89, 23);
        btnDel.setActionCommand(getTypePrefix() + DEL);
        add(btnDel);

        btnEdit = new JButton("Edytuj");
        btnEdit.setBackground(new Color(255, 153, 0));
        btnEdit.setBounds(577, 513, 89, 23);
        btnEdit.setActionCommand(getTypePrefix() + EDIT);
        add(btnEdit);

        btnSee = new JButton("Zobacz");
        btnSee.setBackground(new Color(153, 204, 255));
        btnSee.setBounds(478, 513, 89, 23);
        btnSee.setActionCommand(getTypePrefix() + SEE);
        add(btnSee);

        btnClose = new JButton("Zamknij");
        btnClose.setBounds(901, 513, 89, 23);
        btnClose.setActionCommand(EXIT);
        add(btnClose);

        new JPanelEnchancer(this).standardActions();
    }

    protected abstract void initTableModel();

    protected abstract String getTypePrefix();
}
