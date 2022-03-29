package model;

import model.Tickets;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TicketsTest {
  static class Flight {
    public String airline_iata;
    public String airline_icao;
    public String flight_iata;
    public String flight_icao;
    public String flight_number;
    public String dep_iata;
    public String dep_icao;
    public String dep_terminal;
    public String dep_gate;
    public String dep_time;
    public String dep_time_utc;
    public String arr_iata;
    public String arr_icao;
    public String arr_terminal;
    public String arr_gate;
    public String arr_time;
    public String arr_time_utc;

    public String cs_airline_iata;
    public String cs_flight_number;
    public String cs_flight_iata;
    public String status;
    public int duration;
    public int delayed;
    public String aircraft_icao;
    public int arr_time_ts;
    public int dep_time_ts;

    @Override
    public String toString() {
      return "Flight{" +
        "airline_iata='" + airline_iata + '\'' +
        ", airline_icao='" + airline_icao + '\'' +
        ", flight_iata='" + flight_iata + '\'' +
        ", flight_icao='" + flight_icao + '\'' +
        ", flight_number='" + flight_number + '\'' +
        ", dep_iata='" + dep_iata + '\'' +
        ", dep_icao='" + dep_icao + '\'' +
        ", dep_terminal='" + dep_terminal + '\'' +
        ", dep_gate='" + dep_gate + '\'' +
        ", dep_time='" + dep_time + '\'' +
        ", dep_time_utc='" + dep_time_utc + '\'' +
        ", arr_iata='" + arr_iata + '\'' +
        ", arr_icao='" + arr_icao + '\'' +
        ", arr_terminal='" + arr_terminal + '\'' +
        ", arr_gate='" + arr_gate + '\'' +
        ", arr_time='" + arr_time + '\'' +
        ", arr_time_utc='" + arr_time_utc + '\'' +
        ", cs_airline_iata='" + cs_airline_iata + '\'' +
        ", cs_flight_number='" + cs_flight_number + '\'' +
        ", cs_flight_iata='" + cs_flight_iata + '\'' +
        ", status='" + status + '\'' +
        ", duration=" + duration +
        ", delayed=" + delayed +
        ", aircraft_icao='" + aircraft_icao + '\'' +
        ", arr_time_ts=" + arr_time_ts +
        ", dep_time_ts=" + dep_time_ts +
        '}';
    }
  }

  @Test
 public void testCustomers() throws IOException {
  Tickets tickets= new Tickets();
// create a client
    URL url = new URL("https://airlabs.co/api/v9/schedules?dep_iata=MIA&arr_iata=LAX&api_key=ce5d1ad5-768c-48f3-8705-ac8f97c36fd4");
    HttpURLConnection http = (HttpURLConnection)url.openConnection();
    http.setRequestProperty("Content-Type", "application/json");
    http.setRequestMethod("GET");
   // System.out.println(http.getResponseCode() + " " + http.getResponseMessage()+"\n");

    BufferedReader in = new BufferedReader(new InputStreamReader(
      http.getInputStream()));
    String list;
    StringBuilder response = new StringBuilder();
    while ((list = in.readLine()) != null)
      response.append(list);
    in.close();
    //System.out.println(response.toString()+"\n"+ http.getResponseMessage().length());

    String[] body= response.toString().split("\""+"response"+"\":");
    list=body[1];
    body=list.split(",\"terms\"");
    list=body[0];
    list=list.substring(1);
    list=list.substring(0,list.length()-1);
    String[] List= list.split("},");
//    for(String g : List){
//      System.out.println(g);
//    }
    ArrayList<Flight> Flights = new ArrayList<Flight>();
    for (String i:List){
      try {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Flight ticket;
        if(!i.contains("}")){
         // System.out.println(i);
          ticket = gson.fromJson(i+"}", Flight.class); }
        else {
          ticket = gson.fromJson(i, Flight.class);}
          Flights.add(ticket);
        i= gson.toJson(ticket);
      }catch(JsonIOException err){
        System.out.println("Exception : "+err.toString());
      } }
    http.disconnect();

    System.out.println("Okay here are flights available: ");
    int counter=1;
    for (Flight times: Flights){
      System.out.printf(counter+". FLIGHT NO.%s | %-5s DEPORTING AT %s \n%30s ARRIVING AT  %s\n",times.flight_number,"FROM "+times.dep_icao,times.dep_time_utc, "| TO "+times.arr_icao, times.arr_time_utc);
      System.out.println("DATA| "+ times.toString()+ " |\n");
      counter++;
    } ///Testing
    assert Flights.size()>1;
    }
}