package bsuir.by.labWord2.gui.portForm;

import bsuir.by.labWord2.modules.Product;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;
import bsuir.by.labWord2.modules.QueueShips;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * Created by Сергей on 18.03.2017.
 */
public class FormInitializer {
    private MainForm mainForm;
    private Stock stock;
    private QueueShips ships;

    public FormInitializer(MainForm mainForm, Stock stock,QueueShips ships) {
        this.mainForm = mainForm;
        this.stock = stock;
        this.ships = ships;
        setTableStock();
        setTableQueue();
        initializeTablePier();
    }

    public FormInitializer(MainForm mainForm) {
        this.mainForm = mainForm;
        setTableStock();
        initializeTablePier();
    }

    public void setTableStock(){
        for (Product product: Product.values()
             ) {
            TableItem tableItem = new TableItem(mainForm.tableStock,SWT.NONE);
            tableItem.setText(new String[]{
                    product.getProduct(),
                    stock.getProducts().get(product.getProduct()).toString()
            });
        }
    }

    public void setTableQueue(){

        for (Ship ship: ships.getShipList()
             ) {
            TableItem tableItem = new TableItem(mainForm.tableQueueShips    ,SWT.NONE);
            tableItem.setText(new String[]{
                    ship.getName(),
                    Integer.toString(ship.getPriority()),
                    ship.getProducts().toString()
            });
        }
    }

    private void initializeTablePier(){
        Table table = mainForm.tablePier_1;
        for(int i = 0; i < 3; i++){
            TableItem item = new TableItem(table,SWT.NONE);
            item.setText("");
        }
        table = mainForm.tablePier_2;
        for(int i = 0; i < 3; i++){
            TableItem item = new TableItem(table,SWT.NONE);
            item.setText("");
        }
        table = mainForm.tablePier_3;
        for(int i = 0; i < 3; i++){
            TableItem item = new TableItem(table,SWT.NONE);
            item.setText("");
        }
    }
}

