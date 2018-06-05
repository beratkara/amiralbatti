import java.util.Arrays;

public class World {
	
	private int[][] world;

	public int[][] getWorld() {
		return world;
	}

	public void setWorld(int[][] world) {
		this.world = world;
		
		for (int[] row : this.world)
            Arrays.fill(row, 0);
	}
	
	public void setPointWorld(int x, int y, int value) {
		this.world[x][y] = value;
	}
	
	public int getPointWorld(int x, int y) {
		return this.world[x][y];
	}
	
	public void GridPrint()
	{
		System.out.print("\t");
		for(int i = 0; i < getWorld().length; i++)
		{
			System.out.print(i + "\t");
		}
		
		System.out.println();
		
		for(int i = 0; i < getWorld().length; i++)
		{
			System.out.print(i + "\t");
			for (int j = 0; j < getWorld()[0].length; j++) {
				if(this.world[i][j] >= 2) 		// ships
					System.out.print("S\t");
				else if(this.world[i][j] == 1)  // shot
					System.out.print("x\t");
				else if(this.world[i][j] == 0)  // free
					System.out.print(".\t");
				else							// missed shot
					System.out.print("-\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
