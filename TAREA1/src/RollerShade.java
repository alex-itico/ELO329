public class RollerShade extends DomoticDevice {
    public RollerShade (int channel, double alpha, double length) {
        super(nextId++, channel);
        motor = new Motor(alpha);
        MaxShadeLength = length;
        this.length = 0;
    }
    public void startUp(){
        motor.turnUp();
    }
    public void startDown(){
        motor.turnDown();
    }
    public void stop(){
        motor.stop();
    }
    public void advanceTime(double delta){
        motor.advanceTime(delta);
    }
    public String getHeader(){
        String s = "RS" + getId();
        return s;
    }
    public String toString(int length){
        //String s = String.valueOf(Math.round(length/MaxShadeLength*100));
        String s = String.valueOf(length);
        return s;
    }
    private class Motor {  //nested class, Motor is only used within RollerShade.
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;
        }
        public enum MotorState {
            UPWARD,
            STOPPED,
            DOWNWARD
        }
        public void turnUp(){
            state = MotorState.UPWARD;
        }
        public void turnDown(){
            state = MotorState.DOWNWARD;
        }
        public void stop(){
            state = MotorState.STOPPED;
        }
        public void advanceTime(double delta){
            double increment = alpha*delta*RADIUS; // -> 1 * 10 * 0.04 = 0.4[m]  
            switch (state) {
                case STOPPED:
                    length = 0; 
                    break;
                case DOWNWARD:
                    length = 100;
                    //length += increment;
                    break;
                case UPWARD:
                    length = -100;
                    //length -= increment;
                    break;
            }
        }
        private double alpha; //Velocidad angular (?)
        private MotorState state;
        private static double RADIUS=0.04;
    }

    private Motor motor;
    private double length;
    private final double MaxShadeLength;
    private static int nextId;
}