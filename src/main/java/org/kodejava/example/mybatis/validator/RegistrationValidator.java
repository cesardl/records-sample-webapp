package org.kodejava.example.mybatis.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kodejava.example.mybatis.domain.Record;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Server-side rules mirroring the `record` table: `title` varchar(255) utf8mb4,
 * `artist_id`/`label_id` signed int. The int upper bound (2147483647) is enforced
 * by the Integer type itself: larger input fails binding as typeMismatch.
 *
 * @author Cesardl
 */
@Component
public class RegistrationValidator implements Validator {

    private static final Logger logger = LogManager.getLogger(RegistrationValidator.class);

    static final int TITLE_MAX_LENGTH = 255;

    public boolean supports(Class<?> c) {
        return Record.class.isAssignableFrom(c);
    }

    public void validate(Object command, Errors errors) {
        logger.info("Validating record  ");
        Record recordBean = (Record) command;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required", new Object[]{"Title"});
        String title = recordBean.getTitle();
        // utf8mb4 varchar counts characters (code points), not UTF-16 units
        if (title != null && title.codePointCount(0, title.length()) > TITLE_MAX_LENGTH) {
            errors.rejectValue("title", "field.tooLong", new Object[]{"Title", TITLE_MAX_LENGTH}, null);
        }

        validatePositiveId(errors, "artistId", "Artist Id", recordBean.getArtistId());
        validatePositiveId(errors, "labelId", "Label Id", recordBean.getLabelId());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "releaseDate", "field.required", new Object[]{"Release Date"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "created", "field.required", new Object[]{"Created"});
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modified", "field.required", new Object[]{"Modified"});
    }

    private static void validatePositiveId(Errors errors, String field, String label, Integer value) {
        if (errors.hasFieldErrors(field)) {
            return; // binding already failed (non-numeric or out of int range); one message per field
        }
        if (value == null) {
            errors.rejectValue(field, "field.required", new Object[]{label}, null);
        } else if (value < 1) {
            errors.rejectValue(field, "field.positiveInt", new Object[]{label}, null);
        }
    }
}
