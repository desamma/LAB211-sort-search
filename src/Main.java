import Common.Library;
import Controller.SortController;
import Model.Array;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Array arrayN = new Array();
        arrayN.setaSize(library.getArraySize("Enter number of array: "));
        arrayN.setArray(library.createArray(arrayN.getaSize()));
        Menu mainMenu = new SortController(arrayN, null);
        new SortController(arrayN, mainMenu).run();
    }
}