package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BEGIN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END;

import java.text.ParseException;
import java.util.List;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.interval.Interval;
import seedu.address.model.interval.TimeSlot;

/**
 * FreeTimeCommand
 */
public class FreeTimeCommand extends Command {

    public static final String COMMAND_WORD = "freeTime";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": finds a free time.  "
            + "Parameters: "
            + PREFIX_DAY + "DAY "
            + PREFIX_DURATION + "MINUTES "
            + PREFIX_BEGIN + "BEGIN "
            + PREFIX_END + "END "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DAY + "Monday "
            + PREFIX_DURATION + "60 "
            + PREFIX_BEGIN + "0800 "
            + PREFIX_END + "2200 ";
    public static final String MESSAGE_ERROR = "An error occurred when executing the freeTime command.";
    private final Interval toFind;

    /**
     * Creates an FreeTimeCommand to check for the specified {@code Interval}
     */
    public FreeTimeCommand(Interval interval) {
        requireNonNull(interval);
        toFind = interval;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<String> result = model.findInterval(toFind);
        try {
            List<TimeSlot> timeslots = TimeSlot.parseIntervals(result);
            List<TimeSlot> availableTime = TimeSlot.findAvailableTime(timeslots, toFind);
            return new CommandResult(TimeSlot.printResults(availableTime));
        } catch (ParseException e) {
            throw new CommandException(MESSAGE_ERROR);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FreeTimeCommand)) {
            return false;
        }

        FreeTimeCommand otherFindCommand = (FreeTimeCommand) other;
        return toFind.equals(otherFindCommand.toFind);
    }
}
