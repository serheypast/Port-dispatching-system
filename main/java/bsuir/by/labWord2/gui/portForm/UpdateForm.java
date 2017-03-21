package bsuir.by.labWord2.gui.portForm;

import bsuir.by.labWord2.gui.dialogForm.DialogForm;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import static java.lang.Thread.sleep;

/**
 * Created by Сергей on 19.03.2017.
 */
public class UpdateForm {
    private MainForm mainForm;
    private Stock stock;

    public UpdateForm(MainForm mainForm, Stock stock) {
        this.mainForm = mainForm;
        this.stock = stock;
    }

    public UpdateForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public void addProductsInStock(Ship ship,int id){
        System.out.println(Thread.currentThread().getName());
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                ProgressBar progressBar = getProgressBar(id);
                int sizeOfProduct = ship.getProducts().size();
                int currentSize = 0;
                for (String product: ship.getProducts().keySet()
                        ) {
                    for (TableItem item: mainForm.tableStock.getItems()
                         ) {
                        if (product.equals(item.getText())) {
                            currentSize++;
                            int size = stock.getProducts().get(product);
                            item.setText(1, String.valueOf(size));
                            progressBar.setSelection((int)(((double)currentSize)/sizeOfProduct)*100);
                            progressBar.redraw();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                mainForm.tableStock.redraw();
            }
        });
    }

    public void addShipInPier(Ship ship,int id){

        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                Table table = getTablePier(id);
                TableItem[] items = table.getItems();
                items[0].setText("Name: " + ship.getName());
                items[1].setText("Type: " + ship.getType());
                items[2].setText("Duration: " + String.valueOf(ship.getTime()));
            }
        });
    }


    public void removeShipFromQueue(Ship ship,int id){
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (TableItem item: mainForm.tableQueueShips.getItems()
                        ) {
                    if(item.getText().equals(ship.getName())){
                        mainForm.tableQueueShips.remove(i);
                        mainForm.tableQueueShips.redraw();
                        break;
                    }
                    i++;
                }

            }
        });
    }

    public void removeTablePierAndBar(int id){
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                ProgressBar progressBar = getProgressBar(id);
                progressBar.setSelection(0);
                progressBar.redraw();
                Table table= getTablePier(id);
                for (TableItem item: table.getItems()
                     ) {
                    item.setText("");
                }
                table.redraw();
            }
        });
    }


    private ProgressBar getProgressBar(int id){
        ProgressBar progressBar = null;
        switch (id){
            case 1:
                progressBar = mainForm.progressBar_1;
                break;
            case 2:
                progressBar = mainForm.progressBar;
                break;
            case 3:
                progressBar = mainForm.progressBar_2;
                break;
            default:
                break;
        }
        return progressBar;
    }



    private Table getTablePier(int id){
        Table table = null;
        switch (id){
            case 1:
                table = mainForm.tablePier_1;
                break;
            case 2:
                table = mainForm.tablePier_2;
                break;
            case 3:
                table = mainForm.tablePier_3;
                break;
            default:
                table = null;
                break;
        }
        return table;
    }


    public void addShipInQueue(Ship ship){
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                TableItem tableItem = new TableItem(mainForm.tableQueueShips,SWT.NONE);
                tableItem.setText(new String[]{
                        ship.getName(),
                        Integer.toString(ship.getPriority()),
                        ship.getProducts().toString()
                });
                mainForm.tableQueueShips.redraw();
            }
        });
    }


}
