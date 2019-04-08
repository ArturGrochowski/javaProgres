public class Flat {
    private String city;
    private String region;
    private String street;
    private int rooms;
    private float area;
    private boolean basemant;
    private int price;

    public Flat(String city, String region, String street, int rooms, float area, boolean basemant, int price){
        this.city = city;
        this.region = region;
        this.street = street;
        this.rooms = rooms;
        this.area = area;
        this. basemant = basemant;
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public boolean isBasemant() {
        return basemant;
    }

    public void setBasemant(boolean basemant) {
        this.basemant = basemant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString(){
        return "Flat{ " +
                "city = " + city + '\'' +
                ", region = " + region + '\'' +
                ", street = " + street + '\'' +
                ", rooms = " + rooms + '\'' +
                ", area = " + area + '\'' +
                ", basemant = " + basemant + '\'' +
                ", price = " + price + '}';
    }
}
