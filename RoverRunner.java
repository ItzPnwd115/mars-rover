
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
        //Make a SipmleScanner
        SimpleScanner input = new SimpleScanner();
        
        //Rovers
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover("Lil-Boat");
        Rover r4 = new Rover("4th Reich");
        
        //Make a RoverGroup and add Rovers
        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);
        
        //Now let's do stuffs!
        boolean running = true;
        String exitCommand = "quit";
        
        while (running) {
            //Input name
            System.out.println("Enter the name of the Rover to act: ");
            //Lists names of Robots
            System.out.println("[1] " + r1);
            System.out.println("[2] " + r2);
            System.out.println("[3] " + r3);
            System.out.println("[4] " + r4);
            String name = input.readString();
            
            //Select Rover with matching name
            Rover actor = group.find(name);
            
            if (actor != null) {
                //If the rover is found
                System.out.println("Enter a command: ");
                System.out.println("[1]Move");
                System.out.println("[2]Rotate");
                System.out.println("[3]Take Picture");
                System.out.println("[4]Transmit Picture");
                System.out.println("[5]Check Energy");
                System.out.println("[6]Charge Rover");
                System.out.println("[7]Kill");
                System.out.println("[8]Teleport");
                System.out.println("[9]Move to");
                System.out.println("[10]Quit");
                String command = input.readString();
                
                if (command.equals("move")) {
                    System.out.print("Enter distance to move: ");
                    int n = input.readInt();
                    actor.move(n);
                }
                else if (command.equals("rotate")) {
                    System.out.print("Enter distance to rotate: ");
                    int n = input.readInt();
                    actor.rotate(n);
                }
                else if (command.equals("take picture")) {
                    actor.takePic();
                }
                else if (command.equals("transmit picture")) {
                    actor.transmitPictures();
                }
                else if (command.equals("check energy")) {
                    actor.energyCheck();
                }
                else if (command.equals("charge rover")) {
                    actor.chargeRover();
                }
                else if (command.equals("kill")) {
                    System.out.print("Enter the name the target rover: ");
                    String targetName = input.readString();
                    
                    Rover target = group.find(targetName);
                    
                    if (target != null) {
                        actor.kill(target);
                        System.out.println(target);
                    }
                    else {
                        System.out.println("Error: No such target.");
                    }
                }
                else if (command.equals("teleport")) {
                    System.out.print("Enter x Coordinate: ");
                    int x = input.readInt();
                    System.out.print("Enter y Coordinate: ");
                    int y = input.readInt();
                    actor.teleport(x,y);
                }
                else if (command.equals("move to")) {
                    System.out.print("Enter x Coordinate: ");
                    int x = input.readInt();
                    System.out.print("Enter y Coordinate: ");
                    int y = input.readInt();
                    actor.moveTo(x,y);
                }
                else {
                    System.out.println("Error: Invalid command.");
                }
                
                System.out.println(actor);
            }
            else if (name.equals(exitCommand)) {
                running = false; // set flag to exit loop
            }
            else {
                System.out.println("Error: " + name + " doesn't exist.");
            }
            
            // just a blank line
            System.out.println();
        }
        
        System.out.println("Goodbye.");
    }
}
