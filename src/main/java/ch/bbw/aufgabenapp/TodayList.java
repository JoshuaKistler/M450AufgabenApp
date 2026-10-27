package ch.bbw.aufgabenapp;
import java.time.LocalDate;
public class TodayList {
    public enum Placement { HIDDEN, SHOWN, PINNED }
    public static final int HIGH_PRIORITY = 4;
    public Placement placementFor(Task task, LocalDate today) {
        if (task.done()) {
            return Placement.HIDDEN;
        }
        if (task.priority() >= HIGH_PRIORITY) {
            return Placement.PINNED;
        }
        if (task.dueDate().isAfter(today)) {
            return Placement.HIDDEN;
        }
        return Placement.SHOWN;
    }
}