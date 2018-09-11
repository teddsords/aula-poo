/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;
import java.util.ArrayList;
/**
 *
 * @author 6507050
 */
public class Prova {

    private String courseName;
    private int weight;
    private String place;
    private String date;
    private ArrayList <Questao> questions;
            
    public Prova(String x) {
        this.courseName = x;
        this.weight = 10;
    }
    
    public Prova (){}

    public String obtemDetalhes() {
        String retur = "";
        retur += "\t\t\tUniversidade do Vale de Itajai\r\n";
        retur += "Course: " + this.getCourseName() + "\r\n";
        retur += "Weight: " + this.getWeight() + "\r\n";
        retur += "Place: " + this.getPlace() + "\r\n";
        retur += "Date: " + this.getDate() + "\r\n";
        retur += "Please write your name:__________________________________________________________\r\n";
        retur += "Follow instructions and write with cursive letter.\r\n";
        return retur;
    }
    
    public String obtemProvaImpressao ()
    {
        String print = "";
        print += (obtemDetalhes());
        int number = 1;
    
       for (int i = 0; i < this.questions.size(); i++)
       {       
            print += number;
           print += this.questions.get(i).returningQuestion();
           number++;
       }
        return print;
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
    
    public ArrayList<Questao> getQuestions ()
    {
        return this.questions;
    }
    
    public void setQuestions (ArrayList <Questao> x)
    {
        this.questions = x;
    }
    
//    public void setSizeQuestionsTest1 (int x)
//    {
//        this.questionsTest1 = new Discursiva[x];
//        for (int i = 0; i < x; i++)
//            this.questionsTest1[i] = new Discursiva ();
//    }
//
//    public void setSizeQuestionsTest2 (int x)
//    {
//        this.questionsTest2 = new Objetiva[x];
//        for (int i = 0; i < x; i++)
//            this.questionsTest2[i] = new Objetiva();
//    }   
//    /**
//     * @return the questionsTest1
//     */
//    public Discursiva[] getQuestionsTest1() {
//        return questionsTest1;
//    }
//
//    /**
//     * @param questionsTest1 the questionsTest1 to set
//     */
//    public void setQuestionsTest1(Discursiva[] questionsTest1) {
//        this.questionsTest1 = questionsTest1;
//    }
//
//    /**
//     * @return the questionsTest2
//     */
//    public Objetiva[] getQuestionsTest2() {
//        return questionsTest2;
//    }
//
//    /**
//     * @param questionsTest2 the questionsTest2 to set
//     */
//    public void setQuestionsTest2(Objetiva[] questionsTest2) {
//        this.questionsTest2 = questionsTest2;
//    }
}
