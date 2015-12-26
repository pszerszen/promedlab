package com.manager.labo.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manager.labo.model.ExaminationRequestModel;
import com.manager.labo.model.ExaminationSummaryModel;
import com.manager.labo.service.impl.ExaminationServiceImpl;

public class ValidationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationTest.class);

    private ExaminationService examinationService = new ExaminationServiceImpl();

    private ExaminationRequestModel model;

    @Before
    public void setUp() {
        model = new ExaminationRequestModel();
        model.setAddress1("address1");
        model.setAddress2("address2");
        model.setCity("city");
        model.setExaminationId(0L);
        model.setFirstName("name");
        model.setLastName("surname");
        model.setPesel("91080208596");
        model.setBirthDay("1991-08-02");
        model.setPhone("798749030");
        model.setZipCode("20-570");
        model.addExamination(new ExaminationSummaryModel("A", "description A1"));
        model.addExamination(new ExaminationSummaryModel("A", "description A2"));
        model.addExamination(new ExaminationSummaryModel("A", "description A3"));
        model.addExamination(new ExaminationSummaryModel("B", "description B1"));
        model.addExamination(new ExaminationSummaryModel("B", "description B2"));
        model.addExamination(new ExaminationSummaryModel("B", "description B3"));
        model.addExamination(new ExaminationSummaryModel("C", "description C1"));
        model.addExamination(new ExaminationSummaryModel("C", "description C2"));
        model.addExamination(new ExaminationSummaryModel("C", "description C3"));
    }

    @Test
    public void testValidation() throws IllegalArgumentException, IllegalAccessException {
        assertValidationErrors(examinationService.validate(model, false));
    }

    private void assertValidationErrors(Collection<String> validationErrors, String... expectedValidationErrors) {
        Collection<String> expectedErrors = Arrays.asList(expectedValidationErrors);
        final boolean equalCollection = CollectionUtils.isEqualCollection(validationErrors, expectedErrors);
        if (!equalCollection) {
            CollectionUtils.subtract(validationErrors, expectedErrors)
                    .forEach(error -> LOGGER.error("Unexpected error: " + error));
            CollectionUtils.subtract(expectedErrors, validationErrors)
                    .forEach(error -> LOGGER.error("Expected error not hit: " + error));

        }
        assertTrue(equalCollection);
    }

}
