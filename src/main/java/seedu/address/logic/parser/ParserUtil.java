package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.interval.Duration;
import seedu.address.model.interval.IntervalBegin;
import seedu.address.model.interval.IntervalDay;
import seedu.address.model.interval.IntervalEnd;
import seedu.address.model.person.Address;
import seedu.address.model.person.Begin;
import seedu.address.model.person.Day;
import seedu.address.model.person.Email;
import seedu.address.model.person.End;
import seedu.address.model.person.Name;
import seedu.address.model.person.PayRate;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Subject;
/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }


    /**
     * Parses a {@code String day} into an {@code Day}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code day} is invalid.
     */
    public static Day parseDay(String day) throws ParseException {
        requireNonNull(day);
        String trimmedDay = day.trim();
        Day initialisedDay;

        try {
            initialisedDay = new Day(trimmedDay);
        } catch (IllegalArgumentException e) {
            throw new ParseException(Day.MESSAGE_CONSTRAINTS);
        }

        return initialisedDay;
    }

    /**
     * Parses a {@code String subject} into an {@code Subject}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code subject} is invalid.
     */
    public static Subject parseSubject(String subject) throws ParseException {
        requireNonNull(subject);
        String trimmedSubject = subject.trim();
        if (!Subject.isValidSubject(trimmedSubject)) {
            throw new ParseException(Subject.MESSAGE_CONSTRAINTS);
        }
        return new Subject(trimmedSubject);
    }

    /**
     * Parses a {@code String begin} into an {@code Begin}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code begin} is invalid.
     */
    public static Begin parseBegin(String begin) throws ParseException {
        requireNonNull(begin);
        String trimmedBegin = begin.trim();
        if (!Begin.isValidBegin(trimmedBegin)) {
            throw new ParseException(Begin.MESSAGE_CONSTRAINTS);
        }
        return new Begin(trimmedBegin);
    }

    /**
     * Parses a {@code String end} into an {@code End}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code end} is invalid.
     */
    public static End parseEnd(String end) throws ParseException {
        requireNonNull(end);
        String trimmedEnd = end.trim();
        if (!End.isValidEnd(trimmedEnd)) {
            throw new ParseException(End.MESSAGE_CONSTRAINTS);
        }
        return new End(trimmedEnd);
    }

    /**
     * Parses a {@code String payRate} into an {@code PayRate}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code end} is invalid.
     */
    public static PayRate parsePayRate(String payRate) throws ParseException {
        requireNonNull(payRate);
        String trimmedPayRate = payRate.trim();
        if (!PayRate.isValidPayRate(payRate)) {
            throw new ParseException(PayRate.MESSAGE_CONSTRAINTS);
        }
        return new PayRate(trimmedPayRate);
    }

    /**
     * Parses a {@code String day} into an {@code IntervalDay}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code day} is invalid.
     */
    public static IntervalDay parseIntervalDay(String day) throws ParseException {
        requireNonNull(day);
        String trimmedDay = day.trim();
        IntervalDay initialisedDay;

        try {
            initialisedDay = new IntervalDay(trimmedDay);
        } catch (IllegalArgumentException e) {
            throw new ParseException(IntervalDay.MESSAGE_CONSTRAINTS);
        }

        return initialisedDay;
    }

    /**
     * Parses a {@code String begin} into an {@code IntervalBegin}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code begin} is invalid.
     */
    public static IntervalBegin parseIntervalBegin(String begin) throws ParseException {
        requireNonNull(begin);
        String trimmedBegin = begin.trim();
        if (!IntervalBegin.isValidBegin(trimmedBegin)) {
            throw new ParseException(IntervalBegin.MESSAGE_CONSTRAINTS);
        }
        return new IntervalBegin(trimmedBegin);
    }

    /**
     * Parses a {@code String end} into an {@code IntervalEnd}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code end} is invalid.
     */
    public static IntervalEnd parseIntervalEnd(String end) throws ParseException {
        requireNonNull(end);
        String trimmedEnd = end.trim();
        if (!IntervalEnd.isValidEnd(trimmedEnd)) {
            throw new ParseException(IntervalEnd.MESSAGE_CONSTRAINTS);
        }
        return new IntervalEnd(trimmedEnd);
    }

    /**
     * Parses a {@code String duration} into an {@code Duration}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code end} is invalid.
     */
    public static Duration parseDuration(String duration) throws ParseException {
        requireNonNull(duration);
        String trimmedDuration = duration.trim();
        if (!Duration.isValidDuration(trimmedDuration)) {
            throw new ParseException(Duration.MESSAGE_CONSTRAINTS);
        }
        return new Duration(trimmedDuration);
    }
}
