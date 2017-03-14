package web_service.fllight_implements;

import web_service.flight_dir_object.City;
import web_service.flight_interfaces.Search;
import web_service.flight_objects.Flight;

import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 14.03.2017.
 */
public class SearchImpl implements Search{
    public List<Flight> searchFlight(Date date, City cityFrom, City cityTo, int placeCount) {
        //TODO
        return null;
    }
}
