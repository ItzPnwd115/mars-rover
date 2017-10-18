/**
 * Write a description of class Rover here.
 * 
 * @author Sean Donlin 
 * @version 10/6/17
 */
public class Rover
{
    // fields
    private String name;
    private int x;
    private int y;
    private int dir; // 0=North, 1=North-East, 2=East, 3=South-East, 4=South, 5=South-West, 6=West, 7=South-West
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
    
    // methods - stuff the Rover can do
    
    /**
     * Kills the Rover so it can't be used
     */
        private void oof() {
        isAlive = false;
        System.out.println(name + " goes 'OOOOF!' and dies.");
    }
    
    /**
     * Changes all direction numbers to directions
     */
    private String getDirectionName(){
        if (dir == 0){
            return "North";        
        }
        else if(dir == 1){
            return "North-East";
        }
        else if(dir == 2){
            return "East";
        }
        else if(dir == 3){
            return "South-East";
        }
        else if(dir == 4){
            return "South";
        }
        else if(dir == 5){
            return "South-West";
        }
        else if(dir == 6){
            return "West";
        }
        else if(dir == 7){
            return "North-West";
        }
        else{
            return null;
        }
    }
    
    /**
     * Sets the name of the Rover
     */
    public void setName(String name)
    {
        this.name = name;
        this.energy -= 1;
    }
    
    /**
     * Lets the Rover take a picture
     */
    public void takePic()
    {
        this.numPics += 1;
        if (numPics >= 5){
            this.numPics -= 1;
            System.out.println("Memory full, needs to back up to NASA before taking more!");
        }
        else{
            System.out.println(name + " took a picture at [" + x +"," + y + "] facing" + getDirectionName() + ".");
        }
        this.energy -= 8;
        }   
    
    /**
     * Transmit pictures to NASA to clear memory and be analyzed
     */
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
    
    /**
     * Returns the energy of the Rover
     */
    public void energyCheck()
    {
       System.out.println("Energy: " + energy);
    }
    
    /**
     * Charges the Rover so it can function again
     */
    public void chargeRover()
    {
        System.out.println("Rover beginning to Charge!");
        this.energy = 100;
        System.out.println("CHARGED!");
    }
    
    /**
     * Allows the Rover to move
     */
    public void move(int n)
    {
        if (dir == 0)
        {
            y += n;
        }
        else if (dir == 1)
        {
            y += n;
            x += n;
        }
        else if (dir == 2)
        {
            x += n;
        }
        else if (dir == 3)
        {
            y -= n;
            y += n;
        }
        else if (dir == 4)
        {
            y -= n;
        }
        else if (dir == 5)
        {
            y -= n;
            x -= n;
        }
        else if(dir == 6){
            x -= n;
        }
        else if (dir == 7)
        {
            y += n;            
            x -= n;
        }
        this.energy -= (2*n);
        if(n == 1)
        {
            System.out.println(name + " moved " + getDirectionName() + " by " + n + " unit.");
        }
        else{
            System.out.println(name + " moved " + getDirectionName() + " by " + n + " units.");
        }
    }
    
    public void rotate(int l)
    {
        if(l < 0){
            rotateLeft(l);
        }
        else if(l > 0){
            rotateRight(l);
        }
        else{
            System.out.println("You cant rotate 0 Units RETARD!!");
        }
    }
    
    /**
     * Rotates the Rover Left by n units
     */
    private void rotateLeft(int n) 
    {
        dir += n;
        
        if (dir < 0)
        {
            dir = 8 + n;
        }
        this.energy -= 2;
        System.out.println(name + " turned to the left");        
    }
    
    /**
     * Rotates the Rover right by n units
     */
    private void rotateRight(int n)
    {
        dir += n;
        
        if (dir > 7)
        {
            dir = (7 + n) % 8;
        }
        this.energy -= 2;
        System.out.println(name + " turned to the right");        
    }
    
    /**
     * Moves the Rover to a certain set of coodinates
     */
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
    
    /**
     * Teleports Rover to a certain set of coordinates
     */
    public void teleport(int x, int y)
    {
        System.out.println("Teleporting from [" + this.x + "," + this.y + "] to [" + x + "," + y + "]");
        this.x = x;
        this.y = y;        
        System.out.println("Arrived at (" + x + "," + y + ")");
        this.energy -= 25;
    }
    
    /**
     * One Rover kills another Rover then calls oof method
     */
    public void kill(Rover other)
    {
        System.out.println(this.name + " kills " + other.name + " with a bagette.");
        other.oof();
    }
    
    // accessor methods - just for looking, state doesn't change
    public String getName() {
        return name;
    }
    
    // Prints information about Rover
    public String toString() {
        return "Rover[name=" + name + ", " +
               "x=" + x + ", " +
               "y=" + y + ", " + 
               "dir=" + getDirectionName() + ", " + 
               "isAlive=" + isAlive + "]";
    }
}
