package teddy.aula.br.a05_controle_abastecimento;

import java.io.Serializable;

public class FillUp implements Serializable {
    private double kilometers;
    private double liters;
    private String date;
    private String gasStation;
    private double latitude;
    private double longitude;
    private long id;



    public double getKilometers() {return kilometers; }

    public void setKilometers(double kilometers) {this.kilometers = kilometers; }

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public double getLiters() {return liters;}

    public void setLiters(double liters) {this.liters = liters;}

    public String getGasStation() {return gasStation;}

    public void setGasStation(String gasStation) {this.gasStation = gasStation;}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
