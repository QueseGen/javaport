package model;

public class Places {

    //Places -- set apart for csv output stream manipulation formatting goals, minimize typos


    //location codes -- location needs to be connected to a single location
    int locCode;
    public int getLocCode() {
        return locCode;
    }
    public void setLocCode(int locCode) {
        this.locCode = locCode;
    }

    //origin
    String origin;
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    //destination
    String destination;
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }


}