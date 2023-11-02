package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class RedoCommandTest {
    @Test
    public void execute_initAddressBook_failure() {
        Model model = new ModelManager();

        assertCommandFailure(new RedoCommand(), model, Messages.MESSAGE_CANNOT_REDO);
    }

    @Test
    public void execute_endVersionAddressBook_failure() {
        Model model = new ModelManager();

        // Simulate add command
        model.purgeAddressBook();
        model.addPerson(ALICE);
        model.commitAddressBook();

        assertCommandFailure(new RedoCommand(), model, Messages.MESSAGE_CANNOT_REDO);
    }

    @Test
    public void execute_multipleVersion_success() {
        Model model = new ModelManager();
        Model successModel = new ModelManager();
        successModel.addPerson(ALICE);

        // Simulate add command
        model.purgeAddressBook();
        model.addPerson(ALICE);
        model.commitAddressBook();

        // Simulate undo command
        model.undoAddressBook();

        assertCommandSuccess(new RedoCommand(), model, RedoCommand.MESSAGE_SUCCESS, successModel);
    }
}
