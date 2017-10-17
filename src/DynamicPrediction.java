import java.util.ArrayList;
import java.util.Arrays;

public class DynamicPrediction {
    
    final static double[] STRONGLY_N = {0, 0};
    final static double[] STRONGLY_T = {1, 1};
    final static double[] WEAKLY_N = {0, 1};
    final static double[] WEAKLY_T = {1, 0};
    
    public static double TwoBit(ArrayList<String[]> trace){
        double mispre = 0;
        double[] tb = {1, 1};
        
        for(int i = 0; i < trace.size(); i++){
            String[] current_branch = trace.get(i);
            if(Arrays.equals(tb, STRONGLY_N)){
                if(current_branch[1].equals("0")){
                    continue;
                } else if (current_branch[1].equals("1")){
                    mispre++;
                    tb[1] = 1;
                }
            } else if (Arrays.equals(tb, WEAKLY_N)){
                if(current_branch[1].equals("0")){
                    tb[1] = 0;
                }else if (current_branch[1].equals("1")){
                    mispre++;
                    tb[0] = 1;
                    tb[1] = 0;
                }
            } else if (Arrays.equals(tb, WEAKLY_T)){
                if(current_branch[1].equals("0")){
                    tb[0] = 0;
                    tb[1] = 1;
                    mispre++;
                }else if(current_branch[1].equals("1")){
                    tb[1] = 1;
                }
            } else if (Arrays.equals(tb, STRONGLY_T)){
                if(current_branch[1].equals("0")){
                    tb[1] = 0;
                    mispre++;
                }else if(current_branch[1].equals("1")){
                    continue;
                }
            }
            
        }
        return mispre;
    }
    
    public static double CorrelatingPredictor(ArrayList<String[]> trace){
        
        return 0;
    }
}
