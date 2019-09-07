package cnu.compiler19.hw1;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class NooToC {

    private static final String fixedStart =
	"#include <stdio.h>\n" +
	"int main() {\n" +
	"    int r, t1, t2, t3;\n" ;

	private static final String fixedEnd =
    "    return 1;\n" +
    "}\n" ;

	// translate, next 메서드는 사용되지 않습니다.
    // NooToCTest에서 호출하기 때문에 빈 메서드를 만들었습니다.
	public void translate(int next) { }
    public int next(){
        return -1;
    }

    public NooToC (FileWriter fw, String nooPgm) throws IOException {

        String result_C_Code = "";

        try{
            BufferedWriter   bufCWriter = new BufferedWriter(fw);

            bufCWriter.write(fixedStart);
            String line;

            NooTree tree   = new NooTree(nooPgm);
            result_C_Code += tree.ParseToC();

            bufCWriter.write(result_C_Code);
            bufCWriter.write(fixedEnd);

            bufCWriter.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Input Noo File Not Found");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }


}
