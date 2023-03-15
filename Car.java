import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Car {
	String name;
	String fqcn ="com.mysql.cj.jdbc.Driver";
	 String url="jdbc:mysql://localhost:3306?user=root&password=Poorab@17";
	static
	{  
		 System.out.println("****************************");
		 System.out.println("*        WELCOME           *");
		 System.out.println("*          TO              *");
		 System.out.println("*    GUPTA AUTOMOBILES     *");
		 System.out.println("****************************");
    }
	//login method
	
	public void login()
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter YOur Name: ");
		String name = sc.next();
		this.name=name;
	}
	
	class ShowRoom extends Car{
		
	}
	class NewCar extends Car{
		
	}
	
	//Purchase method
	public void purchase() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("==================================");
		System.out.println("  Enter 1 : Check  our Showroom  ");
		System.out.println("  Enter 2 : To Sell your Car   ");
		System.out.println("  Enter 3 : To Buy our Car   ");
		System.out.println("  Enter 4 : To Check out our Upcoming Cars   ");
		System.out.println("==================================");
		try 
		{
			int i = sc.nextInt();
		    Car a = new ShowRoom();
		    Car d = new NewCar(); 
		    ShowRoom m = (ShowRoom) a;
		    NewCar n = (NewCar) d;
		    
		    switch(i)
			{
			case 1: System.out.println("List of Availiable Cars");
			display();
			buy1();
			display();
			buy();
			break;
			
			case 2: System.out.println("You Want to sell your Car");
			buy1();
			sell();
			display();
			break;
			
			case 3: System.out.println("You Want to Buy our Car");
			display();
			buy();
			display();
			break;
			
			case 4: System.out.println("You Want to Check our new Upcoming Car");
			display1();
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
	
	public void display() {
		
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("select * from carwala.carinfo ;");
			System.out.println("==========================");
		
			System.out.println("id  name  model   price");
			ResultSet rs=pstmt.executeQuery( );
			while(rs.next()) {
				
				System.out.print(rs.getInt(1)+"   ");
				System.out.print(rs.getString(2)+"    ");
				System.out.print(rs.getString(3)+"   ");
				System.out.print(rs.getInt(4)+"    ");
				System.out.println();
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void display1() {
		
		try {
			Class.forName(fqcn);
			Connection con = DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("select * from carwala.newcar ;");
			System.out.println("==========================");
		
			System.out.println("id	"+"name	"+"	model	"+"	price	");
			ResultSet rs=pstmt.executeQuery( );				
			while(rs.next()) {
				
				System.out.print(rs.getInt(1)+"	");
				System.out.print(rs.getString(2)+"		");
				System.out.print(rs.getString(3)+"		");
				System.out.print(rs.getInt(4)+"	 ");
				System.out.println();
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}
	
	public void sell() {
		
		String query="insert into carwala.carinfo values(?,?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id Greater than 10:->");
		int id =sc.nextInt();
		System.out.println("Enter  Car name:->");
	    String name  =sc.next();
		System.out.println("Enter Car Model:->");
		String model =sc.next();
		System.out.println("Enter Price:->");
		int price =sc.nextInt();
		try {
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			 PreparedStatement pstmt =con.prepareStatement(query);
			 
		//SET VALUE FOR PLACEHLDER	 
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(4, price);
			pstmt.setString(3, model);
			
			 pstmt.executeUpdate();
			 System.out.println("Inserted");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("problem hai");
		}	
	}
	
	public void buy(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Car Id you want to buy->");
		int Car_id =sc.nextInt();
		
	
		
		
		try {
		
			Class.forName(fqcn);
			Connection con=DriverManager.getConnection(url);
			PreparedStatement pstmt = con.prepareStatement("select * from carwala.carinfo where Car_id=?;");
			
			 
			 
			 
		//SET VALUE FOR PLACEHLDER	 
			pstmt.setInt(1, Car_id);
	    	 //pstmt.executeUpdate();
			 System.out.println("You bought a car");
			 
			 System.out.println("id   name    model     price");
				
				ResultSet rs=pstmt.executeQuery( );
				while(rs.next()) {
					
					System.out.print(rs.getInt(1)+"   ");
					System.out.print(rs.getString(2)+"    ");
					System.out.print(rs.getString(3)+"   ");
					System.out.print(rs.getInt(4)+"    ");
					System.out.println();
					}
				
			// Statement stmt=con.createStatement();
			//ResultSet rs=pstmt.executeQuery("select * from carwala.carinfo where Car_id=?; ");
			PreparedStatement pstmt1 =con.prepareStatement("delete from carwala.carinfo where Car_id=?;");
			pstmt1.setInt(1, Car_id);
			pstmt1.executeUpdate();
				System.out.println("==========================");
			
				
		}
				catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("problem hai");
		}	
	}
		
	
	
	  public void buy1() 
	    {
			Scanner sc = new Scanner(System.in);
			
			System.out.println();
			System.out.println("Enter 1 : Would you like to buy..? "); 
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
				System.out.println(" Please select a car ");
				buy();
				break;
			
			    case 2:
				System.out.println("Cancel and go back to the Menu");
				purchase();

				System.out.println();
			
				break;
			
			   default : buy1();
			   
			   }
			}
			catch(InputMismatchException Ex)
			{
				System.out.println("===Please enter valid input=== ");
				buy();
			}
		}
	  
	  //customer details method
	    
	    
		public void cutomerDetails() 
		{
			
			try {     
			Scanner s = new Scanner(System.in);
			System.out.print("Enter your favorite number: ");
			int uid=s.nextInt();
			System.out.print("Enter Your Name: ");
			System.out.println(name);
			System.out.print("Enter Your place: ");
			String uplace =s.next();
			//String name= s.nextLine();
			System.out.print("Enter Phone Number: ");
			long i= s.nextLong();
			System.out.print("Enter Email ID: ");
			String email= s.next();
			
				
				String query="insert into carwala.register values(?,?,?,?,?)";
					Class.forName(fqcn);
					Connection con=DriverManager.getConnection(url);
					 PreparedStatement pstmt =con.prepareStatement(query);
					 
				//SET VALUE FOR PLACEHLDER	 
					pstmt.setInt(1, uid);
					pstmt.setString(2, name);
					pstmt.setString(3, uplace);
					pstmt.setLong(4, i);
					pstmt.setString(5, email);
					
					
					 pstmt.executeUpdate();
					 System.out.println("Registered Successfully");
					 buy();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("problem hai");
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
					purchase();
					
					break;
			    case 2: 
					System.out.println(" WE GOT YOUR MONEY TRANSFER..");
					System.out.println("==== THANK YOU SO MUCH VISIT US AGAIN ===");
					purchase();
					break;
			    case 3: 
					System.out.println("Yes... Bank Transfer Successful..");
					System.out.println("==== THANK YOU SO MUCH VISIT US AGAIN ===");
					purchase();
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
		

		
	
		public static void main(String[] args) {
			

			Car ref = new Car();
			
			ref.login();
			ref.purchase();
			try {
				
				Class.forName(ref.fqcn);
				//System.out.println("le machha register ho gya");
				
				Connection con = DriverManager.getConnection(ref.url);
				//System.out.println("le bachhi connection bhi establish ho gya");
				
				Statement stmt =con.createStatement();
				//System.out.println("le hero plateform ban gya");
				
				//stmt.executeUpdate("insert into carwala.carinfo values(1,'Thar','C123',900000)");
				//stmt.executeUpdate("insert into carwala.carinfo values(2,'BMW','C214',600000)");
				//stmt.executeUpdate("insert into carwala.carinfo values(3,'AUDI','C412',5000000)");
                //stmt.executeUpdate("insert into carwala.carinfo values(4,'NANO','C420',100000)");
//				stmt.executeUpdate("insert into carwala.carinfo values(5,'DEZIRE','C512',6000000)");
//				stmt.executeUpdate("insert into carwala.carinfo values(6,'FORD','C612',8000000)");
//				stmt.executeUpdate("insert into carwala.carinfo values(7,'TOYOTA','C712',4000000)");
//				stmt.executeUpdate("insert into carwala.carinfo values(8,'BOLERO','C812',2000000)");
//				stmt.executeUpdate("insert into carwala.carinfo values(9,'SCORPIO','C912',4500000)");
//				stmt.executeUpdate("insert into carwala.carinfo values(10,'NISAN','C1012',1500000)");
//				stmt.executeUpdate("insert into carwala.newcar values(1,'HUNDAI','IONIC5',4500000)");
//				stmt.executeUpdate("insert into carwala.newcar values(2,'MARUTI','VITARA',1000000)");
//				stmt.executeUpdate("insert into carwala.newcar values(3,'TOYOTA','HYCROSS',1800000)");
//				stmt.executeUpdate("insert into carwala.newcar values(4,'TATA','NEXON',1600000)");
//				stmt.executeUpdate("insert into carwala.newcar values(5,'KIA','EV6',6000000)");
//				stmt.executeUpdate("insert into carwala.newcar values(6,'MARCEDES','EQS580',7500000)");
				
			
				
			} catch (Exception e) {
				e.printStackTrace();
			 System.out.println("dubara sahi nahi ho raha");
			}
			
		}

	}



