package com.manager.labo.view;

import javax.swing.*;

import com.manager.labo.view.components.LaboLabel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author pszerszen
 */
public class ExaminationRequest extends JPanel {

    private static final long serialVersionUID = 1132174189890044140L;

    private JTextField seria;
    private JTextField nrDzienny;
    private JTextField kodKreskowyZlecenia;
    private JTextField pesel;
    private JTextField nazwisko;
    private JTextField imie;
    private JComboBox<String> plec;
    private JTextField miasto;
    private JTextField kodPocztowy;
    private JTextField adres;
    private JTextField kraj;
    private JTextField lekarzZlec;
    private JTextField klient;
    private JTextField nrKg;
    private JTable table;
    private JTextField textField;
    private JTable table_1;

    public ExaminationRequest() {
        setSize(new Dimension(1000, 700));
        setMinimumSize(new Dimension(1200, 700));
        setLayout(null);

        LaboLabel lblNewLabel = new LaboLabel("Seria");
        lblNewLabel.setBounds(10, 11, 50, 14);
        add(lblNewLabel);

        seria = new JTextField();
        seria.setBounds(10, 35, 50, 20);
        add(seria);
        seria.setColumns(10);

        LaboLabel lblNumerDzienny = new LaboLabel("Numer dzienny");
        lblNumerDzienny.setBounds(70, 11, 101, 14);
        add(lblNumerDzienny);

        nrDzienny = new JTextField();
        nrDzienny.setBounds(70, 35, 101, 20);
        add(nrDzienny);
        nrDzienny.setColumns(10);

        LaboLabel lblDatagodzinaRejestracjiZlecenia = new LaboLabel("Data/godzina rejestracji zlecenia");
        lblDatagodzinaRejestracjiZlecenia.setBounds(181, 11, 210, 14);
        add(lblDatagodzinaRejestracjiZlecenia);

        JComboBox<String> dataRejestracji = new JComboBox<>();
        dataRejestracji.setBounds(181, 35, 210, 20);
        add(dataRejestracji);

        LaboLabel lblKodKreskowyZlecenia = new LaboLabel("Kod kreskowy zlecenia");
        lblKodKreskowyZlecenia.setBounds(425, 11, 135, 14);
        add(lblKodKreskowyZlecenia);

        LaboLabel lblTrybZlecenia = new LaboLabel("Tryb zlecenia");
        lblTrybZlecenia.setBounds(642, 11, 77, 14);
        add(lblTrybZlecenia);

        kodKreskowyZlecenia = new JTextField();
        kodKreskowyZlecenia.setBounds(425, 35, 135, 20);
        add(kodKreskowyZlecenia);
        kodKreskowyZlecenia.setColumns(10);

        JComboBox<String> trybZlecenia = new JComboBox<>();
        trybZlecenia.setBounds(642, 35, 135, 20);
        add(trybZlecenia);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Dane pacjenta", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel.setBounds(10, 77, 402, 420);
        add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 11, 110, 398);
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        LaboLabel lblPesel = new LaboLabel("Pesel");
        panel_1.add(lblPesel);

        LaboLabel lblNewLabel_1 = new LaboLabel("Nazwisko");
        panel_1.add(lblNewLabel_1);

        LaboLabel lblImi = new LaboLabel("Imię");
        panel_1.add(lblImi);

        LaboLabel lblPe = new LaboLabel("Płeć");
        panel_1.add(lblPe);

        LaboLabel lblDataUrodzenia = new LaboLabel("Data urodzenia");
        panel_1.add(lblDataUrodzenia);

        LaboLabel lblMiasto = new LaboLabel("Miasto");
        panel_1.add(lblMiasto);

        LaboLabel lblKodPocztowy = new LaboLabel("Kod pocztowy");
        panel_1.add(lblKodPocztowy);

        LaboLabel lblAdresPacjenta = new LaboLabel("Adres pacjenta");
        panel_1.add(lblAdresPacjenta);

        LaboLabel lblKraj = new LaboLabel("Kraj");
        panel_1.add(lblKraj);

        JButton btnLekarzZlec = new JButton("Lekarz zlec.");
        panel_1.add(btnLekarzZlec);

