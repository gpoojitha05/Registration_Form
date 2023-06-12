package net.javaguides.registration.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.javaguides.registration.model.Employee;
public class EmployeeDao {

	public int registerEmployee(Employee
			employees) throws ClassNotFoundException {
		String INSERT_USERS_SQL="INSERT INTO employees "+
	         "(id,first_name,last_name,username,password,address,contact)VALUES" +
	         "( ?, ?, ?, ?, ?, ?, ?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false","root","Gpooji@34567");
	         
		//Step 2: Create a Statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2,employees.getFirstName());
			preparedStatement.setString(3,employees.getLastName());
			preparedStatement.setString(4,employees.getUserName());
			preparedStatement.setString(5,employees.getPassword());
			preparedStatement.setString(6,employees.getAddress());
			preparedStatement.setString(7,employees.getContact());
			
			System.out.println(preparedStatement);
			
			//Step 3: Execute the query or update query
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			//process SQL Exception
			e.printStackTrace();
		}
		return result;
	}
}
