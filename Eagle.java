public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

        /**
     * takeOff, must be on ground
     */
    @Override
    public void takeOff() {
        if (!this.isFlying() && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takesoff in the air.%n", this.getName());
        }
    }    
    
    /**
    * fly upward
    * @param meters altitude increase
    * @return altitude
    */
   @Override
   public int ascend(int meters) {
       if (this.flying) {
           this.altitude = Math.min(this.altitude + meters, 500);
           System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
       }
       return this.altitude;
   }

    /**
    * glide, must be in the air
    */
    @Override
    public void glide() {
        if (this.isFlying() && this.altitude > 0) {
            System.out.printf("glides into the air.");
        }
    }    
    
    /**
    * fly downward
    * @param meters altitude decrease
    * @return altitude
    */
   @Override
   public int descend(int meters) {
       if (this.flying) {
           this.altitude = Math.max(this.altitude - meters, 0);
           System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
       }
       return this.altitude;
   }

    /**
     * land on the ground, must be on ground
     */
    @Override
    public void land() {
        if (this.flying && this.altitude <= 1) {
            System.out.printf("%s land on the ground.%n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't land.%n", this.getName());
        }
    }
}
