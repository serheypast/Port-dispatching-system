package bsuir.by.labWord2.gui.portForm;

import bsuir.by.labWord2.gui.dialogForm.DialogForm;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.modules.QueueShips;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

/**
 * Created by Сергей on 17.03.2017.
 */
public class MainForm {
    protected Shell shlPortdispatchingsystem;
    protected Table tableStock;
    protected Table tableQueueShips;
    protected Table tablePier_1;
    protected Table tablePier_2;
    protected Table tablePier_3;

    protected Stock stock;
    protected QueueShips ships;
    protected ProgressBar progressBar;
    protected ProgressBar progressBar_2;
    protected ProgressBar progressBar_1;


    protected TableColumn tblclmnProduct;
    protected TableColumn tblclmnProducts;
    protected TableColumn tblclmnQuantity;
    protected TableColumn tblclmnName;
    protected TableColumn tblclmnPriority;
    protected TableColumn tblclmnPier_1;
    protected TableColumn tblclmnPier_2;
    protected TableColumn tblclmnPier_3;
    protected Button btnNewButton;
    /**
     * Create the application window.
     */
   // protected Shell shell;

    public MainForm(Stock stock, QueueShips ships) {

        createActions();
        this.stock = stock;
        this.ships = ships;
    }

    public MainForm() {
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shlPortdispatchingsystem.open();
        shlPortdispatchingsystem.layout();
        while (!shlPortdispatchingsystem.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the application window.
     */
    protected void createContents() {
        shlPortdispatchingsystem = new Shell();
        shlPortdispatchingsystem.setBackground(SWTResourceManager.getColor(204, 204, 255));
        shlPortdispatchingsystem.setText("Port-dispatching-system");
        shlPortdispatchingsystem.setSize(709, 534);
        shlPortdispatchingsystem.computeSize(450, 300);



        Label lblNewLabel = new Label(shlPortdispatchingsystem, SWT.NONE);
        lblNewLabel.setBackground(SWTResourceManager.getColor(204, 204, 255));
        lblNewLabel.setBounds(10, 10, 145, 39);
        lblNewLabel.setText("Port-dispatching-system");

        Label lblNewLabel_1 = new Label(shlPortdispatchingsystem, SWT.NONE);
        lblNewLabel_1.setForeground(SWTResourceManager.getColor(255, 51, 51));
        lblNewLabel_1.setBackground(SWTResourceManager.getColor(204, 204, 255));
        lblNewLabel_1.setBounds(213, 10, 55, 15);
        lblNewLabel_1.setText("Pier \u21161");

        Label lblNewLabel_2 = new Label(shlPortdispatchingsystem, SWT.NONE);
        lblNewLabel_2.setForeground(SWTResourceManager.getColor(255, 51, 0));
        lblNewLabel_2.setBackground(SWTResourceManager.getColor(204, 204, 255));
        lblNewLabel_2.setBounds(556, 10, 55, 15);
        lblNewLabel_2.setText("Pier \u21163");

        tableStock = new Table(shlPortdispatchingsystem, SWT.BORDER | SWT.FULL_SELECTION);
        tableStock.setBounds(10, 188, 145, 216);
        tableStock.setHeaderVisible(true);
        tableStock.setLinesVisible(true);

        tblclmnProduct = new TableColumn(tableStock, SWT.NONE);
        tblclmnProduct.setWidth(79);
        tblclmnProduct.setText("Product");

        tblclmnQuantity = new TableColumn(tableStock, SWT.NONE);
        tblclmnQuantity.setWidth(100);
        tblclmnQuantity.setText("Quantity");

        tableQueueShips = new Table(shlPortdispatchingsystem, SWT.BORDER | SWT.FULL_SELECTION);
        tableQueueShips.setBounds(184, 188, 465, 283);
        tableQueueShips.setHeaderVisible(true);
        tableQueueShips.setLinesVisible(true);

        tblclmnName = new TableColumn(tableQueueShips, SWT.NONE);
        tblclmnName.setWidth(100);
        tblclmnName.setText("Name");

        tblclmnPriority = new TableColumn(tableQueueShips, SWT.NONE);
        tblclmnPriority.setWidth(100);
        tblclmnPriority.setText("Priority");

        tblclmnProducts = new TableColumn(tableQueueShips, SWT.NONE);
        tblclmnProducts.setWidth(262);
        tblclmnProducts.setText("Products");

        tablePier_1 = new Table(shlPortdispatchingsystem, SWT.BORDER | SWT.FULL_SELECTION);
        tablePier_1.setBounds(184, 31, 123, 103);
        tablePier_1.setHeaderVisible(true);
        tablePier_1.setLinesVisible(true);
        tblclmnPier_1 = new TableColumn(tablePier_1, SWT.NONE);
        tblclmnPier_1.setWidth(120);
        tblclmnPier_1.setText("Ship");

        progressBar_1 = new ProgressBar(shlPortdispatchingsystem, SWT.NONE);
        progressBar_1.setBounds(184, 130, 123, 17);

        btnNewButton = new Button(shlPortdispatchingsystem, SWT.NONE);


        btnNewButton.setBounds(10, 422, 145, 49);
        btnNewButton.setText("Add Ship");

        tablePier_2 = new Table(shlPortdispatchingsystem, SWT.BORDER | SWT.FULL_SELECTION);
        tablePier_2.setLinesVisible(true);
        tablePier_2.setHeaderVisible(true);
        tablePier_2.setBounds(355, 31, 123, 103);
        tblclmnPier_2 = new TableColumn(tablePier_2, SWT.NONE);
        tblclmnPier_2.setWidth(120);
        tblclmnPier_2.setText("Ship");

        progressBar = new ProgressBar(shlPortdispatchingsystem, SWT.NONE);
        progressBar.setBounds(355, 130, 123, 17);

        tablePier_3 = new Table(shlPortdispatchingsystem, SWT.BORDER | SWT.FULL_SELECTION);
        tablePier_3.setLinesVisible(true);
        tablePier_3.setHeaderVisible(true);
        tablePier_3.setBounds(526, 31, 123, 103);
        tblclmnPier_3 = new TableColumn(tablePier_3, SWT.NONE);
        tblclmnPier_3.setWidth(120);
        tblclmnPier_3.setText("Ship");

        progressBar_2 = new ProgressBar(shlPortdispatchingsystem, SWT.NONE);
        progressBar_2.setBounds(526, 130, 123, 17);

        Label lblNewLabel_3 = new Label(shlPortdispatchingsystem, SWT.NONE);
        lblNewLabel_3.setForeground(SWTResourceManager.getColor(255, 51, 0));
        lblNewLabel_3.setBackground(SWTResourceManager.getColor(204, 204, 255));
        lblNewLabel_3.setBounds(386, 10, 55, 15);
        lblNewLabel_3.setText("Pier \u21162");

        Label lblNewLabel_4 = new Label(shlPortdispatchingsystem, SWT.NONE);
        lblNewLabel_4.setBackground(SWTResourceManager.getColor(204, 204, 255));
        lblNewLabel_4.setAlignment(SWT.CENTER);
        lblNewLabel_4.setBounds(10, 167, 145, 15);
        lblNewLabel_4.setText("Stock");

        Label lblNewLabel_5 = new Label(shlPortdispatchingsystem, SWT.NONE);
        lblNewLabel_5.setBackground(SWTResourceManager.getColor(204, 204, 255));
        lblNewLabel_5.setBounds(184, 167, 72, 15);
        lblNewLabel_5.setText("Ship queue");

        Label ErrorLable = new Label(shlPortdispatchingsystem, SWT.NONE);
        ErrorLable.setEnabled(false);
        ErrorLable.setBackground(SWTResourceManager.getColor(204, 204, 255));
        ErrorLable.setBounds(10, 86, 123, 61);

        FormInitializer formInitializer = new FormInitializer(this,stock,ships);

        btnNewButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                DialogForm dialogForm = new DialogForm(shlPortdispatchingsystem,SWT.DIALOG_TRIM,tableQueueShips,ships);
                dialogForm.open();
            }
        });
    }

    /**
     * Create the actions.
     */
    private void createActions() {
        // Create the actions
    }



    public Table getTablePier(int id){
        Table table = null;
        switch (id){
            case 1:
                table = tablePier_1;
                break;
            case 2:
                table = tablePier_2;
                break;
            case 3:
                table = tablePier_3;
                break;
            default:
                table = null;
                break;
        }
        return table;
    }


}
