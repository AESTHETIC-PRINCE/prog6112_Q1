import java.text.DecimalFormat; 

  
 /* Uses: 

 *  - a single-dimensional array (cities[])   -> city names 

 *  - a two-dimensional array (sales[][])     -> PS5 / XBOX / SWITCH sales per city 

 * 

 * Produces: 

 *  - the sales table 

 *  - total sales per city 

 *  - the city with the most total sales 

 */ 

public class Number1ElectronicsReport { 

  

    public static void main(String[] args) { 

  

        // ---- 1D array: holds the city names ---- 

        String[] cities = {"CAPE TOWN", "PORT ELIZABETH", "PRETORIA"}; 

  

        // ---- 2D array: rows = cities, columns = PS5, XBOX, SWITCH ---- 

        int[][] sales = { 

            {1000, 2000, 3000},   // Cape Town 

            {2000, 3000, 4000},   // Port Elizabeth 

            {1500, 1100, 1200}    // Pretoria 

        }; 

  

        String[] consoles = {"PS5", "XBOX", "SWITCH"}; 

  

        DecimalFormat df = new DecimalFormat("#,###"); 

  

        // ---- Print report header ---- 

        printLine(); 

        System.out.println("GAMING CONSOLE REPORT"); 

        printLine(); 

  

        // Column headings 

        System.out.printf("%-16s%-10s%-10s%-10s%n", "", consoles[0], consoles[1], consoles[2]); 

  

        // ---- Print sales table using nested loop over the 2D array ---- 

        for (int row = 0; row < cities.length; row++) { 

            System.out.printf("%-16s", cities[row]); 

            for (int col = 0; col < sales[row].length; col++) { 

                System.out.printf("%-10s", df.format(sales[row][col])); 

            } 

            System.out.println(); 

        } 

  

        System.out.println(); 

        printLine(); 

        System.out.println("CONSOLE SALES TOTALS FOR EACH CITY"); 

        printLine(); 

        System.out.println(); 

  

        // ---- Calculate total sales per city and track the highest ---- 

        int[] cityTotals = new int[cities.length]; 

        int highestTotal = 0; 

        int highestIndex = 0; 

  

        for (int row = 0; row < cities.length; row++) { 

            int total = 0; 

            for (int col = 0; col < sales[row].length; col++) { 

                total += sales[row][col]; 

            } 

            cityTotals[row] = total; 

  

            System.out.printf("%-20s%s%n", cities[row], df.format(total)); 

  

            if (total > highestTotal) { 

                highestTotal = total; 

                highestIndex = row; 

            } 

        } 

  

        System.out.println(); 

        printLine(); 

        System.out.println("CITY WITH THE MOST SALES: " + cities[highestIndex]); 

        printLine(); 

    } 

  

    // Helper method to print the dashed separator line 

    private static void printLine() { 

        System.out.println("--------------------------------------------------------------"); 

    } 

} 
