package service;

import DAO.CityDAO;
import model.City;
import model.Country;

import java.util.ArrayList;

public class CityService {
    private final CityDAO cityDAO = new CityDAO();

    public ArrayList<Country> getCountries() {
        return cityDAO.getAllCountry();
    }

    public City getCity(int id) {
        return null;
    }

    public boolean createCity(City city, int country) {
        return cityDAO.createCity(city, country);
    }

    public void deleteCity(City city) {

    }

    public void editCity(City city, int index) {

    }

    public ArrayList<City> getCities() {
        return cityDAO.getAllCity();
    }
}
