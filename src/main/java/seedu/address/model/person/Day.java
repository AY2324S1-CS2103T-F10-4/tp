package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;

/**
 * Represents the day when the Tutee has tuition every week.
 * Guarantees: immutable; is valid as declared in {@link #isValidDay(String)}
 */
public class Day {
    public static final String MESSAGE_CONSTRAINTS =
            "Days should be written using their full names or their first three letters, and it should not be blank";

    public static final String VALIDATION_REGEX =
            "(?i)^(Mon|Monday|Tue|Tuesday|Wed|Wednesday|Thu|Thursday|Fri|Friday|Sat|Saturday|Sun|Sunday)$";

    public final DayOfWeek value;
    public final String stringValue;

    /**
     * Constructs a {@code Day}.
     *
     * @param day A valid day.
     */
    public Day(String day) {
        requireNonNull(day);
        value = parse(day);
        stringValue = parseDay(day);
    }

    /**
     * Parses an input as a DayOfWeek object.
     *
     * @param test
     * @return DayOfWeek object
     */
    public DayOfWeek parse(String test) {
        String lowerCaseTest = test.toLowerCase();
        switch (lowerCaseTest) {
        case "mon":
        case "monday":
            return DayOfWeek.MONDAY;
        case "tue":
        case "tuesday":
            return DayOfWeek.TUESDAY;
        case "wed":
        case "wednesday":
            return DayOfWeek.WEDNESDAY;
        case "thu":
        case "thursday":
            return DayOfWeek.THURSDAY;
        case "fri":
        case "friday":
            return DayOfWeek.FRIDAY;
        case "sat":
        case "saturday":
            return DayOfWeek.SATURDAY;
        case "sun":
        case "sunday":
            return DayOfWeek.SUNDAY;
        default:
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        //checkArgument(isValidDay(day), MESSAGE_CONSTRAINTS);
        //value = parseDay(day);
    }

    /**
     * Parses the day input
     * @param input string of Day
     * @return parses the day into the complete day name
     */
    public String parseDay(String input) {
        String day = input.toLowerCase();
        String result = "";
        switch (day) {
        case "mon":
        case "monday":
            result = "Mon";
            break;
        case "tue":
        case "tuesday":
            result = "Tue";
            break;
        case "wed":
        case "wednesday":
            result = "Wed";
            break;
        case "thu":
        case "thursday":
            result = "Thu";
            break;
        case "fri":
        case "friday":
            result = "Fri";
            break;
        case "sat":
        case "saturday":
            result = "Sat";
            break;
        case "sun":
        case "sunday":
            result = "Sun";
            break;
        default:

        }
        return result;
    }

    public static boolean isValidDay(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return stringValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Day // instanceof handles nulls
                && value.equals(((Day) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
