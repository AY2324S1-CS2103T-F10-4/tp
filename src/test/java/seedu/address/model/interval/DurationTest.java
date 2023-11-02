package seedu.address.model.interval;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DurationTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Duration(null));
    }

    @Test
    public void constructor_invalidDuration_throwsIllegalArgumentException() {
        String invalidDuration = "2.5";
        assertThrows(IllegalArgumentException.class, () -> new Duration(invalidDuration));
    }

    @Test
    public void isValidDuration() {

        // invalid duration
        assertFalse(Duration.isValidDuration("")); // empty string
        assertFalse(Duration.isValidDuration("!")); //special character
        assertFalse(Duration.isValidDuration("0.5")); // decimal
        assertFalse(Duration.isValidDuration("0")); //zero
        assertFalse(Duration.isValidDuration("-1")); //negative number

        // valid durations
        assertTrue(Duration.isValidDuration("60"));
        assertTrue(Duration.isValidDuration("30"));
        assertTrue(Duration.isValidDuration("45"));
    }

    @Test
    public void equals() {
        Duration validDuration = new Duration("60");

        // same values -> returns true
        assertTrue(validDuration.equals(new Duration("60")));

        // same object -> returns true
        assertTrue(validDuration.equals(validDuration));

        // null -> returns false
        assertFalse(validDuration.equals(null));

        // different types -> returns false
        assertFalse(validDuration.equals(60));

        // different values -> returns false
        assertFalse(validDuration.equals(new Duration("30")));
    }

    @Test
    public void toStringMethod() {
        Duration validDuration = new Duration("60");
        assertTrue(validDuration.toString() == "60");
    }
}
