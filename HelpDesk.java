
/**
 * Welcome to the help desk this class is designed to give a basic understanding of how
 * flying and the rovers work.
 *
 * @author Sean Donlin
 * @version 6/4/2018
 */
public class HelpDesk
{
    public static void subMain(String[] agr0)
    {
        SimpleScanner input = new SimpleScanner();
        
        //Help sections
        Help h1 = new Help("Rover Guide");
        Help h2 = new Help("Flight Guide");
        Help h3 = new Help("Functions Guide");
        
        //Makes a central group
        HelpGroup group = new HelpGroup();
        group.add(h1);
        group.add(h2);
        group.add(h3);
        
        //Enter and Exit my guy
        boolean running = true;
        String exitCommand = "quit";
        
        while(running)
        {
          System.out.println("What do you need help with?");
          
          System.out.println(h1);
          System.out.println(h2);
          System.out.println(h3);
          String name = input.readString();
          
          Help needed = group.find(name);
          if(needed != null)
          {
                
          }
          else if (name.equals(exitCommand)) {
                running = false; // set flag to exit loop
          }
          else {
              System.out.println("Error: " + needed + " doesn't exist.");
          }
            
          // just a blank line
          System.out.println();  
        }
    }
}
