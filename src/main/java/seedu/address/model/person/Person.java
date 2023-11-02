package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private final Lesson lesson;
    private boolean paid;
    private PayRate payRate;
    private Date beginTime;
    private Date endTime;

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
        this.paid = paid;
        this.payRate = payRate;
        this.lesson = new Lesson(day, begin, end);

        try {
            this.beginTime = convertTime(begin.toString());
            this.endTime = convertTime(end.toString());
        } catch (ParseException e) {
            //something
        }

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

    /**
     * Return defensive copy of day
     * @return day
     */
    public Day getDay() {
        String day = lesson.day.toString();
        return new Day(day);
    }

    /**
     * Return defensive copy of Begin
     * @return begin
     */
    public Begin getBegin() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        String begin = lesson.begin.format(formatter);
        return new Begin(begin);
    }

    /**
     * Return defensive copy of end
     * @return end
     */
    public End getEnd() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        String end = lesson.end.format(formatter);
        return new End(end);
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public boolean getPaid() {
        return paid;
    }

    public void setPaid() {
        this.paid = true;
    }

    public void setUnPaid() {
        this.paid = false;
    }

    public PayRate getPayRate() {
        return payRate;
    }

    /**
     * converts a string time into a date object
     * @param time
     * @return date object of the time
     * @throws ParseException
     */
    public Date convertTime(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HHmm");
        return format.parse(time);
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
     * checks for clashing schedules
     * @param otherPerson other person to be checked
     * @return boolean for whether schedules clash
     */
    public boolean isSameDate(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getDay().equals(getDay())
                && getBeginTime().before(otherPerson.getEndTime())
                && otherPerson.getBeginTime().before(getEndTime());
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
                && lesson.equals(otherPerson.lesson)
                && payRate.equals(otherPerson.payRate);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, subject, lesson, paid, payRate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("subject", subject)
                .add("lesson", lesson)
                .add("paid", paid)
                .add("payrate", payRate)
                .toString();
    }

    public double getMonthlyRevenue() {
        return lesson.getMonthlyHours() * payRate.getValue();
    }
}
