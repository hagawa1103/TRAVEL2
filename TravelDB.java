package scene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class TravelDB {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
    private String travelName = "";
	private ArrayList<String> diceTransportList;
	private ArrayList<String> diceDestinationList;
	
	private int start = 0;
	private int end = 0;
	private ArrayList<String> diceHistoryList;
	DefaultTableModel TravelTableModel;

	private int number = 1;
	private int sizeCount;
    
    
    public TravelDB() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diceTravelDB", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
                "postgres", // ログインロール
                "hagawa2548"); // パスワード
		statement = connection.createStatement();
		//this.setTravelTableModel();
		//this.setTravelNames(travelName);
    }
    
    public TravelDB(String travelName) throws ClassNotFoundException, SQLException{
    	Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diceTravelDB", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
                "postgres", // ログインロール
                "hagawa2548"); // パスワード
		statement = connection.createStatement();
		this.setTravelTableModel(travelName);
		
		
    }
    
    
    public ResultSet getInitiallizeTableData(String travelName) throws SQLException {
    	return  this.statement.executeQuery(String.format("SELECT * FROM %S WHERE dice_id BETWEEN %d AND %d", travelName, this.start, this.end));
    }
    
    public void setTravelTableModel(String travelName) throws SQLException {
    	this.setTableSize(travelName);
    	this.resultSet = getInitiallizeTableData(travelName);
    	
    	
         this.diceTransportList = new ArrayList<String>();
         this.diceDestinationList = new ArrayList<String>();
         this.diceHistoryList = new ArrayList<String>();
         while (this.resultSet.next()) {
            String transportData = resultSet.getString("dice_Transportation");
    		 this.diceTransportList.add(transportData);
    		 String destinationData = resultSet.getString("dice_destination");
    		 this.diceDestinationList.add(destinationData);
    		 String histroyData = resultSet.getString("dice_histroy");
    		 this.diceHistoryList.add(histroyData);

         }	 	
    }
    
    public List<String> getDiceTransportList(){
    	return this.diceTransportList;
    }
    
    public List<String> getDiceDestinationList() {
    	return this.diceDestinationList;
    	
    }
    
    public List<String> getDiceHistoryList() {
    	return this.diceHistoryList;
    }
    
    public void setTravelNames(String travelname) {
		this.travelName = travelname;
	}
    
    
     public void setQueryNumber(int start, int end ) {
    	this.start = start;
    	this.end = end;
    }
    
    public void closeDB() {
    	try {
     	   if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch(SQLException e3) {
     	   e3.printStackTrace();
        }
    }
	
	/**
	 * 
	 * @param tableName
	 * @return table size
	 * @throws SQLException 
 	 */
	public void setTableSize(String tableName) throws SQLException {
		int sizeCount = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diceTravelDB", "postgres", "hagawa2548");
		         Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format("SELECT COUNT(*) FROM %s", tableName))) {
		        resultSet.next();
		        sizeCount = resultSet.getInt(1);
		    }
		/*while (this.resultSet.next()) {
			sizeCount++;
   	 }*/ 
		this.sizeCount = sizeCount;
	}
	
	public int getTableSize() {
		return this.sizeCount;
	}
    
	
    
    
   }

