import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//import javax.print.DocFlavor.STRING;

public class Operator {
    public Operator(Cloud c){
        cloud = c;
        rsControls = new ArrayList<ShadeControl>();
        lcControls = new ArrayList<LampControl>();
    }
    public void addShadeControl(ShadeControl sc){
        rsControls.add(sc);
    }

    public void addLampControl(LampControl lc){
        lcControls.add(lc);
    }

    public void executeCommands(Scanner in, PrintStream out){
        out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextInt()){
            int commandTime=in.nextInt(); //almacena tiempo del segundo
            while (time < commandTime) {
                out.println(String.format("%.1f",time)+"\t\t"+cloud.getState());
                cloud.advanceTime(delta);
                time+=delta;
            }
            String device=in.next(); //Almacena el tipo de dispositivo, si es Lampara o Cortina
            if (!(device.charAt(0) == 'C') && !(device.charAt(0) == 'L')) {
                out.println("Unexpected device:" + device);
                System.exit(-1);
            }
            int channel = in.nextInt(); //almacena el canal correspondiente al que se quiere accionar
            String command=in.next(); //rescata el tipo de comando que es puede ser UP, DOWN, STOP, ON OFF or RGB

            if(device.equals("C")) { //Si el dispositivo es de tipo Cortina ejecutará sus comandos
                for (ShadeControl rsControl: rsControls) {
                    if (channel == rsControl.getChannel()) {
                        switch (command.charAt(0)) {
                            case 'D':
                                rsControl.startDown();
                                break;
                            case 'U':
                                rsControl.startUp();
                                break;
                            case 'S':
                                rsControl.stop();
                                break;
                            default: out.println("Unexpected command:" + command);
                                System.exit(-1);
                        }
                    }
                }

            }
            if (device.equals("L")){ //Si el dispositivo es de tipo Lampara ejecturá sus comandos
                    String nextCommand = ""; //Se crea un espacio para el comando siguiente en blanco
                if (command.charAt(0) != 'N' && command.charAt(0) != 'F') {
                    nextCommand = in.next(); //Si el comando no es ON u OFF que agregue la acción siguiente
                    }
                for (LampControl lpControl: lcControls) {
                    if (channel == lpControl.getChannel()){
                        switch (command.charAt(0)){
                            case 'N':
                                lpControl.pressPower();
                                //ChangePowerState to ON
                                break;
                            case 'F':
                                lpControl.pressPower();
                                //ChangePowerState to OFF
                                break;
                            case 'R':
                                if (nextCommand.equals("U")) {
                                    lpControl.upColor(command); // R-G-B , U-D
                                }
                                else if (nextCommand.equals("D")) {
                                    lpControl.downColor(command);
                                } else {
                                    out.println("Unexpected command:" + nextCommand);
                                }
                                break;
                            case 'G':
                                if (nextCommand.equals("U")) {
                                    lpControl.upColor(command);
                                }
                                else if (nextCommand.equals("D")) {
                                    lpControl.downColor(command);
                                } else {
                                    out.println("Unexpected command:" + nextCommand);
                                }
                                break;
                            case 'B':
                                if (nextCommand.equals("U")) {
                                    lpControl.upColor(command);
                                }
                                else if (nextCommand.equals("D")) {
                                    lpControl.downColor(command);
                                } else {
                                    out.println("Unexpected command:" + nextCommand);
                                }
                                break;
                            default: out.println("Unexpected command:" + command);
                                System.exit(-1);
                        }
                    }
                }

            }

        }
        out.println(String.format("%.1f",time-0.1)+"\t\t"+cloud.getState());
    }
    private double time=0;
    private Cloud cloud;
    private final double delta=0.1;
    private ArrayList<ShadeControl> rsControls;
    private ArrayList<LampControl>  lcControls;
}
