package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


/**
 * Represents a Person's Pay Rate in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPayRate(String)}
 */
public class PayRate {

    public static final String MESSAGE_CONSTRAINTS = "PayRate can be either integers"
            + "or decimals of up to 2 decimal places. It cannot be negative";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     * Only accepts positive numbers of up to 2 dp.
     */
    public static final String VALIDATION_REGEX = "^\\s*\\d+(\\.\\d{1,2})?\\s*$";

    public final double value;

    /**
     * Constructs an {@code PayRate}.
     *
     * @param payRate A valid pay rate per hour.
     */
    public PayRate(String payRate) {
        requireNonNull(payRate);
        checkArgument(isValidPayRate(payRate), MESSAGE_CONSTRAINTS);
        value = Double.parseDouble(payRate);
        assert value >= 0; // payrate cannot be negative
    }

    public static boolean isValidPayRate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%.2f", value);
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
        Double payRate = value;
        return payRate.hashCode();
    }

    public double getValue() {
        return value;
    }

}
