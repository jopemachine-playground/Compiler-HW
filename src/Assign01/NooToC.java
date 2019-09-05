package Assign01;
import java.io.*;

public class NooToC {

    private static final String fixedStart =
	"#include <stdio.h>\n" +
	"int main() {\n" +
	"    int r, t1, t2, t3;\n" ;

	private static final String fixedEnd =
    "    return 1;\n" +
    "}\n" ;
	
    public static void main(String[] args){
//        if(args.length < 2){
//            System.out.println("Check the Input");
//            // args[0] =>
//        }

        // 디버깅 용
        args = new String[2];
        args[0] = "main.noo";
        args[1] = "main.c";

        File noo        = new File(System.getProperty("user.dir") + "/" + args[0]);
        File exportC    = new File(System.getProperty("user.dir") + "/" + args[1]);
        String result_C_Code = "";

        try{
            FileReader        nooReader = new FileReader(noo);
            BufferedReader bufNooReader = new BufferedReader(nooReader);
            FileWriter          cWriter = new FileWriter(exportC);
            BufferedWriter   bufCWriter = new BufferedWriter(cWriter);

            bufCWriter.write(fixedStart);
            String line;

            while((line = bufNooReader.readLine()) != null){
                int doubleQuoteNumber = 0;

                NooTree tree = new NooTree(line);

                result_C_Code += tree.ParseToC();
            }

            System.out.println(result_C_Code);

            bufCWriter.write(result_C_Code);
            bufCWriter.write(fixedEnd);

            bufNooReader.close();
            nooReader.close();
            bufCWriter.close();
            cWriter.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Input Noo File Not Found");
        }
        catch(IOException e){
            System.out.println(e);
        }

    }

}
