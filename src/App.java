import java.util.*;

public class App {
    //Declaracion de variables
//    static int startFloor = 4;
    static int actualFloor = 4;
    static int source = 0;
    static int destination = 0;
    static String stateDirectionElevator = "";
    static int sizeArrayFloors = 0;
    static int sizeArrayTower = 0;
    static int[] arrayTower = new int [sizeArrayTower];
    static int[] arrayFloors = new int[sizeArrayFloors];
    static Integer[] arrayFloorsStop = new Integer[sizeArrayFloors];
    static HashMap<Integer, Integer> floorsEntered = new HashMap<>();

    public static void main(String[] args){
        //SCANNER PARA ENTRADAS
        Scanner scan = new Scanner(System.in);

        //INGRESAR VALORES DE LA TORRE
        System.out.println("Ingresar la cantidad de pisos que va a tener la torre");
        sizeArrayTower = scan.nextInt();
        scan.nextLine();
        arrayTower = new int [sizeArrayTower];

        // SE CREA EL ARREGLO CON LOS PISOS DE LA TORRE
        for (int i = 0 ; i<sizeArrayTower ; i++){
            arrayTower[i] = i+1;
        }

        //INGRESAR PISOS A DONDE SE VA A DIRIGIR EL ASCENSOR
        System.out.println("Ingrese la cantidad de pisos en donde va a parar");
        sizeArrayFloors = scan.nextInt();
        scan.nextLine();
        arrayFloors = new int[sizeArrayFloors];

        // LENAR EL ARREGLO CON LOS PISOS EN DONDE SE DESEA PARAR
        System.out.println("Ingrese uno a uno el numero de pisos donde desea detener el ascensor");
        for(int i = 0; i< sizeArrayFloors; i++){
            int floor = scan.nextInt();
            scan.nextLine();
            arrayFloors[i] = floor;
        }

        //HASHMAP QUE INDICA HACIA DONDE ES EL NUEVO DESTINO
        System.out.println("A que piso desea dirigirse?");

        for(int i = 0; i< sizeArrayFloors; i++){
            source = arrayFloors[i];
            System.out.println("llave " + source);
            System.out.println("se dirije");
            destination = scan.nextInt();
            scan.nextLine();
            floorsEntered.put(source, destination);
        }

        //ARREGLO DE NUEVO DESTINO
        arrayFloorsStop = floorsEntered.values().toArray(new Integer[0]);

//        arrayFloors, startFloor, floorsEntered
        iterations();
        scan.close();
    }

//    int floors[], int start, HashMap<Integer,Integer> map
    //Metodo de iteraciones
    public static void iterations (){
        //Piso actual del elevato
        Arrays.sort(arrayFloorsStop);
        Arrays.sort(arrayFloors);
        System.out.println(actualFloor);
        System.out.println("Bienvenido al menu");

        for (int i = 0 ; i< arrayFloors.length ; i++){

            for (int j = 0; j < arrayTower.length; j++){
                System.out.println("El ascensor se encuentra en el piso: " + actualFloor);

                if(actualFloor > 0 && actualFloor < 30) {
                    if (arrayFloors[i] > arrayTower[j]) {
                        stateDirectionElevator = "Ascensor subiendo";
                        actualFloor++;
                    }
                    if (arrayFloors[i] == arrayTower[j]) {
                        stateDirectionElevator = "Ascensor se detiene";
                        actualFloor++;
                    }
                }
                if (actualFloor == 29){
                    if(arrayTower[j] > arrayFloors[i]){
                        stateDirectionElevator = "Ascensor bajando";
                        actualFloor--;
                    }
                }

            }

//            System.out.println(arrayFloors.toString());

        }
//        if(arrayTower[i] < arrayFloors[j]){
//            stateDirectionElevator = "Ascensor Subiendo";
//            System.out.println(stateDirectionElevator);
//        }else if (arrayTower[i] > arrayFloors[j]){
//            stateDirectionElevator = "Ascensor Bajando";
//            System.out.println(stateDirectionElevator);
//        }else if (arrayTower[i] == arrayFloors[j]){
//            stateDirectionElevator = "Ascensor Se detiene";
//            System.out.println(stateDirectionElevator);
//            arrayFloors[j] = arrayFloors[j]-1;
//        }
//        break;
    }




}


