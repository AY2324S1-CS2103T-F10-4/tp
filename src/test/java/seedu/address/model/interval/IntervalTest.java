package seedu.address.model.interval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntervalTest {

    @Test
    public void equals() {
        // same values -> returns true
        Interval interval1 = new Interval(new IntervalDay("Mon"), new Duration("120"), new IntervalBegin("0800"),
                new IntervalEnd("2200"));
        Interval interval1Copy = new Interval(new IntervalDay("Mon"), new Duration("120"), new IntervalBegin("0800"),
                new IntervalEnd("2200"));
        Interval interval2 = new Interval(new IntervalDay("Sun"), new Duration("60"), new IntervalBegin("0900"),
                new IntervalEnd("2300"));

        assertTrue(interval1.equals(interval1Copy));

        // same object -> returns true
        assertTrue(interval1.equals(interval1));

        // null -> returns false
        assertFalse(interval1.equals(null));

        // different type -> returns false
        assertFalse(interval1.equals(5));

        //different intervals
        assertFalse(interval1.equals(interval2));

    }

    @Test
    public void toStringMethod() {
        Interval toTest = new Interval(new IntervalDay("Mon"), new Duration("120"), new IntervalBegin("0800"),
                new IntervalEnd("2200"));

        String expected = Interval.class.getCanonicalName() + "{intervalDay=" + toTest.getIntervalDay()
                + ", duration=" + toTest.getDuration()
                + ", intervalBegin=" + toTest.getIntervalBegin()
                + ", intervalEnd=" + toTest.getIntervalEnd()
                + "}";
        assertEquals(expected, toTest.toString());
    }
}
