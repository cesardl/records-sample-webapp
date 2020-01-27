package org.kodejava.example.mybatis.persistence;

import org.kodejava.example.mybatis.domain.Record;

import java.util.List;

/**
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
     * @param record entity to save.
     */
    void saveRecord(Record record);

    /**
     * @param record entity to update.
     */
    void updateRecord(Record record);

    /**
     * @param id record identifier.
     */
    void deleteRecord(int id);

    /**
     * @return list of records.
     */
    List<Record> getAllRecords();
}
