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
import com.manager.labo.view.components.TableModelName;

public class ExaminationList extends JPanel {

    private static final long serialVersionUID = -3461903130827603302L;

    private JTable table;

    private LaboTableModel tableModel;

    @ActionCommand("Examination-See")
    private JButton btnSee;

    @ActionCommand("Examination-Add")
    private JButton btnDodaj;

    @ActionCommand("Examination-Del")
    private JButton btnUsu;

    @ActionCommand("Examination-Edit")
    private JButton btnEdytuj;

    @ActionCommand("Exit")
    private JButton btnZamknij;

    public ExaminationList() {
        setSize(new Dimension(1000, 570));
        setMinimumSize(new Dimension(1000, 570));
        setLayout(null);

        // TODO columns
        tableModel = new LaboTableModel<>(TableModelName.REQUESTS, "Data Zlecenia", "Kod badania", "PESEL", "Nazwisko", "Imię", "Adres", "Telefon");

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

        btnDodaj = new JButton("Dodaj");
        btnDodaj.setBackground(new Color(0, 204, 102));
        btnDodaj.setBounds(379, 513, 89, 23);
        add(btnDodaj);

        btnUsu = new JButton("Usuń");
        btnUsu.setBounds(705, 513, 89, 23);
        add(btnUsu);

        btnEdytuj = new JButton("Edytuj");
        btnEdytuj.setBounds(577, 513, 89, 23);
        add(btnEdytuj);

        btnZamknij = new JButton("Zamknij");
        btnZamknij.setBounds(901, 513, 89, 23);
        add(btnZamknij);

        btnSee = new JButton("Zobacz");
        btnSee.setBounds(478, 513, 89, 23);
        add(btnSee);

        new JPanelEnchancer(this).standardActions().initButtonsActionCommands();
    }
}
