/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author 6507050
 */
public class GeradorProva {

    public static void main(String[] args) 
    {
        Prova test = new Prova ();
        Scanner scan = new Scanner(System.in);
        int aux;
        double aux1;
        String word = new String();
        String[] choices = new String [5];
        
        System.out.println("Please inform the course");
        word = scan.nextLine();
        test.setCourseName(word);
        
        
        System.out.println("Please inform the place where the test will take place");
        word = scan.nextLine();
        test.setPlace(word);
        
        System.out.println("Please inform the date");
        word =  scan.nextLine();
        test.setDate(word);
      
        System.out.println("Please inform the wieght of the test");
        aux = scan.nextInt();
        scan.nextLine();
        test.setWeight(aux);
        
        System.out.println ("How many short answer questions do you need?");
        aux = scan.nextInt();
        scan.nextLine();
        
        Vector <Discursiva> auxiliar = new Vector <Discursiva> (5);
//        Discursiva[] auxiliar;
//        auxiliar = new Discursiva [5];
        
        for (int i = 0; i < aux; i++)
        {
            System.out.println ("Please write down your question.");
            word = scan.nextLine();
            auxiliar.get(i).setQuestion(word);
            
            System.out.println("Please write down its weight");
            aux1 = scan.nextDouble();
            scan.nextLine();
            auxiliar.get(i).setWeight(aux1);
            
            System.out.println("Please write down the criteria of evaluation");
            word = scan.nextLine ();
            auxiliar.get(i).setCriteria(word); 
        }
        //test.setQuestionsTest1(auxiliar);
        
        
        System.out.println ("How many multiple choice auxiliar do you need?");
        aux = scan.nextInt();
        scan.nextLine();
        Vector <Objetiva> auxiliar2 = new Vector <Objetiva> (aux);
        
        for (int i = 0; i < aux; i++)
        {
            System.out.println ("Please write down your question");
            word = scan.nextLine();
            auxiliar2.get(i).setQuestion(word);
                        
            System.out.println("Please write down its weight");
            aux1 = scan.nextDouble();
            scan.nextLine();
            auxiliar2.get(i).setWeight(aux1);
            
            for (int j = 0; j < 5; j++)
            {
                System.out.println("Please write down the choices");
                choices[j] = scan.nextLine();
            }
            auxiliar2.get(i).setOptions(choices);
            
            System.out.println ("What is the correct answer");
            aux = scan.nextInt();
            auxiliar2.get(i).setCorrectAnswer(aux);
        }
//        test.setQuestionsTest2(auxiliar2);
        
        test.obtemProvaImpressao();
    }   
}