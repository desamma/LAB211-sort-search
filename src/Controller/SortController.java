package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Array;
import java.util.Scanner;
import view.Menu;

public class SortController extends Menu<String> {
    
    private Menu parentMenu;
    private static String[] mc = {"Sort", "Search", "Exit"};
    private Library library;
    private Algorithm algorithm;
    private int aSize;
    private int[] arrayN;
    private boolean check = false;
    
    public SortController (Array array, Menu parentMenu) {
        super("Sort Controller", mc, parentMenu);
        this.parentMenu = parentMenu;
        library = new Library();
        algorithm = new Algorithm();
        aSize = array.getaSize();
        arrayN = array.getArray();
    }
    
    @Override
    public void execute(int n) {
        switch(n) {
            case 1:
                sort();
                break;
            case 2:
                search();
                break;
            case 3:
                System.exit(0);
        }
    }
    
    public void sort() {
        String[] mcs = {"Bubble Sort", "Quick Sort", "Back", "Exit"};
        Menu smenu;
        smenu = new Menu("Sort option", mcs, this) {
            @Override
            public void execute(int n) {
                switch(n) {
                    case 1:
                        check = true;
                        System.out.println("Your array:");
                        library.display(arrayN);
                        algorithm.buddleSort(arrayN);
                        System.out.println("Sorted array:");
                        library.display(arrayN);
                        break;
                    case 2:
                        check = true;
                        System.out.println("Your array:");
                        library.display(arrayN);
                        algorithm.quickSort(arrayN, 0, aSize - 1);
                        System.out.println("Sorted array:");
                        library.display(arrayN);
                        break;
                    case 3:
                        returnToPMenu();
                        break;
                    case 4:
                        System.exit(0);
                }
            } 
        };
        smenu.run();
    }
    
    public void search() {
        String[] mcs = {"Linear search", "Binary search","Return", "Exit"};
        Menu semenu;
        semenu = new Menu("Search option", mcs, this){
            @Override
            public void execute(int n) {
                Scanner sc = new Scanner(System.in);
                switch(n){
                    case 1:
                        System.out.println("Enter the number you want to search: ");
                        int x = sc.nextInt();
                        System.out.println("The array:");
                        library.display(arrayN);
                        int result = algorithm.linearSearch(arrayN, x);
                        if (result != -1){
                            System.out.println("Your number is found at index " + result);
                        }
                        else System.out.println("Your number is not present");
                        break;                        
                    case 2:
                        if (check == true){
                        System.out.println("Enter the number you want to search: ");
                        x = sc.nextInt();
                        System.out.println("The array:");
                        library.display(arrayN);
                        result = algorithm.binarySearch(arrayN, x);
                        if (result != -1){
                            System.out.println("Your number is found at index " + result);
                        }
                        else System.out.println("Your number is not present");
                        break;
                        }
                        else{
                            System.out.println("The array has not been sorted");
                            break;
                        }
                    case 3:
                        returnToPMenu();
                        break;
                    case 4:
                        System.exit(0);
                }
            }
            
        };
        semenu.run();
    }
}