package org.kodejava.example.mybatis.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.kodejava.example.mybatis.domain.Record;

@Component
public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> c) {
        return Record.class.isAssignableFrom(c);
    }

    public void validate(Object command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "releaseDate", "field.standard.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "artistId", "field.age.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "labelId", "field.sex.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "created", "field.standard.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modified", "field.standard.empty");
        Record recordBean = (Record) command;
        if (recordBean.getArtistId() == null || recordBean.getArtistId() == 0) {
            errors.rejectValue("artistId", "field.age.NAN");
        }
        if (recordBean.getLabelId() == null || recordBean.getLabelId() == 0) {
            errors.rejectValue("labelId", "field.age.NAN");
        }
    }
}
