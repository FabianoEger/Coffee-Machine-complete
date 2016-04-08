package coffemachine.machine;

import java.util.ArrayList;
import java.util.List;

public class Panel {
	private List<Button> buttons = new ArrayList<Button>();
	private Display display;

	public Panel(Display display, List<Button> buttons) {
		this.display = display;
		this.buttons = buttons;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Display pressButton(Button button) {
		Display display = new Display();
		display.setMessage(button.getOption());
		return display;
	}
	
	public void addNewButton(Button button) {
		this.buttons.add(button);
	}
}
