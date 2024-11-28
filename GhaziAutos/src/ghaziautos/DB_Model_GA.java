
package ghaziautos;
import java.sql.*;

public class DB_Model_GA {
    Connection con;
    Statement st;
    ResultSet rs;
    
    DB_Model_GA(){
         
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/GA_DB","root","");
     st=con.createStatement();
     System.out.println("DB is connected");
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
    public static void main(String []args){
     DB_Model_GA db= new DB_Model_GA();
     
    }
    
    public ResultSet adminLogin(String id,String pass){
     try{
         String sql="select* from admin where User_Admin='"+id+"' and Password_Admin='"+pass+"'";
       rs=st.executeQuery(sql);
     }
     catch(Exception e){
         System.out.println(e);
     }
        return rs;
    }
    
    public ResultSet showInventory(){
     try{
         String sql="select* from inventory ";
       rs=st.executeQuery(sql);
     }
     catch(Exception e){
         System.out.println(e);
     }
        return rs;
    }
    
    public ResultSet searchProduct(String name){
     try{
         String sql="select* from inventory where name LIKE '"+name+"%' ";
       rs=st.executeQuery(sql);
     }
     catch(Exception e){
         System.out.println(e);
     }
        return rs;
    }
    
    
    
    public int addInventory(String date,String productNo,String productName,String company,int price,int quantity){
    int status=0;
    try{
    String sql="insert into inventory values ('"+date+"','"+productNo+"','"+productName+"','"+company+"','"+price+"','"+quantity+"')";
    status=st.executeUpdate(sql);
    }catch(Exception e){System.out.println(e);}
    return status;
    }
    
    public int updateInventory(String productNo ,String productName,String company,int quantity){
    int status=0;
    try{
    String sql="update inventory set Name='"+productName+"' ,Company='"+company+"', Quantity='"+quantity+"' where Number='"+productNo+"'";
    status=st.executeUpdate(sql);
    }catch(Exception e){System.out.println(e);}
    return status;
    }
    
    public ResultSet checkProduct(String productNo){
     try{
         String sql="select* from inventory where Number='"+productNo+"' ";
       rs=st.executeQuery(sql);
     }
     catch(Exception e){
         System.out.println(e);
     }
        return rs;
    }
    
    public ResultSet checkQuantity(String productNo,int quantity){
     try{
String sql = "SELECT * FROM inventory WHERE Number = '" + productNo + "' AND Quantity >= '" + quantity + "'";
       rs=st.executeQuery(sql);
     }
     catch(Exception e){
         System.out.println(e);
     }
        return rs;
    }
    
//    public int customerInfo(String date,String invoiceNumber,String customerName){
//    int status=0;
//    try{
//    String sql="insert into cart values ('"+date+"','"+invoiceNumber+"','"+customerName+"',null,null,null,null)";
//    status=st.executeUpdate(sql);
//    }catch(Exception e){System.out.println(e);}
//    return status;
//    }
    
    public int sellProduct(String date,String invoiceNumber,String customerName,String productNo,String productName,String company,int price,int quantity){
    int status=0;
    try{
    String sql="insert into sales values ('"+date+"','"+invoiceNumber+"','"+customerName+"','"+productNo+"','"+productName+"','"+company+"','"+price+"','"+quantity+"')";
    status=st.executeUpdate(sql);
    }catch(Exception e){System.out.println(e);}
    return status;
    }
    
    public int sellupdate(String productNo,int quantity){
    int status=0;
    try{
    String sql="update inventory set Quantity=Quantity - '"+quantity+"' where Number= '"+productNo+"'";
    status=st.executeUpdate(sql);
    }catch(Exception e){System.out.println(e);}
    return status;
    }
    
    public int delProduct(String date,String invoiceNumber,String customerName,String productNo,String productName,String company,int quantity){
    int status=0;
    try{
    String sql="delete from sales where date='"+date+"' AND invoice= '"+invoiceNumber+"'AND customer= '"+customerName+"'AND pno='"+productNo+"' AND pname='"+productName+"' AND company='"+company+"' AND quantity='"+quantity+"'";
    status=st.executeUpdate(sql);
    }catch(Exception e){System.out.println(e);}
    return status;
    }
    

    public ResultSet showSales(){
     try{
         String sql="select* from sales ";
       rs=st.executeQuery(sql);
     }
     catch(Exception e){
         System.out.println(e);
     }
        return rs;
    }
    
}