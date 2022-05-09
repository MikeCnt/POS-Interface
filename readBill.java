import java.io.*;
import java.util.*;

public class readBill {
    
//  Variables
    private Vector bill = new Vector();

//  Function to read the worker's database
    public Vector readDBdata(String code){

        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        try{
            f = new File("bill.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                
                String[] token = line.split(",");
                
                if(code.equals(token[0])){
                    
                    for(int i=2; i<(token.length)-1; i++){
                        bill.addElement(token[i]);
                    }
                }
                
                for(int i=0; i<bill.capacity(); i++){
                    System.out.println(bill.elementAt(i));
                }

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

        return bill;
    }
}
