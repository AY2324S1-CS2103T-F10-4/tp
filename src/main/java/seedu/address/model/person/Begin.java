package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Begin in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBegin(String)}
 */

public class Begin {

    public static final String MESSAGE_CONSTRAINTS = "Begin has a format of HHMM";
    public static final String VALIDATION_REGEX = "^(0[0-9]|1[0-9]|2[0-3])[0-5][0-9]$";
    public final String value;

    /**
     * Constructs a {@code Begin}.
     *
     * @param begin A valid phone number.
     */
    public Begin(String begin) {
        requireNonNull(begin);
        checkArgument(isValidBegin(begin), MESSAGE_CONSTRAINTS);
        value = begin;
    }

    public static boolean isValidBegin(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Begin)) {
            return false;
        }

        Begin otherBegin = (Begin) other;
        return value.equals(otherBegin.value);
    }
}
