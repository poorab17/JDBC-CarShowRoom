import java.util.InputMismatchException;
import java.util.Scanner;

public class Display extends Car {

	//static block

			
			
			//login method
			
			public void login()
			{

				Scanner sc = new Scanner(System.in);
				System.out.println("Please Enter YOur Name: ");
				String name = sc.next();
				this.name=name;
			}
			
			//Purchase method
			public void purchase() 
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("==================================");
				System.out.println("  Enter 1 : Look of our Showroom  ");
				System.out.println("  Enter 2 : To Sell your Car   ");
				System.out.println("  Enter 3 : To Buy our Car   ");
				System.out.println("  Enter 4 : To Look our New Arrived Car   ");
				System.out.println("==================================");
				try 
				{
					int i = sc.nextInt();
				    //Car a = new ShowRoom();
				   // Car d = new (); 
				   // Product m = (Product) a;
				   // Service n = (Service) d;
				    
				    switch(i)
					{
					case 1: m.Producto();
					break;
					
					case 2: n.Servicem();
					break;
					
					default: System.out.println("===Please enter valid input===");
			                 purchase();
						}
					}
					catch(InputMismatchException Ex)
					{
						System.out.println("===Please enter valid input===");
						purchase();
					}
					
				}
				
				//toString to override reference variable
			    public String toString()
			    {
			    	System.out.println();
					System.out.println("==========================================");
					System.out.println("        ----Thank You so much----         ");
					System.out.println("         Please fill your details         ");
					System.out.println("==========================================");
}
			    //Buy method for Product
			    public void buy() 
			    {
					Scanner sc = new Scanner(System.in);
					
					System.out.println();
					System.out.println("Enter 1: Would you like to buy..? "); 
					System.out.println("Enter 2: cancle and go to the  menu");
					System.out.print("choice: ");
					try 
					{
						int i=sc.nextInt();
					    switch(i) 
					    {
					    
					    case 1: 
						System.out.println();
						System.out.println();
						System.out.println("==========================================");
						System.out.println("        ----Thank You so much----         ");
						System.out.println("        Please fill your details          ");
						System.out.println("==========================================");
						cutomerDetails();
						break;
					
					    case 2:
						System.out.println("Cancel and go back to the Menu");
						Product ref = new Product();
						ref.Producto();
						System.out.println();
					
						break;
					
					   default : buy();
					   
					   }
					}
					catch(InputMismatchException Ex)
					{
						System.out.println("===Please enter valid input=== ");
						buy();
					}
				}
			   
			    
			    //buy method for Service
			    public void buy1() 
			    {
					Scanner sc = new Scanner(System.in);
					
					System.out.println();
					System.out.println("Enter 1: Would you like to buy ....?"); 
					System.out.println("Enter 2: cancle and go to the  menu");
					System.out.print("choice: ");
					try 
					{
						int i=sc.nextInt();
					    switch(i) 
					    {
					    case 1: 
						System.out.println();
						System.out.println("==========================================");
						System.out.println("        ----Thank You so much----         ");
						System.out.println("        Please fill your details          ");
						System.out.println("==========================================");
						cutomerDetails();
						break;
					
					    case 2:
						System.out.println("Cancel and go back to the  Menu");
						Service ref = new Service();
						ref.Servicem();
						
						System.out.println();
					    break;
					
					    default : buy1();
					    }
					}
					catch(InputMismatchException Ex)
					{
						System.out.println("===Please enter valid input===");
						buy1();
						
					}
			    }
			    
			
			    
			    //customer details method
			    
			    
				public void cutomerDetails() 
				{
					try
					{
						Electric ref = new Electric();
					Scanner s = new Scanner(System.in);
					System.out.print("Enter Your Name: ");
					System.out.println(name);
					//String name= s.nextLine();
					System.out.print("Enter Phone Number: ");
					long i= s.nextLong();
					System.out.print("Enter Email ID: ");
					String email= s.next();
					}
					catch(InputMismatchException Ex)
					{
						System.out.println("Enter Valid Details.");
						cutomerDetails();
						
					}
					System.out.println("==========================================");
					System.out.println();
					System.out.println("!!!!-- Please Choose Your Payment Option --!!!!");
					System.out.println("Enter 1. Cash");
					System.out.println("Enter 2. UPI");
					System.out.println("Enter 3. Bank Transfer.");
					System.out.print("choice: ");
					System.out.println();
					
					try 
					{
						Scanner s1 = new Scanner(System.in);
						int p= s1.nextInt();
					    switch(p)
					    {
					    case 1: 
							System.out.println("==== THANK YOU SO MUCH VISIT US AGAIN ===");
							car();
							
							break;
					    case 2: 
							System.out.println(" WE GOT YOUR MONEY TRANSFER..");
							System.out.println("==== THANK YOU SO MUCH VISIT US AGAIN ===");
							car();
							break;
					    case 3: 
							System.out.println("Yes... Bank Transfer Successful..");
							System.out.println("==== THANK YOU SO MUCH VISIT US AGAIN ===");
							car();
							break;
							
					    default: cutomerDetails();
					    }
					}
					
					catch(InputMismatchException Ex)
					{
						System.out.println("===Please enter valid input===");
						cutomerDetails();
						
					}
				}
				
