public class Game {
	
	public static String FileName = "AmiralBattiInfo.txt"; 
	/* Class Define */
	public static Menu gameoptions = new Menu();
	public static World worldgrid = new World();
	public static Equipment equipment = new Equipment();
	public static Ships ship = new Ships();
	public static Shot war = new Shot();
	public static User user = new User();
	public static Difficulty differ = new Difficulty();
	public static FileProcess fp = new FileProcess();
	/* Default Variable Define */
	public static String username = new String();
	public static int CounterClear = -1;
	
	public static void GameEnd(int win)
	{
		if(win == 0) //lose
		{
			System.out.println("*-* LOSE *-*\n");
			gameoptions.StartMenu(1);
		}
		else		//win
		{
			System.out.println("*+* WIN *+*\n");
			user.updateUser(user.getUsername(), differ.getTypeString(), user.getPlayed()+1);
			gameoptions.StartMenu(1);
		}
	}
	
	public static int GameWorldChecker()
	{
		int counter = 0;
		for (int i = 0; i < differ.getType(); i++) {
			for (int j = 0; j < differ.getType(); j++) {
				if(worldgrid.getPointWorld(i, j) >= 2)
					counter++;
			}
		}
		return counter;
	}
	
	public static void GameStart()
	{
		ship.setRandom();
		
		for (int i = 0; i < equipment.TotalEquipment(); i++) {
			if(equipment.TotalEquipment() == 0)
			{
				GameEnd(0);//0 - lose
				break;
			}
			else if(GameWorldChecker() == 0)
			{
				GameEnd(1);//1 - win
				break;
			}
			worldgrid.GridPrint(); //Haritayý yazdýr
			gameoptions.GunFunc();
		}
		
		
		//oyun baþlatma kodlarý
		
		//gamewin den sonra
		/*
		setUserPlayed(username, 0); // oyun kazandý 1 artýr
		
		if(differ.getType() == 1 && getUserPlayed(username) >= 2) // easy && totalplaywin 2 
		{
			setUserPlayed(username,-1);
			differ.setType(1);//normal
		}
		else if(differ.getType() == 2 && getUserPlayed(username) >= 3) // easy && totalplaywin 3
		{
			setUserPlayed(username,-1);
			differ.setType(2);//hard
		}
		
		*/
	}
	
	public static void main(String[] args) {
		gameoptions.Started();
	}

}
