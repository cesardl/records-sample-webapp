package org.kodejava.example.mybatis.persistence;

import java.util.List;
import org.kodejava.example.mybatis.domain.Record;

/**
 *
 * @author Cesardl
 */
public interface RecordMapper {

    /**
     * Get a single Record from the database based on the record identified.
     *
     * @param id record identifier.
     * @return a record object.
     */
    Record getRecord(int id);

    /**
     *
     * @param record
     */
    void saveRecord(Record record);

    /**
     *
     * @param record
     */
    void updateRecord(Record record);

    /**
     *
     * @param id
     */
    void deleteRecord(int id);

    /**
     *
     * @return
     */
    List<Record> getAllRecords();
}
