import java.util.*;

public class App {
    //Declaracion de variables
    static int actualFloor;
    static String stateDirectionElevator = "";
    static int sizeArrayFloors = 0;
    static int sizeArrayTower = 0;
    static int[] arrayTower = new int [sizeArrayTower];
    static Integer[] arrayFloorsStop = new Integer[sizeArrayFloors];

    public static void main(String[] args){
        //SCANNER PARA ENTRADAS
        Scanner scan = new Scanner(System.in);
        int startFloor = 4;
        int destination;
        int source;
        HashMap<Integer, Integer> floorsEntered = new HashMap<>();
        int[] arrayFloors;

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
        iterations(arrayFloors, startFloor, floorsEntered);
        scan.close();
    }

    //Metodo de iteraciones
    public static void iterations (int[] arrayFloors, int startFloor, HashMap<Integer,Integer> floorsEntered  ) {
        //ARREGLO DE NUEVO DESTINO
        arrayFloorsStop = floorsEntered.values().toArray(new Integer[0]);
        actualFloor = startFloor;
        Arrays.sort(arrayFloorsStop);
        Arrays.sort(arrayFloors);
        System.out.println("Bienvenido al las iteraciones");

        if (actualFloor > 0 && actualFloor < arrayTower.length && actualFloor < arrayFloors[0] ){
            elevatorUp(arrayFloors,startFloor);
        }

        if (actualFloor > 0 && actualFloor <= arrayTower.length && actualFloor >= arrayFloors[0]){
            elevatorDown(arrayFloors,startFloor);
        }
    }
    //Metodo de subir elevador
    public static void elevatorUp(int[] arrayFloors, int startFloor){

        System.out.println("El elevador se encuentra en el piso: " + actualFloor);
        stateDirectionElevator = "Elevador subiendo";
        System.out.println(stateDirectionElevator);
        actualFloor += 1;

        for (int i = startFloor; i < arrayTower.length; i++) {
            System.out.println("El elevador se encuentra en el piso: " + actualFloor);

            if (arrayFloors[0] == actualFloor){
                stateDirectionElevator = "Elevador se detiene";
                System.out.println(stateDirectionElevator);
            }
            if (actualFloor <= arrayTower.length){
                stateDirectionElevator = "Elevador subiendo";
                System.out.println(stateDirectionElevator);
                actualFloor++;
            }

        }
        actualFloor = actualFloor - 1;
    }
    //Metodo de bajar elevador
    public static void elevatorDown(int[] arrayFloors, int startFloor){

        stateDirectionElevator = "Elvador bajando";
        System.out.println(stateDirectionElevator);
        System.out.println("valor del piso actual antes del for"+ actualFloor);

        for (int i = actualFloor; i > 0; i--) {
            System.out.println("El elevador se encuentra en el piso: " + actualFloor);
            stateDirectionElevator = "Elvador bajando";
            System.out.println(stateDirectionElevator);
            actualFloor--;

            if (arrayFloors[0] == actualFloor){
                stateDirectionElevator = "Elevador se detiene";
                System.out.println(stateDirectionElevator);
                stateDirectionElevator = "Elvador bajando";
                System.out.println(stateDirectionElevator);
            }
            if (actualFloor == 1){
                System.out.println("El elevador se encuentra en el piso: " + actualFloor);
                stateDirectionElevator = "Elevador se detiene";
                System.out.println(stateDirectionElevator);
                break;
            }
        }
        actualFloor = actualFloor + startFloor;
    }

}


