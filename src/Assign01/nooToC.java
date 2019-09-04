package Assign01;
import java.io.*;

public class nooToC {

    private static final String fixedStart =
	"	#include <stdio.h> " +
	"	int main(){"         +
	"		r, t1, t2, t3"   ;

	private static final String fixedEnd =
    "   }                   ";
	
    public static void main(String[] args){
//        if(args.length < 2){
//            System.out.println("Check the Input");
//            // args[0] =>
//        }

        // 디버깅 용
        args = new String[2];
        args[0] = "main.noo";
        args[1] = "main.c";

        File noo        = new File(args[0]);
        File exportC    = new File(args[1]);

        try{
            FileReader        nooReader = new FileReader(noo);
            BufferedReader bufNooReader = new BufferedReader(nooReader);
            FileWriter          cWriter = new FileWriter(exportC);
            BufferedWriter   bufCWriter = new BufferedWriter(cWriter);

            String line;
            while((line = bufNooReader.readLine()) != null){
                int doubleQuoteNumber = 0;

                String[] commandArr = line.split("\'");




//                for (int i = 0; i < line.length(); i++){
//                    if     (line.charAt(i) == '\''){
//
//                        doubleQuoteNumber = 0;
//                    }
//                    else if(line.charAt(i) == '\"'){
//                        doubleQuoteNumber++;
//                    }
//                }
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Error: Input Noo File Not Found");
        }
        catch(IOException e){
            System.out.println(e);
        }

    }

    public void processCommand(String[] commandArr){
        for(int i = 0; i < commandArr.length; i++) {
            switch (commandArr[i].length()) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }
    }





}
