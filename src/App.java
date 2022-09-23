import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        //Declaracion de variables
        Scanner scan = new Scanner(System.in);
        int startFloor = 4;
        int ActualFloor;
        String stateElevator = "";

        System.out.println("Ingrese el tamano del arreglo");
        int sizeArray = scan.nextInt();
        scan.nextLine();
        //Tamano del arreglo
        int arrayFloors[] = new int[sizeArray];

        // Llenar el arreglo de pisos
        System.out.println("Ingrese los numero de pisos donde desea detener el ascensor, los valores ingresador deben ser separados por espacio");
        for(int i = 0; i<sizeArray ; i++){
            int floor = scan.nextInt();
            scan.nextLine();
            arrayFloors[i] = floor;
        }
        
        // Prueba de que se el arreglo esta lleno
        System.out.println("Valores del arreglo" + "\n");
        for(int j: arrayFloors){
            System.out.print(j + " ");
        }

        //Se llena el hashMap con el piso donde recoge a una persona y el piso de destino
        System.out.println("Ingrese valores de hashMap");
        HashMap<Integer, Integer> floorsEntered = new HashMap<Integer, Integer>();
        for(int i =0; i<sizeArray ; i++){
            int source = scan.nextInt();
            scan.nextLine();
            int destination = scan.nextInt();
            scan.nextLine();
            floorsEntered.put(source, destination);

            //int valuesDestination = floorsEntered.get(destination);
        }
        /*
        System.out.println("valores");
        for (int i : floorsEntered.keySet()) {
            System.out.println(i);
        }*/

        iterations(arrayFloors, startFloor, floorsEntered);
        scan.close();

    }

    //Metodo de iteraciones
    public static void iterations (int floors[], int start, HashMap<Integer,Integer> map){
        //Piso actual del elevato
        

    }

    public static void state (int start, int floors[]){

    }
}
