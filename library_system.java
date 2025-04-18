package modo;

import java.util.Scanner;

public class library_system{

   
    public static void main(String[] args) {
       

        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the number of books you want : ");
        int Books = input.nextInt();
        input.nextLine();
        
        String[] bookTitles = new String[Books];
        String[] bookDescriptions = new String[Books];
        boolean[] bookStatuses = new boolean[Books];
        int bookCount = 0;
        boolean x=true;
        while (x=true) {
           
            System.out.println("Welcome to the Library Management System !");
            System.out.println("1. Add a Book");
            System.out.println("2. Search for a Book");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Delete a Book");
            System.out.println("6. Edit Book Details");
            System.out.println("7. View All Books");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();
            
            if (choice == 1) {
                if (bookCount >= Books) {
                    System.out.println("Library is full.");
                } else {
                    System.out.println("Enter the book title: ");
                    String title = input.nextLine();
                  
                    
                  
                    if (title.equals("")||title.equals(" ")) {
                        System.out.println("The title can't be empty ");
                    }else{ 
                        System.out.println("Enter the book description: ");
                    String description = input.nextLine();
                    

                    bookTitles[bookCount] = title;
                    bookDescriptions[bookCount] = description;
                    bookStatuses[bookCount] = false;
                    bookCount++;
                    System.out.println("Book added successfully.");
                    }  }
            }

           
            else if (choice == 2) {
                System.out.print("Search by (1) Title or (2) ID: ");
                int option = input.nextInt();
                
                boolean bookexist = false;
                if (option == 1) {
                    System.out.print("Enter the book title: ");
                    String title = input.next();

                    for (int i = 0; i < bookCount; i++) {
                        if (bookTitles[i].equals(title)) {
                            System.out.println("Book ID: " + i);
                            System.out.println("Title: " + bookTitles[i]);
                            System.out.println("Description: " + bookDescriptions[i]);
                            System.out.println("Status: " + (bookStatuses[i] ? "Issued" : "Available"));
                            bookexist = true;
                        }
                    }
                } else if (option == 2) {
                    System.out.print("Enter the book ID: ");
                    int id = input.nextInt();

                    if (id >= 0 && id < bookCount) {
                        System.out.println("Book ID: " + id);
                        System.out.println("Title: " + bookTitles[id]);
                        System.out.println("Description: " + bookDescriptions[id]);
                        System.out.println("Status: " + (bookStatuses[id] ? "Issued" : "Available"));
                      bookexist = true;
                    }
                }

                if (bookexist == false) {
                    System.out.println("The book doesn't exist.");
                }
            }

            
            else if (choice == 3) {
                System.out.print("Enter the book ID to issue: ");
                int id = input.nextInt();

                if (id >= 0 && id < bookCount) {
                    if (bookStatuses[id] == false) {
                        bookStatuses[id] = true;
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Book is already issued.");
                    }
                } else {
                    System.out.println("Invalid book ID.");
                }
            }

            
            else if (choice == 4) {
                System.out.print("Enter the book ID to return: ");
                int id = input.nextInt();

                if (id >= 0 && id < bookCount) {
                    if (bookStatuses[id] == true) {
                        bookStatuses[id] = false;
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book is already available.");
                    }
                } else {
                    System.out.println("Invalid book ID.");
                }
            }

            
            else if (choice == 5) {
                System.out.print("Enter the book ID to delete: ");
                int id = input.nextInt();

                if (id >= 0 && id < bookCount) {
                    for (int i = id; i < bookCount-1 ; i++) {
                        bookTitles[i] = bookTitles[i + 1];
                        bookDescriptions[i] = bookDescriptions[i + 1];
                        bookStatuses[i] = bookStatuses[i + 1];
                    }
                    bookCount--;
                    System.out.println("Book deleted successfully.");
                } else {
                    System.out.println("Invalid book ID.");
                }
            }

            
            else if (choice == 6) {
                System.out.print("Enter the book ID to edit: ");
                int id = input.nextInt();
                input.nextLine();

                if (id >= 0 && id < bookCount) {
                    System.out.print("Enter new title: ");
                    String newTitle = input.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = input.nextLine();

                    bookTitles[id] = newTitle;
                    bookDescriptions[id] = newDescription;

                    System.out.println("Book details updated successfully.");
                } else {
                    System.out.println("Invalid book ID.");
                }
            }

           
            else if (choice == 7) {
                if (bookCount == 0) {
                    System.out.println("No books in the library.");
                } else {
                    for (int i = 0; i < bookCount; i++) {
                        System.out.println("Book ID: " + i);
                        System.out.println("Title: " + bookTitles[i]);
                        System.out.println("Description: " + bookDescriptions[i]);
                        String y;
                        if(bookStatuses[i]==true){
                             y="Issued";
                        }else{
                             y="available";
                        }
                            System.out.println("Status: " + y );
                       
                    }
                }
            }

            
            else if (choice == 8) {
                System.out.println("Exiting the system...");
                break;
            }

            
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

