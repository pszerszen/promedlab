package com.manager.labo.view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import com.manager.labo.view.components.JPanelEnchancer;
import com.manager.labo.view.components.LaboTableModel;
import com.manager.labo.view.components.TableModelName;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ExaminationList extends JPanel {

    private static final long serialVersionUID = -3461903130827603302L;

    private JTable table;
    private LaboTableModel tableModel;
    private JTextField textField;

    public ExaminationList() {
        setSize(new Dimension(1000, 700));
        setMinimumSize(new Dimension(1200, 700));
        setLayout(null);

        // TODO columns
        tableModel = new LaboTableModel<>(TableModelName.REQUESTS, "M", "B", "T", "Nr. dzien", "Kod kreskowy", "Nazwisko", "Imię", "Zlecający",
                "Zarejstrował", "Uwagi", "Pesel", "Data rejestracji", "Nr pełny");

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

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Filtry", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel.setBounds(10, 480, 980, 175);
        add(panel);
        panel.setLayout(null);

        JCheckBox chckbxPokazujAnulowane = new JCheckBox("Pokazuj anulowane");
        chckbxPokazujAnulowane.setBounds(6, 19, 219, 23);
        panel.add(chckbxPokazujAnulowane);

        JLabel lblFiltrTekstowy = new JLabel("Filtr tekstowy");
        lblFiltrTekstowy.setBounds(6, 45, 90, 14);
        panel.add(lblFiltrTekstowy);

        textField = new JTextField();
        textField.setBounds(88, 42, 830, 20);
        panel.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("");
        button.setBounds(928, 39, 42, 23);
        panel.add(button);

        JCheckBox chckbxZakresDat = new JCheckBox("Zakres dat");
        chckbxZakresDat.setBounds(6, 70, 90, 23);
        panel.add(chckbxZakresDat);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(127, 70, 103, 20);
        panel.add(comboBox);

        JLabel lblOd = new JLabel("Od");
        lblOd.setBounds(98, 73, 21, 14);
        panel.add(lblOd);

        JLabel lblDo = new JLabel("Do");
        lblDo.setBounds(250, 73, 21, 14);
        panel.add(lblDo);

        JComboBox<String> comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(279, 70, 103, 20);
        panel.add(comboBox_1);

        JCheckBox chckbxNewCheckBox = new JCheckBox("Pokazuj tylko zlecenia z wybranej lokalizacji");
        chckbxNewCheckBox.setBounds(6, 110, 347, 23);
        panel.add(chckbxNewCheckBox);

        JButton btnDodaj = new JButton("Dodaj");
        btnDodaj.setBounds(511, 666, 89, 23);
        add(btnDodaj);

        JButton btnUsu = new JButton("Usuń");
        btnUsu.setBounds(610, 666, 89, 23);
        add(btnUsu);

        JButton btnEdytuj = new JButton("Edytuj");
        btnEdytuj.setBounds(707, 666, 89, 23);
        add(btnEdytuj);

        JButton btnZamknij = new JButton("Zamknij");
        btnZamknij.setBounds(901, 666, 89, 23);
        add(btnZamknij);

        new JPanelEnchancer(this).standardActions();
    }
}
