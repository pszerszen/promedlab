package com.manager.labo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manager.labo.entities.Icd;
import com.manager.labo.model.ExaminationModel;
import com.manager.labo.model.ExaminationRequestModel;
import com.manager.labo.model.ExaminationSummaryModel;
import com.manager.labo.model.PatientModel;
import com.manager.labo.service.ExaminationService;
import com.manager.labo.service.IcdService;
import com.manager.labo.service.PatientService;
import com.manager.labo.utils.ActionCommands;
import com.manager.labo.view.ExaminationDetails;
import com.manager.labo.view.ExaminationList;
import com.manager.labo.view.MainPanel;
import com.manager.labo.view.PatientList;
import com.manager.labo.view.components.JPanelEnchancer;

public class Controller extends JFrame implements ActionListener, WindowListener {

    private static final long serialVersionUID = -8827922871122450688L;

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private MainPanel mainPanel;

    private ExaminationList examinationList;

    private PatientList patientList;

    private ExaminationDetails examinationDetails;

    private IcdService icdService;

    private PatientService patientService;

    private ExaminationService examinationService;

    private ConfigurableApplicationContext context;

    public Controller() {
        super("PRO-LAB-MANAGER");

        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        icdService = context.getBean(IcdService.class);
        patientService = context.getBean(PatientService.class);
        examinationService = context.getBean(ExaminationService.class);

        setMainPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LOGGER.debug("Action Performed: " + e.getActionCommand());
        switch (e.getActionCommand()) {
            case "Patient-See":
                final PatientModel currentModel = patientList.getCurrentModel();
                if (currentModel != null) {
                    examinationDetails = new ExaminationDetails();
                    final PatientModel patientModel = patientService.getById(currentModel.getId());
                    examinationDetails.mountValuesFromModel(patientModel);
                    setExaminationDetailsActions();
                }
                break;
            case "Examination-See":
                final ExaminationModel currentModel2 = examinationList.getCurrentModel();
                if (currentModel2 != null) {
                    final ExaminationRequestModel examinationModel = examinationService
                            .getExaminationRequestModel(currentModel2.getId());
                    examinationDetails = new ExaminationDetails(examinationModel);
                    setExaminationDetailsActions();
                }
                break;
            case ActionCommands.BACK:
                setMainPanel();
                break;
            case "Patient-Reload":
                patientList.reloadTable(patientService.getAll());
                break;
            case "Examination-Reload":
                examinationList.reloadTable(examinationService.getAll());
                break;
        }
    }

    private void setMainPanel() {
        if (mainPanel == null) {
            mainPanel = new MainPanel();
            new JPanelEnchancer(mainPanel)
                    .addAction(ActionCommands.EXAMINATION_ADD, e -> {
                        examinationDetails = new ExaminationDetails();
                        setExaminationDetailsActions();
                    })
                    .addAction(ActionCommands.PATIENT_LIST, e -> setPatientList())
                    .addAction(ActionCommands.EXAMINATION_LIST, e -> setExaminationList());
        }
        setCurrentPanel(mainPanel);
    }

    private void setPatientList() {
        if (patientList == null) {
            patientList = new PatientList();
            new JPanelEnchancer(patientList)
                    .addListeners(this, null);
        }
        patientList.reloadTable(patientService.getAll());
        setCurrentPanel(patientList);
    }

    private void setExaminationList() {
        if (examinationList == null) {
            examinationList = new ExaminationList();
            new JPanelEnchancer(examinationList)
                    .addListeners(this, null);
        }
        examinationList.reloadTable(examinationService.getAll());
        setCurrentPanel(examinationList);
    }

    private void setExaminationDetailsActions() {
        if (examinationDetails != null) {
            examinationDetails.initExaminationGroups(icdService.getGroups());
            examinationDetails.rewriteAvailableExaminations(
                    icdService.getExaminationsFromGroup(
                            examinationDetails.getCurrentExaminationGroup()));
            new JPanelEnchancer(examinationDetails)
                    .addAction(ActionCommands.SWITCH_AVAILABLE_EXAMINATIONS, e -> {
                        examinationDetails.rewriteAvailableExaminations(
                                icdService.getExaminationsFromGroup(
                                        examinationDetails.getCurrentExaminationGroup()));
                    })
                    .addAction(ActionCommands.SEARCH_FOR_PATIENT, e -> {
                        PatientModel model = patientService.getPatientModelByPesel(examinationDetails.getPesel());
                        if (model != null) {
                            examinationDetails.mountValuesFromModel(model);
                        }
                    })
                    .addAction(ActionCommands.REMOVE_FROM_EXAMINATIONS, e -> {
                        examinationDetails.removeSelectedExamiantionFromTable();
                        examinationDetails.enableExaminationGroup(true);
                    })
                    .addAction(ActionCommands.ADD_TO_EXAMINATIONS, e -> {
                        final Icd icd = icdService.getByCode2(examinationDetails.getCurrentExamination());
                        examinationDetails.addExaminationDetail(new ExaminationSummaryModel(icd.getCode2(), icd.getName2()));
                        examinationDetails.enableExaminationGroup(false);
                    })
                    .addAction(ActionCommands.EXIT, e -> {
                        setMainPanel();
                    })
                    .addAction(ActionCommands.EXAMINATION_SUBMIT, e -> {
                        examinationDetails.loadValuesToModel();
                        final ExaminationRequestModel model = examinationDetails.getModel();
                        Set<String> errors = new HashSet<>();
                        final boolean newExamination = model.getExaminationId() == null;
                        try {
                            errors = examinationService.validate(model, !newExamination);
                            if (CollectionUtils.isNotEmpty(errors)) {
                                JPanel panel = new JPanel();
                                panel.add(new JList<>(errors.toArray(new String[errors.size()])));
                                JOptionPane.showMessageDialog(this, panel, "Błędy walidacji.", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            LOGGER.error("Error while validating:", ex);
                        }

                        if (errors.isEmpty()) {
                            if (newExamination) {
                                examinationService.create(model);
                            } else {
                                examinationService.update(model);
                            }
                            setExaminationList();
                        }

                    });

        }
        setCurrentPanel(examinationDetails);
    }

    private void setCurrentPanel(JPanel jPanel) {
        setContentPane(jPanel);
        setSize(jPanel.getWidth() + 50, jPanel.getHeight() + 50);
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        context.close();
        e.getWindow().dispose();
        this.dispose();
        System.exit(EXIT_ON_CLOSE);
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
