
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Megaport
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Apertua connessione");
        Scanner sc = new Scanner(System.in);
        try {
            Socket server = new Socket("127.0.0.1", 5500);
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader(server.getInputStream()));
            String s = "";
            
            float cifra;
            int appoggio;
            boolean var = true;
            
            String[] conti = in.readLine().split("::");
            for(int i = 0; i < conti.length; i++){
                System.out.print(conti[i]+"  ");
            }
            System.out.println("\n"+"Quale conto vuoi usare?");
            out.println(sc.next());
            
            
            do{
                System.out.println("Menu");
                System.out.println("1. Versare");
                System.out.println("2. Prelevare");
                System.out.println("3. Saldo");
                System.out.println("Quel'è opzine desideri fare");
                appoggio = sc.nextInt();
                out.println(appoggio);
                switch(appoggio){
                    case 1:
                        //versa
                        System.out.println("Inserisci cifra");
                        cifra = sc.nextFloat();
                        out.println(cifra);
                        System.out.println(in.readLine());
                        break;
                    case 2:
                        //preleva
                        System.out.println("Inserisci cifra");
                        cifra = sc.nextFloat();
                        out.println(cifra);
                        System.out.println(in.readLine());
                        break;
                    case 3:
                        //saldo
                        System.out.println(in.readLine());
                        break;
                    default:
                        System.out.println(in.readLine());
                        break;
                }
                System.out.println("Vuoi uscire");
                String z = sc.next();
                out.println(z);
                if(z.equalsIgnoreCase("si")){
                    var = false;
                    
                }
            }while(var);            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    
}
