package seedu.address.model.interval;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TimeSlot Class
 */
public class TimeSlot {
    private Date start;
    private Date end;

    /**
     * Constructor for TimeSlot
     * @param start a Date object for start
     * @param end a Date object for end
     */
    public TimeSlot(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return the duration of the timeslot in minutes
     */
    public long getDurationMinutes() {
        return (end.getTime() - start.getTime()) / (60 * 1000);
    }

    /**
     * Parses a list of String into a list of TimeSlots.
     * @param timeSlots the list of strings to be parsed
     * @return parsed timeslots
     * @throws ParseException
     */
    public static List<TimeSlot> parseIntervals(List<String> timeSlots) throws ParseException {
        List<TimeSlot> timeSlotObjects = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for (String timeSlot : timeSlots) {
            String[] times = timeSlot.split(" - ");
            Date start = dateFormat.parse(times[0]);
            Date end = dateFormat.parse(times[1]);
            timeSlotObjects.add(new TimeSlot(start, end));
        }
        return timeSlotObjects;
    }

    /**
     * Finds the available time within the given list of timeslots and interval
     * @param timeslots
     * @param interval
     * @return a list of available timeslots
     * @throws ParseException
     */
    public static List<TimeSlot> findAvailableTime(List<TimeSlot> timeslots, Interval interval) throws ParseException {
        timeslots.sort(Comparator.comparing(timeslot -> timeslot.start));

        List<TimeSlot> availableTime = new ArrayList<>();
        Date lastEnd = interval.getIntervalBegin().getTime();
        for (TimeSlot timeslot : timeslots) {
            if (timeslot.start.after(lastEnd)) {
                availableTime.add(new TimeSlot(lastEnd, timeslot.start));
            }
            if (lastEnd.before(timeslot.end)) {
                lastEnd = timeslot.end;
            }
        }

        if (lastEnd.before(interval.getIntervalEnd().getTime())) {
            availableTime.add(new TimeSlot(lastEnd, interval.getIntervalEnd().getTime()));
        }
        List<TimeSlot> validTimeSlots = availableTime.stream()
                .filter(timeslot -> timeslot.getDurationMinutes() >= interval.getDuration().toInt())
                .collect(Collectors.toList());

        return validTimeSlots;
    }

    /**
     * Prints out the results
     * @param timeslots
     * @return String of results
     */
    public static String printResults(List<TimeSlot> timeslots) {
        if (timeslots.size() == 0) {
            return "There are no available timeslots.";
        }

        String result = "";

        for (TimeSlot timeslot : timeslots) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String startTime = timeFormat.format(timeslot.start);
            String endTime = timeFormat.format(timeslot.end);
            result = result + "Free from " + startTime + " - " + endTime + "\n";
        }
        return result;
    }

    /**
     * @return start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @return end
     */
    public Date getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TimeSlot)) {
            return false;
        }

        TimeSlot otherTimeslot = (TimeSlot) other;
        return start.equals(otherTimeslot.start)
                && end.equals(otherTimeslot.end);
    }
}
