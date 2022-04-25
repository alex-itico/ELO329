public class Lamp extends DomoticDevice {
    public Lamp (int channel){
        super(nextId++, channel);
        r = 0;
        g = 0;
        b = 0;
        state = LampState.OFF;
    }
    public void changePowerState(Lamp l){
        if (l.state == LampState.OFF) {
            state = LampState.ON;
        }else{
            state = LampState.OFF;
        }
    }

    //Metodos temporales
    public void upColor(String RGB){
        if (RGB.equals("R")) { //falta especificar mientras sea menor o igual a 255
            r += 5;
        }
        if (RGB.equals("G")) {
            g += 5;
        }
        if (RGB.equals("B")) {
            b += 5;
        }
    }

    public void downColor(String RGB){
        if (RGB.equals("R")) {
            r -= 5;
        }
        if (RGB.equals("G")) {
            g -= 5;
        }
        if (RGB.equals("B")) {
            b = 5;
        }
    }
    
    //-----------------
    public String getHeader(){
        return "L"+nextId+"R        "+"L"+nextId+"G         "+"L"+nextId+"B";
    }
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }
    private enum LampState {
        ON,
        OFF
    }

    private short r,g,b;
    private LampState state;
    private static int nextId=0;
}
