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

    public static void main(String[] args) {
        Prova test = new Prova();
        Scanner scan = new Scanner(System.in);
        int aux;
        double aux1;
        String word = new String();
        String[] choices = new String[5];

        System.out.println("Please inform the course");
        word = scan.nextLine();
        test.setCourseName(word);

        System.out.println("Please inform the place where the test will take place");
        word = scan.nextLine();
        test.setPlace(word);

        System.out.println("Please inform the date");
        word = scan.nextLine();
        test.setDate(word);
        
        do
        {
        System.out.println("Please inform the weight of the test");
        aux = scan.nextInt();
        scan.nextLine();
        }while (aux < 0 || aux > 10);
        test.setWeight(aux);

        
        do
        {
        System.out.println("How many short answer questions do you need?");
        aux = scan.nextInt();
        scan.nextLine();
        } while (aux > 10);
        
        Discursiva[] auxiliar;
        auxiliar = new Discursiva[aux];
                    
        test.setSizeQuestionsTest1(aux);
        for (int i = 0; i < aux; i++) {
            auxiliar[i] = new Discursiva();
            
            System.out.println("Please write down your question.");
            word = scan.nextLine();
            auxiliar[i].setQuestion(word);

            System.out.println("Please write down its weight");
            aux1 = scan.nextDouble();
            scan.nextLine();
            auxiliar[i].setWeight(aux1);

            System.out.println("Please write down the criteria of evaluation");
            word = scan.nextLine();
            auxiliar[i].setCriteria(word);
        }
        
        test.setQuestionsTest1(auxiliar);
        
        //System.out.println(test.getQuestionsTest1());

        do
        {
        System.out.println("How many multiple choice auxiliar do you need?");
        aux = scan.nextInt();
        scan.nextLine();
        } while (aux > 10);
        
       Objetiva [] auxiliar2;
       auxiliar2 = new Objetiva [aux];
       test.setSizeQuestionsTest2(aux);
       
        for (int i = 0; i < aux; i++) {
            auxiliar2[i] = new Objetiva ();
            System.out.println("Please write down your question");
            word = scan.nextLine();
            auxiliar2[i].setQuestion(word);

            System.out.println("Please write down its weight");
            aux1 = scan.nextDouble();
            scan.nextLine();
            auxiliar2[i].setWeight(aux1);

            for (int j = 0; j < 5; j++) {
                System.out.println("Please write down choice " + j + ":");
                choices[j] = scan.nextLine();
            }
            auxiliar2[i].setOptions(choices);

            System.out.println("What is the correct answer");
            aux = scan.nextInt();
            auxiliar2[i].setCorrectAnswer(aux);
        }
        test.setQuestionsTest2(auxiliar2);

        System.out.println(test.obtemProvaImpressao());
    }
}
