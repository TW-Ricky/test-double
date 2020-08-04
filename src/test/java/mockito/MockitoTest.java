package mockito;

import mock.DoorPanel;
import mock.SecurityCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stub.GradeService;
import stub.GradeSystem;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoTest {
    private SecurityCenter securityCenter;
    private DoorPanel doorPanel;
    private GradeService gradeService;
    private GradeSystem gradeSystem;
    @BeforeEach
    public void init() {
        doorPanel = mock(DoorPanel.class);
        securityCenter = new SecurityCenter(doorPanel);
        gradeSystem = mock(GradeSystem.class);
        when(gradeSystem.gradesFor(1)).thenReturn(Arrays.asList(70.0, 80.0, 90.0));
        gradeService = new GradeService(gradeSystem);
    }

    @Test
    public void should_return_true_when_verify_given_mock() {
        securityCenter.switchOn();
        verify(doorPanel, times(1)).close();
    }

    @Test
    public void should_return_80_when_calculateAverageGrades_given_stub() {
        Double result = gradeService.calculateAverageGrades(1);
        assertEquals(80.0, result);
    }
}
