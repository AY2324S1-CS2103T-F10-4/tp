package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.getTypicalVersionedAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.testutil.PersonBuilder;

public class VersionedAddressBookTest {

    private final VersionedAddressBook oneVersionVersionedAddressBook = new VersionedAddressBook();
    private final VersionedAddressBook twoVersionVersionedAddressBook = new VersionedAddressBook();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), oneVersionVersionedAddressBook.getPersonList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                oneVersionVersionedAddressBook.resetData(null));
    }

    @Test
    public void undo_invalid_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, oneVersionVersionedAddressBook::undo);
    }

    @Test
    public void redo_invalid_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, oneVersionVersionedAddressBook::redo);
    }

    @Test
    public void canRedo_detects_invalidRedo() {
        assertFalse(oneVersionVersionedAddressBook.canRedo());
    }

    @Test
    public void canUndo_detects_invalidUndo() {
        assertFalse(oneVersionVersionedAddressBook.canUndo());
    }

    @Test
    public void commit_newVersionedAddressBook_updatesPointer() {
        assertFalse(twoVersionVersionedAddressBook.hasPerson(ALICE));

        // Simulate add command
        twoVersionVersionedAddressBook.addPerson(ALICE);

        // commit new version of address book into version history
        twoVersionVersionedAddressBook.commit();

        assertTrue(twoVersionVersionedAddressBook.hasPerson(ALICE));
    }

    @Test
    public void canRedo_detects_validRedo() {
        assertFalse(twoVersionVersionedAddressBook.hasPerson(ALICE));

        // Simulate add command
        twoVersionVersionedAddressBook.addPerson(ALICE);

        // commit new version of address book into version history
        twoVersionVersionedAddressBook.commit();

        assertTrue(twoVersionVersionedAddressBook.hasPerson(ALICE));

        // undo to empty addressbook
        assertTrue(twoVersionVersionedAddressBook.canUndo());
    }

    @Test
    public void canUndo_detects_validUndo() {
        assertFalse(twoVersionVersionedAddressBook.hasPerson(ALICE));

        // Simulate add command
        twoVersionVersionedAddressBook.addPerson(ALICE);

        // commit new version of address book into version history
        twoVersionVersionedAddressBook.commit();

        assertTrue(twoVersionVersionedAddressBook.hasPerson(ALICE));

        // Undo add command
        twoVersionVersionedAddressBook.undo();

        assertFalse(twoVersionVersionedAddressBook.hasPerson(ALICE));

        // Undo to empty addressbook
        assertTrue(twoVersionVersionedAddressBook.canRedo());
    }

    @Test
    public void purge_redundantDataAbsent_noDataRemoved() {
        assertFalse(twoVersionVersionedAddressBook.hasPerson(ALICE));

        twoVersionVersionedAddressBook.purge();

        assertEquals(twoVersionVersionedAddressBook, new AddressBook());
    }
    @Test
    public void purge_redundantDataPresent_removesRedundantData() {
        assertFalse(twoVersionVersionedAddressBook.hasPerson(ALICE));

        // Simulate add command
        twoVersionVersionedAddressBook.addPerson(ALICE);
        twoVersionVersionedAddressBook.commit();

        // Undo add command
        twoVersionVersionedAddressBook.undo();

        // Simulate add command and purge redundant data
        twoVersionVersionedAddressBook.purge();
        twoVersionVersionedAddressBook.addPerson(BOB);
        twoVersionVersionedAddressBook.commit();

        assertFalse(twoVersionVersionedAddressBook.canRedo());
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        AddressBook newData = getTypicalVersionedAddressBook();
        oneVersionVersionedAddressBook.resetData(newData);

        // commit new version into history
        oneVersionVersionedAddressBook.commit();

        assertEquals(newData, oneVersionVersionedAddressBook);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two persons with the same identity fields
        Person editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
        List<Person> newPersons = Arrays.asList(ALICE, editedAlice);
        VersionedAddressBookStub newData = new VersionedAddressBookStub(newPersons);

        assertThrows(DuplicatePersonException.class, () ->
                oneVersionVersionedAddressBook.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                oneVersionVersionedAddressBook.hasPerson(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(oneVersionVersionedAddressBook.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personInCurrentAddressBook_returnsTrue() {
        oneVersionVersionedAddressBook.addPerson(ALICE);

        // commit Add Command to memory
        oneVersionVersionedAddressBook.commit();

        assertTrue(oneVersionVersionedAddressBook.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInCurrentAddressBook_returnsTrue() {
        oneVersionVersionedAddressBook.addPerson(ALICE);

        // commit Add Command to memory
        oneVersionVersionedAddressBook.commit();

        oneVersionVersionedAddressBook.undo();

        oneVersionVersionedAddressBook.addPerson(ALICE);

        // commit Add Command to memory
        oneVersionVersionedAddressBook.commit();

        Person editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).build();
        assertTrue(oneVersionVersionedAddressBook.hasPerson(editedAlice));
    }

    @Test
    public void removePerson_removesPersonInAddressBook() {
        oneVersionVersionedAddressBook.addPerson(ALICE);

        // commit Add Command to memory
        oneVersionVersionedAddressBook.commit();

        oneVersionVersionedAddressBook.removePerson(ALICE);

        // commit delete Command to memory
        oneVersionVersionedAddressBook.commit();

        assertFalse(oneVersionVersionedAddressBook.hasPerson(ALICE));

        oneVersionVersionedAddressBook.undo();

        assertTrue(oneVersionVersionedAddressBook.hasPerson(ALICE));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () ->
                oneVersionVersionedAddressBook.getPersonList().remove(0));
    }

    @Test
    public void toStringMethod() {
        String expected = VersionedAddressBook.class.getCanonicalName()
                + "{persons=" + oneVersionVersionedAddressBook.getPersonList() + "}";
        assertEquals(expected, oneVersionVersionedAddressBook.toString());
    }

    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    private static class VersionedAddressBookStub implements ReadOnlyAddressBook {
        private final ObservableList<Person> persons = FXCollections.observableArrayList();

        VersionedAddressBookStub(Collection<Person> persons) {
            this.persons.setAll(persons);
        }

        @Override
        public ObservableList<Person> getPersonList() {
            return persons;
        }
    }

}
