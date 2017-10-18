import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new FileReader("branchtrace.out"));
//        Predictor bp = null;
        
        
        ArrayList<String[]> blist = new ArrayList<String[]>();
        try{
            String line = null;
//            System.out.println(line);
            long branches = 0;
//            int correctP = 0;
////            int i = 0;
            while ((line = br.readLine()) != null) {
                branches++;
                String[] token = line.split(" ");
                blist.add(token);
            }
        }finally{
            br.close();
        }
        System.out.println("1: Alway taken");
        System.out.println("2: Alway not taken");
        System.out.println("3: 2 bit predictor (4096)");
        System.out.println("Please select Branch Prediction Strategy(number) to see the misprediction rate:");
        Scanner sc = new Scanner(System.in);
        int bps = sc.nextInt();
        sc.close();
        double mispre = 0;
        double rate = 0;
        String misrate = null;
        NumberFormat nf = NumberFormat.getPercentInstance();
            nf.setMinimumFractionDigits(4);
        switch(bps){
        default:
            System.out.println("Sorry, please input the correct number!");
            break;
        case 1:
            mispre = StaticPrediction.NTPredict(blist);
            rate = mispre / blist.size();
            misrate = nf.format(rate);
            System.out.println("The misprediction rate is " + misrate);
            break;
        case 2:
            mispre = StaticPrediction.TPredict(blist);
            rate = mispre / blist.size();
            misrate = nf.format(rate);
            System.out.println("The misprediction rate is " + misrate);
            break;
        case 3:
            mispre = DynamicPrediction.TwoBit(blist);
            rate = mispre / blist.size();
            misrate = nf.format(rate);
            System.out.println("The misprediction rate is " + misrate);
            
//            mispre = BTB.TwoBit(blist, 1);
//            rate = mispre / blist.size();
//            misrate = nf.format(rate);
//            System.out.println("The misprediction rate is " + misrate);
            break;
        }
    }
}
