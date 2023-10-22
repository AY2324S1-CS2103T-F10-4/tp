package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;


/**
 * An UI component that displays schedule of a {@code Person}.
 */
public class ScheduleCard extends UiPart<Region> {

    private static final String FXML = "ScheduleCard.fxml";

    public final Person person;
    @FXML
    private HBox cardPane;

    @FXML
    private Label name;

    @FXML
    private Label address;

    @FXML
    private Label day;

    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public ScheduleCard(Person person) {
        super(FXML);
        this.person = person;
        name.setText(person.getName().fullName);
        address.setText(person.getAddress().value);
        day.setText(person.getDay().value.toString());
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }
}
