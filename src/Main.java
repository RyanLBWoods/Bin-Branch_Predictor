import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        Predictor bp = null;
        
        switch(Integer.valueOf(args[1])){
        case 1:
            
        }
        
        try{
            String line = br.readLine();
            long branches = 0;
            int correctP = 0;
            while (line != null) {
                branches++;
                String[] token = line.split(" ");
                
            }
        }finally{
            
        }
    }

}
