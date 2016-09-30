package boss.rest_apis;

import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author Peter
 */
public class JSONConverter {

    public static Country getCountryFromJSON(String js) {
        return new Gson().fromJson(js, Country.class);
    }

    public static String getJSONfromCountry(Country p) {
        return new Gson().toJson(p, Country.class);
    }

    public static String getJSONfromCountry(List<Country> countries) {
        return new Gson().toJson(countries);
    }

    public static City getCityFromJSON(String js) {
        return new Gson().fromJson(js, City.class);
    }

    public static String getJSONfromCity(City p) {
        return new Gson().toJson(p, City.class);
    }

    public static String getJSONfromCity(List<City> cities) {
        return new Gson().toJson(cities);
    }
}
