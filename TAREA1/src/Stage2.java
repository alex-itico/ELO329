import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Stage2 {

    public static void main(String[] args) throws FileNotFoundException{
        //File file = new File("/Users/alexi/Desktop/ELO329/TAREA1/configuration.txt"); NO BORRAR / FORMA ALTERNATIVA
        Scanner scan = new Scanner(new File(args[0]));
        //<#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        int numero_cortinas = scan.nextInt();
        int numero_lamparas = scan.nextInt();
        int n_control_cortinas = scan.nextInt();
        int n_control_lamparas = scan.nextInt();
        //Creación del arreglo de listas de los dispositivos.
        ArrayList <DomoticDevice> rollerShade = new ArrayList<DomoticDevice>();
        ArrayList <DomoticDevice> lamp = new ArrayList<DomoticDevice>();
        ArrayList <DomoticDeviceControl> shadeControl = new ArrayList<DomoticDeviceControl>();
        ArrayList <DomoticDeviceControl> lampControl = new ArrayList<DomoticDeviceControl>();
        
        Cloud cloud = new Cloud();
        Operator accion = new Operator(cloud);
    
        //Ver casos de objetos
        if (numero_cortinas != 0) {
            for (int i = 0; i < numero_cortinas; i++) {
                double rapidez_angular = Double.parseDouble(scan.next());//scan.nextDouble();
                double largo_cortina = Double.parseDouble(scan.next());//scan.nextDouble();
                int canal_cortina_n = scan.nextInt();
                RollerShade rs = new RollerShade(canal_cortina_n, rapidez_angular, largo_cortina); 
                rollerShade.add(rs);
                cloud.addRollerShade(rs); //agregando a la nube la vola
            }
        }
        if (numero_lamparas != 0) {
            for (int i = 0; i < numero_lamparas; i++) {
                int canal_lampara_n = scan.nextInt();
                Lamp l = new Lamp(canal_lampara_n);
                lamp.add(l);
                cloud.addLamp(l); 
            }
        }
        if (n_control_cortinas != 0){
            for (int i = 0; i < n_control_cortinas; i++) {
                int canal_control_cortinas = scan.nextInt();
                ShadeControl sc = new ShadeControl(canal_control_cortinas, cloud);
                shadeControl.add(sc);
                accion.addShadeControl(sc);
            }
        }

        if (n_control_lamparas != 0){
            for (int i = 0; i < n_control_lamparas; i++) {
                int canal_control_lamparas = scan.nextInt();
                LampControl lc = new LampControl(canal_control_lamparas, cloud);
                lampControl.add(lc);
                accion.addLampControl(lc);
            }
        }

        accion.executeCommands(scan, System.out);
        
        /*
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
         */
        }
    }


