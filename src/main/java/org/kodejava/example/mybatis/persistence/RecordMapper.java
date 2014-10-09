/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kodejava.example.mybatis.persistence;

import java.util.List;
import org.kodejava.example.mybatis.domain.Record;

/**
 *
 * @author pdiaz
 */
public interface RecordMapper {

    /**
     * Get a single Record from the database based on the record
     * identified.
     *
     * @param id record identifier.
     * @return a record object.
     */
    Record getRecord(int id);

    /**
     *
     * @param record
     */
    public void saveRecord(Record record);

    /**
     *
     * @param record
     */
    public void updateRecord(Record record);

    /**
     *
     * @param id
     */
    public void deleteRecord(int id);

    /**
     *
     * @return
     */
    public List<Record> getAllRecords();
}
