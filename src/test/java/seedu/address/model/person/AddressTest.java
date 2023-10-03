package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new Remark(invalidAddress));
    }

    @Test
    public void isValidAddress() {
        // null address
        assertThrows(NullPointerException.class, () -> Remark.isValidAddress(null));

        // invalid addresses
        assertFalse(Remark.isValidAddress("")); // empty string
        assertFalse(Remark.isValidAddress(" ")); // spaces only

        // valid addresses
        assertTrue(Remark.isValidAddress("Blk 456, Den Road, #01-355"));
        assertTrue(Remark.isValidAddress("-")); // one character
        assertTrue(Remark.isValidAddress("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long address
    }

    @Test
    public void equals() {
        Remark address = new Remark("Valid Address");

        // same values -> returns true
        assertTrue(address.equals(new Remark("Valid Address")));

        // same object -> returns true
        assertTrue(address.equals(address));

        // null -> returns false
        assertFalse(address.equals(null));

        // different types -> returns false
        assertFalse(address.equals(5.0f));

        // different values -> returns false
        assertFalse(address.equals(new Remark("Other Valid Address")));
    }
}
