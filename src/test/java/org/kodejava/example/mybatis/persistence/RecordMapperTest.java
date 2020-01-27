package org.kodejava.example.mybatis.persistence;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.kodejava.example.mybatis.domain.Record;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created on 1/26/2020.
 *
 * @author Cesardl
 */
public class RecordMapperTest {

    @Test
    public void crudTest() throws IOException {
        String resource = "org/kodejava/example/mybatis/Configuration.xml";
        Reader reader = Resources.getResourceAsReader(resource);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);

        try (SqlSession session = factory.openSession()) {
            RecordMapper mapper = session.getMapper(RecordMapper.class);
            Record record = mapper.getRecord(231);
            assertNotNull(record);
            System.out.println(record);

            Random random = new Random();
            Record newRecord = new Record();
            newRecord.setTitle(String.valueOf(random.nextFloat()));
            newRecord.setArtistId(random.nextInt());
            newRecord.setLabelId(random.nextInt());
            newRecord.setReleaseDate(new Date());
            mapper.saveRecord(newRecord);
            session.commit();

            int id = newRecord.getId();
            assertNotNull(newRecord);
            System.out.println(newRecord);

            List<Record> allRecords = mapper.getAllRecords();
            int initialSize = allRecords.size();
            allRecords.forEach(System.out::println);

            mapper.deleteRecord(id);

            record = mapper.getRecord(id);
            assertNull(record);

            allRecords = mapper.getAllRecords();
            allRecords.forEach(System.out::println);
            assertEquals(initialSize - 1, allRecords.size());
        }
    }
}
