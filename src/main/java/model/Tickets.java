package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Tickets {
  public Tickets() throws IOException {
  }

  //Ticket Number//


  public String getAPIkey() {
    return APIkey;
  }

  public AtomicInteger getTicketCounter() {
    return ticketCounter;
  }

  public String APIkey() throws IOException {
    FileReader reader=new FileReader("build/local.properties");

    Properties p=new Properties();
    p.load(reader);
    return p.getProperty("PlainAPI");
  }

  private final String APIkey =APIkey();

    private final AtomicInteger ticketCounter = new AtomicInteger(100);
    private int locCode;
    private String origin;
    private String destination;
    private final Map<String, String> locations= getStringMap();
    //private final Map<String, String[]> timeOrigin= getStringMap();

  private Map<String, String> getStringMap() {
    Map<String, String> timeDestination = new HashMap<>();
    timeDestination.put("Seattle", "SEA");
    timeDestination.put("Dallas","DFW");
    timeDestination.put("Orlando","MCO");
    timeDestination.put("Los Angeles","LAX");
    timeDestination.put("Raleigh", "RDU" );
    timeDestination.put("Phoenix","PHX");
    timeDestination.put("Salt Lake City", "SLC");
    timeDestination.put("Tucson", "TUS");
    timeDestination.put("Detroit", "DTW");
    timeDestination.put("Cincinnati", "CVG");
    timeDestination.put("Louisville", "SDF");
    timeDestination.put("New York City", "LGA");
    timeDestination.put( "Sacramento", "SMF");
    timeDestination.put("Atlanta", "ATL");
    timeDestination.put("Miami", "MIA");
    timeDestination.put("Las Vegas","LAS");
    timeDestination.put("Nashville","NAS");
    timeDestination.put("Des Moines","DSM");
    timeDestination.put("Richmond","RIC");
    timeDestination.put("Charleston","CHS");

    return timeDestination;
  }

  public Map<String, String> getLocations() {
    return locations;
  }

  public int getLocCode() {
        return locCode;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setLocCode(int locCode) {
        this.locCode = locCode;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

  @Override
  public String toString() {
    return "Tickets{" +
      "ticketCounter=" + ticketCounter +
      ", locCode=" + locCode +
      ", origin='" + origin + '\'' +
      ", destination='" + destination + '\'' +
      ", locations=" + locations +
      '}';
  }
}
