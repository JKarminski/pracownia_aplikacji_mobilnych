





import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int x = 0;
        String y="a";


        int a,a2=0,b,b2=0,c,d;

        int xa,xa2=0,xb,xb2=0,xc,xd;

        try (BufferedReader br = Files.newBufferedReader(Paths.get("przyklad.txt"))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");



                if(line.charAt(0) == line.charAt(line.length()-1)) {
                    x++;
                    if(x==1){
                        y = line;
                    }
                }

                a = Integer.parseInt(line);
                b=0;
                c = a;
                d=2;
                while(c>1){
                    if(c%d==0){
                        c=c/d;
                        d=2;
                        ++b;
                    }
                    else{
                        ++d;
                    }
                }
                if(b>b2){
                    b2=b;
                    a2=a;
                }


                xa = Integer.parseInt(line);
                xb=0;
                xc = a;
                xd=2;
                while(xc>1){
                    if(xc%xd==0){
                        while (xc%xd==0){
                            xc=xc/xd;
                        }
                        xd=2;
                        ++xb;
                    }
                    else{
                        ++xd;
                    }
                }
                if(xb>xb2){
                    xb2=xb;
                    xa2=xa;
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        System.out.println(sb);
        System.out.print(x);
        System.out.println(y);
        System.out.println(a2);
        System.out.println(b2);
        System.out.println(xa2);
        System.out.println(xb2);


    }
}








