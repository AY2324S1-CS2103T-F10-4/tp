package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Calculates the total monthly revenue from all tutees.
 */
public class RevenueCommand extends Command {

    public static final String COMMAND_WORD = "rev";
    public static final String MESSAGE_SUCCESS = "Sucessfully calculated!!" + "\nTotal monthly revenue: $";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Calculates total revenue "
            + "earned from all tutees in a month.\n " + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<Person> fullList = model.getUnfilteredPersonList();

        double totalRevenue = 0;
        // for every person, find revenue, add them tgt
        for (Person tutee : fullList) {
            // get revenue per lesson
            double lessonRevenue = tutee.getMonthlyRevenue();
            assert lessonRevenue >= 0;
            totalRevenue += lessonRevenue;
        }

        String formattedTotalRevenue = String.format("%.2f", totalRevenue);
        return new CommandResult(MESSAGE_SUCCESS + formattedTotalRevenue);
    }
}
