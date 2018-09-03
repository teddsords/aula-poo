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
    private Discursiva[] questionsTest1;
    private Objetiva [] questionsTest2;
            
    public Prova(String x) {
        this.courseName = x;
        this.weight = 10;
    }
    
    public Prova (){}

    public String obtemDetalhes() {
        String retur = "";
        retur += "Course: " + this.getCourseName() + "\n";
        retur += "Weight: " + this.getWeight() + "\n";
        retur += "Place: " + this.getPlace() + "\n";
        retur += "Date: " + this.getDate() + "\n";
        return retur;
    }
    
    public String obtemProvaImpressao ()
    {
        obtemDetalhes();
        String print = "";
        int number = 1;
        for (int i = 0; i < questionsTest1.length; i++) 
        {
            
           print = (number + "(" + questionsTest1[i].getWeight() + "). " + questionsTest1[i].getQuestion() + "\n");
           System.out.println(print);
           number++;
//            print += questionsTest1[i].getWeight() + " ";
//            print += questionsTest1[i].getQuestion() + "\n"; 
        }
        for (int i = 0; i < questionsTest2.length; i++) 
        {
            print = (number + "(" + questionsTest2[i].getWeight() + ") ." + questionsTest2[i].getQuestion());
            System.out.println(print);
            
            String[] aux = new String [5];
            aux = questionsTest2[i].getOptions();
            
            for (int a = 0; a < 5; a++)
                System.out.println("[" + a + "]" + aux[a]);
                
//            print += questionsTest2.getWeight() + " ";
//            print += questionsTest2.getQuestion() + "\n";
//            System.out.println("\t");
//            print += questionsTest2.getOptions() + "\n";
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
    
    public void setSizeQuestionsTest1 (int x)
    {
        this.questionsTest1 = new Discursiva[x];
        for (int i = 0; i < x; i++)
            this.questionsTest1[i] = new Discursiva ();
    }

    public void setSizeQuestionsTest2 (int x)
    {
        this.questionsTest2 = new Objetiva[x];
        for (int i = 0; i < x; i++)
            this.questionsTest2[i] = new Objetiva();
    }   
    /**
     * @return the questionsTest1
     */
    public Discursiva[] getQuestionsTest1() {
        return questionsTest1;
    }

    /**
     * @param questionsTest1 the questionsTest1 to set
     */
    public void setQuestionsTest1(Discursiva[] questionsTest1) {
        this.questionsTest1 = questionsTest1;
    }

    /**
     * @return the questionsTest2
     */
    public Objetiva[] getQuestionsTest2() {
        return questionsTest2;
    }

    /**
     * @param questionsTest2 the questionsTest2 to set
     */
    public void setQuestionsTest2(Objetiva[] questionsTest2) {
        this.questionsTest2 = questionsTest2;
    }
}
