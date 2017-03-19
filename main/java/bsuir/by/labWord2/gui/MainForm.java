package bsuir.by.labWord2.gui;

import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.modules.QueueShips;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

/**
 * Created by Сергей on 17.03.2017.
 */
public class MainForm {
    protected Table table;

    protected Table table_1;
    protected TableColumn tblclmnName;
    protected TableColumn tblclmnNewColumn;
    protected TableColumn tblclmnSomeData;
    protected ListViewer listViewer;
    protected ListViewer listViewer_1;
    protected ListViewer listViewer_2;
    protected Button btnNewButton;
    protected TableColumn tblclmnQuantity;
    protected Stock stock;
    protected QueueShips ships;
    protected TableColumn tblclmnProduct;
    protected ProgressBar progressBar_1;
    protected ProgressBar progressBar_2;
    protected ProgressBar progressBar;






    /**
     * Create the application window.
     */
    protected Shell shell;

    public MainForm(Stock stock, QueueShips ships) {
        createActions();
        this.stock = stock;
        this.ships = ships;
    }

    public MainForm() {
    }

    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the application window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setSize(759, 572);
        shell.setText("SWT Application");
        /*
        setStatus("dasdasd");
        Composite shell = new Composite(parent, SWT.NONE);
        shell.setBackground(SWTResourceManager.getColor(102, 153, 102));
*/
        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(189, 178, 528, 301);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tblclmnName = new TableColumn(table, SWT.NONE);
        tblclmnName.setWidth(100);
        tblclmnName.setText("Name");

        tblclmnNewColumn = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn.setWidth(100);
        tblclmnNewColumn.setText("Priority");

        tblclmnSomeData = new TableColumn(table, SWT.NONE);
        tblclmnSomeData.setWidth(307);
        tblclmnSomeData.setText("Some data");

        listViewer = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL);
        List list = listViewer.getList();
        list.setBackground(SWTResourceManager.getColor(255, 255, 255));
        list.setBounds(189, 42, 132, 81);

        listViewer_1 = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL);
        List list_1 = listViewer_1.getList();
        list_1.setBounds(393, 42, 132, 81);


        listViewer_2 = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL);
        List list_2 = listViewer_2.getList();
        list_2.setBounds(585, 42, 132, 81);

        Label lblNewLabel = new Label(shell, SWT.BORDER | SWT.WRAP | SWT.SHADOW_NONE | SWT.CENTER);
        lblNewLabel.setCapture(true);
        lblNewLabel.setOrientation(SWT.RIGHT_TO_LEFT);
        lblNewLabel.setToolTipText("sdff");
        lblNewLabel.setTouchEnabled(true);
        lblNewLabel.setSize(new Point(122, 122));
        lblNewLabel.setBounds(10, 25, 158, 37);

        lblNewLabel.setText("Port-dispatching-system");

        Button btnNewButton = new Button(shell, SWT.NONE);
        btnNewButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event event)
            {
                System.out.println("SWT.Selection");
            }
        });

        btnNewButton.setBounds(10, 442, 158, 37);
        btnNewButton.setText("New Button");

        table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table_1.setBackground(SWTResourceManager.getColor(255, 255, 255));
        table_1.setBounds(10, 178, 158, 244);

        table_1.setHeaderVisible(true);
        table_1.setLinesVisible(true);

        tblclmnProduct = new TableColumn(table_1, SWT.NONE);
        tblclmnProduct.setText("product");
        tblclmnProduct.setWidth(74);

        tblclmnQuantity = new TableColumn(table_1, SWT.NONE);
        tblclmnQuantity.setWidth(77);
        tblclmnQuantity.setText("Quantity");

        progressBar = new ProgressBar(shell, SWT.NONE);
        progressBar.setBounds(189, 129, 132, 17);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        progressBar_1 = new ProgressBar(shell, SWT.NONE);
        progressBar_1.setBounds(393, 129, 132, 17);
        progressBar_1.setMinimum(0);
        progressBar_1.setMaximum(100);

        progressBar_2 = new ProgressBar(shell, SWT.NONE);
        progressBar_2.setBounds(585, 129, 132, 17);
        progressBar_2.setMinimum(0);
        progressBar_2.setMaximum(100);

        Label lblNewLabel_1 = new Label(shell, SWT.NONE);
        lblNewLabel_1.setAlignment(SWT.CENTER);
        lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
        lblNewLabel_1.setBounds(189, 21, 132, 15);

        lblNewLabel_1.setText("Pier № 1");

        Label lblPier = new Label(shell, SWT.NONE);
        lblPier.setAlignment(SWT.CENTER);
        lblPier.setText("Pier № 2");
        lblPier.setBounds(393, 21, 132, 15);

        Label lblPier_1 = new Label(shell, SWT.NONE);
        lblPier_1.setAlignment(SWT.CENTER);
        lblPier_1.setText("Pier № 3");
        lblPier_1.setBounds(585, 21, 132, 15);

        Label lblStock = new Label(shell, SWT.NONE);
        lblStock.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
        lblStock.setBackground(SWTResourceManager.getColor(204, 102, 51));
        lblStock.setAlignment(SWT.CENTER);
        lblStock.setBounds(56, 150, 55, 15);

        lblStock.setText("Stock");

        FormInitializer formInitializer = new FormInitializer(this,stock,ships);

    }

    /**
     * Create the actions.
     */
    private void createActions() {
        // Create the actions
    }



}
