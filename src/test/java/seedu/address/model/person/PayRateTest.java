package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PayRateTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PayRate(null));
    }

    @Test
    public void constructor_invalidPayRate_throwsIllegalArgumentException() {
        String emptyPayRate = "";
        assertThrows(IllegalArgumentException.class, () -> new PayRate(emptyPayRate));

        String invalidPayRate = "abc";
        assertThrows(IllegalArgumentException.class, () -> new PayRate(invalidPayRate));

        String negativePayRate = "-2.30";
        assertThrows(IllegalArgumentException.class, () -> new PayRate(negativePayRate));
    }

    @Test
    public void equals() {
        PayRate payRate = new PayRate("23");

        // same values -> returns true
        assertTrue(payRate.equals(new PayRate("23")));

        // same object -> returns true
        assertTrue(payRate.equals(payRate));

        // null -> returns false
        assertFalse(payRate.equals(null));

        // different types -> returns false
        assertFalse(payRate.equals(5.0f));

        // different values -> returns false
        assertFalse(payRate.equals(new PayRate("23.1")));
    }
}
