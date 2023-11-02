package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INTERVAL_BEGIN_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.INTERVAL_DAY_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.INTERVAL_DURATION_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.INTERVAL_END_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVAL_BEGIN_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVAL_DAY_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVAL_DURATION_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INTERVAL_END_DESC_ONE;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVAL_BEGIN;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVAL_DAY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVAL_DURATION;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVAL_END;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTERVAL_ONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BEGIN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.FreeTimeCommand;
import seedu.address.model.interval.Duration;
import seedu.address.model.interval.IntervalBegin;
import seedu.address.model.interval.IntervalDay;
import seedu.address.model.interval.IntervalEnd;

public class FreeTimeCommandParserTest {

    private FreeTimeCommandParser parser = new FreeTimeCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + INTERVAL_DAY_DESC_ONE + INTERVAL_DURATION_DESC_ONE
                + INTERVAL_BEGIN_DESC_ONE + INTERVAL_END_DESC_ONE, new FreeTimeCommand(VALID_INTERVAL_ONE));
    }

    @Test
    public void parse_repeatedValue_failure() {
        String validExpectedInterval = INTERVAL_DAY_DESC_ONE + INTERVAL_DURATION_DESC_ONE
                + INTERVAL_BEGIN_DESC_ONE + INTERVAL_END_DESC_ONE;

        // multiple days
        assertParseFailure(parser, INTERVAL_DAY_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DAY));

        // multiple durations
        assertParseFailure(parser, INTERVAL_DURATION_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DURATION));

        //multiple begin
        assertParseFailure(parser, INTERVAL_BEGIN_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_BEGIN));

        //multiple end
        assertParseFailure(parser, INTERVAL_END_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_END));

        // invalid value followed by valid value
        assertParseFailure(parser, INVALID_INTERVAL_DAY_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DAY));

        assertParseFailure(parser, INVALID_INTERVAL_BEGIN_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_BEGIN));

        assertParseFailure(parser, INVALID_INTERVAL_END_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_END));

        assertParseFailure(parser, INVALID_INTERVAL_DURATION_DESC_ONE + validExpectedInterval,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DURATION));

    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, FreeTimeCommand.MESSAGE_USAGE);

        // missing day prefix
        assertParseFailure(parser, VALID_INTERVAL_DAY + INTERVAL_DURATION_DESC_ONE + INTERVAL_BEGIN_DESC_ONE
                + INTERVAL_END_DESC_ONE, expectedMessage);

        // missing DURATION prefix
        assertParseFailure(parser, INTERVAL_DAY_DESC_ONE + VALID_INTERVAL_DURATION + INTERVAL_BEGIN_DESC_ONE
                + INTERVAL_END_DESC_ONE, expectedMessage);

        // missing BEGIN prefix
        assertParseFailure(parser, INTERVAL_DAY_DESC_ONE + INTERVAL_DURATION_DESC_ONE + VALID_INTERVAL_BEGIN
                + INTERVAL_END_DESC_ONE, expectedMessage);

        // missing END prefix
        assertParseFailure(parser, INTERVAL_DAY_DESC_ONE + INTERVAL_DURATION_DESC_ONE + INTERVAL_BEGIN_DESC_ONE
                + VALID_INTERVAL_END, expectedMessage);

    }

    @Test
    public void parse_invalidValue_failure() {
        //invalid day
        assertParseFailure(parser, INVALID_INTERVAL_DAY_DESC_ONE + INTERVAL_DURATION_DESC_ONE
            + INTERVAL_BEGIN_DESC_ONE + INTERVAL_END_DESC_ONE, IntervalDay.MESSAGE_CONSTRAINTS);

        //invalid duration
        assertParseFailure(parser, INTERVAL_DAY_DESC_ONE + INVALID_INTERVAL_DURATION_DESC_ONE
                + INTERVAL_BEGIN_DESC_ONE + INTERVAL_END_DESC_ONE, Duration.MESSAGE_CONSTRAINTS);

        //invalid begin
        assertParseFailure(parser, INTERVAL_DAY_DESC_ONE + INTERVAL_DURATION_DESC_ONE
                + INVALID_INTERVAL_BEGIN_DESC_ONE + INTERVAL_END_DESC_ONE, IntervalBegin.MESSAGE_CONSTRAINTS);

        //invalid end
        assertParseFailure(parser, INTERVAL_DAY_DESC_ONE + INTERVAL_DURATION_DESC_ONE
                + INTERVAL_BEGIN_DESC_ONE + INVALID_INTERVAL_END_DESC_ONE, IntervalEnd.MESSAGE_CONSTRAINTS);
    }

}
