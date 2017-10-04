
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
    private int energy;
    
    
    // constructor(s)
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
        this.isAlive= true;
        this.energy = 100;
    }
    
        private void oof() {
        isAlive = false;
        System.out.println(name + " goes 'OOOOF!' and dies.");
    }
    // methods - stuff the Rover can do
    public void setName(String name)
    {
        this.name = name;
        this.energy -= 1;
    }
    
    public void takePic()
    {
        this.numPics += 1;
        if (numPics >= 5){
            this.numPics -= 1;
            System.out.println("Memory full, needs to back up to NASA before taking more!");
        }
        else{
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
        }
        this.energy -= 8;
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
       this.energy -= 5;
    }
    
    public void energyCheck()
    {
       System.out.println("Energy: " + energy);
    }
    
    public void chargeRover()
    {
        System.out.println("Rover beginning to Charge!");
        this.energy = 100;
        System.out.println("CHARGED!");
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
        this.energy -= (2*n);
        if(n == 1)
        {
            System.out.println(name + " moved in direction " + dir + " by " + n + " unit.");
        }
        else{
            System.out.println(name + " moved in direction " + dir + " by " + n + " units.");
        }
    }
    
    public void rotateLeft(int n) 
    {
        dir -= n;
        
        if (dir < 0)
        {
            dir = Math.abs(n % 4);
        }
        this.energy -= 2*n;
        System.out.println(name + " turned to the left");        
    }
    
    public void rotateRight(int n)
    {
        dir += n;
        
        if (dir >= 4)
        {
            dir = n % 4;
        }
        this.energy -= 2*n;
        System.out.println(name + " turned to the right");        
    }
    
    public void moveTo(int x, int y)
    {
        System.out.println(name + "Moving to: " + x + y);
        move(x);
        if(x < 0 && y < 0){
            rotateLeft(1);
        }
        else if(x > 0 && y > 0){
            rotateLeft(1);
        }
        else if(x > 0 && y < 0){
            rotateRight(1);
        }
        else if (x < 0 && y > 0){
            rotateRight(1);
        }
        else{
            System.out.println("OOOOOFFFFFFFF!!!");
        }
        move(y);
        System.out.println("Arrived at (" + x + "," + y + ")");
    }
    
    public void goHome()
    {
        
    }
    
    public void teleport(int x, int y)
    {
        System.out.println("Teleporting from [" + this.x + "," + this.y + "] to [" + x + "," + y + "]");
        this.x = x;
        this.y = y;        
        System.out.println("Arrived at (" + x + "," + y + ")");
        this.energy -= 25;
    }
        
    public void kill(Rover other)
    {
        System.out.println(this.name + " kills " + other.name + " with a bagette.");
        other.oof();
    }
    
        // accessor methods - just for looking, state doesn't change
    public String getName() {
        return name;
    }
    
    public String toString() {
        return "Rover[name=" + name + ", " +
               "x=" + x + ", " +
               "y=" + y + ", " + 
               "dir=" + dir + ", " + 
               "isAlive=" + isAlive + "]";
    }
}
