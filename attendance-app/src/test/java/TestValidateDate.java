import dto.WorkerDataByDayDTO;
import org.junit.Assert;
import org.junit.Test;
import subsystem.timekeepingmachine.impl.RecordRepository;
import usecase.detail.BaseDetailController;
import usecase.detail.impl.WorkerDetailController;

import java.time.LocalDate;

public class TestValidateDate {
    private final BaseDetailController<WorkerDataByDayDTO> workerDetailController = new WorkerDetailController(RecordRepository.getInstance());
    @Test
    public void TC1() {
        String date = "2023-01-01";
        Assert.assertEquals(LocalDate.of(2023,1,1), workerDetailController.validateDate(date));
    }

    @Test
    public void TC2() {
        String date = "2023-12-31";
        Assert.assertEquals(LocalDate.of(2023,12,31), workerDetailController.validateDate(date));
    }

    @Test
    public void TC3() {
        String date = "1000-10-30";
        Assert.assertEquals(LocalDate.of(1000, 10, 30), workerDetailController.validateDate(date));
    }

    @Test
    public void TC4() {
        String date = "2002-07-18";
        Assert.assertEquals(LocalDate.of(2002,7,18), workerDetailController.validateDate(date));
    }

    @Test
    public void TC5() {
        String date = "2023-12-32";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC6() {
        String date = "2023-13-15";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC7() {
        String date = "20200-05-10";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC8() {
        String date = "2022-5-15";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC9() {
        String date = "2022/5/15";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC10() {
        String date = "abc";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC11() {
        String date = "yyyy/mm/dd";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC12() {
        String date = "2022-5-4";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC13() {
        String date = "2022520";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC14() {
        String date = "2022-05";
        Assert.assertNull(workerDetailController.validateDate(date));
    }

    @Test
    public void TC15() {
        String date = "05-18";
        Assert.assertNull(workerDetailController.validateDate(date));
    }
}
