import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollerShades = new ArrayList<RollerShade>();
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
        for (int index = 0; index < rollerShades.size(); index++) {
            if (rollerShades.get(index).getChannel() == channel) {
                rollerShades.get(index).startUp();
            }
            //rollerShades.get(index).startUp();
        }
    }
    public void startShadeDown(int channel){
        for (int index = 0; index < rollerShades.size(); index++) {
            if (rollerShades.get(index).getChannel() == channel) {
                rollerShades.get(index).startDown();
            }

        }
    }
    public void stopShade(int channel){
        for (int index = 0; index < rollerShades.size(); index++) {
            if (rollerShades.get(index).getChannel() == channel) {
                rollerShades.get(index).stop();
            }
            //rollerShades.get(index).stop();
        }
    }

    //---------------------------------------

    //Acciones de la lampara

    public void changeLampPowerState(int channel) {
        for (Lamp l : lamps) {
            if (channel == l.getChannel()) {
                l.changePowerState(l);
            }
        }
    }
    public void upColor(int channel, String rgb){
        for (Lamp l : lamps) {
            if (channel == l.getChannel()){
                l.upColor(rgb);
            }
        }
    }

    public void downColor(int channel, String rgb){
        for (Lamp l : lamps) {
            if (channel == l.getChannel()){
                l.downColor(rgb);
            }
        }
    }
    //Obtener los estados de los dispositivos
    public String getState(){
        String state_lamp = "";
        String state_roller = "";
        for (DomoticDevice l : lamps){
            state_lamp += l.toString()+"\t"+"\t\t";
        }
        for (DomoticDevice rs: rollerShades) {
            state_roller += rs.toString()+"\t\t";
        }
        return state_roller +"\t"+ state_lamp;
    }

    //-------------------------------------
    
    //Obtener cabecera de dispositivos

    public String getHeaders(){
        String header = "";
        for (DomoticDevice  rs: rollerShades){
            header += rs.getHeader()+"\t\t";
        }
        header += "\t";
        for (DomoticDevice l: lamps){
            header += l.getHeader()+"\t\t";
        }
        return header;
    }

    
    private ArrayList<Lamp> lamps;
    private ArrayList<RollerShade> rollerShades;
}
