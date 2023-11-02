package seedu.address.model.person;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;


/**
 * Compares a {@code Person}'s {@code Lesson} against another {@code Lesson}.
 */
public class LessonComparator implements Comparator<Person> {
    /**
     * Compares two Person objects based on the lesson they are currently attending.
     *
     * @param person1 the first Person object to be compared
     * @param person2 the second Person object to be compared
     * @return a negative integer, zero, or a positive integer as the first
     *     Person's lesson is less than, equal to, or greater than the second Person's lesson.
     */
    public int compare(Person person1, Person person2) {
        Lesson lesson1 = person1.getLesson();
        Lesson lesson2 = person2.getLesson();

        DayOfWeek currentDay = LocalDate.now().getDayOfWeek();

        // Compare the days cyclically
        // if lesson1 is earlier in the week than lesson 2, dayComparison return negative
        int dayComparison = compareDaysCyclically(lesson1.day, currentDay)
                - compareDaysCyclically(lesson2.day, currentDay);

        if (dayComparison != 0) {
            return dayComparison;
        }
        // If days are the same, compare by start time
        return lesson1.begin.compareTo(lesson2.begin);
    }


    /**
     * Returns the days from day 2 to day 1 in a cyclical manner
     *
     * @param day1
     * @param day2
     * @return days from day2 to day1
     */
    public int compareDaysCyclically(DayOfWeek day1, DayOfWeek day2) {
        // returns days required to get from day 2 to day 1 in a cyclical manner
        return (day1.getValue() - day2.getValue() + DayOfWeek.values().length) % DayOfWeek.values().length;
    }
}
