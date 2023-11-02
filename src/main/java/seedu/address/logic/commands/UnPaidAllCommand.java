package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Mark All tutees as unpaid.
 */
public class UnPaidAllCommand extends Command {
    public static final String COMMAND_WORD = "unpaidAll";

    public static final String MESSAGE_USAGE = COMMAND_WORD;

    public static final String MESSAGE_MARK_ALL_PERSON_UNPAID_SUCCESS = "RESET ALL PERSON TO UNPAID SUCCESS";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        for (Person person : lastShownList) {
            model.markPersonUnPaid(person);
        }
        return new CommandResult(MESSAGE_MARK_ALL_PERSON_UNPAID_SUCCESS);
    }

}
