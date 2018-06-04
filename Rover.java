/**
 * Gives Function for use of Rover Runner class.
 * 
 * @author Sean Donlin 
 * @version 10/22/17
 */
public class Rover
{
    // fields
    private String name;
    private int x;//x coordinate
    private int y;//y coordinate
    private int z;//z = hight coordinate
    private int dir; // 0=North, 1=North-East, 2=East, 3=South-East, 4=South, 5=South-West, 6=West, 7=South-West
    private int numPics;
    private boolean isAlive;
    private boolean isFlying;
    private int energy;
        
    public static final int MAX_CHARGE = 100;
    public static final int LOW_BATTERY = 0;
    public static final int EMPTY_MEMORY = 0;
    public static final int MEMORY = 5;
    public static final int SET_NAME_ENERGY = 1;
    public static final int TAKE_PICTURE_ENERGY = 8;
    public static final int TAKE_PICTURE = 1;
    public static final int TRANSMIT_PIC_ENERGY = 5;
    public static final int NO_TRANSMIT_PIC_ENERGY = 1;
    public static final int MOVE_ENERGY = 2;
    public static final int ROTATE_ENERGY = 2;
    public static final int TELEPORT_ENERGY = 25;
    
    // constructor(s)
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.dir = 0;
        this.numPics = 0;
        this.isAlive= true;
        this.isFlying = false;
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
     * Contols if rover is flying or not.
     * */
     private void flight()
    {
        isFlying = true;
        
    }
   
    /**
     * Changes all direction numbers to directions
     * @return Directions instead of numbers.
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
        this.energy -= SET_NAME_ENERGY;
    }
       
    /**
     * Lets the Rover take a picture
     */
    public void takePic()
    {
        if (numPics < MEMORY){
            System.out.println(name + " took a picture at [" + x +"," + y + "] facing " + getDirectionName() + ".");
            this.numPics += TAKE_PICTURE;
            this.energy -= TAKE_PICTURE_ENERGY;
        }
        else{
            System.out.println("Memory full, needs to back up to NASA before taking more!");
        }
    }   
    
    /**
     * Transmit pictures to NASA to clear memory and be analyzed
     */
    public void transmitPictures()
    {
       if(numPics > 0){
           System.out.println("Sending " + numPics + " pictures to NASA HQ ......");
           System.out.println("Recieved");
           this.numPics = EMPTY_MEMORY;
           this.energy -= TRANSMIT_PIC_ENERGY;
        }
       else{
           System.out.println("No pictures to transmit.");
           this.energy -= NO_TRANSMIT_PIC_ENERGY;
       }
    }
    
    public void checkMemory()
    {
        System.out.println("Pictures: " + numPics + " of " + MEMORY);
    }
    
    /**
     * Returns the energy of the Rover
     */
    public void checkEnergy()
    {
       System.out.println("Energy: " + energy);
    }
    
    /**
     * Charges the Rover so it can function again
     */
    public void chargeRover(int n)
    {
        System.out.println("Rover beginning to Charge!");
        this.energy = Math.min(this.energy + n, MAX_CHARGE);
        System.out.println("CHARGED!");
    }
    
    public void fly()
    {
        if(this.z == 0)
        {
            z = 1;
        }
        flight();
    }
    
    public void changeElevation(int z)
    {
        int h = Math.abs(this.z-z);
        this.z += h;        
    }
    
    /**
     * Allows the Rover to move
     * @param n How many units it moves in said direction.
     */
    public void move(int n)
    {
        if (this.energy >= MOVE_ENERGY) {
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
            this.energy -= (MOVE_ENERGY * n);
            if(n == 1)
            {
                System.out.println(name + " moved " + getDirectionName() + " by " + n + " unit.");
            }
            else{
                System.out.println(name + " moved " + getDirectionName() + " by " + n + " units.");
            }
        }
        else{
            System.out.println("Your rover is at low battery, you need to charge your rover before making another move.");
        }
    }
    
    /**
     * Calls rotateLeft() or rotateRight() depending on if the int is positive or negative
     * @param n = How many units left or right the rover will turn
     */
    public void rotate(int n)
    {
        if(this.energy > ROTATE_ENERGY){
            if(n < 0){
                rotateLeft(n);
            }
            else if(n > 0){
                rotateRight(n);
            }
            else{
                System.out.println("You can not rotate 0 Units.");
            }
        }
        else{
            System.out.println("Your rover is at low battery, you need to charge your rover before you can rotate.");
        }
    }
    
    /**
     * Rotates the Rover Left by n units
     * @param nTakes the n int from the function rotate() and uses it in the function
     */
    private void rotateLeft(int n) 
    {
        dir += n;
        
        if (dir < 0)
        {
            dir = 8 + n;
        }
        this.energy -= ROTATE_ENERGY;
        System.out.println(name + " turned to the left");        
    }
    
    /**
     * Rotates the Rover right by n units
     * @param n Takes the n int from the function rotate() and uses it in the function
     */
    private void rotateRight(int n)
    {
        dir += n;
        
        if (dir > 7)
        {
            dir = (7 + n) % 8;
        }
        this.energy -= ROTATE_ENERGY;
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
     * @param x x-coordinate rover is being sent to
     * @param y y-coordinate rover is being sent to
     */
    public void teleport(int x, int y)
    {
        if(this.energy > TELEPORT_ENERGY){
            System.out.println("Teleporting from [" + this.x + "," + this.y + "] to [" + x + "," + y + "]");
            this.x = x;
            this.y = y;        
            System.out.println("Arrived at (" + x + "," + y + ")");
            this.energy -= TELEPORT_ENERGY;
        }
        else{
            System.out.println("Your rover is at low battery, you need to charge if you want to teleport.");
        }
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
    /**
     * @return Name of Rover
     */
    public String getName() {
        return name;
    }
    
    // Prints information about Rover
    /**
     * @return  Name, X & Y Coordinates, Direction, and if its alive
     */
    public String toString() {
        return "Rover[name=" + name + ", " +
               "x=" + x + ", " +
               "y=" + y + ", " + 
               "z=" + z + ", " +
               "dir=" + getDirectionName() + ", " + 
               "isAlive=" + isAlive + "]";
    }
}
