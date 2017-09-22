
/**
 * Write a description of class RoverRunner here.
 * 
 * @author Sean Donlin 
 * @version 9/21/17
 */
public class RoverRunner
{
    public static void main(String[] arrrggggggs)
    {
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover("Lil-Boat");
        
        System.out.println(r1);
        r1.move();
        r1.rotateRight();             
        r1.move();
        System.out.println(r1);
        
        System.out.println(r2);
        r2.rotateRight();
        r2.move();        
        r2.move();        
        r2.move();       
        r2.move();        
        r2.move();       
        r2.rotateRight();       
        r2.move();        
        r2.move();
        System.out.println(r2);
    }
}
