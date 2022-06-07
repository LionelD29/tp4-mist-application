package be.technifutur;

public class Ex13 {

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        int z = 0;

        z = x; // z = 3
        x = y; // x = 5
        y = z; // y = 3

        System.out.println("La valeur de x est de " + x + " et celle de y est de " + y);
    }
}
