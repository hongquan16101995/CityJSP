package DAO;

import connection.MyConnect;
import model.City;
import model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CityDAO implements ICityDAO{
    private final MyConnect myConnect = new MyConnect();
    private static final String SELECT_ALL_CITIES = "select city.id, city.name, popular, area, gdp, country.name as country_name from city\n" +
            "join country on city.country = country.id";
    private static final String SELECT_ALL_COUNTRIES = "select * from country";
    private static final String INSERT_CITY = "insert into city(name, popular, area, gdp, country) value (?,?,?,?,?);";

    @Override
    public ArrayList<City> getAllCity() {
        ArrayList<City> cities = new ArrayList<>();
        try {
            Connection connection = myConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CITIES );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double popular = resultSet.getDouble("popular");
                double area = resultSet.getDouble("area");
                double gdp = resultSet.getDouble("gdp");
                String country = resultSet.getString(6);
                cities.add(new City(id, name, popular, area, gdp, country));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return cities;
    }

    @Override
    public ArrayList<Country> getAllCountry() {
        ArrayList<Country> countries = new ArrayList<>();
        try {
            Connection connection = myConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRIES );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                countries.add(new Country(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return countries;
    }

    @Override
    public City getCity() {
        return null;
    }

    @Override
    public boolean createCity(City city, int country) {
        boolean check = false;
        try {
            Connection connection = myConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITY );
            preparedStatement.setString(1, city.getName());
            preparedStatement.setDouble(2, city.getPopular());
            preparedStatement.setDouble(3, city.getArea());
            preparedStatement.setDouble(4, city.getGDP());
            preparedStatement.setInt(5, country);
            check = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return check;
    }

    @Override
    public void deleteCity(int id) {

    }

    @Override
    public void updateCity(City city, int id) {

    }
}
