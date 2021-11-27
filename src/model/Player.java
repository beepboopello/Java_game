
package model;

/**
 *
 * @author Admin
 */
public class Player {
    private String name, timewin, date;
    private int timetosec;

    public Player(String s) {
        String mang[] = s.split(" ");
        name = mang[0];
        timewin = mang[1];
        timetosec = tinhTime();
        date = mang[2];
    }
    
    private int tinhTime(){
        String mang[] = timewin.split(":");
        return Integer.parseInt(mang[0])*60+Integer.parseInt(mang[1]);
    }

    public String getName() {
        return name;
    }

    public String getTimewin() {
        return timewin;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Name: "+name+" ----- Time: "+timewin+" ----- Date: "+date;
    }
    
    
    
}
