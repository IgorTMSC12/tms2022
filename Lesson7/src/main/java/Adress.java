public class Adress {
    private String country;
    private String town;

    public Adress(String country, String town) {
        this.country = country;
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    public void info() {
        System.out.println(country + " " + town);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}

