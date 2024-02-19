package Lab11;

public class Flights {
    private String code;
    private City source;
    private City destination;
    private DayOfWeek day;
    private Time departTime;

    Flights(String code, City source, City destination, 
            DayOfWeek day, Time departTime) {
        this.code = code;
        this.source = source;
        this.destination = destination;
        this.day = day;
        this.departTime = departTime;
    }

    @Override
    public String toString() {
        return ("Flights [code=" + code + ", source=" + source + ", destination=" + 
        destination + ", day=" + day + ", departTime=" + departTime + "]");
    }
    
}
