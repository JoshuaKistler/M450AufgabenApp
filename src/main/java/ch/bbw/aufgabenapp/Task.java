package ch.bbw.aufgabenapp;
import java.time.LocalDate;
public record Task(String title, int priority, LocalDate dueDate,
                   boolean done) {
}