        JButton btnKlient = new JButton("Klient");
        panel_1.add(btnKlient);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(130, 11, 262, 398);
        panel.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_2);

        pesel = new JTextField();
        panel_2.add(pesel);
        pesel.setColumns(15);

        JButton szukajPesel = new JButton("");
        szukajPesel.setIcon(new ImageIcon(ExaminationRequest.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-confirm.png")));
        panel_2.add(szukajPesel);

        JPanel panel_4 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_4);

        nazwisko = new JTextField();
        nazwisko.setColumns(15);
        panel_4.add(nazwisko);

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_5);

        imie = new JTextField();
        imie.setColumns(15);
        panel_5.add(imie);

        JPanel panel_6 = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) panel_6.getLayout();
        flowLayout_3.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_6);

        plec = new JComboBox<>();
        plec.setPreferredSize(new Dimension(70, 20));
        plec.setModel(new DefaultComboBoxModel<>(new String[] {"M", "K" }));
        panel_6.add(plec);

        JPanel panel_7 = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
        flowLayout_4.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_7);

        JComboBox<String> dataUrodzenia = new JComboBox<>();
        dataUrodzenia.setPreferredSize(new Dimension(70, 20));
        panel_7.add(dataUrodzenia);

        JPanel panel_8 = new JPanel();
        FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
        flowLayout_5.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_8);

        miasto = new JTextField();
        miasto.setColumns(15);
        panel_8.add(miasto);

        JPanel panel_9 = new JPanel();
        FlowLayout flowLayout_6 = (FlowLayout) panel_9.getLayout();
        flowLayout_6.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_9);

        kodPocztowy = new JTextField();
        kodPocztowy.setColumns(7);
        panel_9.add(kodPocztowy);

        JPanel panel_10 = new JPanel();
        FlowLayout flowLayout_7 = (FlowLayout) panel_10.getLayout();
        flowLayout_7.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_10);

        adres = new JTextField();
        adres.setColumns(30);
        panel_10.add(adres);

        JPanel panel_11 = new JPanel();
        FlowLayout flowLayout_8 = (FlowLayout) panel_11.getLayout();
        flowLayout_8.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_11);

        kraj = new JTextField();
        kraj.setColumns(10);
        panel_11.add(kraj);

        LaboLabel lblblNumerKg = new LaboLabel();
        lblblNumerKg.setText("Numer KG");
        panel_11.add(lblblNumerKg);

        nrKg = new JTextField();
        panel_11.add(nrKg);
        nrKg.setColumns(10);

        JPanel panel_12 = new JPanel();
        FlowLayout flowLayout_9 = (FlowLayout) panel_12.getLayout();
        flowLayout_9.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_12);

        lekarzZlec = new JTextField();
        lekarzZlec.setColumns(15);
        panel_12.add(lekarzZlec);

        JPanel panel_13 = new JPanel();
        FlowLayout flowLayout_10 = (FlowLayout) panel_13.getLayout();
        flowLayout_10.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_13);

        klient = new JTextField();
        klient.setColumns(15);
        panel_13.add(klient);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new TitledBorder(null, "Uwagi do zlecenia:", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel_14.setBounds(10, 519, 402, 129);
        add(panel_14);
        panel_14.setLayout(new GridLayout(0, 1, 0, 0));

        JTextArea uwagi = new JTextArea();
        panel_14.add(uwagi);

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new TitledBorder(null, "Lista zleconych bada\u0144", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel_15.setBounds(425, 77, 565, 420);
        add(panel_15);
        panel_15.setLayout(null);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }));
        table.setBounds(10, 24, 452, 307);
        panel_15.add(table);

        JButton btnDodaj = new JButton("Dodaj");
        btnDodaj.setBounds(466, 20, 89, 23);
        panel_15.add(btnDodaj);

        JButton btnUsu = new JButton("Usuń");
        btnUsu.setBounds(466, 52, 89, 23);
        panel_15.add(btnUsu);

        JButton btnEdytuj = new JButton("Edytuj");
        btnEdytuj.setBounds(466, 86, 89, 23);
        panel_15.add(btnEdytuj);

        JButton btnProfile = new JButton("Profile");
        btnProfile.setBounds(466, 136, 89, 23);
        panel_15.add(btnProfile);

        LaboLabel lblblRabat = new LaboLabel();
        lblblRabat.setText("Rabat, %");
        lblblRabat.setBounds(246, 387, 89, 22);
        panel_15.add(lblblRabat);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.TRAILING);
        textField.setText("0");
        textField.setBounds(345, 388, 117, 21);
        panel_15.add(textField);
        textField.setColumns(10);

        JPanel panel_16 = new JPanel();
        panel_16.setBorder(new TitledBorder(null, "Lista materia\u0142u do pobrania", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_16.setBounds(425, 519, 565, 129);
        add(panel_16);
        panel_16.setLayout(null);

        table_1 = new JTable();
        table_1.setBounds(10, 25, 418, 93);
        panel_16.add(table_1);

        JButton btnOznaczMateriaJako = new JButton("Oznacz materiał jako pobrany");
        btnOznaczMateriaJako.setBounds(438, 21, 117, 44);
        panel_16.add(btnOznaczMateriaJako);
    }
}
