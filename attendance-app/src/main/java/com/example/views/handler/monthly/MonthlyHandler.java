package views.handler.monthly;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import views.handler.BaseHandler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class MonthlyHandler extends BaseHandler {
    public List<AnchorPane> getListColumn(AnchorPane rootTimeTable) {
        List<AnchorPane> list = new ArrayList<>();

        ObservableList<Node> children = rootTimeTable.getChildren();

        for (Node child : children) {
            if (child instanceof AnchorPane) list.add((AnchorPane) child);
        }

        list.remove(0);
        list.remove(0);

        return list;
    }

    public void setTimeTableDate(LocalDate currentDate, AnchorPane rootTimeTable) {
        List<AnchorPane> list = getListColumn(rootTimeTable);

        int currentIndex = currentDate.getDayOfWeek().getValue(); // Mon-1 Sun-7

        List<String> weeksLabel = new ArrayList<>();
        for(DayOfWeek day : DayOfWeek.values()) {
            String dayName = day.name();

            String firstLetter = dayName.substring(0, 1).toUpperCase();
            String remainingLetter = dayName.substring(1).toLowerCase();

            String capitalizedDay = firstLetter  + remainingLetter;
            weeksLabel.add(capitalizedDay);
        }

        List<LocalDate> weekDates = new ArrayList<>();

        for(int i = 0;i < 7; i++) {
            LocalDate tempDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), currentDate.getDayOfMonth());
            weekDates.add(tempDate.minusDays(currentIndex - i - 1));
        }


        List<String> weekLabelsAndDates = new ArrayList<>();
        for(int i = 0;i < 7; i++) {
            weekLabelsAndDates.add(weeksLabel.get(i) + "\n" + weekDates.get(i));
        }

        for(AnchorPane column : list) {
            int index = list.indexOf(column);

            if(index != currentIndex - 1) column.getStyleClass().remove("column-active");
            else column.getStyleClass().add("column-active");

            Node firstNode = column.getChildren().get(0);

            if(firstNode instanceof Label label) {
                label.setText(weekLabelsAndDates.get(index));
            }
        }
    }

    abstract void initWeekAttendTime(String employeeId, List<AnchorPane> weekColumns);
}
