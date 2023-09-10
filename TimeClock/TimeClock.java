/**
* @author Adam Zieman
* Date: October 21, 2021
* 
* Course: CSCI 241 (Computer Science 1)
* Assignment: 9
*
* Description:
* Creates a clock object holding hours:minutes:seconds
* Display 24/12-hour time format
* Compare two objects
* Add seconds to the clock, re-adjusting the time
*
* Known bugs:
* Cannot accurately compare objects
*/

public class TimeClock
{
    // instance variables
    // holds the TimeClock hour setting
    private int hours;
    // holds the TimeClock minute setting
    private int minutes;
    // holds the TimeClock second setting
    private int seconds;

    // default: setS instance variables to zero
    public TimeClock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    // alternative: sets instance variables to user defined
    // instance variables are evaluated to fit the 24-hour format
    public TimeClock(int hours, int minutes, int seconds) {
        // seconds cannot be negative
        if (seconds < 0)
            this.seconds = 0;
        // there cannot be 60 or greater seconds
        else if (seconds >= 60) {
            this.seconds = seconds % 60;
            minutes += seconds / 60;
            this.minutes = minutes;
        }
        else
            this.seconds = seconds;

        // minutes cannot be negative
        if (minutes < 0)
            this.minutes = 0;
        // minutes cannot be 60 or greater
        else if (minutes >= 60) {
            this.minutes = minutes % 60;
            hours += minutes / 60;
            this.hours = hours;
        }
        else
            this.minutes = minutes;

        // hours cannot be negative
        if (hours < 0)
            this.hours = 0;
        // hours cannot be 24 or greater
        else if (hours >= 24)
            this.hours = hours % 24;
        else
            this.hours = hours;
    }

    // getHours()
    public int getHours() {
        return hours;
    }

    // getMinutes()
    public int getMinutes() {
        return minutes;
    }

    // getSeconds()
    public int getSeconds() {
        return seconds;
    }

    // setHours(int)
    public void setHours(int hours) {
        // checks if hours are in range
        if (hours >= 0 && hours <= 23)
            this.hours = hours;
        // error message if hours are our of range
        else
            System.out.println("Usage Error: hours entry range 0 to 23");
    }

    // setMinutes(int)
    public void setMinutes(int minutes) {
        // checks if minutes are in range
        if (minutes >= 0 && minutes <= 59)
            this.minutes = minutes;
        // error message if minutes are out of range
        else
            System.out.println("Usage Error: minutes entry range 0 to 59");
    }

    // setSeconds(int)
    public void setSeconds(int seconds) {
        // checks if seconds are in range
        if (seconds >= 0 && seconds <= 59)
            this.seconds = seconds;
        // if seconds are greater than 60, seconds mod 60 is assigned as the value
        else if (seconds >= 60)
            this.seconds = seconds % 60;
        // error message if seconds are negative
        else
            System.out.println("Usage Error: seconds must be 0 or greater");
    }

    // toString
    public String toString() {
        // declare and initialize string variable
        String formatted = String.format("%02d%s%02d%s%02d", hours, ":", minutes, ":", seconds);

        // return string variable
        return formatted;
    }

    // toString12
    public String toString12() {
        // declare string variable
        String formatted;

        // initialize string variable
        if (hours < 12) // A.M.
            formatted = String.format("%02d%s%02d%s%02d%5s", hours, ":", minutes, ":", seconds, "A.M.");
        else { // P.M.
            // hours -= 12;
            formatted = String.format("%02d%s%02d%s%02d%5s", hours - 12, ":", minutes, ":", seconds, "P.M.");
        }

        // return string variable
        return formatted;
    }

    // equals(TimeClock)
    public boolean equals(TimeClock clockA, TimeClock clockB) {
        if (clockA == clockB) {
            return true;
        }
        else {
            return false;
        }
    }

    // addSeconds(int)
    public void addSeconds(int sec) {
        // checks if parameter is negative
        if (sec < 0) {
            System.out.println("Error: can't advance by negative seconds!");
            System.out.println("No change to clock time.");
        }
        else {
            // adjust parameter from seconds to hours:minutes:seconds format
            if (sec < 60)
                seconds += sec;
            else if (sec >= 60 && sec < 60 * 60) {
                seconds += sec % 60;
                minutes += sec / 60;
            }
            else {
                seconds += sec % 60;
                minutes += (sec / 60) % 60;
                hours += sec / (60 * 60);
            }
            
            // adjust seconds to be less than 60
            if (sec >= 60) {
                minutes += seconds / 60;
                seconds %= 60;
            }
            
            // adjust minutes to be less than 60
            if (minutes >= 60) {
                hours += minutes / 60;
                minutes %= 60;
            }
            
            // adjust hours to be less than 24
            if (hours >= 24)
                hours %= 24;
        }
    }
}
