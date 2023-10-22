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
 * Check if the tutee paid.
 */
public class IsPaidCommand extends Command {
    public static final String COMMAND_WORD = "ispaid";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_CHECK_PERSON_PAID = "Check Whether Person Paid, Paid: %1$s";

    private final Index targetIndex;

    public IsPaidCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TUTEE_DISPLAYED_INDEX);
        }

        Person personToGetPaid = lastShownList.get(targetIndex.getZeroBased());
        model.getPersonPaid(personToGetPaid);
        return new CommandResult(String.format(MESSAGE_CHECK_PERSON_PAID, personToGetPaid.getPaid()));

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

        IsPaidCommand otherPaidCommands = (IsPaidCommand) other;
        return targetIndex.equals(otherPaidCommands.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
