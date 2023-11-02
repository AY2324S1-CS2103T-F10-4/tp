package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BEGIN_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BEGIN_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DAY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DAY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_END_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_END_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PAYRATE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PAYRATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SUBJECT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SUBJECT_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.VersionedAddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withSubject("Maths")
            .withDay("Mon")
            .withBegin("0800")
            .withEnd("1000")
            .withPayRate("20.00")
            .build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withSubject("Chemistry")
            .withDay("Tue")
            .withBegin("0900")
            .withEnd("1100")
            .withPayRate("15.00")
            .build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street")
            .withSubject("Biology")
            .withDay("Thu")
            .withBegin("1000")
            .withEnd("1200")
            .withPayRate("25.00")
            .build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street")
            .withSubject("Physics")
            .withDay("Thu")
            .withBegin("1100")
            .withEnd("1300")
            .withPayRate("35.00")
            .build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave")
            .withSubject("Maths")
            .withDay("Fri")
            .withBegin("1200")
            .withEnd("1400")
            .withPayRate("50.00")
            .build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo")
            .withSubject("English")
            .withDay("Sat")
            .withBegin("1300")
            .withEnd("1500")
            .withPayRate("40.00")
            .build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street")
            .withSubject("Chinese")
            .withDay("Sun")
            .withBegin("1400")
            .withEnd("1620")
            .withPayRate("30.00")
            .build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india")
            .withSubject("Maths")
            .withDay("Mon")
            .withBegin("0800")
            .withEnd("1000")
            .withPayRate("10.00")
            .build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave")
            .withSubject("English")
            .withDay("Tue")
            .withBegin("0900")
            .withEnd("1100")
            .withPayRate("60.00")
            .build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
            .withSubject(VALID_SUBJECT_AMY).withDay(VALID_DAY_AMY).withBegin(VALID_BEGIN_AMY)
            .withEnd(VALID_END_AMY).withPayRate(VALID_PAYRATE_AMY).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withSubject(VALID_SUBJECT_BOB)
            .withDay(VALID_DAY_BOB).withBegin(VALID_BEGIN_BOB).withEnd(VALID_END_BOB)
            .withPayRate(VALID_PAYRATE_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    /**
     * Returns an {@code VersionedAddressBook} with all the typical persons.
     */
    public static VersionedAddressBook getTypicalVersionedAddressBook() {
        VersionedAddressBook vab = new VersionedAddressBook();
        for (Person person : getTypicalPersons()) {
            vab.addPerson(person);
        }
        return vab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
