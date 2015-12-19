package com.manager.labo.view.components;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.table.DefaultTableModel;

import com.manager.labo.utils.DisplayInJTable;

public class LaboTableModel<M extends Object> extends DefaultTableModel {

    private static final long serialVersionUID = -1829166783442405688L;

    private final TableModelName name;

    private Map<Integer, M> modelTable;

    public LaboTableModel(TableModelName name, String... columns) {
        super(columns, 0);
        this.name = name;
        modelTable = new ConcurrentHashMap<>();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Class<String> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public void setRowCount(int rowCount) {
        modelTable.forEach((key, obj) -> {
            if (key >= rowCount) {
                modelTable.remove(key);
            }
        });
        super.setRowCount(rowCount);
    }

    public void addRows(List<M> models) {
        models.forEach(this::addRow);
    }

    public M getRowAsModel(int row) {
        return modelTable.get(row);
    }
    
    public List<M> getRowsAsModels(int... rows){
        List<M> list = new ArrayList<>();
        for(int row : rows){
            list.add(getRowAsModel(row));
        }
        return list;
    }

    public List<M> getModelList() {
        List<M> list = new ArrayList<>();
        for (int i = 0; i < modelTable.size(); i++) {
            list.add(modelTable.get(i));
        }
        return list;
    }

    public void addRow(M model) {
        Map<Integer, String> row = new HashMap<>();
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            DisplayInJTable[] displayInJTables = field.getAnnotationsByType(DisplayInJTable.class);
            for (DisplayInJTable displayInJTable : displayInJTables) {
                if (name.equals(displayInJTable.name())) {
                    try {
                        row.put(displayInJTable.order(), field.get(model).toString());
                    } catch (Exception ignore) {}
                }
            }
        }
        Object[] tableRow = new Object[row.size()];
        for (int i = 0; i < row.size(); i++) {
            tableRow[i] = row.get(i);
        }

        addRow(tableRow);
        modelTable.put(getRowCount() - 1, model);
    }

    @Override
    public void removeRow(int row) {
        modelTable.remove(row);
        super.removeRow(row);
    }
}
