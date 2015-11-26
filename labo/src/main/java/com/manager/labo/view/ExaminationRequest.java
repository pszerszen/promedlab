package com.manager.labo.view;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.function.Consumer;
import java.awt.Component;

/**
 * @author pszerszen
 */
public class ExaminationRequest extends JPanel {

    private static final long serialVersionUID = 1132174189890044140L;

    private JTextField series;
    private JTextField dayNumber;
    private JTextField requestCode;
    private JTextField pesel;
    private JTextField lastName;
    private JTextField firstName;
    private JComboBox<String> gender;
    private JTextField city;
    private JTextField zipCode;
    private JTextField address;
    private JTextField country;
    private JTextField requestingDoctor;
    private JTextField client;
    private JTextField nrKg;
    private JTable examinationTable;
    private DefaultTableModel examinationTableModel;
    private JTextField discount;
    private JTable materialTable;
    private DefaultTableModel materialTableModel;
    private JComboBox<String> registrationDate;
    private JComboBox<String> requestType;
    private JCheckBox chckbxUnknownBirthday;
    private JButton szukajPesel;
    private JButton btnLekarzZlec;
    private JButton btnKlient;
    private JButton btnOznaczMateriaJako;
    private JButton btnDodaj;
    private JButton btnUsu;
    private JButton btnEdytuj;
    private JButton btnProfile;

    public ExaminationRequest() {
        setSize(new Dimension(1000, 700));
        setMinimumSize(new Dimension(1200, 700));
        setLayout(null);

        JLabel lblNewLabel = new JLabel("Seria");
        lblNewLabel.setBounds(10, 11, 50, 14);
        add(lblNewLabel);

        series = new JTextField();
        series.setBounds(10, 35, 50, 20);
        add(series);
        series.setColumns(10);

        JLabel lblNumerDzienny = new JLabel("Numer dzienny");
        lblNumerDzienny.setBounds(70, 11, 101, 14);
        add(lblNumerDzienny);

        dayNumber = new JTextField();
        dayNumber.setBounds(70, 35, 101, 20);
        add(dayNumber);
        dayNumber.setColumns(10);

        JLabel lblDatagodzinaRejestracjiZlecenia = new JLabel("Data/godzina rejestracji zlecenia");
        lblDatagodzinaRejestracjiZlecenia.setBounds(181, 11, 210, 14);
        add(lblDatagodzinaRejestracjiZlecenia);

        registrationDate = new JComboBox<>();
        registrationDate.setBounds(181, 35, 210, 20);
        add(registrationDate);

        JLabel lblKodKreskowyZlecenia = new JLabel("Kod kreskowy zlecenia");
        lblKodKreskowyZlecenia.setBounds(425, 11, 135, 14);
        add(lblKodKreskowyZlecenia);

        JLabel lblTrybZlecenia = new JLabel("Tryb zlecenia");
        lblTrybZlecenia.setBounds(642, 11, 77, 14);
        add(lblTrybZlecenia);

        requestCode = new JTextField();
        requestCode.setBounds(425, 35, 135, 20);
        add(requestCode);
        requestCode.setColumns(10);

        requestType = new JComboBox<>();
        requestType.setBounds(642, 35, 135, 20);
        add(requestType);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Dane pacjenta", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel.setBounds(10, 77, 402, 420);
        add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 14, 110, 395);
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblPesel = new JLabel("Pesel");
        panel_1.add(lblPesel);

        JLabel lblNewLabel_1 = new JLabel("Nazwisko");
        panel_1.add(lblNewLabel_1);

        JLabel lblImi = new JLabel("Imię");
        panel_1.add(lblImi);

        JLabel lblPe = new JLabel("Płeć");
        panel_1.add(lblPe);

        JLabel lblDataUrodzenia = new JLabel("Data urodzenia");
        panel_1.add(lblDataUrodzenia);

        JLabel lblMiasto = new JLabel("Miasto");
        panel_1.add(lblMiasto);

        JLabel lblKodPocztowy = new JLabel("Kod pocztowy");
        panel_1.add(lblKodPocztowy);

