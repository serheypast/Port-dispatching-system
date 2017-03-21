package bsuir.by.labWord2.gui.dialogForm;

import bsuir.by.labWord2.gui.portForm.MainForm;
import bsuir.by.labWord2.gui.portForm.UpdateForm;
import bsuir.by.labWord2.modules.QueueShips;
import bsuir.by.labWord2.modules.Ship.InitializerShip;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.run.Main;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.*;
/**
 * Created by Сергей on 21.03.2017.
 */
public class DialogForm extends Dialog {
    private QueueShips ships;
    private Table table;
    protected Object result;
    protected Shell shell;
    private Text text;
    private Text text_1;

    /**
     * Create the dialog.
     *
     * @param parent
     * @param style
     */
    public DialogForm(Shell parent, int style, Table table, QueueShips ships) {
        super(parent, style);
        setText("Add new Ship");
        this.table = table;
        this.ships = ships;
    }

    /**
     * Open the dialog.
     *
     * @return the result
     */
    public Object open() {
        createContents();
        shell.open();
        shell.layout();
        Display display = getParent().getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        return result;
    }

    /**
     * Create contents of the dialog.
     */
    private void createContents() {
        shell = new Shell(getParent(), getStyle());
        shell.setSize(255, 334);
        shell.setText(getText());

        Label lblName = new Label(shell, SWT.NONE);
        lblName.setBounds(29, 51, 55, 15);
        lblName.setText("Name");

        Label lblPriority = new Label(shell, SWT.NONE);
        lblPriority.setBounds(29, 96, 55, 15);
        lblPriority.setText("Priority");

        Label lblDuration = new Label(shell, SWT.NONE);
        lblDuration.setBounds(29, 141, 55, 15);
        lblDuration.setText("Duration");

        text = new Text(shell, SWT.BORDER);
        text.setToolTipText("");
        text.setBounds(108, 51, 91, 21);

        Spinner spinner = new Spinner(shell, SWT.BORDER);
        spinner.setBounds(108, 89, 91, 22);

        text_1 = new Text(shell, SWT.BORDER);
        text_1.setBounds(108, 135, 91, 21);

        Label lblNewLabel = new Label(shell, SWT.NONE);
        lblNewLabel.setBounds(29, 194, 55, 15);
        lblNewLabel.setText("Type");

        Button btnNewButton = new Button(shell, SWT.NONE);
        btnNewButton.setBounds(87, 270, 75, 25);
        btnNewButton.setText("Add ship");

        Label lblNewLabel_1 = new Label(shell, SWT.NONE);
        lblNewLabel_1.setBounds(87, 10, 55, 15);
        lblNewLabel_1.setText("New Label");

        Label lblNewLabel_2 = new Label(shell, SWT.NONE);
        lblNewLabel_2.setBounds(29, 235, 179, 15);


        Button btnInout = new Button(shell, SWT.CHECK);


        btnInout.setBounds(109, 194, 90, 16);
        btnInout.setText("IN/OUT");
        btnNewButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                Ship ship = new Ship();
                ship.setName(text.getText());
                if (btnInout.getSelection()) {
                    ship.setLoadUnLoad(true);
                    ship.setType("Loader");
                } else {
                    ship.setLoadUnLoad(false);
                    ship.setType("UnLoader");
                }
                ship.setTime(Integer.parseInt(text_1.getText()));
                ship.setProducts(InitializerShip.randomProducts());
                ship.setPriority(spinner.getSelection());
                sendShipInQueue(ship);
            }
        });


    }

    /**
     * Add ship in queue and update mainForm
     * @param ship ship in Queue
     */
    private void sendShipInQueue(Ship ship) {
//        Display.getDefault().syncExec(new Runnable() {
//            @Override
//            public void run() {
        ships.addShip(ship);
        TableItem tableItem = new TableItem(table, SWT.NONE);
        tableItem.setText(new String[]{
                ship.getName(),
                Integer.toString(ship.getPriority()),
                ship.getProducts().toString()
        });
        table.redraw();

//            }
//        });
//    }
    }
}
