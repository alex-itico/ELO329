import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(Cloud c){
        cloud = c;
    }
    public void addShadeControl(ShadeControl sc){
        rsControl = sc;
    }

    public void addLampControl(LampControl lc){
        lpControl = lc;
    }

    public void executeCommands(Scanner in, PrintStream out){
        out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextInt()){
            int commandTime=in.nextInt(); //almacena tiempo del segundo
            while (time < commandTime) {
                out.println(time+"\t"+cloud.getState());
                cloud.advanceTime(delta);
                time+=delta;
            }
            String device=in.next(); //Almacena el tipo de dispositivo, si es Lampara o Cortina
            if (!device.equals("C" /* "L"*/)) {
                out.println("Unexpected device:" + device);
                System.exit(-1);
            }
            int channel = in.nextInt();
            String command=in.next(); //rescata el tipo de comando que es puede ser UP, DOWN, STOP, ON OFF or RGB

            if(device.equals("C")) { //Si el dispositivo es de tipo Cortina ejecutará sus comandos
                if (channel == rsControl.getChannel()) {
                    switch (command.charAt(0)) {
                        case 'D': //??
                            // ??
                        default: out.println("Unexpected command:" + command);
                            System.exit(-1);
                    }
                }
            }
            if (device.equals("L")){ //Si el dispositivo es de tipo Lampara ejecturá sus comandos
                if (channel == lpControl.getChannel()){
                    switch (command.charAt(0)){
                        case "N":
                            //ChangePowerState to ON
                            break;
                        case "F":
                            //ChangePowerState to OFF
                            break;
                        case "R":
                            //
                            break;
                        case "G":
                            //
                            break;
                        case "B":
                            //
                            break;
                        default: out.println("Unexpected command:" + command);
                            System.exit(-1);
                    }
                }
            }
            /*
            if (channel == rsControl.getChannel()) {
                switch (command.charAt(0)) {
                    case 'D': //??
                    // ??
                    default: out.println("Unexpected command:" + command);
                        System.exit(-1);
                }
            }*/
        }
        out.println(time+"\t"+cloud.getState());
    }
    private double time=0;
    private LampControl lpControl;
    private ShadeControl rsControl;
    private Cloud cloud;
    private final double delta=0.1;
}
