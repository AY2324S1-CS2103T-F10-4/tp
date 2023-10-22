package seedu.address.testutil;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Address;
import seedu.address.model.person.Begin;
import seedu.address.model.person.Day;
import seedu.address.model.person.Email;
import seedu.address.model.person.End;
import seedu.address.model.person.Name;
import seedu.address.model.person.PayRate;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Subject;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setPhone(person.getPhone());
        descriptor.setEmail(person.getEmail());
        descriptor.setAddress(person.getAddress());
        descriptor.setSubject(person.getSubject());
        descriptor.setDay(person.getDay());
        descriptor.setBegin(person.getBegin());
        descriptor.setEnd(person.getEnd());
        descriptor.setPaid(null);
        descriptor.setPayRate(person.getPayRate());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }
  
    /**
     * Sets the {@code Subject} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withSubject(String subject) {
        descriptor.setSubject(new Subject(subject));
        return this;
    }

    /**
     * Sets the {@code Day} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withDay(String day) {
        descriptor.setDay(new Day(day));
        return this;
    }

    /**
     * Sets the {@code Begin} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withBegin(String begin) {
        descriptor.setBegin(new Begin(begin));
        return this;
    }

    /**
     * Sets the {@code End} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEnd(String end) {
        descriptor.setEnd(new End(end));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withPayRate(String payRate) {
        descriptor.setPayRate(new PayRate(payRate));
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
