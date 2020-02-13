package model.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.JDBCMySQLConnection;
import model.entity.EnseignantEntite;

public class EnseignantTransaction extends EnseignantEntite{
	public void create() {
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "INSERT INTO enseignant(matricule, nom, prenom, adresse) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int matricule = this.getMatricule();
			String nom = this.getNom();
			String prenom = this.getPrenom();
			String adresse = this.getAdresse();
			statement.setInt(1, matricule);
			statement.setString(2, nom);
			statement.setString(3, prenom);
			statement.setString(4, adresse);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public EnseignantEntite read() {
		ResultSet rs = null;
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "SELECT * FROM enseignant WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, this.getId());
			rs = statement.executeQuery();
			if(rs.next()) {
				this.setId(rs.getInt("id"));
				this.setMatricule(rs.getInt("matricule"));
				this.setNom(rs.getString("nom"));
				this.setPrenom(rs.getString("prenom"));
				this.setAdresse(rs.getString("adresse"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return this;
	}
	
	public void update() {
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "UPDATE enseignant SET matricule = ?, nom = ?, prenom = ?, adresse = ? WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int matricule = this.getMatricule();
			String nom = this.getNom();
			String prenom = this.getPrenom();
			String adresse = this.getAdresse();
			int id = this.getId();
			statement.setInt(1, matricule);
			statement.setString(2, nom);
			statement.setString(3, prenom);
			statement.setString(4, adresse);
			statement.setInt(5, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void delete() {
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "DELETE FROM enseignant WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int id = this.getId();
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList readall(){
		ArrayList ids = new ArrayList();
		ResultSet rs = null;
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "SELECT id FROM enseignant";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				ids.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return ids;
	}
	
}
