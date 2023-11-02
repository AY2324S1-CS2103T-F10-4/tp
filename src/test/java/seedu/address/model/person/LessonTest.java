package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class LessonTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Lesson(null, null, null));
    }

    @Test
    public void equals() {
        Lesson lesson = new Lesson(new Day("thu"), new Begin("0800"), new End("1000"));

        // same values -> returns true
        assertTrue(lesson.equals(new Lesson(new Day("thu"), new Begin("0800"), new End("1000"))));

        // same object -> returns true
        assertTrue(lesson.equals(lesson));

        // null -> returns false
        assertFalse(lesson.equals(null));

        // different type -> returns false
        assertFalse(lesson.equals(9.0));

        // different values -> returns false;
        assertFalse(lesson.equals(new Lesson(new Day("fri"), new Begin("0800"), new End("1000"))));
        assertFalse(lesson.equals(new Lesson(new Day("thu"), new Begin("0830"), new End("1000"))));
        assertFalse(lesson.equals(new Lesson(new Day("thu"), new Begin("0800"), new End("1100"))));
    }

    @Test
    public void getNumOfDaysInMonth() {
        // Testing for October in 2023
        Lesson monLesson = new Lesson(new Day("Mon"), new Begin("1200"), new End("1300"));
        int expectedMonsInOctober2023 = 5;
        assertEquals(expectedMonsInOctober2023, monLesson.getNumOfDaysInMonth(2023, 1));

        // Testing for January in 2023 & 2024
        Lesson wedLesson = new Lesson(new Day("Wed"), new Begin("1300"), new End("1400"));
        int expectedDaysInJanuary2023 = 4; // January 2023 has 31 days
        assertEquals(expectedDaysInJanuary2023, wedLesson.getNumOfDaysInMonth(2023, 1));

        int expectedDaysInJanuary2024 = 5;
        assertEquals(expectedDaysInJanuary2024, wedLesson.getNumOfDaysInMonth(2024, 1));

        Lesson satLesson = new Lesson(new Day("Sat"), new Begin("1300"), new End("1400"));
        int expectedSatsInOctober2023 = 4;
        assertEquals(expectedSatsInOctober2023, satLesson.getNumOfDaysInMonth(2023, 10));
    }

    @Test
    public void calculateLessonDuration() {
        Lesson lessonOne = new Lesson(new Day("Mon"), new Begin("1200"), new End("1330"));
        double expectedDurationOne = 1.5; // Expected hours between 8:00 AM and 4:00 PM is 8 hours
        assertEquals(expectedDurationOne, lessonOne.calculateLessonDuration());

        // hours that have more than 2dp should be truncated
        Lesson lessonTwo = new Lesson(new Day("Tue"), new Begin("1900"), new End("1920"));
        double expectedDurationTwo = 0.33;
        assertEquals(expectedDurationTwo, lessonTwo.calculateLessonDuration());

    }

}
