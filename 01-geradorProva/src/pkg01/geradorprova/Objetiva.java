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
final class Objetiva extends Questao 
{
    private String [] options;
    private int correctAnswer;
    
    public Objetiva ()
    {
        this.options =  new String[5];
    }

    /**
     * @return the options
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(String[] options) {
        this.options = options;
    }

    /**
     * @return the correctAnswer
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    @Override
    public String returningQuestion ()
    {
        String[] aux = new String[5];
        String print = "";
        print += "Please mark with an X the correct answer.\n";

        print += (". [" + this.getWeight() + "]." + this.getQuestion() + "\n");
        aux = this.getOptions();

        for (int a = 0; a < 5; a++)
            print += ("[" + (a + 1) + "]" + aux[a] + "\n");
        
        return print;
    }
}
