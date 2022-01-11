import java.util.Scanner;
class PetWorld
{
	public static void main(String[]args)
	{
		//Declaration of variables
		Scanner in = new Scanner(System.in);
		String name;
		char ans;
		int kibble;
		boolean askAgain;
		
		//Program intro and instructions
		System.out.println("Welcome To Cyber Pet!\n=====================\n");
		System.out.println("--------------------------------------------------------");
		System.out.println("|>Your pet will start with 100 life points             |");
		System.out.println("|>Each day your pet will lose 33 life by default       |");
		System.out.println("|>One piece of kibble = one life point                 |");
		System.out.println("|>Don't let your pet's life get over 200 or it will die|");
		System.out.println("|>Don't let your pet's life get to 0 or it will die    |");
		System.out.println("|>Each day your pet has a 10% chance of getting sick   |");
		System.out.println("|>Keep your pet alive for 30 days for a special ending |");
		System.out.println("|>Have Fun!                                            |");
		System.out.println("--------------------------------------------------------\n");
		
		System.out.println("What would you like to name your pet?");
		name = in.next();
		
		CyberPet pet1 = new CyberPet(name);
		
		//Loop to make days go by until the pet dies
		do
		{
			System.out.println(pet1); //This will print the pet status
			//Method to pass a day
			pet1.dayGone();
			
			//Loop that will repeat if the user enters an invalid answer
			do
			{
				askAgain = false;
				//asking user if they would like to feed their pet
				System.out.println("Would you like to feed " + name + " today? (y/n)\n");
				ans = in.next().charAt(0);
				if(ans != 'y' && ans != 'n') //error checking user's answer
				{
					System.out.println("\nInvalid answer\n");
					askAgain = true;
				}
			}
			while(askAgain == true);
			
			if(ans == 'y')
			{
				System.out.println("How many pieces of kibble would you like to give " + name + "?");
				kibble = in.nextInt();
				pet1.feedPet(kibble);
			}
			
			//Method to chance the pet getting sick
			pet1.rollSickness();
		}
		while(pet1.getLife() > 0 && pet1.getLife() <= 200 && pet1.getDaysOld() < 30 && pet1.getPetSick() != true);
		
		//if statement to determine what the pet has died from
		if(pet1.getLife() <= 1)
			System.out.println("\n" + name + " has died of starvation :(");
		else if(pet1.getLife() >= 200)	
			System.out.println("\n" + name + " has died of being over fed :(");
		else if(pet1.getPetSick() == true)
			System.out.println("\n" + name + " has unfortunately died of sickness :(");
		else
			System.out.println("\n" + name + " has lived 30 days and has therefore become immortal.\nThank you for being a great pet owner :)");
	}
}
