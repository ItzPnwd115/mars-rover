
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
    private int dir; // 0=North, 0.5=NE, 1=East, 1.5=SE, 2=South, 2.5=SW, 3=West, 3.5=NW
    private int numPics;
    
    
    // constructor(s)
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
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
    
    public void killRover()
    {
        
    }
}
