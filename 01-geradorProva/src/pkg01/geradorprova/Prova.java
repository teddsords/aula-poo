/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author 6507050
 */
public class Prova {

    private String courseName;
    private int weight;
    private String place;
    private String date;

    public Prova(String x) {
        this.courseName = x;
        this.weight = 10;
    }

    public String obtemDetalhes() {
        String retur = "";
        retur += "Course: " + this.getCourseName() + "\n";
        retur += "Weight: " + this.getWeight() + "\n";
        retur += "Place: " + this.getPlace() + "\n";
        retur += "Date: " + this.getDate() + "\n";
        return retur;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}
