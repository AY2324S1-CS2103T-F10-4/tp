package seedu.address.model.interval;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TimeSlotTest {

    @Test
    public void equals() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        TimeSlot timeSlot1 = new TimeSlot(dateFormat.parse("15:00"), dateFormat.parse("16:00"));
        TimeSlot timeSlot2 = new TimeSlot(dateFormat.parse("15:00"), dateFormat.parse("16:00"));
        TimeSlot timeSlot3 = new TimeSlot(dateFormat.parse("15:00"), dateFormat.parse("17:00"));

        //check equal
        assertEquals(timeSlot1, timeSlot2);

        //check not equal
        assertNotEquals(timeSlot1, timeSlot3);
    }

    @Test
    public void parseIntervals() throws ParseException {
        List<String> stringList = new ArrayList<>();
        stringList.add("10:00 - 12:00");
        stringList.add("14:00 - 16:00");
        stringList.add("18:00 - 20:00");

        List<TimeSlot> result = TimeSlot.parseIntervals(stringList);
        List<TimeSlot> expected = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        expected.add(new TimeSlot(dateFormat.parse("10:00"), dateFormat.parse("12:00")));
        expected.add(new TimeSlot(dateFormat.parse("14:00"), dateFormat.parse("16:00")));
        expected.add(new TimeSlot(dateFormat.parse("18:00"), dateFormat.parse("20:00")));

        List<TimeSlot> expectedWrong = new ArrayList<>();
        expectedWrong.add(new TimeSlot(dateFormat.parse("10:00"), dateFormat.parse("14:00")));

        assertEquals(expected, result);
        assertNotEquals(expectedWrong, result);
    }

    @Test
    public void findAvailableTime() throws ParseException {
        // check when interval end is bigger than last end in timeslot

        Interval interval = new Interval(new IntervalDay("Mon"), new Duration("30"), new IntervalBegin("0800"),
                new IntervalEnd("2200"));

        List<TimeSlot> timeslots = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        timeslots.add(new TimeSlot(dateFormat.parse("12:00"), dateFormat.parse("14:00")));
        timeslots.add(new TimeSlot(dateFormat.parse("15:00"), dateFormat.parse("18:00")));

        List<TimeSlot> result = TimeSlot.findAvailableTime(timeslots, interval);
        List<TimeSlot> expected = new ArrayList<>();
        expected.add(new TimeSlot(dateFormat.parse("08:00"), dateFormat.parse("12:00")));
        expected.add(new TimeSlot(dateFormat.parse("14:00"), dateFormat.parse("15:00")));
        expected.add(new TimeSlot(dateFormat.parse("18:00"), dateFormat.parse("22:00")));

        assertEquals(expected, result);

        Interval interval2 = new Interval(new IntervalDay("Mon"), new Duration("120"), new IntervalBegin("0800"),
                new IntervalEnd("1900"));
        List<TimeSlot> result2 = TimeSlot.findAvailableTime(timeslots, interval2);
        List<TimeSlot> expected2 = new ArrayList<>();
        expected2.add(new TimeSlot(dateFormat.parse("08:00"), dateFormat.parse("12:00")));
        assertEquals(result2, expected2);

        //check when interval end is smaller than last end in timeslots.

        List<TimeSlot> timeslots3 = new ArrayList<>();
        timeslots3.add(new TimeSlot(dateFormat.parse("20:00"), dateFormat.parse("21:00")));

        Interval interval3 = new Interval(new IntervalDay("Mon"), new Duration("120"), new IntervalBegin("0800"),
                new IntervalEnd("1000"));

        List<TimeSlot> expected3 = new ArrayList<>();
        expected3.add(new TimeSlot(dateFormat.parse("08:00"), dateFormat.parse("10:00")));
        List<TimeSlot> result3 = TimeSlot.findAvailableTime(timeslots3, interval3);
        assertEquals(result3, expected3);


        //checks when duration is smaller than given the begin and end of intervals
        List<TimeSlot> timeslots4 = new ArrayList<>();
        timeslots4.add(new TimeSlot(dateFormat.parse("20:00"), dateFormat.parse("21:00")));

        Interval interval4 = new Interval(new IntervalDay("Mon"), new Duration("180"), new IntervalBegin("0800"),
                new IntervalEnd("1000"));
        List<TimeSlot> expected4 = new ArrayList<>();
        List<TimeSlot> result4 = TimeSlot.findAvailableTime(timeslots4, interval4);
        assertEquals(result4, expected4);
    }

}