        JLabel lblAdresPacjenta = new JLabel("Adres pacjenta");
        panel_1.add(lblAdresPacjenta);

        JLabel lblKraj = new JLabel("Kraj");
        panel_1.add(lblKraj);

        btnLekarzZlec = new JButton("Lekarz zlec.");
        panel_1.add(btnLekarzZlec);

        btnKlient = new JButton("Klient");
        panel_1.add(btnKlient);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(130, 14, 262, 395);
        panel.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_2);

        pesel = new JTextField();
        panel_2.add(pesel);
        pesel.setColumns(15);

        szukajPesel = new JButton("");
        szukajPesel.setAlignmentX(Component.CENTER_ALIGNMENT);
        szukajPesel.setBounds(new Rectangle(0, 0, 10, 10));
        szukajPesel.setSize(new Dimension(10, 10));
        panel_2.add(szukajPesel);

        JPanel panel_4 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_4);

        lastName = new JTextField();
        lastName.setColumns(15);
        panel_4.add(lastName);

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_5);

        firstName = new JTextField();
        firstName.setColumns(15);
        panel_5.add(firstName);

        JPanel panel_6 = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
        flowLayout_3.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_6);

        gender = new JComboBox<>();
        gender.setPreferredSize(new Dimension(70, 20));
        gender.setModel(new DefaultComboBoxModel<>(new String[] {"M", "K" }));
        panel_6.add(gender);

        JPanel panel_7 = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
        flowLayout_4.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_7);

        JComboBox<String> birthDate = new JComboBox<>();
        birthDate.setPreferredSize(new Dimension(70, 20));
        panel_7.add(birthDate);

        chckbxUnknownBirthday = new JCheckBox("Nieznana data urodzenia");
        panel_7.add(chckbxUnknownBirthday);

        JPanel panel_8 = new JPanel();
        FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
        flowLayout_5.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_8);

        city = new JTextField();
        city.setColumns(15);
        panel_8.add(city);

        JPanel panel_9 = new JPanel();
        FlowLayout flowLayout_6 = (FlowLayout) panel_9.getLayout();
        flowLayout_6.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_9);

        zipCode = new JTextField();
        zipCode.setColumns(7);
        panel_9.add(zipCode);

        JPanel panel_10 = new JPanel();
        FlowLayout flowLayout_7 = (FlowLayout) panel_10.getLayout();
        flowLayout_7.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_10);

        address = new JTextField();
        address.setColumns(22);
        panel_10.add(address);

        JPanel panel_11 = new JPanel();
        FlowLayout flowLayout_8 = (FlowLayout) panel_11.getLayout();
        flowLayout_8.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_11);

        country = new JTextField();
        country.setColumns(8);
        panel_11.add(country);

        JLabel lblblNumerKg = new JLabel();
        lblblNumerKg.setText("Numer KG");
        panel_11.add(lblblNumerKg);

        nrKg = new JTextField();
        panel_11.add(nrKg);
        nrKg.setColumns(8);

        JPanel panel_12 = new JPanel();
        FlowLayout flowLayout_9 = (FlowLayout) panel_12.getLayout();
        flowLayout_9.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_12);

        requestingDoctor = new JTextField();
        requestingDoctor.setColumns(15);
        panel_12.add(requestingDoctor);

        JPanel panel_13 = new JPanel();
        FlowLayout flowLayout_10 = (FlowLayout) panel_13.getLayout();
        flowLayout_10.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_13);

        client = new JTextField();
        client.setColumns(15);
        panel_13.add(client);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new TitledBorder(null, "Uwagi do zlecenia:", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel_14.setBounds(10, 519, 402, 129);
        add(panel_14);
        panel_14.setLayout(new GridLayout(0, 1, 0, 0));

        JTextArea comments = new JTextArea();
        panel_14.add(comments);

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new TitledBorder(null, "Lista zleconych bada\u0144", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel_15.setBounds(425, 77, 565, 420);
        add(panel_15);
        panel_15.setLayout(null);
        examinationTableModel = new DefaultTableModel(
                new String[] {"Kod badania", "Nazwa", "Uwagi", "Wartość"
                }, 0) {
            private static final long serialVersionUID = -5462480773278412043L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<String> getColumnClass(int columnIndex) {
                return String.class;
            }

        };

        examinationTable = new JTable();
        examinationTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        examinationTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        examinationTable.setModel(examinationTableModel);

        JScrollPane scrollPane_1 = new JScrollPane(examinationTable);
        scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_1.setBounds(10, 20, 446, 356);
        panel_15.add(scrollPane_1);
        scrollPane_1.setLayout(new ScrollPaneLayout());

        btnDodaj = new JButton("Dodaj");
        btnDodaj.setBounds(466, 20, 89, 23);
        panel_15.add(btnDodaj);

        btnUsu = new JButton("Usuń");
        btnUsu.setBounds(466, 52, 89, 23);
        panel_15.add(btnUsu);

        btnEdytuj = new JButton("Edytuj");
        btnEdytuj.setBounds(466, 86, 89, 23);
        panel_15.add(btnEdytuj);

        btnProfile = new JButton("Profile");
        btnProfile.setBounds(466, 136, 89, 23);
        panel_15.add(btnProfile);

        JLabel lblblRabat = new JLabel();
        lblblRabat.setText("Rabat, %");
        lblblRabat.setBounds(246, 387, 89, 22);
        panel_15.add(lblblRabat);

        discount = new JTextField();
        discount.setHorizontalAlignment(SwingConstants.TRAILING);
        discount.setText("0");
        discount.setBounds(345, 388, 117, 21);
        panel_15.add(discount);
        discount.setColumns(10);

        JPanel panel_16 = new JPanel();
        panel_16.setBorder(new TitledBorder(null, "Lista materia\u0142u do pobrania", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_16.setBounds(425, 519, 565, 129);
        add(panel_16);
        panel_16.setLayout(null);

        materialTableModel = new DefaultTableModel(
                new String[] {"Materiał", "Pobrany przez"
                }, 0) {
            private static final long serialVersionUID = -5462480773278412043L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<String> getColumnClass(int columnIndex) {
                return String.class;
            }

        };

        materialTable = new JTable();
        materialTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        materialTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        materialTable.setModel(materialTableModel);

        JScrollPane scrollPane_2 = new JScrollPane(materialTable);
        scrollPane_2.setBounds(10, 20, 405, 100);
        scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel_16.add(scrollPane_2);
        scrollPane_2.setLayout(new ScrollPaneLayout());

        btnOznaczMateriaJako = new JButton("<html>Oznacz materiał jako pobrany</html>");
        btnOznaczMateriaJako.setHorizontalTextPosition(SwingConstants.CENTER);
        btnOznaczMateriaJako.setBounds(425, 21, 130, 57);
        panel_16.add(btnOznaczMateriaJako);

        standardActions();
    }

    public void addListeners(ActionListener actionListener, KeyListener keyListener) {
        Arrays.asList(getClass().getDeclaredFields())
                .stream()
                .filter(field -> field.getType().equals(JButton.class))
                .forEach(buttonField -> {
                    try {
                        final JButton button = (JButton) buttonField.get(this);
                        button.addActionListener(actionListener);
                        button.addKeyListener(keyListener);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    private void standardActions() {
        final Font calibriPlain14 = new Font("Calibri", Font.PLAIN, 14);
        standardActionsForComponent(JButton.class, jButton -> {
            jButton.setFont(calibriPlain14);
        });
        standardActionsForComponent(JLabel.class, label -> {
            label.setFont(calibriPlain14);
        });
    }

    private <C extends JComponent> void standardActionsForComponent(Class<C> type, Consumer<C> action) {
        Arrays.asList(getClass().getDeclaredFields())
                .stream()
                .filter(field -> field.getType().equals(type))
                .forEach(componentField -> {
                    try {
                        @SuppressWarnings("unchecked")
                        C comp = (C) componentField.get(this);
                        action.accept(comp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

}
