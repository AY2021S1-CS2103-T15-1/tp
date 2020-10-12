package seedu.medmoriser.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.medmoriser.storage.JsonAdaptedQAndA.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.medmoriser.testutil.Assert.assertThrows;
import static seedu.medmoriser.testutil.TypicalQuestionSet.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.medmoriser.commons.exceptions.IllegalValueException;
import seedu.medmoriser.model.qanda.Answer;
import seedu.medmoriser.model.qanda.Email;
import seedu.medmoriser.model.qanda.Phone;
import seedu.medmoriser.model.qanda.Question;

public class JsonAdaptedQAndATest {
    private static final String INVALID_QUESTION = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_QUESTION = BENSON.getQuestion().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAnswer().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validQuestionSetDetails_returnsQuestionSet() throws Exception {
        JsonAdaptedQAndA questionSet = new JsonAdaptedQAndA(BENSON);
        assertEquals(BENSON, questionSet.toModelType());
    }

    @Test
    public void toModelType_invalidQuestion_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSet =
                new JsonAdaptedQAndA(INVALID_QUESTION, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Question.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, questionSet::toModelType);
    }

    @Test
    public void toModelType_nullQuestion_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSet = new JsonAdaptedQAndA(null, VALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Question.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, questionSet::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSet =
                new JsonAdaptedQAndA(VALID_QUESTION, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, questionSet::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSet = new JsonAdaptedQAndA(VALID_QUESTION, null, VALID_EMAIL,
                VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, questionSet::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSet =
                new JsonAdaptedQAndA(VALID_QUESTION, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, questionSet::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSet = new JsonAdaptedQAndA(VALID_QUESTION, VALID_PHONE, null,
                VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, questionSet::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSize =
                new JsonAdaptedQAndA(VALID_QUESTION, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Answer.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, questionSize::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedQAndA questionSize = new JsonAdaptedQAndA(VALID_QUESTION, VALID_PHONE,
                VALID_EMAIL, null, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Answer.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, questionSize::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedQAndA questionSet =
                new JsonAdaptedQAndA(VALID_QUESTION, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, invalidTags);
        assertThrows(IllegalValueException.class, questionSet::toModelType);
    }

}
