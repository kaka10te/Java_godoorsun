import javax.swing.*;


public class FgMenu extends JMenu{
	/**
	 * �Զ���˵�
	 */
	private static final long serialVersionUID = 1L;

	public FgMenu(String label) {
		super(label);
	}

	public FgMenu(String label, int nAccelerator) {
		super(label);
		setMnemonic(nAccelerator);
	}
}
