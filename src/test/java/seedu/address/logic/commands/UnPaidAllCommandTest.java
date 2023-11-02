package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.UnPaidAllCommand.MESSAGE_MARK_ALL_PERSON_UNPAID_SUCCESS;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class UnPaidAllCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_unpaidAll_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_MARK_ALL_PERSON_UNPAID_SUCCESS, false, false);
        assertCommandSuccess(new UnPaidAllCommand(), model, expectedCommandResult, expectedModel);
    }
}
