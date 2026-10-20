package ch.bbw.aufgabenapp;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskValidatorTest {

    private final TaskValidator validator = new TaskValidator();
    private final LocalDate today = LocalDate.of(2026, 10, 20); // Referenzdatum "heute"

    // ==========================================
    // TITEL (TF-01 bis TF-07)
    // ==========================================
    @Test void TF_01() { assertFalse(validator.isTitleValid("")); }
    @Test void TF_02() { assertTrue(validator.isTitleValid("a")); }
    @Test void TF_03() { assertTrue(validator.isTitleValid("a".repeat(50))); }
    @Test void TF_04() { assertTrue(validator.isTitleValid("a".repeat(100))); } // Grenzwert (sollte gültig sein)
    @Test void TF_05() { assertFalse(validator.isTitleValid("a".repeat(101))); }
    @Test void TF_06() { assertFalse(validator.isTitleValid(null)); }
    @Test void TF_07() { assertFalse(validator.isTitleValid("   ")); }

    // ==========================================
    // PRIORITÄT (TF-08 bis TF-12)
    // ==========================================
    @Test void TF_08() { assertFalse(validator.isPriorityValid(0)); }
    @Test void TF_09() { assertTrue(validator.isPriorityValid(1)); }
    @Test void TF_10() { assertTrue(validator.isPriorityValid(3)); }
    @Test void TF_11() { assertTrue(validator.isPriorityValid(5)); }
    @Test void TF_12() { assertFalse(validator.isPriorityValid(8)); }

    // ==========================================
    // FÄLLIGKEITSDATUM (TF-13 bis TF-16)
    // ==========================================
    @Test void TF_13() { assertFalse(validator.isDueDateValid(LocalDate.of(2007, 12, 13), today)); }
    @Test void TF_14() { assertTrue(validator.isDueDateValid(LocalDate.of(2026, 10, 20), today)); } // Grenzwert "heute" (sollte gültig sein)
    @Test void TF_15() { assertTrue(validator.isDueDateValid(LocalDate.of(2026, 12, 13), today)); }
    @Test void TF_16() { assertFalse(validator.isDueDateValid(null, today)); }
    @Test void TF_17() { assertTrue(validator.isDueDateValid(LocalDate.of(9999, 12, 31), today)); } // TF-17: Spezialfall - Extremes Datum (ferne Zukunft)
}
