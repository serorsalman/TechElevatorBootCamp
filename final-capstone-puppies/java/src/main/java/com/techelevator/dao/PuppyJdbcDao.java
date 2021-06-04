package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.exceptions.PuppyNotFoundException;
import com.techelevator.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

/**
 * PuppyJdbcDao
 */
@Component
public class PuppyJdbcDao implements PuppyDao {

	private JdbcTemplate template;

	public PuppyJdbcDao(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Puppy> getPuppies() {
		String sqlGetPuppy = "SELECT * FROM puppies";
		SqlRowSet result = template.queryForRowSet(sqlGetPuppy);
		return mapResultsToPuppies(result);
	}

	@Override
	public Puppy getPuppy(int id) {
		String sqlGetPuppy = "SELECT * FROM puppies WHERE id=?";
		SqlRowSet result = template.queryForRowSet(sqlGetPuppy, id);
		if (result.next()) {
			return mapResultToPuppy(result);
		} else {
			throw new PuppyNotFoundException();
		}
	}





	private Puppy mapResultToPuppy(SqlRowSet result) {
		int id = result.getInt("id");
		String name = result.getString("name");
		int weight = result.getInt("weight");
		String gender = result.getString("gender");
		boolean paper_trained = result.getBoolean("paper_trained");
		String image = result.getString("image");
		Puppy retrievedPuppy = new Puppy(id, name, weight, gender, paper_trained, image);

		return retrievedPuppy;
	}

	private List<Puppy> mapResultsToPuppies(SqlRowSet results) {
		List<Puppy> retrievedPuppies = new ArrayList<>();
		while (results.next()) {
			retrievedPuppies.add(mapResultToPuppy(results));
		}

		return retrievedPuppies;
	}

	@Override
	public void savePuppy(Puppy puppyToSave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePuppy(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPuppy(Puppy puppyToSave) {
		// TODO Auto-generated method stub
		
	}


}