package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class UndoCommandTest {
    @Test
    public void execute_emptyAddressBook_failure() {
        Model model = new ModelManager();

        assertCommandFailure(new UndoCommand(), model, Messages.MESSAGE_CANNOT_UNDO);
    }

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model successModel = new ModelManager();

        // Simulate add command
        model.purgeAddressBook();
        model.addPerson(ALICE);
        model.commitAddressBook();

        assertCommandSuccess(new UndoCommand(), model, UndoCommand.MESSAGE_SUCCESS, successModel);
    }
}
