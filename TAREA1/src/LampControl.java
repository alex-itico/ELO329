public class LampControl extends DomoticDeviceControl {
    public LampControl(int channel, Cloud c){
        super(channel, c);
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public void upColor(String UD, String RGB){
        cloud.upColor(channel, RGB);
    }
    public void downColor(String UP, String RGB){
        cloud.downColor(channel, RGB);
    }
}
