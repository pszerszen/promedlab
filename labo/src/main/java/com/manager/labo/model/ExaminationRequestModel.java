package com.manager.labo.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.manager.labo.utils.MappingField;
import com.manager.labo.utils.ValidDate;

public class ExaminationRequestModel {

    private static final String ZŁY_FORMAT_TELEFONU = "Zły format telefonu.";

    private static final String ZŁY_FORMAT_KODU_POCZTOWEGO = "Zły format kodu pocztowego";

    private static final String BRAK_NR_TELEFONU = "Brak nr telefonu";

    private static final String BRAK_MIASTA = "Brak miasta.";

    private static final String BRAK_KODU_POCZTOWEGO = "Brak kodu pocztowego.";

    private static final String NIE_WPROWADZONO_ADRESU = "Nie wprowadzono adresu.";

    private static final String NIEPRAWIDŁOWA_DATA = "Nieprawidłowa data.";

    private static final String NIEPRAWIDŁOWY_ZAPIS_DATY = "Nieprawidłowy zapis daty (wymagany format: dd-MM-rrrr)";

    private static final String BRAK_DATY_URODZENIA = "Brak daty urodzenia.";

    private static final String NIEPRAWIDŁOWY_FORMAT_NR_PESEL = "Nieprawidłowy format nr PESEL.";

    private static final String BRAK_NAZWISKA = "Brak nazwiska.";

    private static final String BRAK_IMIENIA = "Brak imienia.";

    private Long examinationId;

    @MappingField
    @NotNull(message = BRAK_IMIENIA)
    private String firstName;

    @MappingField
    @NotNull(message = BRAK_NAZWISKA)
    private String lastName;

    @MappingField
    @Pattern(regexp = "(\\d{11})?", message = NIEPRAWIDŁOWY_FORMAT_NR_PESEL)
    private String pesel;

    @MappingField
    @NotNull(message = BRAK_DATY_URODZENIA)
    @Pattern(regexp = "\\d{4}(-\\d{2}){2}", message = NIEPRAWIDŁOWY_ZAPIS_DATY)
    @ValidDate(message = NIEPRAWIDŁOWA_DATA)
    private String birthDay;

    @MappingField
    @NotNull(message = NIE_WPROWADZONO_ADRESU)
    private String address1;

    @MappingField
    private String address2;

    @MappingField
    @NotNull(message = BRAK_KODU_POCZTOWEGO)
    @Pattern(regexp = "\\d{2}-\\d{3}", message = ZŁY_FORMAT_KODU_POCZTOWEGO)
    private String zipCode;

    @MappingField
    @NotNull(message = BRAK_MIASTA)
    private String city;

    @MappingField
    @NotNull(message = BRAK_NR_TELEFONU)
    @Pattern(regexp = "(\\(\\+\\d{2}\\))* ?\\d{9}", message = ZŁY_FORMAT_TELEFONU)
    private String phone;

    @Valid
    private List<ExaminationSummaryModel> examinations = new ArrayList<>();

    public Long getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Long examinationId) {
        this.examinationId = examinationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<ExaminationSummaryModel> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<ExaminationSummaryModel> examinations) {
        this.examinations = examinations;
    }

    public void addExamination(ExaminationSummaryModel examinationSummaryModel) {
        if (examinations == null) {
            examinations = new ArrayList<>();
        }
        examinations.add(examinationSummaryModel);
    }

    public void removeExamination(ExaminationSummaryModel examinationSummaryModel) {
        if (examinations == null) {
            examinations = new ArrayList<>();
        }
        examinations.remove(examinationSummaryModel);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(examinationId)
                .append(firstName)
                .append(lastName)
                .append(pesel)
                .append(address1)
                .append(address2)
                .append(zipCode)
                .append(city)
                .append(phone)
                .append(examinations)
                .build();
    }

}
