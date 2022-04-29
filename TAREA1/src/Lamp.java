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
            if (r <=255){
                r+= 5;
            }else {
                r+=0;
            }
        }
        if (RGB.equals("G")) {
            if (g <=255) {
                g += 5;
            }else {
                g+=0;
            }
        }
        if (RGB.equals("B")) {
            if (b <=255) {
                b += 5;
            }else {
                b+=0;
            }
        }
    }

    public void downColor(String RGB){
        if (RGB.equals("R")) {
            if (r >=0){
                r-= 5;
            }
        }
        if (RGB.equals("G")) {
            if (g >=255) {
                g -= 5;
            }
        }
        if (RGB.equals("B")) {
            if (b >=255) {
                b -= 5;
            }
        }
    }
    
    //-----------------
    public String getHeader(){
        return "L"+getId()+"R        "+"L"+getId()+"G         "+"L"+getId()+"B\t";
    }
    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
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
