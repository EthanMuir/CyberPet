class CyberPet
{
	//variable declaration
	private String name;
	private int daysOld;
	private int life;
	private int kibble;
	private int sickness; 
	private boolean petSick = false;
	
	//constructor method to set the name and default the life points to 100
	CyberPet(String name)
	{
		this.name = name;
		this.life = 100;
	}
	
	//accessor method to get life
	public int getLife()
	{
		return life;
	} 
	
	//accessor method to get kibble
	public int getKibble()
	{
		return kibble;
	}
	
	//accessor method to get days old
	public int getDaysOld()
	{
		return daysOld;
	}
	
	//accessor method to get if the pet is sick or not
	public boolean getPetSick()
	{
		return petSick;
	}
	
	//mutator method to allow user to change their pet name
	public void setName(String name)
	{
		this.name = name;
	}
	
	//mutator method to change how much kibble the user would like to give their pet
	public void setKibble(int kibble)
	{
		if(kibble >= 0)
			this.kibble = kibble;
		else
			this.kibble = 0;
	}
	
	//method to chance the pet to get sick
	public void rollSickness()
	{
		sickness = (int)(Math.random()*10 + 1);
		
		if(sickness == 5) //if the random number come out to a five, the pet will get sick
			petSick = true;
		else
			petSick = false;
	}
	
	//method to pass a day
	public void dayGone()
	{
		daysOld += 1;
		life -= 33;
		if(life < 0)
			life = 0;
	}
	
	//method to feed the pet a givrn amount
	public void feedPet(int kibble)
	{
		life += kibble;
	}
	
	//toString method to print the pet status
	public String toString()
	{
		return "\nPET STATUS: \n-----------\n" + this.name + " is " + this.daysOld + " days old\nHe has " + this.life + " life left\n";
	}
}
