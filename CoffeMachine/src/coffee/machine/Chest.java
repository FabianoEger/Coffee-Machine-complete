package coffee.machine;

import java.util.ArrayList;
import java.util.List;

public class Chest {
	private List<Coin> coins = new ArrayList<>();
	private double change;
	
	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public void depositCoin(Coin coin) {
		coins.add(coin);
	}

	public Boolean chestIsEmpty() {
		return coins.isEmpty();
	}

	public double returnChange(Coin coin) {
		Coffee coffee = new Coffee();
		if (coin.getValue() > coffee.getPrice()) {
			change = coin.getValue() - coffee.getPrice();
		}
		return change;
	}
}
