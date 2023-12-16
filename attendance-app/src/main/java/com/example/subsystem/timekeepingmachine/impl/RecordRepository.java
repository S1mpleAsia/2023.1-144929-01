package subsystem.timekeepingmachine.impl;

import mapper.impl.RecordMapper;
import model.Record;
import subsystem.AbstractRepository;
import subsystem.timekeepingmachine.IRecordRepository;
import utils.Utils;

import java.time.LocalDate;
import java.util.List;

public class RecordRepository extends AbstractRepository<Record> implements IRecordRepository {
    private static RecordRepository recordRepository = null;

    public static RecordRepository getInstance() {
        if (recordRepository == null) recordRepository = new RecordRepository();

        return recordRepository;
    }

    @Override
    public List<Record> getRecordListByEmployeeIdAndDate(String employeeId, LocalDate startDate) {
        String sql = "SELECT * FROM record " +
                "WHERE employee_id = ? " +
                "AND check_time >= ? " +
                "AND check_time < DATE_ADD(?, INTERVAL 1 DAY)";

        return query(sql, RecordMapper.getInstance(), employeeId, startDate.toString(), startDate.toString());
    }

    @Override
    public Record getFirstRecordOfTime(String employeeId, String stringDate) {
        LocalDate nextDay = Utils.convert(stringDate).plusDays(1);
        String prevDay = stringDate.split(" ")[0];

        String sql = "SELECT * FROM record " +
                "WHERE employee_id = ? " +
                "AND check_time > ? " +
                "AND check_time < ? " +
                "AND check_time >= ? " +
                "ORDER BY check_time ASC " +
                "LIMIT 1";
        List<Record> recordList = query(sql, RecordMapper.getInstance(), employeeId, prevDay, nextDay.toString(), stringDate);

        return recordList.isEmpty() ? null : recordList.get(0);
    }

    @Override
    public Record getLastRecordOfTime(String employeeId, String stringDate) {
        LocalDate nextDay = Utils.convert(stringDate).plusDays(1);
        String prevDay = stringDate.split(" ")[0];


        String sql = "SELECT * FROM record " +
                "WHERE employee_id = ? " +
                "AND check_time > ? " +
                "AND check_time < ? " +
                "AND check_time <= ? " +
                "ORDER BY check_time DESC " +
                "LIMIT 1";
        List<Record> recordList = query(sql, RecordMapper.getInstance(), employeeId, prevDay, nextDay.toString(), stringDate);

        return recordList.isEmpty() ? null : recordList.get(0);
    }
}
