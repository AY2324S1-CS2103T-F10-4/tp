package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Subject subject;
    private final Day day;
    private final Begin begin;
    private final End end;

    private boolean paid;
    private PayRate payRate;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Subject subject, Day day,
                  Begin begin, End end, boolean paid, PayRate payRate) {
        requireAllNonNull(name, phone, email, address, subject, day, begin, end);

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.subject = subject;
        this.day = day;
        this.begin = begin;
        this.end = end;
        this.paid = paid;
        this.payRate = payRate;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Subject getSubject() {
        return subject;
    }

    public Day getDay() {
        return day;
    }


    public Begin getBegin() {
        return begin;
    }

    public End getEnd() {
        return end;
    }

    public boolean getPaid() {
        return paid;
    }

    public void setPaid() {
        this.paid = true;
    }

    public PayRate getPayRate() {
        return payRate;
    }
  
    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && subject.equals(otherPerson.subject)
                && day.equals(otherPerson.day)
                && begin.equals(otherPerson.begin)
                && end.equals(otherPerson.end)
                && payRate.equals(otherPerson.payRate);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, subject, day, begin, end, paid, payRate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("subject", subject)
                .add("day", day)
                .add("begin", begin)
                .add("end", end)
                .add("paid", paid)
                .add("payrate", payRate)
                .toString();
    }

}
