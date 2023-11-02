package seedu.address.model.interval;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class IntervalEndTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new IntervalBegin(null));
    }

    @Test
    public void constructor_invalidIntervalEnd_throwsIllegalArgumentException() {
        String invalidIntervalEnd = "9999";
        assertThrows(IllegalArgumentException.class, () -> new IntervalBegin(invalidIntervalEnd));
    }

    @Test
    public void isValidIntervalEnd() {
        // null address
        assertThrows(NullPointerException.class, () -> IntervalEnd.isValidEnd(null));

        // invalid IntervalBegin
        assertFalse(IntervalEnd.isValidEnd("9999")); // invalid
        assertFalse(IntervalEnd.isValidEnd("")); // empty

        // valid addresses
        assertTrue(IntervalEnd.isValidEnd("1800"));
        assertTrue(IntervalEnd.isValidEnd("0000"));
    }

    @Test
    public void equals() {
        IntervalEnd intervalEnd = new IntervalEnd("1800");

        // same values -> returns true
        assertTrue(intervalEnd.equals(new IntervalEnd("1800")));

        // same object -> returns true
        assertTrue(intervalEnd.equals(intervalEnd));

        // null -> returns false
        assertFalse(intervalEnd.equals(null));

        // different types -> returns false
        assertFalse(intervalEnd.equals(1800));

        // different values -> returns false
        assertFalse(intervalEnd.equals(new IntervalEnd("1900")));
    }

    @Test
    public void toStringMethod() {
        IntervalEnd intervalEnd = new IntervalEnd("2100");
        assertTrue(intervalEnd.toString() == "2100");
    }
}
