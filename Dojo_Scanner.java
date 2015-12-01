//Shantanu Jha
//2015-11-30
//CS Dojo Scanners

import cs1.Keyboard;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.*;
import java.io.File;

public class Dojo_Scanner
{
private static String NowDate;

//Add some color lol
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";

   
public static void main(String [] args)
   {
	boolean existance = true; //does the file exist already

	//Check if file exists for that day -- if it doesn't then create it 
	Date Now = new Date( );
      	SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd");
	NowDate = ft.format(Now);
	
	
	File foo = new File(NowDate + ".csv");
	existance = foo.exists();

	//init FileWriter
	try{ 
		FileWriter writer = new FileWriter(NowDate + ".csv", existance);
	
	//generate file header if the file didn't exist before
	if(!existance){
	 	writer.append("STUDENT OSIS");
            	writer.append(',');
            	writer.append("DATE: " + NowDate);
            	writer.append('\n');
	}


	long osis = -1;
	while(osis != 0){
	osis = ask();
	if(osis!= 0){
	writer.append("" + osis + "\n");
	writer.close();
	writer = new FileWriter(NowDate + ".csv", true);
	}
	}
	writer.flush();
        writer.close();
	System.out.println("Thank you for using CS Dojo Scanners!");
        }
	catch(IOException e)
        {
             e.printStackTrace();
        }

   
}


//Append to CSV file
private static long ask(){
long temp = -1;
while(temp<0 || temp>=1000000000){
System.out.println(ANSI_GREEN + "================================================================================================================================================" + ANSI_RESET);
System.out.print(ANSI_BLUE + "Please enter your OSIS: " + ANSI_RESET);
temp = Keyboard.readLong();
}
return temp;
}
} 
