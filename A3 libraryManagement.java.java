import java.util.Scanner;

class Book {

String title;
boolean isIssued;

static int totalBooks = 0;

public Book(String title) {

this.title = title;
this.isIssued = false;

totalBooks++;

}

public void issueBook() {

if (!isIssued) {

isIssued = true;

System.out.println("Book '" + title + "' has been issued.");

} else {

System.out.println("Book '" + title + "' is already issued.");

}

}

public void returnBook() {

if (isIssued) {

isIssued = false;

System.out.println("Book '" + title + "' has been returned.");

} else {

System.out.println("Book '" + title + "' was not issued.");

}

}

public void displayBook() {

System.out.println(title + " | " + (isIssued ? "Issued" : "Available"));

}

public static void displayTotalBooks() {

System.out.println("Total Books in Library: " + totalBooks);

}

}

public class LibrarySystem {

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

Book[] library = new Book[5];

int count = 0;

while (true) {

System.out.println("\nLibrary Management System");

System.out.println("1. Add Book");
System.out.println("2. Issue Book");
System.out.println("3. Return Book");
System.out.println("4. View Books");
System.out.println("5. Check Total Books");
System.out.println("6. Exit");

System.out.print("Enter your choice: ");

int choice = scanner.nextInt();

scanner.nextLine();

switch (choice) {

case 1:

if (count < library.length) {

System.out.print("Enter Book Title: ");

String title = scanner.nextLine();

library[count] = new Book(title);

count++;

System.out.println("Book added successfully.");

} else {

System.out.println("Library is full, can't add more books.");

}

break;

case 2:

System.out.print("Enter Book Number to Issue (1-" + count + "): ");

int issueNum = scanner.nextInt();

if (issueNum > 0 && issueNum <= count) {

library[issueNum - 1].issueBook();

} else {

System.out.println("Invalid book number.");

}

break;

case 3:

System.out.print("Enter Book Number to Return (1-" + count + "): ");

int returnNum = scanner.nextInt();

if (returnNum > 0 && returnNum <= count) {

library[returnNum - 1].returnBook();

} else {

System.out.println("Invalid book number.");

}

break;

case 4:

System.out.println("\nLibrary Books:");

for (int i = 0; i < count; i++) {

System.out.print((i + 1) + ". ");

library[i].displayBook();

}

break;

case 5:

Book.displayTotalBooks();

break;

case 6:

System.out.println("Exiting the system. Thank you!");

scanner.close();

return;

default:

System.out.println("Invalid choice. Try again.");

}

}

}

}
