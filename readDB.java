import java.io.*;
import java.util.*;

public class readDB {
    
//  Variables para almacenar los datos de la base de datos de trabajadores
    private Vector name = new Vector();
    private Vector surname = new Vector();
    private Vector email = new Vector();
    private Vector number = new Vector();
    private Vector sold = new Vector();

//  Funcion para leer de la base de datos de trabajadores
    public Vector readDBdata(String index){

        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        try{
            f = new File("workers.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                
                String[] token = line.split(",");
                
                name.addElement(token[0]);
                surname.addElement(token[1]);
                email.addElement(token[2]);
                String parseNumber = String.valueOf(token[3]);
                number.addElement(parseNumber);
                String parseSold = String.valueOf(token[4]);
                sold.addElement(parseSold);

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fr != null){
                    fr.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }

        if(index.equals("name")){
            return name;
        }else if(index.equals("surname")){
            return surname;
        }else if(index.equals("email")){
            return email;
        }else if(index.equals("number")){
            return number;
        }else{
            return sold; 
        }
    }
}
