package com.manager.labo.view;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.JTextComponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.manager.labo.model.ExaminationRequestModel;
import com.manager.labo.model.ExaminationSummaryModel;
import com.manager.labo.model.PatientModel;
import com.manager.labo.utils.ActionCommand;
import com.manager.labo.utils.ActionCommands;
import com.manager.labo.utils.MappingField;
import com.manager.labo.view.components.JPanelEnchancer;
import com.manager.labo.view.components.LaboTableModel;
import com.manager.labo.view.components.TableModelName;

public class ExaminationDetails extends JPanel {

    private static final long serialVersionUID = -8066527372257354621L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExaminationDetails.class);

    private ExaminationRequestModel model;

    private LaboTableModel<ExaminationSummaryModel> examinationTableModel;

    private JTextField firstName;

    private JTextField lastName;

    private JTextField pesel;

    private JTextField zipCode;

    private JTextField address2;

    private JTextField address1;

    private JTextField city;

    private JTextField phone;

    private JLabel lblListaBada;

    private JTable table;

    private JComboBox<String> availableExamination;

    @ActionCommand(ActionCommands.ADD_TO_EXAMINATIONS)
    private JButton addToExaminations;

    @ActionCommand(ActionCommands.REMOVE_FROM_EXAMINATIONS)
    private JButton removeFromExaminations;

    private JLabel lblTelefon;

    private JLabel lblMiasto;

    private JLabel lblKodPocztowy;

    private JLabel lblAdresCd;

    private JLabel lblAdres;

    private JLabel lblPesel;

    private JLabel lblNazwisko;

    private JLabel lblImi;

    @ActionCommand(ActionCommands.SEARCH_FOR_PATIENT)
    private JButton searchForPatient;

    @ActionCommand(ActionCommands.SWITCH_AVAILABLE_EXAMINATIONS)
    private JComboBox<String> examinationGroup;

    private JTextField birthDay;

    @ActionCommand(ActionCommands.EXAMINATION_SUBMIT)
    private JButton submit;

    @ActionCommand(ActionCommands.EXIT)
    private JButton exit;

    private JLabel lblWykonujcyBadanie;

    private JTextField examiner;

    private JLabel lblWynikBadania;

    private JSpinner examinationValue;

    private JButton addExaminationValue;

    private JLabel lblDataUrodzenia;

    private JLabel lblGrupaBada;

    public ExaminationDetails() {
        this(null);
    }

    public ExaminationDetails(ExaminationRequestModel model) {
        setSize(new Dimension(1000, 700));
        setMinimumSize(new Dimension(1200, 700));
        setLayout(null);

        lblImi = new JLabel("Imię");
        lblImi.setBounds(10, 31, 80, 14);
        add(lblImi);

        firstName = new JTextField();
        firstName.setBounds(109, 28, 120, 20);
        add(firstName);
        firstName.setColumns(10);

        lblNazwisko = new JLabel("Nazwisko");
        lblNazwisko.setBounds(10, 56, 80, 14);
        add(lblNazwisko);

        lastName = new JTextField();
        lastName.setBounds(109, 53, 120, 20);
        add(lastName);
        lastName.setColumns(10);

        lblPesel = new JLabel("PESEL");
        lblPesel.setBounds(10, 109, 80, 14);
        add(lblPesel);

        pesel = new JTextField();
        pesel.setBounds(109, 106, 120, 20);
        add(pesel);
        pesel.setColumns(10);

        lblAdres = new JLabel("Adres");
        lblAdres.setBounds(313, 31, 80, 14);
        add(lblAdres);

        lblAdresCd = new JLabel("Adres cd");
        lblAdresCd.setBounds(313, 56, 80, 14);
        add(lblAdresCd);

        lblKodPocztowy = new JLabel("Kod Pocztowy");
        lblKodPocztowy.setBounds(313, 81, 80, 14);
        add(lblKodPocztowy);

        lblMiasto = new JLabel("Miasto");
        lblMiasto.setBounds(511, 81, 80, 14);
        add(lblMiasto);

        zipCode = new JTextField();
        zipCode.setBounds(403, 78, 86, 20);
        add(zipCode);
        zipCode.setColumns(10);

        address2 = new JTextField();
        address2.setBounds(403, 53, 188, 20);
        add(address2);
        address2.setColumns(10);

        address1 = new JTextField();
        address1.setBounds(403, 28, 188, 20);
        add(address1);
        address1.setColumns(10);

        city = new JTextField();
        city.setBounds(558, 78, 149, 20);
        add(city);
        city.setColumns(10);

        lblTelefon = new JLabel("Telefon");
        lblTelefon.setBounds(313, 106, 80, 14);
        add(lblTelefon);

        phone = new JTextField();
        phone.setBounds(403, 103, 120, 20);
        add(phone);
        phone.setColumns(10);

        lblListaBada = new JLabel("Lista badań");
        lblListaBada.setBounds(10, 222, 80, 14);
        add(lblListaBada);

        availableExamination = new JComboBox<String>();
        availableExamination.setBounds(104, 219, 603, 20);
        add(availableExamination);

        addToExaminations = new JButton("Dodaj do zlecenia");
        addToExaminations.setBounds(717, 218, 230, 23);
        add(addToExaminations);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(new TitledBorder(null, "Lista zleconych bada\u0144", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        scrollPane.setBounds(10, 269, 697, 246);
        add(scrollPane);

        examinationTableModel = new LaboTableModel<>(TableModelName.EXAMINATIONS_SET, "Kod badania", "Nazwa Badania", "Badający", "Wynik");

        table = new JTable(examinationTableModel);
        scrollPane.setViewportView(table);

        removeFromExaminations = new JButton("Usuń wybrane badanie z listy");
        removeFromExaminations.setBounds(717, 281, 230, 23);
        add(removeFromExaminations);

        this.model = Optional.ofNullable(model).orElse(new ExaminationRequestModel());

        searchForPatient = new JButton("<html>Szukaj<br/>pacjenta</html>");
        searchForPatient.setBounds(109, 130, 120, 37);
        add(searchForPatient);

        lblGrupaBada = new JLabel("Grupa badań");
        lblGrupaBada.setBounds(10, 194, 80, 14);
        add(lblGrupaBada);

        examinationGroup = new JComboBox<String>();
        examinationGroup.setBounds(104, 191, 603, 20);
        add(examinationGroup);

        lblDataUrodzenia = new JLabel("Data Urodzenia");
        lblDataUrodzenia.setBounds(10, 81, 123, 14);
        add(lblDataUrodzenia);

        birthDay = new JTextField();
        birthDay.setBounds(109, 78, 120, 20);
        add(birthDay);
        birthDay.setColumns(10);

        submit = new JButton("Zapisz");
        submit.setBounds(717, 541, 89, 23);
        add(submit);

        exit = new JButton("Wyjdź");
        exit.setBounds(717, 575, 89, 23);
        add(exit);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Wprowad\u017A wynik badania", TitledBorder.LEFT, TitledBorder.TOP, null, null));
        panel.setBounds(717, 315, 230, 207);
        add(panel);
        panel.setLayout(null);

        lblWykonujcyBadanie = new JLabel("Wykonujący badanie");
        lblWykonujcyBadanie.setBounds(10, 24, 210, 14);
        panel.add(lblWykonujcyBadanie);

        examiner = new JTextField();
        examiner.setBounds(10, 44, 210, 20);
        panel.add(examiner);
        examiner.setColumns(10);

        lblWynikBadania = new JLabel("Wynik badania");
        lblWynikBadania.setBounds(10, 75, 220, 14);
        panel.add(lblWynikBadania);

        examinationValue = new JSpinner();
        examinationValue.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
        examinationValue.setBounds(10, 100, 210, 20);
        final JComponent editor = examinationValue.getEditor();
        JFormattedTextField formattedTextField = (JFormattedTextField) editor.getComponent(0);
        DefaultFormatter formatter = (DefaultFormatter) formattedTextField.getFormatter();
        formatter.setCommitsOnValidEdit(true);
        panel.add(examinationValue);

        addExaminationValue = new JButton("Dodaj wynik badań");
        addExaminationValue.setBounds(10, 173, 210, 23);
        addExaminationValue.addActionListener(e -> {
            for (int row : table.getSelectedRows()) {
                model.getExaminations().get(row).setStaffNameAndValue(examiner.getText(), (int) examinationValue.getValue());
            }
            mountValuesFromModel();
        });
        panel.add(addExaminationValue);

        if (model != null) {
            mountValuesFromModel();

            setComponentsEnabled(false, firstName, lastName, pesel, zipCode, address1, address2, city, phone, examinationGroup, availableExamination,
                    addToExaminations, removeFromExaminations, searchForPatient, birthDay);
        } else {
            setComponentsEnabled(false, lblWykonujcyBadanie, examiner, lblWynikBadania, examinationValue, addExaminationValue);
        }

        new JPanelEnchancer(this).standardActions();
    }

    public ExaminationRequestModel getModel() {
        return model;
    }

    public void mountValuesFromModel(PatientModel patientModel) {
        mappingOperation(patientModel, this::setUpSwingComponentValues);
    }

    public void loadValuesToModel() {
        mappingOperation(model, this::setUpModelValues);

        model.getExaminations().clear();
        model.getExaminations().addAll(examinationTableModel.getModelList());
    }

    public void initExaminationGroups(List<String> groups) {
        groups.stream().forEach(examinationGroup::addItem);
    }

    public String getCurrentExaminationGroup() {
        final String selectedItem = (String) examinationGroup.getSelectedItem();
        return selectedItem.substring(0, 1);
    }

    public void rewriteAvailableExaminations(List<String> examinations) {
        availableExamination.removeAllItems();
        examinations.stream().forEach(availableExamination::addItem);
    }

    public String getPesel() {
        return pesel.getText();
    }

    public String getCurrentExamination() {
        final String selectedItem = (String) availableExamination.getSelectedItem();
        return selectedItem.substring(0, 3);
    }

    public void addExaminationDetail(ExaminationSummaryModel model) {
        examinationTableModel.addRow(model);
    }

    public void removeSelectedExamiantionFromTable() {
        final int selectedRow = table.getSelectedRow();
        if (selectedRow > -1) {
            examinationTableModel.removeRow(selectedRow);
        }
    }

    public void mountValuesFromModel(Object model) {
        mappingOperation(model, this::setUpSwingComponentValues);
    }

    public void enableExaminationGroup(boolean enable) {
        setComponentsEnabled(enable && examinationTableModel.getRowCount() < 1, examinationGroup);
    }

    private void setComponentsEnabled(boolean enabled, JComponent... components) {
        for (JComponent component : components) {
            component.setEnabled(enabled);
        }
    }

    private void mountValuesFromModel() {
        mappingOperation(model, this::setUpSwingComponentValues);

        examinationTableModel.setNumRows(0);
        examinationTableModel.addRows(model.getExaminations());
    }

    private void mappingOperation(Object model, TriConsumer consumer) {
        try {
            for (Field field : model.getClass().getDeclaredFields()) {
                final MappingField mappingField = field.getAnnotation(MappingField.class);
                if (mappingField != null) {
                    final String mappingName = Optional
                            .ofNullable(Strings.emptyToNull(
                                    mappingField.value().trim()))
                            .orElse(field.getName());
                    field.setAccessible(true);
                    final Field swingField = this.getClass().getDeclaredField(mappingName);
                    swingField.setAccessible(true);
                    consumer.accept(model, field, (JTextComponent) swingField.get(this));
                }
            }
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException e) {
            LOGGER.error("Error during mapping values with UI.", e);
        }
    }

    private void setUpModelValues(Object model, Field field, JTextComponent component) {
        try {
            field.set(model, component.getText());
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void setUpSwingComponentValues(Object model, Field field, JTextComponent component) {
        Object object;
        try {
            object = field.get(model);
            component.setText(object != null ? object.toString() : "");
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    private interface TriConsumer {

        void accept(Object model, Field field, JTextComponent component);
    }
}
