package main;

import java.util.Scanner;

import entities.User;
import service.AdminService;
import service.UserService;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		User user = new User();

		int choose = 0;
		int input = 0;

		do {
			System.out.println("Welcome to Read Book Application!Please enter your username and password.");
			user = UserService.login();

			// Service Admin

			if (user.getRole() == 1) {
				do {
					getMenuAdmin();

					boolean err1 = true;
					while (err1) {
						if (sc.hasNextInt()) {
							choose = Integer.parseInt(sc.nextLine());
						} else {

							System.out.println("Please enter number: ");
							sc.nextLine();
							continue;
						}
						err1 = false;
					}
					switch (choose) {
					case 1:
						// getMenuCreateBook();
						AdminService.createBook();
						break;
					case 2:
						AdminService.deleteBook();
						break;
					case 3:
						AdminService.editBookContent();
						break;

					}
				} while (choose != 4);
			}

			// Service User

			if (user.getRole() == 0) {
				do {
					getMenuUser();
					System.out.print("Enter choice : ");
					boolean err1 = true;
					while (err1) {
						if (sc.hasNextInt()) {
							choose = Integer.parseInt(sc.nextLine());
						} else {

							System.out.println("Please enter number: ");
							sc.nextLine();
							continue;
						}
						err1 = false;
					}
					switch (choose) {

					// View List Books

					case 1:
						UserService.viewListBook();
						break;

					// Search Book

					case 2:
						do {
							System.out.println("Please select search type:");
							getMenuSearch();
							System.out.print("Enter choice : ");
//							input = Integer.parseInt(sc.nextLine());
							boolean err2 = true;
							while (err2) {
								if (sc.hasNextInt()) {
									input = Integer.parseInt(sc.nextLine());
								} else {

									System.out.println("Please enter number: ");
									sc.nextLine();
									continue;
								}
								err2 = false;
							}
							switch (input) {
							case 1:
								UserService.searchBookByName();
								break;
							case 2:
								UserService.searchBookByAuthor();
								break;
							case 3:
								UserService.searchBookByCategory();
								break;
							}
						} while (input != 4);

						break;

					// Read Book

					case 3:
						UserService.readBook();
						break;

					// View BookCase

					case 4:
						UserService.viewBookCase(user.getBookcase());
						break;

					// Edit BookCase

					case 5:
						do {
							System.out.println("Please enter the number:");
							getMenuEditBookCase();
							// input = Integer.parseInt(sc.nextLine());
							boolean err2 = true;
							while (err2) {
								if (sc.hasNextInt()) {
									input = Integer.parseInt(sc.nextLine());
								} else {

									System.out.println("Please enter number: ");
									sc.nextLine();
									continue;
								}
								err2 = false;
							}
							switch (input) {
							case 1:
								UserService.addBookInBookCase(user.getBookcase());
								break;
							case 2:
								UserService.deleteBookInBookCase(user.getBookcase());
								break;
							case 3:
								UserService.clearBookCase(user.getBookcase());
								break;
							}
						} while (input != 4);
						break;
					}
				} while (choose != 6);
			}

		} while (true);

	}

	public static void getMenuAdmin() {
		System.out.println("1. Create Book");
		System.out.println("2. Delete Book");
		System.out.println("3. Edit Book Content");
		System.out.println("4. Logout");

	}

	public static void getMenuUser() {
		System.out.println("1. View List Books");
		System.out.println("2. Search Books");
		System.out.println("3. Read Book");
		System.out.println("4. View Your BookCase");
		System.out.println("5. Edit Your BookCase");
		System.out.println("6. Logout");
	}

	public static void getMenuSearch() {
		System.out.println("1. By name");
		System.out.println("2. By author");
		System.out.println("3. By category");
		System.out.println("4. Back");
	}

	public static void getMenuEditBookCase() {
		System.out.println("1. Add a new book");
		System.out.println("2. Remove a book ");
		System.out.println("3. Clear BookCase");
		System.out.println("4. Back");
	}

	public static void getMenuCreateBook() {
		System.out.println("1. Enter Book Name");
		System.out.println("2. Enter Book Title");
		System.out.println("3. Enter the author");
		System.out.println("4. Enter category");
		System.out.println("5. Enter brief");
		System.out.println("6. Enter publisher");
		System.out.println("7. Enter content");
	}

}
