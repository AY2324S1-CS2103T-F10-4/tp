package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BEGIN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END;

import java.util.stream.Stream;

import seedu.address.logic.commands.FreeTimeCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.interval.Duration;
import seedu.address.model.interval.Interval;
import seedu.address.model.interval.IntervalBegin;
import seedu.address.model.interval.IntervalDay;
import seedu.address.model.interval.IntervalEnd;

/**
 * Parses input arguments and creates a new FreeTimeCommand object
 */
public class FreeTimeCommandParser implements Parser<FreeTimeCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FreeTimeCommand
     * and returns an FreeTimeCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FreeTimeCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DAY, PREFIX_DURATION, PREFIX_BEGIN, PREFIX_END);

        if (!arePrefixesPresent(argMultimap, PREFIX_DAY, PREFIX_DURATION, PREFIX_BEGIN, PREFIX_END)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FreeTimeCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_DAY, PREFIX_DURATION, PREFIX_BEGIN, PREFIX_END);

        IntervalDay day = ParserUtil.parseIntervalDay(argMultimap.getValue(PREFIX_DAY).get());
        Duration duration = ParserUtil.parseDuration(argMultimap.getValue(PREFIX_DURATION).get());
        IntervalBegin begin = ParserUtil.parseIntervalBegin(argMultimap.getValue(PREFIX_BEGIN).get());
        IntervalEnd end = ParserUtil.parseIntervalEnd(argMultimap.getValue(PREFIX_END).get());


        Interval interval = new Interval(day, duration, begin, end);

        return new FreeTimeCommand(interval);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
