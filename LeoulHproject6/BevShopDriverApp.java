
/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: This App shows people if they can order certain drinks and shows the total. 
 * Due: 12/12/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Leoul Hailu Woldeyes
*/

package LeoulHproject6;



import java.util.Scanner;

/**
 * Main method to run BevShop
 */
public class BevShopDriverApp{

	public static void main(String[] args) 
	{
		String userName;
		DAY orderDay;
		int age;
		int menu;
		int time;
		int repeat = 0;
		
		Scanner choice = new Scanner(System.in);
		BevShop run = new BevShop();
		
		//Request and except order info
		System.out.println("\t *******  Welcome To The BevShop  *******"
							+ "\n To place an order Please input Time, Name and Age below"
							+ "\n Name: ");
		userName = choice.nextLine();
		
		System.out.println("Age: ");
		age = choice.nextInt();
		
		System.out.println("Time: ");
		time = choice.nextInt();
		
		System.out.println("\n Please choose a Number for the day\n"
							+ "1 --------- Monday\n"
							+ "2 --------- Tuesday\n"
							+ "3 --------- Wednesday\n"
							+ "4 --------- Thursday\n"
							+ "5 --------- Friday\n"
							+ "6 --------- Saturday\n"
							+ "7 --------- Sunday");
		menu = choice.nextInt();
		// set value to order day
		orderDay = day(menu);
		
		run.startNewOrder(time,orderDay,userName,age);
	
		// get choice of drinks based on age and choice from menu
		do 
		{
			
			// ordering for 21 year old or older
			if(run.isValidAge(age))
			{
				menu= 0;
			
				displayMenu();
				menu = choice.nextInt();
				while(menu > 10 || menu <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						menu = choice.nextInt();
					}
			
				if(menu <= 4)
				{
					if(run.isEligibleForMore())
					{
						int pick = 0;
						SIZE s;
			
						displaySize();
						pick = choice.nextInt();
					
						while(pick > 3 || pick <1)
						{
							System.out.println("!! Invalid Choice pick again !!");
							pick = choice.nextInt();
						}
					
						if(pick ==1)
							s= SIZE.SMALL;
						else if(pick ==2)
							s= SIZE.MEDIUM;
						else
							s= SIZE.LARGE;
					
						if(menu==1)
							run.processAlcoholOrder("Dry martini",s );
						else if(menu == 2)
							run.processAlcoholOrder("Lemon Drop",s );
						else if(menu == 3)
							run.processAlcoholOrder("Sangria",s);
						else
							run.processAlcoholOrder("Vodka Tonic",s);
					
					
						System.out.println("If you would like to add more drinks to your order please press 1\n"
											+ "or press any other key to finish order");
						repeat = choice.nextInt();
					
					}
					else
					{
						System.out.println("You have reached limit for Alcoholic drink\n"
											+ " Please Start new order");
						System.exit(time);
					}
	
				}
				else if(menu >= 5 &&  menu <=7)
				{
					int pick ;
					boolean protein;
					SIZE s;
					System.out.println("Would You like to Add Protein to your Smoothie\n"
										+ "1 -------yes\n"
										+ "2 -------No");
					pick = choice.nextInt();
				
					while(pick > 2 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

				
					if(pick == 1)
						protein = true;
					else
						protein = false;
				
					displaySize();
					pick = choice.nextInt();
				
					while(pick > 3 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

				
					if(pick ==1)
						s= SIZE.SMALL;
					else if(pick ==2)
						s= SIZE.MEDIUM;
					else
						s= SIZE.LARGE;
					
					switch(menu) 
					{
						case 5: run.processSmoothieOrder("Mango Pineapple Smoothie", s,2, protein);
								break;
				
						case 6: run.processSmoothieOrder("Strawberry Banana and Apple Smoothie", s,3, protein);
								break;
							
						case 7: run.processSmoothieOrder("Strawberry Smoothie", s, 1, protein);
								break;
					}
				
					System.out.println("If you would like to add more drinks to your order please press 1\n"
							+ "or press any other key to finish order");
					repeat = choice.nextInt();
				}
				else
				{
					int pick ;
					boolean shot;
					boolean syrup;
					SIZE s;
					System.out.println("Would You like to Add an Extra Shot to your Coffee\n"
										+ "1 -------yes\n"
										+ "2 -------No");
					pick = choice.nextInt();
				
					while(pick > 2 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

				
					if(pick == 1)
						shot = true;
					else
						shot = false;
				
					System.out.println("Would You like to Add Extra Syrup to your Coffee\n"
										+ "1 -------yes\n"
										+ "2 -------No");
					pick = choice.nextInt();
				
					while(pick > 2 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

	
					if(pick == 1)
						syrup = true;
					else
						syrup = false;
				
					displaySize();
					pick = choice.nextInt();
				
					while(pick > 3 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

				
					if(pick ==1)
						s= SIZE.SMALL;
					else if(pick ==2)
						s= SIZE.MEDIUM;
					else
						s= SIZE.LARGE;
				
					switch(menu)
					{
						case 8: run.processCoffeeOrder("Light Roast", s, shot, syrup);
								break;
				
						case 9: run.processCoffeeOrder("Medium Roast", s, shot, syrup);
								break;
						
						case 10: run.processCoffeeOrder("Dark Roast", s, shot, syrup);
								break;
				
					}
			
					System.out.println("If you would like to add more drinks to your order please press 1\n"
										+ "or press any other key to finish order");
					repeat = choice.nextInt();
				}
			}
			//ordering for 20 year old or younger
			else
			{
				menu= 0;
			
				displayMenu();
				menu = choice.nextInt();
				while(menu > 10 || menu <5)
				{
					System.out.println("!! Invalid Choice pick again !!");
					menu = choice.nextInt();
				}
			
				if(menu >= 5 &&  menu <=7)
				{
					int pick ;
					boolean protein;
					SIZE s;
					System.out.println("Would You like to Add Protein to your Smoothie\n"
									+ "1 -------yes\n"
									+ "2 -------No");
					pick = choice.nextInt();
				
					while(pick > 2 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

					if(pick == 1)
						protein = true;
					else
						protein = false;
				
					displaySize();
					pick = choice.nextInt();
				
					while(pick > 3 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

				
					if(pick ==1)
						s= SIZE.SMALL;
					else if(pick ==2)
						s= SIZE.MEDIUM;
					else
						s= SIZE.LARGE;
					
					switch(menu) 
					{
						case 5: run.processSmoothieOrder("Mango Pineapple Smoothie", s,2, protein);
								break;
				
						case 6: run.processSmoothieOrder("Strawberry Banana and Apple Smoothie", s,3, protein);
								break;
						
						case 7: run.processSmoothieOrder("Strawberry Smoothie", s, 1, protein);
								break;
					}
				
					System.out.println("If you would like to add more drinks to your order please press 1\n"
										+ "or press any other key to finish order");
					repeat = choice.nextInt();
				}
				else
				{
					int pick ;
					boolean shot;
					boolean syrup;
					SIZE s;
					System.out.println("Would You like to Add an Extra Shot to your Coffee\n"
										+ "1 -------yes\n"
										+ "2 -------No");
					pick = choice.nextInt();
				
					while(pick > 2 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

					if(pick == 1)
						shot = true;
					else
						shot = false;
				
					System.out.println("Would You like to Add Extra Syrup to your Coffee\n"
										+ "1 -------yes\n"
										+ "2 -------No");
					pick = choice.nextInt();
				
					while(pick > 2 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

					if(pick == 1)
						syrup = true;
					else
					syrup = false;
				
					displaySize();
					pick = choice.nextInt();
				
					while(pick > 3 || pick <1)
					{
						System.out.println("!! Invalid Choice pick again !!");
						pick = choice.nextInt();
					}

					if(pick ==1)
						s= SIZE.SMALL;
					else if(pick ==2)
						s= SIZE.MEDIUM;
					else
						s= SIZE.LARGE;
				
					switch(menu) 
					{
						case 8: run.processCoffeeOrder("Light Roast", s, shot, syrup);
								break;
				
						case 9: run.processCoffeeOrder("Medium Roast", s, shot, syrup);
								break;
						
						case 10: run.processCoffeeOrder("Dark Roast", s, shot, syrup);
								break;
					}
			
					System.out.println("If you would like to add more drinks to your order please press 1\n"
										+ "or press any other key to finish order");
					repeat = choice.nextInt();
				}
			}
		}while(repeat == 1);
		
		//display Order info
		System.out.println(run.getCurrentOrder().toString());		
	}
	
	//method to assign day 
	public static DAY day(int x)
	{
		Scanner test = new Scanner(System.in);
		DAY orderDay1;
		
		if(x == 1)
			return orderDay1 = DAY.MONDAY;
		else if(x == 2)
			return orderDay1 = DAY.TUESDAY;
		else if(x == 3)
			return orderDay1 = DAY.WEDNESDAY;
		else if(x == 4)
			return orderDay1 = DAY.THURSDAY;
		else if(x == 5)
			return orderDay1 = DAY.FRIDAY;
		else if(x == 6)
			return orderDay1 = DAY.SATURDAY;
		else if(x ==7)
			return orderDay1 = DAY.SUNDAY;
		else
		{
			System.out.println("You entered an invalid choice please enter again!!\n");
			
			System.out.println("\n Please choose a Number for the day\n"
					+ "1 --------- Monday\n"
					+ "2 --------- Tuesday\n"
					+ "3 --------- Wednesday\n"
					+ "4 --------- Thursday\n"
					+ "5 --------- Fridayday\n"
					+ "6 --------- Saturday\n"
					+ "7 --------- Sunday\n");
			x = test.nextInt();
					
			if(x == 1)
				return orderDay1 = DAY.MONDAY;
			else if(x == 2)
				return orderDay1 = DAY.TUESDAY;
			else if(x == 3)
				return orderDay1 = DAY.WEDNESDAY;
			else if(x == 4)
				return orderDay1 = DAY.THURSDAY;
			else if(x == 5)
				return orderDay1 = DAY.FRIDAY;
			else if(x == 6)
				return orderDay1 = DAY.SATURDAY;
			else if(x ==7)
				return orderDay1 = DAY.SUNDAY;
			else
			{
				System.out.println("You have entered an invalid input again!!\n"
									+ " Please restart your order");
				System.exit(x);
				return DAY.MONDAY;
			}
			
		}	
	}
	
	//method to display drink menu
	public static void displayMenu()
	{
		System.out.println("\nYou are not Old enough to order alcoholic drink \n"
				+ "Please choose non-alcoholic beverage\n"
				+ "\n\t*******  Alcoholic Drinks  *******\n"
				+ "1-------Dry martini\n"
				+ "2-------Lemon Drop\n"
				+ "3-------Sangria\n"
				+ "4-------Vodka Tonic"
				+ "\n\t*******  Smoothies  *******\n"
				+ "5-------Mango Pineapple Smoothie\n"
				+ "6-------Strawberry Banana and Apple Smoothie\n"
				+ "7-------Strawberry Smoothie "
				+ "\n\t*******  Coffee  *******\n"
				+ "8-------Light Roast\n"
				+ "9-------Medium Roast\n"
				+ "10-------Dark Roast\n"
				+ "Please Select a number from the Beverage menu");
	}
	
	//method to display size
	public static void displaySize()
	{
		System.out.println("\n Please Select Size\n"
				+ "1---------Small\n"
				+ "2---------medium\n"
				+ "3---------Large");
	}

}