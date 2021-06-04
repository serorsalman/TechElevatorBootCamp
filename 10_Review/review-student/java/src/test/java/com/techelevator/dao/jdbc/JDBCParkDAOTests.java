package com.techelevator.dao.jdbc;

import com.techelevator.dao.ParkDAO;
import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class JDBCParkDAOTests extends BaseDAOTests {

    private ParkDAO parkDao;

    @Before
    public void setup() {
        String sqlParkScript = "DELETE FROM reservation; DELETE from site; DELETE FROM campground;"+
                "DELETE FROM park; INSERT INTO park ( Park_id, name, location, establish_date, area, visitors, description) " +
                "VALUES (98, 'Park 1', 'Pennsylvania', '1/1/1970', 1024, 512, 'Test description 1'); " +
                " " +
                "INSERT INTO park (park_id, name, location, establish_date, area, visitors, description) " +
                "VALUES (99, 'Park 2', 'Ohio', '1/1/1970', 2048, 1024, 'Test description 2');";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlParkScript);

        parkDao = new JDBCParkDAO(dataSource);
    }

    @Test
    public void getParksTest_Should_ReturnAllParksInLocationAlphaOrder() {
        List<Park> parks = parkDao.getAllParks();

        assertEquals(2, parks.size());
        assertEquals("Ohio", parks.get(0).getLocation());
        assertEquals("Pennsylvania", parks.get(1).getLocation());
    }

}
