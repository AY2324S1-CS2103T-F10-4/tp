package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Day in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDay(String)}
 */

public class Day {

    public static final String MESSAGE_CONSTRAINTS = "Day can take any of the following choices: \n"
            + "(Mon/Tues/Wed/Thurs/Fri/Sat/Sun)";
    public static final String VALIDATION_REGEX = "(?i)^(Mon|Tues|Wed|Thurs|Fri|Sat|Sun|Thu)$";
    public final String value;

    /**
     * Constructs a {@code Day}.
     *
     * @param day A valid phone number.
     */
    public Day(String day) {
        requireNonNull(day);
        checkArgument(isValidDay(day), MESSAGE_CONSTRAINTS);
        value = day;
    }

    public static boolean isValidDay(String test) {
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
        if (!(other instanceof Day)) {
            return false;
        }

        Day otherDay = (Day) other;
        return value.equals(otherDay.value);
    }

}
