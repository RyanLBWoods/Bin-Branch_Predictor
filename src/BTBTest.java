import java.io.File;
import java.util.HashSet;

public class BTBTest {
    public static final int M = 1;
    public static final int N = 2;
    public static final int MAX_BTB_LEN = 1024;
    public static final long MAXITERS = 100000;
    public static int correct_pre, mis_pre, tot_br, btb_len;
    public static int msbraddr, msbraddr_hits, msbraddr_mis;
    public static HashSet<String> set = new HashSet<String>();
    
    static BTB btb[] = new BTB[MAX_BTB_LEN];
    static File f1, f2;
    
    public BTBTest(){
        for(int i = 0; i < btb.length; i++){
            btb[i] = new BTB();
        }
    }
    
    int get_btb_index(int addr_br_instr){
        int index = addr_br_instr & (btb_len - 1);
        return index;
    }
    
    boolean check_prediction(int branch, int index){
        switch (branch) {
        case 1:
            if (btb[index].prediction >= 2){
                correct_pre++;
                return true;
            } else {
                mis_pre++;
                return false;
            }
        case 0: 
            if (btb[index].prediction <= 1){
                correct_pre++;
                return true;
            } else {
                mis_pre++;
                return false;
            }
        default:
            System.out.println("branch value error");
            return false;
        }
    }
    
    void updata_table(int branch, int index, int addr, int target){
        if(btb[index].addr_of_br == addr){
            btb[index].hits++;
        } else {
            btb[index].miss++;
            btb[index].addr_of_br = addr;
        }
        
        switch(branch){
        case 1:
            btb[index].prediction++;
            if(btb[index].prediction > 3){
                btb[index].prediction = 3;
            }
            break;
        
        case 0:
            btb[index].prediction--;
            if(btb[index].prediction < 0){
                btb[index].prediction = 0;
            }
            break;
        default:
        }
    }
}
