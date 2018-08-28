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
public class GeradorProva {

    public static void main(String[] args) 
    {
            Prova x = new Prova("POO");
            //x.place =  "Lab 3 - Bloco B6";
            //x.date = "2018/08/28";

            //forma resumida
            System.out.println(x.obtemDetalhes());
            
            
            Discursiva d = new Discursiva ();
            
            d.setQuestion("What is your name?");
            d.setWeight(0);
            d.setCriteria("To know his/her own name");
            
            Objetiva o = new Objetiva ();
            o.setQuestion ("Qual o melhor time do Brasil?");
            o.setWeight (2);
            String [] options = new String[5];
            options[0] = "Gremio";
            options[1] = "Inter";
            options[2] = "Flamengo";
            options[3] = "Corinthians";
            options[4] = "Sao Paulo";
            o.setOptions(options);
            o.set
            
            
            
            
    }
    
}
