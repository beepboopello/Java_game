package model;

import javax.swing.*;

public class cell extends JButton{
    private String value;
    private int ix, iy;
    public cell(int x, int y) {
        this.ix=x;
        this.iy=y;
        this.value = "";
        setText(value);
    }
    
    public void changeValue(String val){
        if(this.value.equals("")){
            setText(val);
            value = val;
        }
        else{
            return;
        }
    }

    public int getIx() {
        return ix;
    }

    public int getIy() {
        return iy;
    }

    public String getValue() {
        return value;
    }
    
    public boolean isBlank(){
        return value.equals("");
    }
    
    public boolean equals(cell c){
        return value.equals(c.getValue());
    }
}