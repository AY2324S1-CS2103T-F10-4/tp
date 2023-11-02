package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Mark the tutee as unpaid.
 */
public class UnPaidCommand extends Command {
    public static final String COMMAND_WORD = "unpaid";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_MARK_PERSON_UNPAID_SUCCESS = "MARK PERSON UNPAID SUCCESS, paid: %1$s";

    private final Index targetIndex;

    public UnPaidCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TUTEE_DISPLAYED_INDEX);
        }

        Person personToMarkUnPaid = lastShownList.get(targetIndex.getZeroBased());
        model.markPersonUnPaid(personToMarkUnPaid);
        return new CommandResult(String.format(MESSAGE_MARK_PERSON_UNPAID_SUCCESS, (personToMarkUnPaid.getPaid())));

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UnPaidCommand)) {
            return false;
        }

        UnPaidCommand otherUnPaidCommands = (UnPaidCommand) other;
        return targetIndex.equals(otherUnPaidCommands.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
