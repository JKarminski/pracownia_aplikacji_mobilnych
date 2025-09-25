import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class klasa2 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int x = 0;
        String y = "a";


        try (BufferedReader br = Files.newBufferedReader(Paths.get("przyklad.txt"))) {
            List<Integer> Listaa = new ArrayList<>();

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                Listaa.add(Integer.parseInt(line));
                sb.append(line).append("\n");


                if (line.charAt(0) == line.charAt(line.length() - 1)) {
                    x++;
                    if (x == 1) {
                        y = line;
                    }
                }

            }
            Listaa.get(0);
            System.out.println(Listaa.get(0));
            int a = 0;
            for(int i = 0; i < Listaa.size(); i++){
                for(int j = 0; j < Listaa.size(); j++){
                    if(Listaa.get(i)%Listaa.get(j)==0 && Listaa.get(j)-Listaa.get(i)!=0){
                        for(int k = 0; k < Listaa.size(); k++){
                            if(Listaa.get(j)%Listaa.get(k)==0 && Listaa.get(j)-Listaa.get(k)!=0){
                                a++;
                            }
                        }
                    }
                }
            }
            int b = 0;
            for(int i = 0; i < Listaa.size(); i++){
                for(int j = 0; j < Listaa.size(); j++){
                    if(Listaa.get(i)%Listaa.get(j)==0 && Listaa.get(j)-Listaa.get(i)!=0){
                        for(int k = 0; k < Listaa.size(); k++){
                            if(Listaa.get(j)%Listaa.get(k)==0 && Listaa.get(j)-Listaa.get(k)!=0){
                                for(int l = 0; l < Listaa.size(); l++){
                                    if(Listaa.get(k)%Listaa.get(l)==0 && Listaa.get(l)-Listaa.get(k)!=0){
                                        for(int m = 0; m < Listaa.size(); m++){
                                            if(Listaa.get(l)%Listaa.get(m)==0 && Listaa.get(m)-Listaa.get(l)!=0){
                                                b++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(a);
            System.out.println(b);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}

