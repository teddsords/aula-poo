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
final class Discursiva extends Questao
{
    private String criteria;

    /**
     * @return the criteria
     */
    
    public String getCriteria() {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    
    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
    
    @Override 
    public String returningQuestion()
    {
        String print = "";
        print += (". [" + this.getWeight() + "]. " + this.getQuestion() + "\n\n\n\n\n");
        return print;
    }

}
