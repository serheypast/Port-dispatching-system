package bsuir.by.labWord2.gui;

import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.thread.QueueShips;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Created by Сергей on 17.03.2017.
 */
public class MainForm extends ApplicationWindow {
    protected Table table;
    private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
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
    /**
     * Create the application window.
     */
    public MainForm(Stock stock, QueueShips ships) {
        super(null);
        createActions();
        addToolBar(SWT.FLAT | SWT.WRAP);
        addMenuBar();
        addStatusLine();
        this.stock = stock;
        this.ships = ships;
    }

    protected void setContainer(){

    }


    /**
     * Create contents of the application window.
     * @param parent
     */
    @Override
    protected Control createContents(Composite parent) {

        setStatus("dasdasd");
        Composite container = new Composite(parent, SWT.NONE);
        container.setBackground(SWTResourceManager.getColor(102, 153, 102));

        table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(189, 178, 528, 301);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tblclmnName = new TableColumn(table, SWT.NONE);
        tblclmnName.setWidth(100);
        tblclmnName.setText("Name");

        tblclmnNewColumn = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn.setWidth(100);
        tblclmnNewColumn.setText("Operation");

        tblclmnSomeData = new TableColumn(table, SWT.NONE);
        tblclmnSomeData.setWidth(307);
        tblclmnSomeData.setText("Some data");

        listViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
        List list = listViewer.getList();
        list.setBackground(SWTResourceManager.getColor(255, 255, 255));
        list.setBounds(189, 42, 132, 81);

        listViewer_1 = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
        List list_1 = listViewer_1.getList();
        list_1.setBounds(393, 42, 132, 81);
        listViewer_1.add("string");
        listViewer_1.add("string2");

        listViewer_2 = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
        List list_2 = listViewer_2.getList();
        list_2.setBounds(585, 42, 132, 81);

        Label lblNewLabel = new Label(container, SWT.BORDER | SWT.WRAP | SWT.SHADOW_NONE | SWT.CENTER);
        lblNewLabel.setCapture(true);
        lblNewLabel.setOrientation(SWT.RIGHT_TO_LEFT);
        lblNewLabel.setToolTipText("sdff");
        lblNewLabel.setTouchEnabled(true);
        lblNewLabel.setSize(new Point(122, 122));
        lblNewLabel.setBounds(10, 25, 158, 37);
        formToolkit.adapt(lblNewLabel, true, true);
        lblNewLabel.setText("Port-dispatching-system");

        Button btnNewButton = new Button(container, SWT.NONE);
        btnNewButton.addListener(SWT.Selection, new Listener()
        {
            @Override
            public void handleEvent(Event event)
            {
                System.out.println("SWT.Selection");
            }
        });

        btnNewButton.setBounds(10, 442, 158, 37);
        formToolkit.adapt(btnNewButton, true, true);
        btnNewButton.setText("New Button");

        table_1 = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
        table_1.setBackground(SWTResourceManager.getColor(255, 255, 255));
        table_1.setBounds(10, 178, 158, 244);
        formToolkit.adapt(table_1);
        formToolkit.paintBordersFor(table_1);
        table_1.setHeaderVisible(true);
        table_1.setLinesVisible(true);

        tblclmnProduct = new TableColumn(table_1, SWT.NONE);
        tblclmnProduct.setText("product");
        tblclmnProduct.setWidth(74);

        tblclmnQuantity = new TableColumn(table_1, SWT.NONE);
        tblclmnQuantity.setWidth(77);
        tblclmnQuantity.setText("Quantity");

        ProgressBar progressBar = new ProgressBar(container, SWT.NONE);
        progressBar.setBounds(189, 129, 132, 17);
        formToolkit.adapt(progressBar, true, true);

        ProgressBar progressBar_1 = new ProgressBar(container, SWT.NONE);
        progressBar_1.setBounds(393, 129, 132, 17);
        formToolkit.adapt(progressBar_1, true, true);

        ProgressBar progressBar_2 = new ProgressBar(container, SWT.NONE);
        progressBar_2.setBounds(585, 129, 132, 17);
        formToolkit.adapt(progressBar_2, true, true);

        Label lblNewLabel_1 = new Label(container, SWT.NONE);
        lblNewLabel_1.setAlignment(SWT.CENTER);
        lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
        lblNewLabel_1.setBounds(189, 21, 132, 15);
        formToolkit.adapt(lblNewLabel_1, true, true);
        lblNewLabel_1.setText("Pier \u2116 1");

        Label lblPier = new Label(container, SWT.NONE);
        lblPier.setAlignment(SWT.CENTER);
        lblPier.setText("Pier \u2116 2");
        lblPier.setBounds(393, 21, 132, 15);
        formToolkit.adapt(lblPier, true, true);

        Label lblPier_1 = new Label(container, SWT.NONE);
        lblPier_1.setAlignment(SWT.CENTER);
        lblPier_1.setText("Pier \u2116 3");
        lblPier_1.setBounds(585, 21, 132, 15);
        formToolkit.adapt(lblPier_1, true, true);

        Label lblStock = new Label(container, SWT.NONE);
        lblStock.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
        lblStock.setBackground(SWTResourceManager.getColor(204, 102, 51));
        lblStock.setAlignment(SWT.CENTER);
        lblStock.setBounds(56, 150, 55, 15);
        formToolkit.adapt(lblStock, true, true);
        lblStock.setText("Stock");

        FormInitializer formInitializer = new FormInitializer(this,stock,ships);
        return container;
    }

    /**
     * Create the actions.
     */
    private void createActions() {
        // Create the actions
    }


    /**
     * Create the status line manager.
     * @return the status line manager
     */
    @Override
    protected StatusLineManager createStatusLineManager() {
        StatusLineManager statusLineManager = new StatusLineManager();
        statusLineManager.setErrorMessage("dads");
        return statusLineManager;
    }


    /**
     * Configure the shell.
     * @param newShell
     */
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Port dispatching system");
    }

    /**
     * Return the initial size of the window.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(759, 572);
    }
}
