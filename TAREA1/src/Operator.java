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
            int commandTime=in.nextInt();
            while (time < commandTime) {
                out.println(time+"\t"+cloud.getState());
                cloud.advanceTime(delta);
                time+=delta;
            }
            String device=in.next(); //Almacena el tipo de dispositivo, si es Lampara o Cortina
            if (!device.equals("C")) {
                out.println("Unexpected device:" + device);
                System.exit(-1);
            }
            int channel = in.nextInt();
            String command=in.next();
            if (channel == rsControl.getChannel()) {
                switch (command.charAt(0)) {
                    case 'D': //??
                    // ??
                    default: out.println("Unexpected command:" + command);
                        System.exit(-1);
                }
            }
        }
        out.println(time+"\t"+cloud.getState());
    }
    private double time=0;
    private LampControl lpControl;
    private ShadeControl rsControl;
    private Cloud cloud;
    private final double delta=0.1;
}