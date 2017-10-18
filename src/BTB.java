import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BTB {
    int prediction;
    int addr_of_br;
    int br_traget;
    int hits;
    static double miss = 0;
    private static double[] tb = new double[2];
    final static double[] STRONGLY_N = {0, 0};
    final static double[] STRONGLY_T = {1, 1};
    final static double[] WEAKLY_N = {0, 1};
    final static double[] WEAKLY_T = {1, 0};
    
    public static double TwoBit(ArrayList<String[]> trace, int size){
        
        String bf = null;
        int de = 0;
        String bi = "";
        String[] taken = new String[2];
        
        HashMap<String, double[]> buffer = new HashMap<String, double[]>();
        
        for(int i = 0; i < trace.size(); i++){

            taken = trace.get(i);
            bf = taken[0].substring(taken[0].length() - 4, taken[0].length());
            de = Integer.valueOf(bf);
            bi = Integer.toBinaryString(de);
            taken[0] = bi;
            
            if(buffer.containsKey(taken[0])){
                double[] tmp = buffer.get(taken[0]);
                if(taken[1].equals("1") && Arrays.equals(tmp, WEAKLY_T)){
                    tmp = buffer.get(taken[0]);
                    tmp[1] = 1;
                    buffer.put(taken[0], tmp);
                } else if(taken[1].equals("0") && Arrays.equals(tmp, WEAKLY_T)){
                    miss++;
                    tmp = buffer.get(taken[0]);
                    tmp[0] = 0;
                    buffer.put(taken[0], tmp);

                } else if(taken[1].equals("0") && Arrays.equals(tmp, STRONGLY_T)){
                    miss++;
                    tmp = buffer.get(taken[0]);
                    tmp[1] = 0;
                    buffer.put(taken[0], tmp);

                } else if(taken[1].equals("1") && Arrays.equals(tmp, STRONGLY_T)){
//                    continue;
                } else if(taken[1].equals("0") && Arrays.equals(tmp, WEAKLY_N)){
                    tmp = buffer.get(taken[0]);
                    tmp[1] = 0;
                    buffer.put(taken[0], tmp);

                } else if(taken[1].equals("1") && Arrays.equals(tmp, WEAKLY_N)){
                    miss++;
                    tmp = buffer.get(taken[0]);
                    tmp[0] = 1;
                    buffer.put(taken[0], tmp);

                } else if(taken[1].equals("0") && Arrays.equals(tmp, STRONGLY_N)){
//                    continue;
                } else if(taken[1].equals("1") && Arrays.equals(tmp, STRONGLY_N)){
                    miss++;
                    tmp = buffer.get(taken[0]);
                    tmp[1] = 0;
                    buffer.put(taken[0], tb);

                }
            } else {
                tb[0] = 1;
                tb[1] = 0;
                if(taken[1].equals("1")){
                    tb[1] = 1;
                    buffer.put(taken[0], tb);
                }else{
                    miss++;
                    tb[0] = 0;
                    buffer.put(taken[0], tb);
                }
            }
        }
        
        return miss;
    }
}
