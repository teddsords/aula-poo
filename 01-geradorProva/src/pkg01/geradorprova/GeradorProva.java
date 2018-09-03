/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;

/**
 *
 * @author 6507050
 */
public class GeradorProva {

    public static void main(String[] args) {
        Prova test = new Prova();
        Scanner scan = new Scanner(System.in);
        int aux = 0, aux2 = 0;
        double aux1;
        String word = new String();


        System.out.println("Please inform the course");
        word = scan.nextLine();
        test.setCourseName(word);

        System.out.println("Please inform the place where the test will take place");
        word = scan.nextLine();
        test.setPlace(word);

        System.out.println("Please inform the date");
        word = scan.nextLine();
        test.setDate(word);

        System.out.println("Please inform the weight of the test");
        while (!scan.hasNextInt()) 
        {
            System.out.println("Error. Please write a number.");
            scan.next();            
        }
        test.setWeight(scan.nextInt());
        scan.nextLine();

        System.out.println("How many short answer questions do you need?");
        while (!scan.hasNextInt()) 
        {
            System.out.println("Error. Please write a number.");
            scan.next();           
        }
        aux = scan.nextInt();
        test.setSizeQuestionsTest1(aux);
        scan.nextLine();

        Discursiva[] auxiliar;
        auxiliar = new Discursiva[aux];

        test.setSizeQuestionsTest1(aux);
        for (int i = 0; i < auxiliar.length; i++) {
            auxiliar[i] = new Discursiva();

            System.out.println("Please write down your question.");
            word = scan.nextLine();
            auxiliar[i].setQuestion(word);

            System.out.println("Please write down its weight");
            while(!scan.hasNextDouble())
            {
                System.out.println("Error. Please write a number.");
                scan.next();
            }
            aux1 = scan.nextDouble();
            scan.nextLine();
            auxiliar[i].setWeight(aux1);

            System.out.println("Please write down the criteria of evaluation");
            word = scan.nextLine();
            auxiliar[i].setCriteria(word);
        }
        test.setQuestionsTest1(auxiliar);

        System.out.println("How many multiple choice do you need?");
        while (!scan.hasNextInt()) 
        {
            System.out.println("Error. Please write a number.");
            scan.next();            
        }
        aux2 = scan.nextInt();
        test.setSizeQuestionsTest2(aux2);
        scan.nextLine();

        Objetiva[] auxiliar2;
        auxiliar2 = new Objetiva[aux2];
        test.setSizeQuestionsTest2(aux2);
        
        for (int i = 0; i < aux2; i++)
        {
            auxiliar2[i] = new Objetiva();
            System.out.println("Please write down your question");
            word = scan.nextLine();
            auxiliar2[i].setQuestion(word);

            System.out.println("Please write down its weight");
            while (!scan.hasNextDouble())
            {
                System.out.println ("Error. please write a number.");
                scan.next();
            }
            aux1 = scan.nextDouble();
            scan.nextLine();
            auxiliar2[i].setWeight(aux1);
            
                    String[] choices = new String[5];
            for (int j = 0; j < 5; j++) 
            {
                System.out.println("Please write down choice " + (j+1) + ":");
                choices[j] = scan.nextLine();
            }
            auxiliar2[i].setOptions(choices);

            System.out.println("What is the correct answer");
            aux = scan.nextInt();
            scan.nextLine();
            if (aux < 1 || aux > 5)
            {
                do
                {
                    System.out.println("Error. Please write down a number between 1 and 5.");
                    aux = scan.nextInt();
                    scan.nextLine();
                }while(aux < 1 || aux > 5);
            }
            auxiliar2[i].setCorrectAnswer(aux-1); 
            //scan.nextLine();
        }
        test.setQuestionsTest2(auxiliar2);

        System.out.println(test.obtemProvaImpressao());
    }
}
