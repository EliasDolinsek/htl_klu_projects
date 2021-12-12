package dao;


import obj.DbConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeDao {
    private static Connection connection;
    private static Statement statement;

    public static ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            connection = DbConnection.getConnection();
            statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Mitarbeiter;");

            while (results.next()) {
                int id = results.getInt("id");
                String lastName = results.getString("nachname");
                String firstName = results.getString(3);

                char sex = results.getString(4).charAt(0);
                LocalDate birthday = results.getDate(5).toLocalDate();

                String street = results.getString(6);
                String zip = results.getString(7);
                String location = results.getString(8);
                String state = results.getString(9);

                Employee employee = new Employee(id, firstName, lastName, street, zip, location, state, sex, birthday);
                employees.add(employee);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;
    }

    public static int insertData(Employee employee) {

        //INSERT INTO mitarbeiter (nachname, vorname, geschlecht, gebdat, strasse, plz, ort, bundesland) VALUES ('Maier', 'Markus', 'm', '2004-04-06', 'Zwetschkenstraße 99', '8010', 'Graz', 'Steiermark');
        String sql = "INSERT INTO mitarbeiter (nachname, vorname, geschlecht, gebdat, strasse, plz, ort, bundesland) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = DbConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, employee.getLastname());
            pst.setString(2, employee.getFirstName());
            pst.setString(3, String.valueOf(employee.getSex()));
            pst.setDate(4, Date.valueOf(employee.getBirthdate()));
            pst.setString(5, employee.getStreet());
            pst.setString(6, employee.getZip());
            pst.setString(7, employee.getLocation());
            pst.setString(8, employee.getState());

            int retVal = pst.executeUpdate();

            ResultSet rset = pst.getGeneratedKeys();

            if (rset.next()) {
                int id = rset.getInt(1);
                employee.setId(id);
                System.out.println(id);
            }

            return retVal;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static ArrayList<Employee> getAllEmployeesByPLZ(String plz) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        String query = "SELECT * FROM mitarbeiter WHERE plz LIKE ?";

        try (PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, plz);

            ResultSet resultSet = statement.executeQuery();
            return employeesFromResultSet(resultSet);
        }
    }

    public static ArrayList<Employee> getAllEmployeesByProjectCode(String code) throws SQLException {
        Connection con = DbConnection.getConnection();

        String query = "SELECT * FROM mitarbeiter WHERE id IN ( " +
                "SELECT zuord.ma_id FROM projekte pr " +
                "JOIN arbeitspakete ap ON ap.pr_nr = pr.nr AND pr.code LIKE ? " +
                "JOIN ma_ap_zuord zuord ON zuord.ap_id = ap.id);";

        try(PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, code);
            ResultSet results = statement.executeQuery();
            return employeesFromResultSet(results);
        }
    }

    public static int updatePLZEmployees(String plzOld, String plzNew) throws SQLException {
        ArrayList<Employee> employeesOfOldPlace = getAllEmployeesByPLZ(plzOld);
        ArrayList<Integer> ids = (ArrayList<Integer>) employeesOfOldPlace.stream().map(Employee::getId).collect(Collectors.toList());
        for (int id:ids){
            System.out.println(id);
        }

        Connection con = DbConnection.getConnection();
        String query = "UPDATE mitarbeiter SET plz = ? WHERE id in (?)";
        try(PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, plzNew);
            statement.setArray(2, connection.createArrayOf("Int", ids.toArray(new Integer[0])));
        }


        return 0;
    }

    private static ArrayList<Employee> employeesFromResultSet(ResultSet set) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        while(set.next()){
            employees.add(employeeFromResultSet(set));
        }

        return employees;
    }

    private static Employee employeeFromResultSet(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String lastName = set.getString("nachname");
        String firstName = set.getString(3);
        char sex = set.getString(4).charAt(0);
        LocalDate birthday = set.getDate(5).toLocalDate();
        String street = set.getString(6);
        String zip = set.getString(7);
        String location = set.getString(8);
        String state = set.getString(9);

        return new Employee(id, firstName, lastName, street, zip, location, state, sex, birthday);
    }
}
