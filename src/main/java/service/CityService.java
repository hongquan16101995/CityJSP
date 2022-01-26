package service;

import model.City;

import java.util.ArrayList;

public class CityService {
    private final static ArrayList<City> cities;
    private final static ArrayList<String> countries;

    static {
        cities = new ArrayList<>();
        cities.add(new City(1, "HN", 1000001, 40000, 10000000, "VN"));
        cities.add(new City(2, "HCM", 900000, 40000, 1000, "VN"));
        countries = new ArrayList<>();
        countries.add("VN");
        countries.add("TL");
        countries.add("NB");
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public City getCity(int id) {
        for (City city: cities) {
            if (city.getId() == id) {
                return city;
            }
        }
        return null;
    }

    public void createCity(City city) {
        cities.add(city);
    }

    public void deleteCity(City city) {
        cities.remove(city);
    }

    public void editCity(City city, int index) {
        cities.set(index, city);
    }

    public ArrayList<City> getCities() {
        return cities;
    }
}
