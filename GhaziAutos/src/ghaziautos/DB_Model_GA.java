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
    
    public ResultSet searchProduct(String searchTerm){
     try{
         String sql="select* from inventory where Number LIKE '"+searchTerm+"%' OR Name LIKE '"+searchTerm+"%' OR Company LIKE '"+searchTerm+"%'";
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
    String sql="update inventory set Name='"+productName+"' ,Company='"+company+"', Quantity='"+quantity+"' where Number='"+productNo+"' AND Company='"+company+"'";
    status=st.executeUpdate(sql);
    }catch(Exception e){System.out.println(e);}
    return status;
    }
    
    public ResultSet checkProduct(String productNo, String company){
     try{
         String sql="select* from inventory where Number='"+productNo+"' AND Company='"+company+"'";
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
    
    public ResultSet executeQuery(String query, Object[] params) {
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public int deleteProduct(String productNo) {
        int status = 0;
        try {
            String sql = "DELETE FROM inventory WHERE Number='" + productNo + "'";
            status = st.executeUpdate(sql);
        } catch(Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public ResultSet getProductCompanies(String productNo) {
        try {
            String sql = "SELECT DISTINCT Company FROM inventory WHERE Number='" + productNo + "'";
            rs = st.executeQuery(sql);
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet getProductByNumberAndCompany(String productNo, String company) {
        try {
            String sql = "SELECT * FROM inventory WHERE Number='" + productNo + "' AND Company='" + company + "'";
            rs = st.executeQuery(sql);
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet getDistinctYears() {
        try {
            String sql = "SELECT DISTINCT YEAR(date) as year FROM sales ORDER BY year DESC";
            rs = st.executeQuery(sql);
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet getProductNames(String productNo) {
        try {
            String sql = "SELECT DISTINCT Name FROM inventory WHERE Number='" + productNo + "'";
            rs = st.executeQuery(sql);
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet getProductCompanies(String productNo, String selectedName) {
        try {
            String sql = "SELECT DISTINCT Company FROM inventory WHERE Number='" + productNo + "' AND Name='" + selectedName + "'";
            rs = st.executeQuery(sql);
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }
}