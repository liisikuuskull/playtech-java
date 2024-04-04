package test_data.test;

public class Bins {
    private String name;
    private long rangeFrom;
    private long rangeTo;
    private String type;
    private String country;

    // Konstruktor, getterid ja setterid
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRangeFrom() {
        return rangeFrom;
    }

    public void setRangeFrom(long rangeFrom) {
        this.rangeFrom = rangeFrom;
    }

    public long getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(long rangeTo) {
        this.rangeTo = rangeTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}