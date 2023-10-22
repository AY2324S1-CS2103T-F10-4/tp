package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;


/**
 * Panel containing the list of persons' schedules.
 */
public class ScheduleListPanel extends UiPart<Region> {

    private static final String FXML = "ScheduleListPanel.fxml";

    @FXML
    private ListView<Person> scheduleListView;

    private final Logger logger = LogsCenter.getLogger(ScheduleListPanel.class);

    /**
     * Creates a {@code ScheduleListPanel} with the given {@code ObservableList}.
     */
    public ScheduleListPanel(ObservableList<Person> personList) {
        super(FXML);
        scheduleListView.setItems(personList);
        scheduleListView.setCellFactory(listView -> new ScheduleListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class ScheduleListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ScheduleCard(person).getRoot());
            }
        }
    }


}
