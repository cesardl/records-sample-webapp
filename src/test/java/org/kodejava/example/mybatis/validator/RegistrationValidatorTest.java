package org.kodejava.example.mybatis.validator;

import org.junit.Test;
import org.kodejava.example.mybatis.domain.Record;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.Assert.*;

public class RegistrationValidatorTest {

    private final RegistrationValidator validator = new RegistrationValidator();

    private static Record validRecord() {
        Record r = new Record();
        r.setTitle("Abbey Road");
        r.setArtistId(1);
        r.setLabelId(Integer.MAX_VALUE);
        return r;
    }

    private Errors validate(Record r) {
        Errors errors = new BeanPropertyBindingResult(r, "record");
        validator.validate(r, errors);
        return errors;
    }

    @Test
    public void validRecordPasses() {
        assertFalse(validate(validRecord()).hasErrors());
    }

    @Test
    public void idsMustBePositive() {
        for (Integer bad : new Integer[]{0, -1, Integer.MIN_VALUE}) {
            Record r = validRecord();
            r.setArtistId(bad);
            r.setLabelId(bad);
            Errors errors = validate(r);
            assertEquals("field.positiveInt", errors.getFieldError("artistId").getCode());
            assertEquals("field.positiveInt", errors.getFieldError("labelId").getCode());
        }
    }

    @Test
    public void missingIdsGiveOneRequiredError() {
        Record r = validRecord();
        r.setArtistId(null);
        Errors errors = validate(r);
        assertEquals(1, errors.getFieldErrorCount("artistId"));
        assertEquals("field.required", errors.getFieldError("artistId").getCode());
    }

    @Test
    public void titleLimitCountsCharactersNotUtf16Units() {
        Record r = validRecord();
        r.setTitle("🎵".repeat(255)); // 255 emoji = 510 UTF-16 units, still fits varchar(255) utf8mb4
        assertFalse(validate(r).hasFieldErrors("title"));

        r.setTitle("a".repeat(256));
        assertEquals("field.tooLong", validate(r).getFieldError("title").getCode());

        r.setTitle("   ");
        assertEquals("field.required", validate(r).getFieldError("title").getCode());
    }
}
