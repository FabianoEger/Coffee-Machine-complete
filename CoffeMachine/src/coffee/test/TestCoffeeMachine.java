package coffee.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import coffee.machine.Button;
import coffee.machine.Chest;
import coffee.machine.Coin;
import coffee.machine.Display;
import coffee.machine.Ingredient;
import coffee.machine.Machine;
import coffee.machine.Panel;

public class TestCoffeeMachine {

	@Test
	public void depositCoinTest() {
		Chest chest = new Chest();
		Button button = new Button("Café");
		Display display = new Display();
		List<Button> buttons = new ArrayList<Button>();
		Panel panel = new Panel(display, buttons);
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Machine machine = new Machine(panel, chest, ingredients);
		Coin coin10 = new Coin();
		Coin coin25 = new Coin();
		machine.getPanel().addNewButton(button);
		coin10.setValue(0.10);
		coin25.setValue(0.25);

		machine.getChest().depositCoin(coin10);
		machine.getPanel().getDisplay().setMessage("0.10");
		assertEquals("0.10", machine.getPanel().getDisplay().getMessage());
		machine.getChest().depositCoin(coin25);
		machine.getPanel().getDisplay().setMessage("0.35");
		
		assertEquals("0.35", machine.getPanel().getDisplay().getMessage());
		
		assertEquals("Pronto", machine.coffeIsReady());
	}

	@Test
	public void pressButtonCoffe() {
		Chest chest = new Chest();
		Button button = new Button("Café");
		Display display = new Display();
		List<Button> buttons = new ArrayList<Button>();
		Panel panel = new Panel(display, buttons);
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Machine machine = new Machine(panel, chest, ingredients);
		machine.getPanel().addNewButton(button);
		assertEquals("Café", panel.pressButton(button).getMessage());

	
	}

	@Test
	public void combineIngredients() {
		Chest chest = new Chest();
		Button button = new Button("Café");
		Display display = new Display();

		Ingredient cup = new Ingredient("Copo", 1);
		Ingredient water = new Ingredient("Água", 50);
		Ingredient coffePowder = new Ingredient("Café", 10);
		Ingredient sugar = new Ingredient("Açucar", 5);

		List<Button> buttons = new ArrayList<Button>();
		Panel panel = new Panel(display, buttons);

		List<Ingredient> ingredients = new ArrayList<Ingredient>();

		Machine machine = new Machine(panel, chest, ingredients);

		machine.getPanel().addNewButton(button);
		machine.combineIngredients(cup);
		machine.combineIngredients(water);
		machine.combineIngredients(coffePowder);
		machine.combineIngredients(sugar);

		assertEquals("Pronto", machine.coffeIsReady());
		
		Coin coin = new Coin();
		coin.setValue(0.50);
		chest.returnChange(coin);
		display.setMessage("Receba seu troco: ");
		
		assertEquals(display.getMessage()+chest.getChange(), display.getMessage()+chest.returnChange(coin));

	}

	@Test
	public void pressButtonCoffeWithoutMoney() {
		Chest chest = new Chest();
		Button button = new Button("Café");
		Display display = new Display();
		List<Button> buttons = new ArrayList<Button>();
		Panel panel = new Panel(display, buttons);
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Machine machine = new Machine(panel, chest, ingredients);
		machine.getPanel().addNewButton(button);
		if (machine.getChest().chestIsEmpty()) {
			machine.getPanel().getDisplay().setMessage("0.35");
			assertEquals("0.35", panel.getDisplay().getMessage());
		}

	}

}
