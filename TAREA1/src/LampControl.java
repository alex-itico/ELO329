public class LampControl extends DomoticDeviceControl {
    public LampControl(int channel, Cloud c){
        super(channel, c);
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public void upColor(String RGB){
        cloud.upColor(channel, RGB);
    }
    public void downColor(String RGB){
        cloud.downColor(channel, RGB);        
    }
}
