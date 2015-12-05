package com.manager.labo.view;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.manager.labo.model.ExaminationModel;
import com.manager.labo.model.ExaminationRequestModel;
import com.manager.labo.utils.MappingField;
import com.manager.labo.view.components.JPanelEnchancer;
import com.manager.labo.view.components.LaboTableModel;
import com.manager.labo.view.components.TableModelName;

public class ExaminationDetails extends JPanel {
    
    private static final long serialVersionUID = -8066527372257354621L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExaminationDetails.class);
    
    private ExaminationRequestModel model;

    private LaboTableModel<ExaminationModel> examinationTableModel;

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

    private JButton addToExaminations;

    private JButton removeFromExaminations;

    private JLabel lblTelefon;

    private JLabel lblMiasto;

    private JLabel lblKodPocztowy;

    private JLabel lblAdresCd;

    private JLabel lblAdres;

    private JLabel lblPesel;

    private JLabel lblNazwisko;

    private JLabel lblImi;
    
    public ExaminationDetails(){
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
        firstName.setBounds(104, 28, 120, 20);
        add(firstName);
        firstName.setColumns(10);

        lblNazwisko = new JLabel("Nazwisko");
        lblNazwisko.setBounds(10, 56, 80, 14);
        add(lblNazwisko);

        lastName = new JTextField();
        lastName.setBounds(104, 53, 120, 20);
        add(lastName);
        lastName.setColumns(10);

        lblPesel = new JLabel("PESEL");
        lblPesel.setBounds(10, 81, 80, 14);
        add(lblPesel);

        pesel = new JTextField();
        pesel.setBounds(104, 78, 120, 20);
        add(pesel);
        pesel.setColumns(10);

        lblAdres = new JLabel("Adres");
        lblAdres.setBounds(252, 31, 80, 14);
        add(lblAdres);

        lblAdresCd = new JLabel("Adres cd");
        lblAdresCd.setBounds(252, 56, 80, 14);
        add(lblAdresCd);

        lblKodPocztowy = new JLabel("Kod Pocztowy");
        lblKodPocztowy.setBounds(252, 81, 80, 14);
        add(lblKodPocztowy);

        lblMiasto = new JLabel("Miasto");
        lblMiasto.setBounds(450, 81, 80, 14);
        add(lblMiasto);

        zipCode = new JTextField();
        zipCode.setBounds(342, 78, 86, 20);
        add(zipCode);
        zipCode.setColumns(10);

        address2 = new JTextField();
        address2.setBounds(342, 53, 188, 20);
        add(address2);
        address2.setColumns(10);

        address1 = new JTextField();
        address1.setBounds(342, 28, 188, 20);
        add(address1);
        address1.setColumns(10);

        city = new JTextField();
        city.setBounds(497, 78, 149, 20);
        add(city);
        city.setColumns(10);

        lblTelefon = new JLabel("Telefon");
        lblTelefon.setBounds(252, 106, 80, 14);
        add(lblTelefon);

        phone = new JTextField();
        phone.setBounds(342, 103, 120, 20);
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

        examinationTableModel = new LaboTableModel<>(TableModelName.EXAMINATIONS_SET, "Kod badania", "Nazwa Badania");

        table = new JTable(examinationTableModel);
        scrollPane.setViewportView(table);

        removeFromExaminations = new JButton("Usuń wybrane badanie z listy");

        removeFromExaminations.setBounds(717, 334, 230, 23);
        add(removeFromExaminations);

        new JPanelEnchancer(this).standardActions();
        
        this.model = model;
        if(model != null){
            try {
                mountValuesFromModel();
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                LOGGER.error("Error during setting up model values on UI", e);
            }
        }
    }
    
    private void mountValuesFromModel() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        for(Field field : model.getClass().getDeclaredFields()){
            final MappingField mappingField = field.getAnnotation(MappingField.class);
            if (field.isAnnotationPresent(MappingField.class)){
                String mappingName = Optional
                        .ofNullable(Strings.emptyToNull(
                                mappingField.value().trim()))
                        .orElse(field.getName());
                field.setAccessible(true);
                final Object modelValue = field.get(model);
                final Field swingField = this.getClass().getDeclaredField(mappingName);
                swingField.setAccessible(true);
                setValueToComponent(modelValue, (JTextComponent) swingField.get(this));
            }
        }
        
        examinationTableModel.addRows(model.getExaminations());
    }
    
    private void setValueToComponent(Object value, JTextComponent component){
        component.setText(value.toString());
    }
}