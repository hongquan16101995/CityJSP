package DAO;

import model.City;
import model.Country;

import java.util.ArrayList;

public interface ICityDAO {
    ArrayList<City> getAllCity();

    ArrayList<Country> getAllCountry();

    City getCity();

    boolean createCity(City city, int country);

    void deleteCity(int id);

    void updateCity(City city, int id);
}
