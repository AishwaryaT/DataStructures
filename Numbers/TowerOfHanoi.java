package Numbers;

public class TowerOfHanoi {
	public static void main(String args[]){
		TowerOfHanoi t = new TowerOfHanoi();
		t.TowerOfHanoi(4, 'A', 'B', 'C');
	}

	void TowerOfHanoi(int n, char from, char to, char auxi){
		if(n==1){
			System.out.println("Move disk 1 from peg "+from+ " to peg "+to);
			return;
		}
		
		TowerOfHanoi(n-1,from,auxi,to);
		System.out.println("Move disk from peg "+from+ " to peg "+to);
		TowerOfHanoi(n-1,auxi,to,from);
	}
}
