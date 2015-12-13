package com.manager.labo.view;

import com.manager.labo.model.PatientModel;
import com.manager.labo.view.components.LaboTableModel;
import com.manager.labo.view.components.TableModelName;

public class PatientList extends ListPanel<PatientModel> {

    private static final long serialVersionUID = 4187893120379148890L;

    private static final String PATIENT = "Patient-";

    @Override
    protected void initTableModel() {
        tableModel = new LaboTableModel<PatientModel>(TableModelName.PATIENTS, "PESEL", "Nazwisko", "Imię", "Adres", "Telefon");
    }

    @Override
    protected String getTypePrefix() {
        return PATIENT;
    }

}
