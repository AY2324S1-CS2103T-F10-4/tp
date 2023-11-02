package seedu.address.model.interval;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;

public class IntervalDayTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new IntervalDay(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidDay = "Christmas";
        assertThrows(IllegalArgumentException.class, () -> new IntervalDay(invalidDay));
    }

    @Test
    public void isValidIntervalDay() {
        // null address
        assertThrows(NullPointerException.class, () -> IntervalDay.isValidDay(null));

        // invalid IntervalDay
        assertFalse(IntervalDay.isValidDay("")); // empty string
        assertFalse(IntervalDay.isValidDay("tues")); // not 3 letter word or full day

        // valid addresses
        assertTrue(IntervalDay.isValidDay("Mon"));
        assertTrue(IntervalDay.isValidDay("Tuesday"));
        assertTrue(IntervalDay.isValidDay("wEd"));
        assertTrue(IntervalDay.isValidDay("SUNDAY"));
    }

    @Test
    public void equals() {
        IntervalDay intervalDay = new IntervalDay("Mon");

        // same values -> returns true
        assertTrue(intervalDay.equals(new IntervalDay("Monday")));

        // same object -> returns true
        assertTrue(intervalDay.equals(intervalDay));

        // null -> returns false
        assertFalse(intervalDay.equals(null));

        // different values -> returns false
        assertFalse(intervalDay.equals(new IntervalDay("Tuesday")));
    }

    @Test
    public void parseDay() {
        IntervalDay intervalDay = new IntervalDay("Mon");
        IntervalDay intervalDay2 = new IntervalDay("Fri");

        assertTrue(intervalDay.parseDay("mon") == "Mon");
        assertTrue(intervalDay.parseDay("friday") == "Fri");
    }

    @Test
    public void parse() {
        IntervalDay intervalDay = new IntervalDay("Mon");
        IntervalDay intervalDay2 = new IntervalDay("Fri");

        assertTrue(intervalDay.parse("mon").equals(DayOfWeek.MONDAY));
        assertTrue(intervalDay.parse("friday").equals(DayOfWeek.FRIDAY));
    }

    @Test
    public void toStringMethod() {
        IntervalDay intervalDay = new IntervalDay("mon");
        IntervalDay intervalDay2 = new IntervalDay("FRIDAY");

        assertTrue(intervalDay.toString() == "Mon");
        assertTrue(intervalDay2.toString() == "Fri");
    }


}
