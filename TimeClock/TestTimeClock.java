/**
 * TestTimeClock
 * This class tests the methods of the TimeClock class
 * 
 * @author Erica Eddy
 * @version November 2021
 */
public class TestTimeClock
{
    public static void main (String [] args)
    {
        // make a clock with midnight
        System.out.println("Setting a clock with midnight");
        
        // test default constructor
        TimeClock clock1 = new TimeClock();
        System.out.println("clock1 has time: " + clock1.toString());        
        System.out.println();
        
        // change clock1 to later in the day, one part at a time
        clock1.setHours(6);
        clock1.setMinutes(25);
        clock1.setSeconds(45);
        
        // retrieve clock1 values, one at a time
        System.out.println("clock1 values reset to 06:25:45");
        System.out.println("new hour: " + clock1.getHours());
        System.out.println("new minute: " + clock1.getMinutes());
        System.out.println("new second: " + clock1.getSeconds());
        System.out.println("clock1 time using 12-hour clock: "
                    + clock1.toString12());        
        System.out.println();
        
        // make a new clock, with different time values
        TimeClock clock2 = new TimeClock(14,59,16);
        System.out.println("clock2 has time: " + clock2.toString());
        System.out.println("clock2 time using 12-hour clock: "
                    + clock2.toString12());
        System.out.println();
        
        // see if clock1 and clock2 are holding the same time
        printEquals(clock1,clock2);
            
        // Add negative seconds to clock1
        System.out.println("Adding -29 seconds to clock1");
        clock1.addSeconds(-29);
        System.out.println("Clock1 still reads: " + clock1);
        System.out.println();
        
        // add time to clock1
        System.out.println("Adding 31171 seconds to clock1");
        clock1.addSeconds(31171);
        System.out.println("Now clock1 reads: " + clock1);
        
        // see if clock1 and clock2 are holding the same time
        printEquals(clock1,clock2);
        
        // adding 360 seconds to clock2
        System.out.println("Adding 360 seconds to clock2");
        clock2.addSeconds(360);
        System.out.println("Now clock2 reads: " + clock2);
        
        // see if clock1 and clock2 are holding the same time       
        printEquals(clock1,clock2);

    }
    
    // print appropriate message depending on whether the clocks hold
    // the same time values
    public static void printEquals(TimeClock clockA, TimeClock clockB)
    {
        if (clockA.equals(clockB))
            System.out.println("The two clocks read the same.");
        else
            System.out.println("The two clocks hold different times.");
        System.out.println();
    }
    
}