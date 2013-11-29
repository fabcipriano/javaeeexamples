package com.facio.modules;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Echo e = new Echo();
        System.out.println( "Calling a echo..." );
        
        System.out.println(e.say("Hi"));
        
        System.out.println( "Echo called" );
    }
}
