package ch.bbw.aufgabenapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TodayListDecisionTableTest {

    private static final LocalDate TODAY = LocalDate.of(2026, 10, 27);
    private final TodayList todayList = new TodayList();

    @ParameterizedTest(name = "{0}: erledigt={1}, +{2} Tage, Prio {3} -> {4}")
    @CsvSource({
        "R1, true,  0, 4, HIDDEN",
        "R2, true,  0, 3, HIDDEN",
        "R3, true,  1, 4, HIDDEN",
        "R4, true,  1, 3, HIDDEN",
        "R5, false, 0, 4, PINNED",
        "R6, false, 0, 3, SHOWN",
        "R7, false, 1, 4, PINNED",
        "R8, false, 1, 3, HIDDEN"
    })
    void placement_followsDecisionTable(String rule, boolean done,
            int dueInDays, int priority, TodayList.Placement expected) {
        LocalDate dueDate = TODAY.plusDays(dueInDays);
        Task task = new Task("Testaufgabe", priority, dueDate, done);
        assertEquals(expected, todayList.placementFor(task, TODAY));
    }
}
