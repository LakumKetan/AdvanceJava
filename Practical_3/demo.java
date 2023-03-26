package Practical_3;
// To develop JDBC application. 
// 1. Create a table in database named Books (BookTitle, Authorname, 
// Publisher, Price). 
// 2. Enter 20 records in this table. 
// 3. Search and update the price of a given book. 
// 4. Delete the record of a given book. 

import java.sql.*;
import java.util.Scanner;

public class demo {
    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/ketan?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "Ketan8@.2003";
        Scanner sc = new Scanner(System.in);

        /* Establish connection with server */
        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        // for Creating the BOOKS table 
        // String createTable = "CREATE TABLE BOOKS (BOOKTITLE VARCHAR(200), AUTHORNAME VARCHAR(200), PUBLISHER VARCHAR(200), PRICE DECIMAL(5,2))";
        // st.executeUpdate(createTable);

        String input = "";
        boolean flag = true;
        String bookName;
        int num;
                int newPrice;
        while (flag) {
            System.out.println("1. add record in the table ");
            System.out.println("2.change price ");
            System.out.println("3.delete row");
            System.out.println("4.exit");
            input = sc.next();

            if ("1".equals(input)) {

                System.out.print("Number of record do you want to add ");
                num = sc.nextInt();
                System.out.println("Enter data like : bookname, authorname, publisher, price");
                addRecords(num, st);
            } else if ("2".equals(input)) {
                
                System.out.print("Enter a book name you want to change price ");
                bookName = sc.next();
                System.out.print("Enter a new price :");
                newPrice = sc.nextInt();
                updatePrice(bookName, newPrice, st);
            } else if ("3".equals(input)) {
                System.out.println("Enter a book name you want to delete :");
                bookName = sc.next();
                deleteRecord(bookName, st);
            } else {
                flag = false;
            }
        }
        con.close();
    }

    public static void addRecords(int num, Statement st) throws SQLException, NumberFormatException {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= num; i++) {
            String str = in.nextLine();
            String[] array = str.split(",");
            String bookTitle = array[0].strip();
            String authorName = array[1].strip();
            String publisher = array[2].strip();
            int price = Integer.parseInt(array[3]);
            String insertValueQuery = "INSERT INTO BOOKS (BOOKTITLE, AUTHORNAME,PUBLISHER, PRICE) VALUES ( '"
                    + bookTitle + "','" + authorName + "','" + publisher + "','" + price + "')";
            st.executeUpdate(insertValueQuery);
        }
        System.out.println(num + "Record added sucessfully.........");
    }

    public static void updatePrice(String bookTitle, int newPrice, Statement st) throws SQLException {
        String updatePriceQuery = "SELECT * FROM BOOKS WHERE BOOKTITLE ='" + bookTitle + "';";
        ResultSet rs = st.executeQuery(updatePriceQuery);
        String changeQuery = "UPDATE BOOKS SET PRICE = " + newPrice + " WHERE BOOKTITLE = '" + bookTitle + "'";
        if (rs.next()) {
            st.executeUpdate(changeQuery);
            System.out.println("Book price changed to "+ newPrice);
        } else {
            System.out.println("No book found");
        }
    }

    public static void deleteRecord(String bookTitle, Statement st) throws SQLException {
        String deleteQuery = "DELETE FROM BOOKS WHERE BOOKTITLE = '" + bookTitle + "'";
        st.executeUpdate(deleteQuery);
        System.out.println(bookTitle + " is Deleted.......");
    }
}