package bsuir.by.labWord2.gui;

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
    private Table table;
    private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
    private Table table_1;
    private TableColumn tblclmnName;
    private TableColumn tblclmnNewColumn;
    private TableColumn tblclmnSomeData;
    private ListViewer listViewer;
    private ListViewer listViewer_1;
    private ListViewer listViewer_2;
    private Button btnNewButton;
    TableColumn tblclmnQuantity;

    private TableColumn tblclmnProduct;
    /**
     * Create the application window.
     */
    public MainForm() {
        super(null);
        createActions();
        addToolBar(SWT.FLAT | SWT.WRAP);
        addMenuBar();
        addStatusLine();
    }

    /**
     * Create contents of the application window.
     * @param parent
     */
    @Override
    protected Control createContents(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);

        table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
        table.setBounds(198, 135, 528, 287);
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
        list.setBounds(203, 25, 132, 81);

        listViewer_1 = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
        List list_1 = listViewer_1.getList();
        list_1.setBounds(393, 25, 132, 81);


        listViewer_2 = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
        List list_2 = listViewer_2.getList();
        list_2.setBounds(585, 25, 132, 81);

        Label lblNewLabel = new Label(container, SWT.BORDER | SWT.WRAP | SWT.SHADOW_NONE | SWT.CENTER);
        lblNewLabel.setCapture(true);
        lblNewLabel.setFont(SWTResourceManager.getFont("Snap ITC", 8, SWT.ITALIC));
        lblNewLabel.setOrientation(SWT.RIGHT_TO_LEFT);
        lblNewLabel.setToolTipText("sdff");
        lblNewLabel.setTouchEnabled(true);
        lblNewLabel.setSize(new Point(122, 122));
        lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
        lblNewLabel.setBounds(10, 25, 158, 37);
        formToolkit.adapt(lblNewLabel, true, true);
        lblNewLabel.setText("Портовая диспетчерская система");

        btnNewButton = new Button(container, SWT.NONE);
        btnNewButton.setBounds(10, 385, 158, 37);
        formToolkit.adapt(btnNewButton, true, true);
        btnNewButton.setText("New Button");
        btnNewButton.addListener(SWT.Selection, new Listener()
        {
            @Override
            public void handleEvent(Event event)
            {
                System.out.println("SWT.Selection");
            }
        });

        table_1 = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
        table_1.setBounds(10, 135, 158, 244);
        formToolkit.adapt(table_1);
        formToolkit.paintBordersFor(table_1);
        table_1.setHeaderVisible(true);
        table_1.setLinesVisible(true);

        tblclmnProduct = new TableColumn(table_1, SWT.NONE);
        tblclmnProduct.setText("product");
        tblclmnProduct.setWidth(75);

        tblclmnQuantity = new TableColumn(table_1, SWT.NONE);
        tblclmnQuantity.setWidth(77);
        tblclmnQuantity.setText("Quantity");
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
        return new Point(796, 522);
    }
}
