package com.techelevator.dao.jdbc;

import com.techelevator.dao.CampgroundDAO;
import com.techelevator.model.Campground;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JDBCCampgroundDAO implements CampgroundDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCCampgroundDAO(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Campground> getCampgroundsByParkId(int parkId) {
            List<Campground> campgrounds = new ArrayList<>();
            String sqlFindCampgroundByParkId = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm," +
                    " daily_fee FROM campground WHERE park_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCampgroundByParkId, parkId);
            while (results.next()){
                Campground campground = mapRowToCampground(results);
                campgrounds.add(campground);
            }


        return campgrounds;
    }

    @Override
    public Campground createNewCampground(Campground campground) {

        String sqlInsertCampground = "INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING campground_id";
        int campground_id = jdbcTemplate.queryForObject(sqlInsertCampground, Integer.class, campground.getParkId(),
                campground.getName(), campground.getOpenFromMonth(), campground.getOpenToMonth(),
                new BigDecimal(campground.getDailyFee())); // need to convert the double to a BigDecimal

        campground.setCampgroundId(campground_id);
        return campground;
    }

    private Campground mapRowToCampground(SqlRowSet results) {
        Campground camp = new Campground();
        camp.setCampgroundId(results.getInt("campground_id"));
        camp.setParkId(results.getInt("park_id"));
        camp.setName(results.getString("name"));
        camp.setOpenFromMonth(results.getInt("open_from_mm"));
        camp.setOpenToMonth(results.getInt("open_to_mm"));
        camp.setDailyFee(results.getDouble("daily_fee"));
        return camp;
    }
}
