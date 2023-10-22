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
 * Mark the tutee as paid.
 */
public class PaidCommand extends Command {
    public static final String COMMAND_WORD = "paid";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_MARK_PERSON_PAID_SUCCESS = "MARK PERSON PAID SUCCESS, Paid: %1$s";

    private final Index targetIndex;

    public PaidCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TUTEE_DISPLAYED_INDEX);
        }

        Person personToMarkPaid = lastShownList.get(targetIndex.getZeroBased());
        model.markPersonPaid(personToMarkPaid);
        return new CommandResult(String.format(MESSAGE_MARK_PERSON_PAID_SUCCESS, personToMarkPaid.getPaid()));

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PaidCommand)) {
            return false;
        }

        PaidCommand otherPaidCommands = (PaidCommand) other;
        return targetIndex.equals(otherPaidCommands.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
