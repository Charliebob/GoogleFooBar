package googleInterview;

public class ZombitInfection {
	public static int[][] answer(int[][] population, int x, int y, int strength) { 

        // Your code goes here.
		if(population.length==0 || population[0].length==0) return population;
		DFS(population, x, y, strength);
		return population;
    }
	public static void DFS(int[][] population, int x, int y, int strength){
		//careful with termination condition!!!  
		// if not add "population[x][y]==-1", will recursively call DFS line 16 and 17, leading to a stackoverflow!
		if(x<0 || x>=population.length || y<0 || y>=population[0].length || population[x][y]>strength || population[x][y]==-1) return;
		population[x][y] = -1;
		DFS(population, x-1, y, strength);
		DFS(population, x+1, y, strength);
		DFS(population, x, y-1, strength);
		DFS(population, x, y+1, strength);
	}
	public static void main(String[] args){
		int[][] rabbit = {{1,2,3},{2,3,4},{3,2,1}};
		rabbit  = answer(rabbit,0,0,2);
		for(int i=0; i<rabbit.length; i++){
			for(int j=0; j<rabbit[0].length; j++){
				System.out.print(rabbit[i][j]);
			}
		}
	}
}
