package beans_unit;

import java.util.List;

public interface FrameDay extends Facturable{
	 
    public void setDate(String date);
    public String getDate();
    
    public void setFacture(String list);
    //public List<String> getFacture();	//..in interface Facturable
    
    public void setInfo(List<String> info);
    public List<String> getInfo();
}