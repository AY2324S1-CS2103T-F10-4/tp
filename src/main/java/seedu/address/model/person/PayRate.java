package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


/**
 * Represents a Person's Pay Rate in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPayRate(String)}
 */
public class PayRate {

    public static final String MESSAGE_CONSTRAINTS = "PayRate can take any values, as long as they are integers.";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     * Only accepts positive integers.
     */
    public static final String VALIDATION_REGEX = "^\\d+$";

    public final int value;

    /**
     * Constructs an {@code PayRate}.
     *
     * @param payRate A valid pay rate per hour.
     */
    public PayRate(String payRate) {
        requireNonNull(payRate);
        checkArgument(isValidPayRate(payRate), MESSAGE_CONSTRAINTS);
        value = Integer.parseInt(payRate);
        assert value >= 0; // payrate cannot be negative
    }

    public static boolean isValidPayRate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PayRate)) {
            return false;
        }

        PayRate otherPayRate = (PayRate) other;
        return value == otherPayRate.value;
    }

    @Override
    public int hashCode() {
        Integer payRate = (Integer) value;
        return payRate.hashCode();
    }

}
