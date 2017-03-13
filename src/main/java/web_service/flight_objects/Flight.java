package web_service.flight_objects;

import web_service.flight_dir_object.Aircraft;
import web_service.flight_dir_object.City;

import java.util.Calendar;

/**
 * Created by Dell on 13.03.2017.
 */
public class Flight {

    private String code;
    private Calendar flightDate;
    private Calendar flightTime;
    private Aircraft aircraft;
    private long duration;
    private City cityFrom;
    private City cityTo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Calendar flightDate) {
        this.flightDate = flightDate;
    }

    public Calendar getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Calendar flightTime) {
        this.flightTime = flightTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }
}
