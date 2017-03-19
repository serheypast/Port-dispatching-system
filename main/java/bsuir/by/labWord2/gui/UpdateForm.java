package bsuir.by.labWord2.gui;

import bsuir.by.labWord2.modules.Product;
import bsuir.by.labWord2.modules.Ship.Ship;
import bsuir.by.labWord2.modules.Stock.Stock;
import org.eclipse.core.internal.filebuffers.Progress;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TableItem;

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
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                ProgressBar progressBar = getProgressBar(id);
                int sizeOfProduct = ship.getProducts().size();
                int i = 0;
                for (String product: ship.getProducts().keySet()
                        ) {
                    for (TableItem item: mainForm.table_1.getItems()
                         ) {
                        if (product.equals(item.getText())) {
                            i++;
                            int size = stock.getProducts().get(product);
                            item.setText(1, String.valueOf(size));
                            progressBar.setSelection((int)(((double)i)/sizeOfProduct)*100);
                            progressBar.redraw();
                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                }
                mainForm.table_1.redraw();
            }
        });
    }

    public void addShipInPier(Ship ship,int id){

        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                ListViewer listViewer = getListViewer(id);
                listViewer.getList().removeAll();
                listViewer.getList().setItems(new String[]{
                        "Name: " + ship.getName(),
                        "Priority " + ship.getPriority(),
                        "Duration " + ship.getTime(),
                        "Product " + ship.getProducts().toString()
                });
            }
        });
    }


    public void removeShipFromQueue(Ship ship,int id){
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (TableItem item: mainForm.table.getItems()
                        ) {
                    if(item.getText().equals(ship.getName())){
                        mainForm.table.remove(i);
                        mainForm.table.redraw();
                        break;
                    }
                    i++;
                }

            }
        });
    }

    public void removeListAndBar(int id){
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                ProgressBar progressBar = getProgressBar(id);
                progressBar.setSelection(0);
                progressBar.redraw();
                ListViewer listViewer = getListViewer(id);
                listViewer.getList().removeAll();
                listViewer.getList().redraw();
            }
        });
    }


    private ProgressBar getProgressBar(int id){
        ProgressBar progressBar = null;
        switch (id){
            case 1:
                progressBar = mainForm.progressBar;
                break;
            case 2:
                progressBar = mainForm.progressBar_1;
                break;
            case 3:
                progressBar = mainForm.progressBar_2;
                break;
            default:
                break;
        }
        return progressBar;
    }



    private ListViewer getListViewer(int id){
        ListViewer listViewer = null;
        switch (id){
            case 1:
                listViewer = mainForm.listViewer;
                break;
            case 2:
                listViewer = mainForm.listViewer_1;
                break;
            case 3:
                listViewer = mainForm.listViewer_2;
                break;
            default:
                listViewer = mainForm.listViewer;
                break;
        }
        return listViewer;
    }
}
