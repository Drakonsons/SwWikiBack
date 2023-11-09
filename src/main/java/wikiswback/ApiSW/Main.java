package wikiswback.ApiSW;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Printer printer = new Printer();

        ArgumentSwitcher argumentSwitcher = new ArgumentSwitcher(reader, printer);

        if (args.length == 0) {
            System.out.println("no parameters, enter help for more information");
            return;
        }
        if (args[0].equalsIgnoreCase("help")) {
            System.out.println("For getting all results in a category");
            System.out.println("usage: [category]");
            System.out.println();
            System.out.println("For searching in results in a category");
            System.out.println("usage: [category] [search]");
            System.out.println();
            System.out.println("[category] : films, planets, starships");
            System.out.println("[search] you can search on following fields per category");
            System.out.println();
            System.out.println("films : title");
            System.out.println("planets : name");
            System.out.println("starships : name, model");
            return;
        }

        if (args.length == 1) {
            argumentSwitcher.switchCommand(args[0], null);
            return;
        }
        if (args.length == 2) {
            argumentSwitcher.switchCommand(args[0], args[1]);
        }
    }
}
