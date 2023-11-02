package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.FIONA;
import static seedu.address.testutil.TypicalPersons.HOON;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.testutil.AddressBookBuilder;



public class RevenueCommandTest {

    @Test
    public void execute_validRevenue() {
        // create addressbook with two persons
        AddressBookBuilder addressbook = new AddressBookBuilder();
        addressbook.withPerson(HOON);
        addressbook.withPerson(FIONA);

        // expected values
        double expectedRevenue = HOON.getMonthlyRevenue() + FIONA.getMonthlyRevenue();
        String formattedTotalRevenue = String.format("%.2f", expectedRevenue);
        String expectedMessage = RevenueCommand.MESSAGE_SUCCESS + formattedTotalRevenue;

        Command command = new RevenueCommand();
        Model model = new ModelManager(addressbook.build(), new UserPrefs());
        assertCommandSuccess(command, model, expectedMessage, model);
    }

    @Test
    public void execute_validRevenueEmptyList() {
        // create addressbook with no persons
        AddressBookBuilder addressbook = new AddressBookBuilder();

        // expected 0.00
        double expectedRevenue = 0.0;
        String formattedTotalRevenue = String.format("%.2f", expectedRevenue);
        String expectedMessage = RevenueCommand.MESSAGE_SUCCESS + formattedTotalRevenue;

        Command command = new RevenueCommand();
        Model model = new ModelManager(addressbook.build(), new UserPrefs());
        assertCommandSuccess(command, model, expectedMessage, model);
    }

}
