package use_cases;

import entities.Meeting;
import entities.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static use_cases.TimetableValidator.validateMeetings;

public class TimetableValidatorTest {
    @Test
    /**
     * Test if the TimetableValidator class outputs the correct boolean object if there is a session overlap
     */
    public void TestTimetableValidator() {
        Session session1 = new Session(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(5,0), "BA2165");
        Session session2 = new Session(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(5,0), "BA2165");

        Meeting meeting1 = new Meeting("0101", Meeting.Type.LEC, "L McQueen", 100, 70, 0, session1);
        Meeting meeting2 = new Meeting("0201", Meeting.Type.LEC, "L McQueen", 100, 70, 0, session2);
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(meeting1);
        meetings.add(meeting2);

        boolean checkOverlap = validateMeetings(meetings);

        Assertions.assertTrue(checkOverlap);
    }
}
