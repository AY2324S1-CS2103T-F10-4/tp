package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class LessonComparatorTest {

    private final LessonComparator lessonComparator = new LessonComparator();

    @Test
    public void testCompareDaysCyclically() {
        assertEquals(5, lessonComparator.compareDaysCyclically(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY));
        assertEquals(4, lessonComparator.compareDaysCyclically(DayOfWeek.FRIDAY, DayOfWeek.MONDAY));
        assertEquals(1, lessonComparator.compareDaysCyclically(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY));
        assertEquals(0, lessonComparator.compareDaysCyclically(DayOfWeek.THURSDAY, DayOfWeek.THURSDAY));
    }

    @Test
    public void testCompareDifferentStartTimesSameDay() {
        Person person1 = new PersonBuilder().withBegin("0900").withEnd("1000").build();
        Person person2 = new PersonBuilder().withBegin("1100").withEnd("1200").build();

        LessonComparator comparator = new LessonComparator();

        assertEquals(-1, comparator.compare(person1, person2));
    }

    @Test
    public void testCompareSameStartTimeSameDay() {
        Person person1 = new PersonBuilder().build();
        Person person2 = new PersonBuilder().build();

        LessonComparator comparator = new LessonComparator();
        assertEquals(0, comparator.compare(person1, person2));
    }

}
