package web_service.flight_interfaces;

import web_service.flight_dir_object.City;
import web_service.flight_objects.Flight;

import java.util.Date;
import java.util.List;

/**
 * Created by Dell on 13.03.2017.
 */
public interface Search {

    List<Flight> searchFlight(Date date, City cityFrom, City cityTo, int placeCount);
}
