public class LampControl extends DomoticDeviceControl {
    public LampControl(int channel, Cloud c){
        super(channel, c);
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    /*
    public void changeIntensity(int LpChannel, int LcChannel,){
        
    }
    */   
}
