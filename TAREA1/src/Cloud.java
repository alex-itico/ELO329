import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }
    public void advanceTime(double delta){
        for (DomoticDevice dd: rollerShades) {
            RollerShade rs =(RollerShade)dd;
            rs.advanceTime(delta);
        }
    }
    private String getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel){
        String Ids = "";
        for (int i = 0; i < devices.size(); i++) {
            if(devices.get(i).getChannel() == channel){
            Ids += devices.get(i).getId() + "/t";
            }
        }
        return Ids;
    } //Retorna un String con los Id de los dispositivos que estan en el canal especificado.
    

    //Acciones de la cortina
    public void startShadeUp(int channel){
        // ???
    }
    public void startShadeDown(int channel){
        // ???
    }
    public void stopShade(int channel){
        // ???
    }
    //---------------------------------------

    //Acciones de la lampara

    public void changeLampPowerState(int channel){
        
        for (Lamp l : lamps) {
            if (channel == l.getChannel()){
                l.changePowerState();
            }
    }

    public void upColor(int channel){

    }

    
    public void downColor(int channel){

    }
    
    public String getState(){
        String state_lamp = "";
        for (DomoticDevice l : lamps){
            state_lamp = l.toString();
        }
        return state_lamp;
    }

    //-------------------------------------
    
    //Obtener cabecera de dispositivos

    public String getHeaders(){
        String header = "";
        for (DomoticDevice  rs: rollerShades)
            header += rs.getHeader()+"\t";
        for (DomoticDevice l: lamps)
            header += l.getHeader()+"\t";
        return header;
    }

    
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;
}
