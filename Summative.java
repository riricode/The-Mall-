//Summative
//Riana Haq and Warisha Noushad
//June 5th 2022
//ICS3U1-1C

import java.awt.*;
import hsa.Console;

public class TheMall
{
    static Console c;
    static char option, paymentMethod;
    static double budget, cost, total, remaining, change, payed, left;
    static int amount, flavour, scoops, choice, item, slices;

    public static void main (String[] args)
    {
	c = new Console ();
	char choice;
	do
	{
	    c.println ("The Mall");
	    c.println ("--------------");
	    c.println ("1. Arctic Cream  ");
	    c.println ("2. Delicate Desserts ");
	    c.println ("3. Cineplex ");
	    c.println ("0. Quit");
	    c.println ();
	    c.println ("Hey there! How you doing? Wanna solve a fun prime problem? Let's get started!   Type 1 from the menu above and click <Enter> for a fun experience or 0 to quit.");
	    choice = c.readChar ();
	    c.clear (); // clears the screen



	    if (choice == '1')
		ArcticCream ();
	    else if (choice == '2')
		DelicateDesserts ();
	    //else if (choice == '3')
	    //Cineplex ();
	    else if (choice == '0')
	    {
		c.println ("Well that was fun wasn't it? Hope you had a great time in the mall.");
		c.println ("Thank you! Come again :)");
	    }

	}


	while (choice != '0'); // exit when 0
    } // main method


    public static void Budget ()
    {
	c.println ("What is the budget for today?");
	budget = c.readDouble ();
    }


    public static void HowManyPeople ()
    {

	c.println ("For how many people would you like to order?");
	amount = c.readInt ();
	c.clear ();
    }


    public static void remaining () //PROBLEM HERE we want to repeat this code for the 3 programs, so we used if else statements for the different food options to be renewed but it doesn't work. We don't want to make 3 different methods for each program since it will be too big and disorganized.
    {
	remaining = budget - total;
	if (remaining >= 0)
	{
	    c.println ("Proceed to checkout!");
	    checkout ();
	}
	else if (remaining < 0)
	{
	    while (remaining < 0)
	    {
		c.clear ();
		c.println ("You are above your budget. Please consider your options.");
		total = 0.00;

		if (choice == '1')
		{
		    menuAC ();
		    checkout ();
		}
		else if (choice == '2')
		{
		    menuDD ();
		    checkout ();
		}

	    }
	}
    }


    public static void Size ()
    {
	char size;
	c.println ("small, medium or large? (Press: s = small, m = medium, l = large)");
	size = c.readChar ();
	if (size == 's')
	{
	    cost = cost + 0.15;
	}
	else if (size == 'm')
	{
	    cost = cost + 0.35;
	}
	else if (size == 'l')
	{
	    cost = cost + 0.75;
	}
    }


    public static void Toppings ()
    {
	int toppers;
	c.println ("Please enter the amount for the topping you would like (for no toppings type '0'");
	toppers = c.readInt ();

	if (toppers == 1)
	{
	    cost = cost + 0.50;
	}
	else if (toppers == 2)
	{
	    cost = cost + 0.70;
	}
	else if (toppers == 3)
	{
	    cost = cost + 0.90;
	}
	else if (toppers == 4)
	{
	    cost = cost + 1.10;
	}
	else if (toppers == 5)
	{
	    cost = cost + 1.20;
	}
	else if (toppers == 6)
	{
	    cost = cost + 1.30;
	}
	else if (toppers == 0)
	{
	    cost = cost;
	}
    }


    public static void menuAC ()
    {
	c.println ("**********************************************************************");
	c.println ("     # Flavours .........................................  Prices");
	c.println ("     01. Vanilla ........................................  $1.75");
	c.println ("     02. Chocolate ........................................  $1.99");
	c.println ("     03. Mixed Swirl ......................................  $2.30");
	c.println ("     04. Strawberry .......................................  $2.75");
	c.println ("     05. Blueberry ........................................  $3.15");
	c.println ("=======================================================================");
	c.println ("     #  Toppings .........................................  Prices");
	c.println ("     1. Sprinkles .....................................  $0.50");
	c.println ("     2. Blueberries ......................................  $0.70");
	c.println ("     3. Chocolate Chips ..................................  $0.90");
	c.println ("     4. Chocolate Syrup ..................................  $1.10");
	c.println ("     5. Maple Syrup ......................................  $1.20");
	c.println ("     6. Caramel ..........................................  $1.30");
	c.println ("**********************************************************************");

	c.println ("\nPlease enter the amount for the flavour you would like to buy ");
	total = 0.00;

	for (int loop = 1 ; loop <= amount ; loop = loop + 1)
	{
	    c.print ("Choice # " + loop + ": ");
	    flavour = c.readInt ();

	    if (flavour == 1) //option 1: Vanilla
	    {
		cost = 1.75;
		Size ();
		Toppings ();

	    }
	    else if (flavour == 2) //option 3: Chocolate
	    {

		cost = 1.99;
		Size ();
		Toppings ();
	    }
	    else if (flavour == 3) //option 3: Mixed Swirl
	    {

		cost = 2.30;
		Size ();
		Toppings ();
	    }
	    else if (flavour == 4) //option 4: Strawberry
	    {

		cost = 2.75;
		Size ();
		Toppings ();
	    }
	    else if (flavour == 5) //option 5: Blueberry
	    {
		cost = 2.75;

		Size ();
		Toppings ();
	    }
	    else if (flavour == 0)
	    {
		cost = 0.00;
		/*c.clear ();
		c.println ("See you later, have a good day!"); //goodbye message*/
	    }
	    total = cost + total + (cost * 0.13);
	}
	c.clear ();
	c.print ("HST (13%) : $");
	c.println (total, 0, 2);

	remaining ();

    }


