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
	private List<String> TransportList = new ArrayList<>();
	private List<String> DestinationList = new ArrayList<>();
	private int start = 0;
	private int end = 0;
	private ArrayList<String> diceHistoryList;
	DefaultTableModel TravelTableModel;
	 DiceGameJF diceGame = new DiceGameJF();
    
    
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
    	return  this.statement.executeQuery(String.format("SELECT * FROM %S WHERE dice_id BETWEEN %d AND %d", travelName,this.start, this.end));
    }
    
    public void setTravelTableModel(String travelName) throws SQLException {
    	this.resultSet = getInitiallizeTableData(travelName);
         this.diceTransportList = new ArrayList<String>();
         this.diceDestinationList = new ArrayList<String>();
         this.diceHistoryList = new ArrayList<String>();
         while (this.resultSet.next()) {
        	/*Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }*/
           // TravelTableModel.addRow(rowData);
            String transportData = resultSet.getString("dice_Transportation");
    		 diceTransportList.add(transportData);
    		 String destinationData = resultSet.getString("dice_destination");
    		 diceDestinationList.add(destinationData);
    		 String histroyData = resultSet.getString("dice_histroy");
    		 diceHistoryList.add(histroyData);
//    		 if(diceTransportList.size() != 0) {
//	    		 int limit = Math.min(diceTransportList.size(), 6);
//	    		 //TravelTableModel.setRowCount(limit);
//	    		 //for(int i = 0;  i < limit; i++) {
//	    			 this.setDiceTransport(diceTransportList.get(i));
//	    			 this.setDiceDestination(diceDestinationList.get(i));
//	    		      	
//			     //}
//    		 }
         }	 	
    }
    
    public List<String> getDiceTransportList(){
    	return this.diceTransportList;
    }
    
    public List<String> getDiceDestinationList() {
    	return this.diceDestinationList;
    	
    }
    
    public List<String> diceHistoryList() {
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
	public int getTableSize(String tableName) throws SQLException {
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
		return sizeCount;
	}
    
	/*TravelDB() {
    	try {
			
			//int start = this.number;
			//int end = start + 5;
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diceTravelDB", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
                    "postgres", // ログインロール
                    "hagawa2548"); // パスワード
			Statement statement = connection.createStatement();
			
			//this.resultSet = statement.executeQuery("SELECT * FROM travel1");

			int travel1Size = getTableSize(this.travelName);
			
			this.resultSet = statement.executeQuery(String.format("SELECT * FROM %S WHERE dice_id BETWEEN %d AND %d", this.travelName,this.start, this.end));
			
			
			//this.number = end + 1;
			if(end == travel1Size) {
				//this.number = 1;
				
			}
			
			this.diceTransportList = new ArrayList<String>();
	    	this.diceDestinationList = new ArrayList<String>();
	    	this.diceHistoryList = new ArrayList<String>();
	    	
			if(start == 1) {
				
             ResultSetMetaData meta = resultSet.getMetaData();
             int columnCount = meta.getColumnCount();
             while (resultSet.next()) {

            	Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                TravelTableModel.addRow(rowData);
                String transportData = resultSet.getString("dice_Transportation");
	    		 diceTransportList.add(transportData);
	    		 String destinationData = resultSet.getString("dice_destination");
	    		 diceDestinationList.add(destinationData);
	    		 String histroyData = resultSet.getString("dice_histroy");
	    		 diceHistoryList.add(histroyData);
	    		 if(diceTransportList.size() != 0) {
		    		 int limit = Math.min(diceTransportList.size(), 6);
		    		 TravelTableModel.setRowCount(limit);
		    		 for(int i = 0;  i < limit; i++) {
		    			 this.setDiceTransport(diceTransportList.get(i));
		    			 this.setDiceTransport(diceDestinationList.get(i));
		    		      	
				     }
		    		 
		    	 } 	
             }
		    }else {
		    	
		    	
		    	 while (resultSet.next()) {
		    		 String transportData = resultSet.getString("dice_Transportation");
		    		 diceTransportList.add(transportData);
		    		 String destinationData = resultSet.getString("dice_destination");
		    		 diceDestinationList.add(destinationData);
		    		 String histroyData = resultSet.getString("dice_histroy");
		    		 diceHistoryList.add(histroyData);
		    	 } 
		    	 
		    	 if(diceTransportList.size() != 0) {
		    		 int limit = Math.min(diceTransportList.size(), 6);
		    		 TravelTableModel.setRowCount(limit);
		    		 for(int i = 0;  i < limit; i++) {
		    			 this.setDiceTransport(diceTransportList.get(i));
		    		     TravelTableModel.setValueAt(diceDestinationList.get(i), i, 2);
		    		      	
				     }
		    		 
		    	 } 	
		    }
			
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}catch(SQLException e2) {
			e2.printStackTrace();
		}finally {
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
	}*/
    
    
   }

