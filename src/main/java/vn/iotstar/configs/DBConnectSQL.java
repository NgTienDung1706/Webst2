package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
	public class DBConnectSQL {
		private final String serverName ="DESKTOP-7AIMP95";
		private final String dbName ="ltwebst2";
		private final String portNumber ="1433";
		//private final String instance ="";
		private final String userID ="sa";
		private final String password ="170604";
		public Connection getConnection() throws Exception {
				String url="jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
				//"\\"+instance+
				//if(instance ==null|| instance.trim().isEmpty())
					//url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				return DriverManager.getConnection(url,userID,password);

		}
		public static void main(String[] args) {
			try {
			System.out.println(new DBConnectSQL().getConnection());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
}
