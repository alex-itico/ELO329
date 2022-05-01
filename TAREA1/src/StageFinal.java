import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StageFinal {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(args[0]));
        //<#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        int numero_cortinas = scan.nextInt();
        int numero_lamparas = scan.nextInt();
        int n_control_cortinas = scan.nextInt();
        int n_control_lamparas = scan.nextInt();

        Cloud cloud = new Cloud();
        Operator accion = new Operator(cloud);
    
        //Ver casos de objetos
        if (numero_cortinas != 0) {
            for (int i = 0; i < numero_cortinas; i++) {
                double rapidez_angular = Double.parseDouble(scan.next());
                double largo_cortina = Double.parseDouble(scan.next());
                int canal_cortina_n = scan.nextInt();
                RollerShade rs = new RollerShade(canal_cortina_n, rapidez_angular, largo_cortina);
                cloud.addRollerShade(rs); //agregando a la nube la vola
            }
        }
        if (numero_lamparas != 0) {
            for (int i = 0; i < numero_lamparas; i++) {
                int canal_lampara_n = scan.nextInt();
                Lamp l = new Lamp(canal_lampara_n);
                cloud.addLamp(l); 
            }
        }
        if (n_control_cortinas != 0){
            for (int i = 0; i < n_control_cortinas; i++) {
                int canal_control_cortinas = scan.nextInt();
                ShadeControl sc = new ShadeControl(canal_control_cortinas, cloud);
                accion.addShadeControl(sc);
            }
        }

        if (n_control_lamparas != 0){
            for (int i = 0; i < n_control_lamparas; i++) {
                int canal_control_lamparas = scan.nextInt();
                LampControl lc = new LampControl(canal_control_lamparas, cloud);
                accion.addLampControl(lc);
            }
        }
        accion.executeCommands(scan, System.out);
        }
    }


