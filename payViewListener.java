/*
    Listener for the menu pay buttons
*/

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class payViewListener implements ActionListener{
	Container cp;
    
    public payViewListener(Container cp) {
        this.cp = cp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("EFECTIVO") || e.getActionCommand().equals("CASH") 
			|| e.getActionCommand().equals("TARJETA") || e.getActionCommand().equals("CARD")) {

			try {
				File temp = new File("temp.txt");
                Scanner tempReader = new Scanner(temp);

				String worker = tempReader.nextLine();
				String table = tempReader.nextLine();
				String paymentType = tempReader.nextLine();

				String[] aux = table.split(",", 3);
				
				String tableNumber = aux[0];
				String tablePrice = aux[1];
				String tableOrder = aux[3];

				String newTable = tableNumber.concat(",0,order");

				String newTableStart = tableNumber.concat(",");
				String newTableEnd = ",".concat(tableOrder);


				//if the select to play everything that is left

				if (paymentType.equals("Todos") || paymentType.equals("All")) {

					//this part put all the tables info on a temp file reseting the payed table info

					File tables = new File("tables.txt");
					Scanner tablesReader = new Scanner(tables);
					BufferedWriter tempWriter = new BufferedWriter(new FileWriter("tablesTemp.txt"));

					while (tablesReader.hasNextLine()) {

						String data = tablesReader.nextLine();
						String[] tokens = data.split(",", 3);

						if (tokens[0].equals(tableNumber)) {
							tempWriter.write(newTable);
						}
						else {
							tempWriter.write(data);
						}

						if (tablesReader.hasNextLine()) {tempWriter.write("\n");}
					}

					tempWriter.close();
					tablesReader.close();


					//this part move all the info from the tablesTemp file to the tables file
					
					File newTemp = new File("tablesTemp.txt");
					Scanner newTempReader = new Scanner(newTemp);
					BufferedWriter tablesWriter = new BufferedWriter(new FileWriter("tables.txt"));

					while (newTempReader.hasNextLine()) {

						String data = newTempReader.nextLine();

						tablesWriter.write(data);

						if (newTempReader.hasNextLine()) {tablesWriter.write("\n");}
					}

					tablesWriter.close();
					newTempReader.close();

					//this ends the session so it has to go back to the usersView
				}


				//if the want to pay only the selected items

				else if (paymentType.equals("Seleccionados") || paymentType.equals("Selected")) {

					//this part change the value table price on the temp file

					String price = tempReader.nextLine();

					Float tablePriceFloat = Float.parseFloat(tablePrice);
					Float priceFloat = Float.parseFloat(price);

					Float newTablePriceFloat = tablePriceFloat - priceFloat;

					String newTablePrice = String.format("%.02f", newTablePriceFloat);

					String auxS = newTableStart.concat(newTablePrice);
					String newTableS = auxS.concat(newTableEnd);

					BufferedWriter tempSWriter = new BufferedWriter(new FileWriter("temp.txt"));

					tempSWriter.write(worker);
					tempSWriter.write(newTableS);

					tempSWriter.close();


					//this part put all the tables info on a temp file changing the payed table info

					File tables = new File("tables.txt");
					Scanner tablesReader = new Scanner(tables);
					BufferedWriter tempWriter = new BufferedWriter(new FileWriter("tablesTemp.txt"));

					while (tablesReader.hasNextLine()) {

						String data = tablesReader.nextLine();
						String[] tokens = data.split(",", 3);

						if (tokens[0].equals(tableNumber)) {
							tempWriter.write(newTableS);
						}
						else {
							tempWriter.write(data);
						}

						if (tablesReader.hasNextLine()) {tempWriter.write("\n");}
					}

					tempWriter.close();
					tablesReader.close();


					//this part move all the info from the tablesTemp file to the tables file
					
					File newTemp = new File("tablesTemp.txt");
					Scanner newTempReader = new Scanner(newTemp);
					BufferedWriter tablesWriter = new BufferedWriter(new FileWriter("tables.txt"));

					while (newTempReader.hasNextLine()) {

						String data = newTempReader.nextLine();

						tablesWriter.write(data);

						if (newTempReader.hasNextLine()) {tablesWriter.write("\n");}
					}

					tablesWriter.close();
					newTempReader.close();

					//this does not end the sesion so it has to go back to de menuView
				}

				tempReader.close();
			
			} catch (FileNotFoundException fnf) {
    
                System.out.println("File Not Found.");
                fnf.printStackTrace();
			
			} catch (IOException io) {

				System.out.println("An error occurred.");
                io.printStackTrace();
			}
			
		}
        
    }
}