    public static void checkout () //PROBLEM HERE we want to repeat this code for the 3 programs, so we used if else statements for the different food options to be renewed but it doesn't work. We don't want to make 3 different methods for each program since it will be too big and disorganized.
    {
    {

	c.println ();
	c.println ("How would you like to pay?");
	c.println (" 1. Cash");
	c.println (" 2. Card");
	paymentMethod = c.getChar ();

	if (paymentMethod == '1')
	{
	    c.println ("How much would you like to pay? ");
	    payed = c.readDouble ();
	    change = payed - total;

	    if (payed < total || payed == 0)
	    {
		left = total - payed;
		c.print ("Sorry, that is not enough money to pay for your order. You need $");
		c.print (left, 0, 2);
		c.println (" more.    Press '1' if you would like to order again or 'x' if you'd like to proceed to the exit");
		choice = c.readChar ();
		if (option == '1')
		{
		    c.clear ();
		    total = 0;
		    if (choice == '1')
		    {
			menuAC ();
		    }
		    else if (choice == '2')
		    {
			menuDD ();
		    }
		    checkout ();
		}
		else if (option == 'x')
		{
		    c.println ("Thank you for coming. Have a wonderful day! Press any key to return to the menu.");
		    c.getChar ();
		    c.clear ();
		}
	    }
	    else
		change ();
	}
	else if (paymentMethod == '2')
	{
	    c.println ("Please insert your card by clicking any key");
	    c.getChar ();
	    payed = total;
	    change ();

	}
    }

ALL THIS IS COMMENTED OUT 
    /*public static void optionForAC ()
    {
	checkout ();
	if (option == '1')
	{

	    c.clear ();
	    total = 0;
	    menuAC ();
	    checkout ();
	}
	checkout2 ();
    }


    public static void optionForDD ()
    {
	checkout ();
	if (option == '1')
	{

	    c.clear ();
	    total = 0;
	    menuDD ();
	    checkout ();
	}
	checkout2 ();
    }


    public static void checkout2 ()
    {
	if (paymentMethod == '1')
	{
	    if (option == '1')
	    {

	    }
	    else if (option == 'x')
	    {
		c.println ("Thank you for coming have a wonderful day. Please press any key to return to the menu");
		c.getChar (); // any key returns to the menu.
		c.clear (); // fresh screen for method
	    }



	    else
	    {

		change ();
	    }
	}
	else if (paymentMethod == '2')
	{
	    c.println ("Please insert your card by clicking any key");
	    c.getChar ();
	    payed = total;
	    change ();

	}
    }

    */ ALL THIS IS COMMENTED OUT 

    public static void change ()
    {
	c.print ("Here is your change: $");
	c.println (change, 0, 2);
	c.println ("Have a chilly day!");
    }


    public static void ArcticCream ()
    {
	c.println ("Welcome to Arctic Cream!!");
	c.println ("\nWe have many flavours for you to enjoy!");
	c.println ("Press enter to proceed");
	c.getChar ();
	Budget ();
	HowManyPeople ();
	c.println ("Press enter to see all the delicious options!!");
	c.getChar ();
	c.clear ();
	menuAC ();
	
    }


    public static void menuDD ()
    {
	c.println ("=================================================================");
	c.println ("#  Desserts...............................Prices");
	c.println ("1. Vanilla Cheesecake.....................$4.99");
	c.println ("2. Caramel pastries.......................$3.69");
	c.println ("3. Sweet Apple Pie........................$2.64");
	c.println ("4. Banana pudding.........................$4.75");
	c.println ("5.Chocolate Cheesecake.........................$4.99");

	c.println ();

	for (int i = 1 ; i <= amount ; i = i + 1)
	{
	    c.print ("Choice # " + i + ": ");
	    item = c.readInt ();
	    c.print ("\n");
	    c.println ("How many slices?");
	    slices = c.readInt ();

	    if (item == 1)
	    {
		cost = 4.99 * slices;
	    }
	    else if (item == 2)
	    {
		cost = 3.69 * slices;
	    }
	    else if (item == 3)
	    {
		cost = 2.64 * slices;
	    }
	    else if (item == 4)
	    {
		cost = 4.75 * slices;
	    }
	    if (item == 5)
	    {
		cost = 4.99 * slices;
	    }
	    else if (item == 0)
	    {
		cost = 0;
	    }
	    total = cost + total + (cost * 0.13);
	}

	c.print ("\nHST (13%) : $");
	c.println (total, 0, 2);

	remaining ();
    }


    public static void DelicateDesserts ()
    {
	c.println ("Welcome to Delicate Desserts!");
	c.println ("\nWe have many desserts to sweeten your day! Press enter to proceed");
	c.getChar ();
	Budget ();
	HowManyPeople ();
	c.println ("Press enter to see all the sugar sweet options.");
	c.getChar ();
	c.clear ();
	c.println ("What would you like to order today? Currently we have some fresh: ");
	menuDD ();
	
    }




} // The Mall Class




