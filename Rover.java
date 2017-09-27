
/**
 * Write a description of class Rover here.
 * 
 * @author Sean Donlin 
 * @version 9/21/17
 */
public class Rover
{
    // fields
    private String name;
    private int x;
    private int y;
    private int dir; // 0=North, 1=East, 2=South,3=West
    private int numPics;
    private boolean isAlive;
    
    
    // constructor(s)
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
        this.isAlive= false;
    }
    
    
    // methods - stuff the Rover can do
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void takePic()
    {
        if (dir == 0){
            System.out.println(name + " took a picture at [" + x +"," + y + "] facing North");
        }
        else if(dir == 1){
            System.out.println(name + " took a picture at [" + x +"," + y + "] facing East");
        }
        else if(dir == 2){
            System.out.println(name + " took a picture at [" + x +"," + y + "] facing South");
        }
        else{
            System.out.println(name + " took a picture at [" + x +"," + y + "] facing West");
        }
        this.numPics += 1;
    }
    
    public void transmitPictures()
    {
       if(numPics >= 1){
           System.out.println("Sending " + numPics + " pictures to NASA HQ ......");
           System.out.println("Recieved");
           this.numPics = 0;
        }
       else{
           System.out.println("No pictures to transmit.");
       }
    }
    
    public void move(int n)
    {
        if (dir == 0)
        {
            y += n;
        }
        else if (dir == 1)
        {
            x += n;
        }
        else if (dir == 2)
        {
            y -= n;
        }
        else 
        {
            x -= n;
        }
        
        if(n == 1)
        {
            System.out.println(name + " moved in direction " + dir + " by " + n + " unit.");
        }
        else{
            System.out.println(name + " moved in direction " + dir + " by " + n + " units.");
        }
    }
    
    public void teleport(int xz, int yz)
    {
        System.out.println("Teleporting from [" + this.x + "," + this.y + "] to [" + xz + "," + yz + "]");
        x = xz;
        y = yz;
        System.out.println("Arrived at (" + xz + "," + yz + ")");
    }
    
    public void rotateLeft() 
    {
        dir -= 1;
        
        if (dir < 0)
        {
            dir = 3;
        }
        
        System.out.println(name + " turned to the left");        
    }
    
    public void rotateRight()
    {
        dir += 1;
        
        if (dir == 4)
        {
            dir = 0;
        }
        
        System.out.println(name + " turned to the right");        
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + " Pictures: "+ numPics +"]";
    }
    
    public void killRover(Rover other)
    {
        System.out.println(this.name + " OOOF'ed " + other.name + ".");
        other.isAlive = false;
    }
}
