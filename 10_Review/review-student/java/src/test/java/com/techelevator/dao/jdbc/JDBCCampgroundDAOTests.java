package com.techelevator.dao.jdbc;

import com.techelevator.dao.CampgroundDAO;
import com.techelevator.model.Campground;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JDBCCampgroundDAOTests extends BaseDAOTests {

    private CampgroundDAO dao;

    @Before
    public void setup() {
        String sql = "DELETE FROM reservation; " +
                "DELETE FROM site; " +
                "DELETE FROM campground; " +
                "DELETE FROM park; " +
                "INSERT INTO park (park_id, name, location, establish_date, area, visitors, description) " +
                "VALUES (98, 'Park 1', 'Pennsylvania', '1/1/1970', 1024, 512, 'Test description 1'); " +
                "INSERT INTO park (park_id, name, location, establish_date, area, visitors, description) " +
                "VALUES (99, 'Park 2', 'Ohio', '1/1/1970', 2048, 1024, 'Test description 2'); " +
                "INSERT INTO campground(campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee) " +
                "VALUES (998, 99, 'Test Campground 1', '1', '12', 35); " +
                "INSERT INTO campground(campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee) " +
                "VALUES (999, 99, 'Test Campground 2', '1', '12', 35)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
        dao = new JDBCCampgroundDAO(dataSource);
    }

    @Test
    public void getCampgrounds_Should_ReturnAllCampgrounds() {
        List<Campground> campgrounds = dao.getCampgroundsByParkId(99);

        assertEquals(2,campgrounds.size());
    }
@Test
    public void CreateNewCampgroundReturns_New_campground(){

    Campground campground = new Campground();
    campground.setParkId(99);
    campground.setName("Minnie's Campground");
    campground.setDailyFee(15.00);
    campground.setOpenFromMonth(1);
    campground.setOpenToMonth(12);
    Campground savedCampground = dao.createNewCampground(campground);
    //call the helper method
    assertCampgroundsAreSame(campground, savedCampground);
}

//helper method
public void assertCampgroundsAreSame(Campground expected, Campground actual){
    assertEquals(expected.getParkId(), actual.getParkId());
    assertEquals(expected.getCampgroundId(), actual.getCampgroundId());
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getOpenFromMonth(), actual.getOpenFromMonth());
    assertEquals(expected.getOpenToMonth(), actual.getOpenToMonth());
    // assertEquals(double, double) is deprecated -- you have to pass in a delta value
    // a delta says we can vary by the delta amount (+/-) and still be considered equal
    assertEquals(expected.getDailyFee(), actual.getDailyFee(), 0.001);
}
}

