package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.logic.Messages.MESSAGE_TUTEES_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Day;
import seedu.address.model.person.DayPredicate;

class ListByDayCommandTest {

    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private final Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_validDay_multipleTuteesFound() {
        String expectedMessage = String.format(MESSAGE_TUTEES_LISTED_OVERVIEW, 1);
        Day day = new Day("Mon");
        DayPredicate predicate = new DayPredicate(day);
        ListByDayCommand command = new ListByDayCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE), model.getFilteredPersonList());
    }

    @Test
    public void execute_validDay_noTuteesFound() {
        String expectedMessage = String.format(MESSAGE_TUTEES_LISTED_OVERVIEW, 0);
        Day day = new Day("Wed");
        DayPredicate predicate = new DayPredicate(day);
        ListByDayCommand command = new ListByDayCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.EMPTY_LIST, model.getFilteredPersonList());
    }

    @Test
    public void equals() {
        Day firstDay = new Day("Mon");
        Day secondDay = new Day("Mon");

        DayPredicate firstPredicate = new DayPredicate(firstDay);
        DayPredicate secondPredicate = new DayPredicate(secondDay);

        ListByDayCommand listByDayFirstCommand = new ListByDayCommand(firstPredicate);
        ListByDayCommand listByDaySecondCommand = new ListByDayCommand(secondPredicate);

        // same object -> returns true
        assertEquals(listByDayFirstCommand, listByDayFirstCommand);

        // same values -> returns true
        assertEquals(listByDayFirstCommand, listByDaySecondCommand);

        // different types -> returns false
        assertNotEquals(new ListCommand(), listByDayFirstCommand);

        // null -> returns false
        assertNotEquals(null, listByDayFirstCommand);
    }
}
