package coffemachine.machine;

import java.util.ArrayList;
import java.util.List;

public class Chest {
	private List<Coin> coins = new ArrayList<>();

	public void depositCoin(Coin coin) {
		coins.add(coin);
	}
	public Boolean chestIsEmpty() {
		return coins.isEmpty();
	}
}
