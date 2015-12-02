package com.manager.labo.view;

import com.manager.labo.model.ExaminationModel;
import com.manager.labo.view.components.LaboTableModel;
import com.manager.labo.view.components.TableModelName;

public class ExaminationList extends ListPanel<ExaminationModel> {
    public ExaminationList() {
    }

    private static final long serialVersionUID = -3461903130827603302L;

    private static final String EXAMINATION = "Examination-";

    @Override
    protected void initTableModel() {
        tableModel = new LaboTableModel<>(TableModelName.REQUESTS, "Data Zlecenia", "Kod badania", "PESEL", "Nazwisko", "Imię", "Adres", "Telefon");
    }

    @Override
    protected String getTypePrefix() {
        return EXAMINATION;
    }

}
