package org.springframework.samples.petclinic;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		
		
		
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
					
			statement = connection.createStatement();
			
//			String sql = "SELECT * FROM petclinic.owners";
//			ResultSet rs = statement.executeQuery(sql);
//			int a = 0;
//			while(rs.next()) {
//			System.out.print(rs.getString(1));
//			a = rs.getString(1).length();
//			while(a < 15) {
//				System.out.print(" ");
//				a++;
//			}
//			System.out.print(rs.getString(2));
//			a = rs.getString(2).length();
//			while(a < 15) {
//				System.out.print(" ");
//				a++;
//			}
//			System.out.print(rs.getString(3));
//			a = rs.getString(3).length();
//			while(a < 15) {
//				System.out.print(" ");
//				a++;
//			}
//			System.out.print(rs.getString(4));
//			a = rs.getString(4).length();
//			while(a < 25) {
//				System.out.print(" ");
//				a++;
//			}
//			System.out.print(rs.getString(5));
//			a = rs.getString(5).length();
//			while(a < 15) {
//				System.out.print(" ");
//				a++;
//			}
//			System.out.print(rs.getString(6));
//			a = rs.getString(6).length();
//			while(a < 15) {
//				System.out.print(" ");
//				a++;
//			}
//			System.out.println(" ");
//		}
			///////////////////////////////////////////////////////////
//			String sql = "INSERT INTO petclinic.owners (id, first_name, last_name, address, city, telephone) VALUES ('11','David','León Ruiz','geranio','Sevilla','639110557')";
//			int b = statement.executeUpdate(sql);
			/////////////////////////////////////////////////////////
//			String sql = "UPDATE petclinic.owners SET city = 'Cadiz' WHERE id = '11'";
//			int b = statement.executeUpdate(sql);
			
		////////////////////////////////////////////////////////////
//				String buscar = "Da";
//				buscar = "%" + buscar + "%";
//				String sql = "SELECT * FROM petclinic.owners WHERE first_name LIKE '" + buscar +"' OR last_name LIKE '" + buscar +"'";
//				ResultSet rs = statement.executeQuery(sql);
//				int a = 0;
//				while(rs.next()) {
//					System.out.print(rs.getString(1));
//					a = rs.getString(1).length();
//					while(a < 15) {
//						System.out.print(" ");
//						a++;
//					}
//					System.out.print(rs.getString(2));
//					a = rs.getString(2).length();
//					while(a < 15) {
//						System.out.print(" ");
//						a++;
//					}
//					System.out.print(rs.getString(3));
//					a = rs.getString(3).length();
//					while(a < 15) {
//						System.out.print(" ");
//						a++;
//					}
//					System.out.print(rs.getString(4));
//					a = rs.getString(4).length();
//					while(a < 25) {
//						System.out.print(" ");
//						a++;
//					}
//					System.out.print(rs.getString(5));
//					a = rs.getString(5).length();
//					while(a < 15) {
//						System.out.print(" ");
//						a++;
//					}
//					System.out.print(rs.getString(6));
//					a = rs.getString(6).length();
//					while(a < 15) {
//						System.out.print(" ");
//						a++;
//					}
//					System.out.println(" ");
//				}		
//				
				////////////////////////////////////////////////////////////////////////////////////
				
				//String id = "13";
//				String first_name = "pepe";
//				String last_name = "gomez";
//				String address = "12";
//				String city = "sevilla";
//				String telephone = "123456789";
				PreparedStatement preparedStatement = null;
				Owner yo = new Owner();
				Pet mascota = new Pet();
				yo.setId(13);
				yo.setFirstName("David");
				yo.setLastName("León Ruiz");
				yo.setAddress("Geranio 7");
				yo.setCity("Sevilla");
				yo.setTelephone("639110557");
				
				mascota.setBirthDate(new Date(2010, 4, 12));
				mascota.setId(14);
				mascota.setName("Firulais");
//				mascota.setType();
				
				String sql = "INSERT INTO petclinic.owners (id, first_name, last_name, address, city, telephone) VALUES (?,?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, yo.getId());
				preparedStatement.setString(2, yo.getFirstName());
				preparedStatement.setString(3, yo.getLastName());
				preparedStatement.setString(4, yo.getAddress());
				preparedStatement.setString(5, yo.getCity());
				preparedStatement.setString(6, yo.getTelephone());
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
				sql = "INSERT INTO petclinic.pets (id, name, birth_date, type_id, owner_id) VALUES (?,?,?,?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, mascota.getId());
				preparedStatement.setString(2, mascota.getName());
				preparedStatement.setDate(3, (java.sql.Date) mascota.getBirthDate());
				preparedStatement.setInt(4, mascota.getType().getId());
				preparedStatement.setInt(5, yo.getId());
				preparedStatement.executeUpdate();
				preparedStatement.close();
				
				
			
			
			
			
			
			
		
			
			} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
		
		
		
		
		
		
	}

}
