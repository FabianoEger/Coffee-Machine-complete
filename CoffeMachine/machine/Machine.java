package coffemachine.machine;

import java.util.ArrayList;
import java.util.List;

public class Machine {
	private Panel panel;
	private Chest chest;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public Machine(Panel panel, Chest chest, List<Ingredient> ingredients) {
		this.ingredients = ingredients;
		this.panel = panel;
		this.chest = chest;

	}
	public Chest getChest() {
		return chest;
	}

	public void setChest(Chest chest) {
		this.chest = chest;
	}
	public Panel getPanel() {
		return panel;
	}
	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	public void combineIngredients(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	public String coffeIsReady() {
		panel.getDisplay().setMessage("Pronto");
		return panel.getDisplay().getMessage();
	}
}
