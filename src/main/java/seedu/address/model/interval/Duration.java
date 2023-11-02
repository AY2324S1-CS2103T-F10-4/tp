package seedu.address.model.interval;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a duration in an interval
 */

public class Duration {
    public static final String MESSAGE_CONSTRAINTS = "The duration must be a positive integer";

    public final String value;


    /**
     * Constructs a {@code Begin}.
     *
     * @param duration A valid duration
     */
    public Duration(String duration) {
        requireNonNull(duration);
        checkArgument(isValidDuration(duration), MESSAGE_CONSTRAINTS);
        value = duration;
    }

    /**
     * Checks if it is a valid duration
     * @param test String to be checked
     * @return boolean on whether the value is a valid duration
     */
    public static boolean isValidDuration(String test) {
        try {
            int number = Integer.parseInt(test);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int toInt() {
        return Integer.parseInt(value);
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
        if (!(other instanceof Duration)) {
            return false;
        }

        Duration otherDuration = (Duration) other;
        return value.equals(otherDuration.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
