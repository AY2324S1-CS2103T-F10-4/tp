package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;


/**
 * Represents the day and time when the Tutee has tuition every week.
 * Guarantees: immutable; is valid as declared in
 */
public class Lesson {
    public final DayOfWeek day;

    public final LocalTime begin;

    public final LocalTime end;

    /**
     * Constructs a {@code DayTime}.
     *
     * @param day   A valid day.
     * @param begin A valid begin.
     * @param end   A valid end.
     */
    public Lesson(Day day, Begin begin, End end) {
        requireNonNull(day);
        requireNonNull(begin);
        requireNonNull(end);

        this.day = day.value;
        this.begin = begin.getTime();
        this.end = end.getTime();
    }

    public static boolean isValid(Begin begin, End end) {
        return begin.getTime().compareTo(end.getTime()) < 0;
    }

    public String getTimeSlot() {
        return begin.toString() + " - " + end.toString();
    }

    @Override
    public String toString() {
        return day.toString() + ", " + begin.toString() + " - " + end.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Lesson)) {
            return false;
        }

        Lesson otherLesson = (Lesson) other;
        return day.equals(otherLesson.day)
                && begin.equals(otherLesson.begin)
                && end.equals(otherLesson.end);
    }
    public int getNumOfDaysInMonth(int year, int month) {
        // Construct the LocalDate for the first day of the specified month and year
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

        // Construct the LocalDate for the last day of the specified month and year
        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());
        // Count occurrences of the specific day in the current month
        int count = 0;
        LocalDate temp = firstDayOfMonth;
        while (!temp.isAfter(lastDayOfMonth)) {
            if (temp.getDayOfWeek() == day) {
                count++;
                temp = temp.plusDays(7);
            } else {
                temp = temp.plusDays(1);
            }
        }
        return count;
    }

    /**
     * Calculates the lesson duration in hours.
     *
     * @return duration in terms of hours.
     */
    public double calculateLessonDuration() {
        Duration duration = Duration.between(begin, end);
        long minutes = duration.toMinutes();
        double hours = (double) minutes / 60; // Convert minutes to a fraction of hours

        // Truncate to 2 decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        hours = Double.parseDouble(df.format(hours));

        return hours;
    }

    public double getMonthlyHours() {
        return calculateLessonDuration() * getNumOfDaysInMonth(LocalDate.now()
                .getYear(), LocalDate.now().getMonthValue());
    }



}
