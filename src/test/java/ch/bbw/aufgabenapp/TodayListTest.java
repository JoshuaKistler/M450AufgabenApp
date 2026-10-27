package ch.bbw.aufgabenapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class TodayListTest {

    private static final LocalDate TODAY = LocalDate.of(2026, 10, 27);
    private final TodayList todayList = new TodayList();

    @Test
    void openTaskDueToday_isShown() {
        Task task = new Task("Einkaufen", 2, TODAY, false);
        assertEquals(TodayList.Placement.SHOWN,
                todayList.placementFor(task, TODAY));
    }

    @Test
    void openTaskWithHighPriority_isPinned() {
        Task task = new Task("Prüfung lernen", 5, TODAY.plusDays(3), false);
        assertEquals(TodayList.Placement.PINNED,
                todayList.placementFor(task, TODAY));
    }
}
