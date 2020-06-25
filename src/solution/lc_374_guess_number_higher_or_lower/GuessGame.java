package solution.oj_374_guess_number_higher_or_lower;

public abstract class GuessGame {
	private int target;
	public int guess(int n){
		if(n < target){
			return -1;
		} else if(n > target){
			return 1;
		} else {
			return 0;
		}
	}
}
