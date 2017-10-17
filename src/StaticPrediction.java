import java.util.ArrayList;

public class StaticPrediction {
    
    public static double NTPredict(ArrayList<String[]> trace){
        double mispre = 0;
        for(int i = 0;i < trace.size(); i++){
            String[] branch = trace.get(i);
            if(!branch[1].equals("1")){
                continue;
            } else {
                mispre++;
            }
        }
        return mispre;
    }
    
    public static double TPredict(ArrayList<String[]> trace){
        double mispre = 0;
        for(int i = 0;i < trace.size(); i++){
            String[] branch = trace.get(i);
            if(branch[1].equals("1")){
                continue;
            } else {
                mispre++;
            }
        }
        return mispre;
    }
}
