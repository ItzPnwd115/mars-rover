
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
        r1.move(1);
        r1.rotateRight();             
        r1.move(1);
        r1.setName("Sojourner");
        r1.teleport(5,9);
        System.out.println(r1);
        
        System.out.println(r2);
        r2.rotateRight();
        r2.move(5);        
        r2.rotateRight();  
        r2.takePic();
        r2.move(2);
        r2.takePic();
        r2.killRover(r1);
        r2.takePic();
        r2.rotateLeft();
        r2.takePic();
        r2.teleport(9,3);
        r2.takePic();
        r2.rotateLeft();
        r2.takePic();
        r2.transmitPictures();
        r2.takePic();
        System.out.println(r2);
        
        System.out.println(r3);
        r3.move(2);
        r3.rotateLeft();
        r3.move(1);
        r3.transmitPictures();
        System.out.print(r3);
                
    }
}
