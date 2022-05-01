public class Lamp extends DomoticDevice {
    public Lamp (int channel){
        super(nextId++, channel);
        r=255;
        g=255;
        b=255;
        state = LampState.OFF;
    }
    public void changePowerState(Lamp l){
        if (l.state == LampState.OFF) {
            state = LampState.ON;
        }else{
            state = LampState.OFF;
        }
    }
    public void upColor(String RGB){
        if (RGB.equals("R")) {
            if (r <255){
                r+= 5;
            }else {
                r+=0;
            }
        }
        if (RGB.equals("G")) {
            if (g <255) {
                g += 5;
            }else {
                g+=0;
            }
        }
        if (RGB.equals("B")) {
            if (b < 255) {
                b += 5;
            }else {
                b+=0;
            }
        }
    }

    public void downColor(String RGB){
        if (RGB.equals("R")) {
            if (r >0){
                r-= 5;
            }else {
                r-=0;
            }
        }
        if (RGB.equals("G")) {
            if (g > 0) {
                g -= 5;
            }else {
                g-=0;
            }
        }
        if (RGB.equals("B")) {
            if (b >0) {
                b -= 5;
            }else {
                b-=0;
            }
        }
    }
    
    //-----------------
    public String getHeader(){
        return "L"+getId()+"R\t\t\t"+"L"+getId()+"G\t\t\t"+"L"+getId()+"B\t";
    }
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t\t\t"+g+"\t\t\t"+b;
        else
            return "0\t\t\t0\t\t\t0";
    }
    private enum LampState {
        ON,
        OFF
    }

    private short r,g,b;
    private LampState state;
    private static int nextId=0;
}
