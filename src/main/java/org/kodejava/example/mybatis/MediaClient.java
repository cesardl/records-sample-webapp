/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kodejava.example.mybatis;

import java.io.Reader;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.kodejava.example.mybatis.domain.Record;
import org.kodejava.example.mybatis.persistence.RecordMapper;

/**
 *
 * @author pdiaz
 */
public class MediaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String resource = "org/kodejava/example/mybatis/Configuration.xml";
        Reader reader = Resources.getResourceAsReader(resource);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);

        SqlSession session = factory.openSession();
        try {
            RecordMapper mapper = session.getMapper(RecordMapper.class);
            Record record = mapper.getRecord(2);
            System.out.println("Record = " + record);

            Record newRecord = new Record();
            newRecord.setId(100);
            newRecord.setArtistId(12);
            newRecord.setLabelId(3);
            newRecord.setReleaseDate(new Date());
//            mapper.saveRecord(newRecord);
//            session.commit();

            List<Record> allRecords = mapper.getAllRecords();
            for (Record r : allRecords) {
                System.out.println(r);
            }
        } finally {
            session.close();
        }
    }

}
