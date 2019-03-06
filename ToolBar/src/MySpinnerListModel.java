import javax.swing.*;
/*This class make going around up and down on the SpinnerListModel possible. Like in circle*/

public class MySpinnerListModel extends SpinnerListModel {
    MySpinnerListModel(Object[] values){
        super(values);
        firstValue = values[0];
        lastValue = values[values.length-1];
    }
    @Override
    public Object getNextValue(){
        if(super.getNextValue() == null)
            return firstValue;
        else
            return super.getNextValue();
    }
    @Override
    public Object getPreviousValue(){
        if(super.getPreviousValue() == null)
            return lastValue;
        else
            return super.getPreviousValue();
    }
   private Object firstValue, lastValue;
}
