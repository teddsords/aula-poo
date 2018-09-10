/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
/**
 *
 * @author 6507050
 */
public class GeradorProva {

    public static void main(String[] args) {
        Prova test = new Prova();
        Scanner scan = new Scanner(System.in);
        int aux1;
        String word = new String();
        File file = new File ("test.txt");
        
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
        while (true)
        {
            try
            {
                aux1 = Integer.parseInt(scan.nextLine()); // porque no funciona con test.setWeight(scan.nextInt()); ?
                if (aux1 < 1)
                    throw new Exception();
                break;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Please write again the weight.");
                continue;
            }
        }
        test.setWeight(aux1);
        
        String cont;
        ArrayList <Questao> questions = new ArrayList <Questao> (); 
        do
        {
            do
            {
            System.out.println ("Please write S for a short answer question and"
                    + " M for multiple choice for question");
            cont = scan.nextLine();
            }while (cont.equals("S") != true && cont.equals("s") != true && 
                    cont.equals("M") != true && cont.equals("m") !=true);
            
            if (cont.equals("S") == true || cont.equals("s") == true)
            {
                Discursiva aux = new Discursiva();
                
                System.out.println("Please write down your question.");
                word = scan.nextLine();
                aux.setQuestion(word);
                
                System.out.println("Please write down the weight.");
                while(true)
                {
                    try
                    {
                        aux1= Integer.parseInt(scan.nextLine());
                        if (aux1 < 1)
                            throw new Exception();
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Exception thrown " + e.getMessage());
                        System.out.println("Please write again weight.");
                    }
                }
                aux.setWeight(aux1);
                
                System.out.println("Please write down the criteria of evaluation");
                word = scan.nextLine();
                aux.setCriteria(word);
                
                questions.add(aux);
            } 
            else
            {
                Objetiva aux2 = new Objetiva();
                System.out.println("Please write down your question");
                word = scan.nextLine();
                aux2.setQuestion(word);
                
                System.out.println("Please write down the weight.");
                while(true)
                {
                    try
                    {
                        aux1= Integer.parseInt(scan.nextLine());
                        if (aux1 < 1)
                            throw new Exception();
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Exception thrown " + e.getMessage());
                        System.out.println("Please write again weight.");
                    }
                }
                aux2.setWeight(aux1);
                
                String[] options = new String[5];
                
                for (int i = 0; i < 5; i++)
                {
                    System.out.println("Please write choice " + (i+1) + ":");
                    options[i] = scan.nextLine();
                }
                aux2.setOptions(options);
                
                System.out.println("Please write the correct answer.");
                while (true)
                {
                    try
                    {
                        aux1 = Integer.parseInt(scan.nextLine());
                        if (aux1 < 1 || aux1 > 5)
                            throw new IllegalArgumentException();
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println ("Exception thrown " + e.getMessage());
                        System.out.println("Please write again the correct answer.");
                    }
                }
                aux2.setCorrectAnswer(aux1-1);
                questions.add(aux2);
            }
         
        System.out.println("Do you need another question?");   
        cont = scan.nextLine();   
        }while (cont.equals("Y") == true || cont.equals("y") == true || cont.equals("Yes") == true
                || cont.equals("yes") == true || cont.equals("YES") == true); 
        
        test.setQuestions(questions);
        
        System.out.println(test.obtemProvaImpressao());
        
        try
        {
            if (!file.exists())
                file.createNewFile();
            
            FileWriter fw = new FileWriter (file, true);
            BufferedWriter bw = new BufferedWriter (fw);
           
            bw.write(test.obtemProvaImpressao()); // porque esta imprimindo tudo na mesma linha?
            
            bw.close();
        }
        catch(Exception e)
        {
            System.out.println("You got an error");
        }
    }
}
