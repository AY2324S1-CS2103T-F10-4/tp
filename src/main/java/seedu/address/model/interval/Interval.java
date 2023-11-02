package seedu.address.model.interval;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;


/**
 * Represents an Interval in the address book.
 */
public class Interval {

    private final IntervalDay intervalDay;
    private final IntervalBegin intervalBegin;
    private final IntervalEnd intervalEnd;
    private final Duration duration;

    /**
     * Constructor for interval class
     * @param intervalDay
     * @param duration
     * @param intervalBegin
     * @param intervalEnd
     */
    public Interval(IntervalDay intervalDay, Duration duration, IntervalBegin intervalBegin, IntervalEnd intervalEnd) {
        requireAllNonNull(intervalDay, intervalBegin, intervalDay, duration);
        this.intervalDay = intervalDay;
        this.duration = duration;
        this.intervalBegin = intervalBegin;
        this.intervalEnd = intervalEnd;
    }

    public IntervalDay getIntervalDay() {
        return intervalDay;
    }

    public Duration getDuration() {
        return duration;
    }

    public IntervalBegin getIntervalBegin() {
        return intervalBegin;
    }

    public IntervalEnd getIntervalEnd() {
        return intervalEnd;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Interval)) {
            return false;
        }

        Interval otherInterval = (Interval) other;
        return intervalDay.equals(otherInterval.intervalDay)
                && duration.equals(otherInterval.duration)
                && intervalBegin.equals(otherInterval.intervalBegin)
                && intervalEnd.equals(otherInterval.intervalEnd);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(intervalDay, duration, intervalBegin, intervalEnd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("intervalDay", intervalDay)
                .add("duration", duration)
                .add("intervalBegin", intervalBegin)
                .add("intervalEnd", intervalEnd)
                .toString();
    }
}
