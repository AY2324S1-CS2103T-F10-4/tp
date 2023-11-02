package seedu.address.model.interval;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class IntervalBeginTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new IntervalBegin(null));
    }

    @Test
    public void constructor_invalidIntervalBegin_throwsIllegalArgumentException() {
        String invalidIntervalBegin = "9999";
        assertThrows(IllegalArgumentException.class, () -> new IntervalBegin(invalidIntervalBegin));
    }

    @Test
    public void isValidIntervalBegin() {
        // null address
        assertThrows(NullPointerException.class, () -> IntervalBegin.isValidBegin(null));

        // invalid IntervalBegin
        assertFalse(IntervalBegin.isValidBegin("9999")); // invalid
        assertFalse(IntervalBegin.isValidBegin("")); // empty

        // valid addresses
        assertTrue(IntervalBegin.isValidBegin("1800"));
        assertTrue(IntervalBegin.isValidBegin("0000"));
    }

    @Test
    public void equals() {
        IntervalBegin intervalBegin = new IntervalBegin("1800");

        // same values -> returns true
        assertTrue(intervalBegin.equals(new IntervalBegin("1800")));

        // same object -> returns true
        assertTrue(intervalBegin.equals(intervalBegin));

        // null -> returns false
        assertFalse(intervalBegin.equals(null));

        // different types -> returns false
        assertFalse(intervalBegin.equals(1800));

        // different values -> returns false
        assertFalse(intervalBegin.equals(new IntervalBegin("1900")));
    }

    @Test
    public void toStringMethod() {
        IntervalBegin intervalBegin = new IntervalBegin("2100");
        assertTrue(intervalBegin.toString() == "2100");
    }
}
