
public abstract class Predictor {
    public Predictor(){}
    
    abstract public void Train();
    
    abstract public boolean predict(long address);
}
