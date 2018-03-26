package studentDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDAO {
	private final String username;
	private final String password;
	private final String databaseURL;

	public StudentDAO() throws Exception {
		username = ConnectionParameters.username;
		password = ConnectionParameters.password;
		databaseURL = ConnectionParameters.databaseURL;

		// In *Tomcat 8* the JDBC driver must be explicitly loaded as below
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
  * Opens a new database connection 
  * @throws SQLException
  */
	private Connection openConnection() throws SQLException {
		Connection dbConnection = DriverManager.getConnection(databaseURL, username, password);
		return dbConnection;
	}

	/**
  * Closes an existing database connection 
  * @throws SQLException
  */
	private void closeConnection(Connection dbConnection) throws SQLException {
		if (dbConnection != null) {
			dbConnection.close();
		}
	}

	/**
  * Retrieves all student from the database. 
  * @return ArrayList<Student> - a List of Movies
  * @throws SQLException
  */
	/////////////////////////////////////////////////////////
	public ArrayList < Student > getAllStudents() throws SQLException {
		ArrayList < Student > studentList = new ArrayList < Student > ();
		Connection dbConnection = null;

		try {
			dbConnection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice " + "FROM Student ORDER BY firstname";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

			return studentList;

		} catch(SQLException sqle) {
			throw sqle; // Let the caller decide what to do with the exception
		} finally {
			closeConnection(dbConnection);
		}
	}

	public ArrayList < Student > getStudentById(int givenId) throws SQLException {
		ArrayList < Student > studentList = new ArrayList < Student > ();
		Connection dbConnection = null;

		try {
			dbConnection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice " + "FROM Student where id=? ORDER BY firstname";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, givenId);

			ResultSet resultSet = preparedStatement.executeQuery();
			boolean rowFound = false;
			while (resultSet.next()) {
				rowFound = true;
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}
			if (!rowFound) {
				System.out.println("No student found with id " + givenId);
			}
			return studentList;

		} catch(SQLException sqle) {
			throw sqle; // Let the caller decide what to do with the exception
		} finally {
			closeConnection(dbConnection);
		}
	}
////////////////////////////////////////////////
	public int insertStudent(Student student) throws SQLException {
		int resultCode = -1;
		Connection dbConnection = null;
		try {
			dbConnection = openConnection();
			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstname());
			preparedStatement.setString(3, student.getLastname());
			preparedStatement.setString(4, student.getStreetaddress());
			preparedStatement.setString(5, student.getPostcode());
			preparedStatement.setString(6, student.getPostoffice());
			preparedStatement.executeUpdate();
			resultCode = 0;
		} catch(SQLException sqle) {
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				/*System.out.println("Cannot insert the data. " +
		        "The student id (" + student.getId() + ") is already in use.");*/
				resultCode = 1;
			} else {
				/*System.out.println("===== Database error =====\n" + sqle.getMessage());*/
				resultCode = -1;
			} // Let the caller decide what to do with the exception
		} finally {
			closeConnection(dbConnection);
		}

		return resultCode;
	}
	//////////////////////////////////////////////
	
	public String getAllStudentsJSON() throws SQLException {
		String studentJSON = "";
		Connection dbConnection = null;

		try {
			dbConnection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY firstname";

			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);

			ResultSet resultSet = preparedStatement.executeQuery();
			studentJSON = "{\"students\":[";
			while (resultSet.next()) {
				studentJSON += "\n{\"firstname\":\""+resultSet.getString("firstname")+"\","+
						"\"lastname\":\""+resultSet.getString("lastname")+"\","+
						"\"streetaddress\":\""+resultSet.getString("streetaddress")+"\","+
						"\"postcode\":\""+resultSet.getString("postcode")+"\","+
						"\"postoffice\":\""+resultSet.getString("postoffice")+"\"},";
						
				}
			String studentJSONNoLastComma = studentJSON.substring(0,studentJSON.length()-1);
			
			studentJSONNoLastComma += "\n]}";
			return studentJSONNoLastComma;

		} catch(SQLException sqle) {
			throw sqle; // Let the caller decide what to do with the exception
		} finally {
			closeConnection(dbConnection);
		}
	}
	
}