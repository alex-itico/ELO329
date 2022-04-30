# ELO329 
---
### *Diseño y Programacion Orientados a Objetos*
---

#### **Tarea 1: Simulando Ventanas y Lamparas Domoticas**  
---  

###### • Integrantes del equipo:
- **Nombre:** Jesus Chaffe    
**Rol:** 202023501-5  
**Correo:** jesus.chaffe@usm.cl
- **Nombre:** Alex Aravena       
**Rol:** 202004521-6    
**Correo:** alexaravenata@usm.cl
- **Nombre:** Javier Acuña       
**Rol:** 201944537-5    
**Correo:** javier.acuna@usm.cl

---

## Descripcion del programa  
Este programa resuelve el desafio de configurar distintos aparatos como  
lamparas y cortinas mediante la domotica y la realizacion de un programa  
que recibe instrucciones como parametros en un archivo de texto.  

Se pide tambien que los resultados de dicha configuracion se entreguen en  
un archivo .tsv para poder ver graficamente el ambiente que se busca recrear.

---
## Requisitos de compilacion y ejecución

**Tener Compilador:** jdk-17.0.2
**Sistema Operativo:** Linux   
Deben descargarse todos los archivos y guardarlos en un mismo directorio en Aragorn. Usando el makefile que tambien es parte de la entrega pueden realizar el comando:

$Make para compilación de todos los archivos correspondientes dentro del directorio.
$Make run para ejecución automatica del código. En caso de no resultar, por terminal desplegar comando **java "nombre del proyecto"** ./configuration.txt.
$Make clean para eliminación de archivos de tipo .class en el directorio.


---
## Archivos del programa  
-Cloud: clase que se encarga de almacenar arreglos de cortinas y lamparas, y de distribuir sus métodos en domotica.
-DomoticDevice: clase que construye un dispositivo de domotica almacenando su Id y canal correspondiente.
-DomoticDeviceControl: clase que construye un dispositivo de control domotica almacenando su Id y canal correspondiente.
-Lamp: objeto domotica de tipo Lampara.
-LampControl: control domotica de tipo Lampara.
-Operator: clase que desplegara la lectura de las acciones del archivo configuration.txt
-RollerShade: objeto domotica de tipo Cortina.
-ShadeControl: control comotica de tipo Cortina
-Stage2: Funcion Main del programa inicializa las cortinas y las lamparas junto con el cloud y los operadores segun el archivo de entrada que recibe


---
## Consideraciones finales  
Rellenar con consideraciones


