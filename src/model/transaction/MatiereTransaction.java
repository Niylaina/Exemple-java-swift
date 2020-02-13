package model.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.JDBCMySQLConnection;
import model.entity.MatiereEntite;;

public class MatiereTransaction extends MatiereEntite {
	public void create() {
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "INSERT INTO matiere(intitule, htotal, htptd, enseignant) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			String intitule = this.getIntitule();
			int htotal = this.gethT();
			int htptd = this.gethP();
			int enseignant = this.getEnseignant();
			statement.setString(1, intitule);
			statement.setInt(2, htotal);
			statement.setInt(3, htptd);
			statement.setInt(4, enseignant);
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

	public MatiereEntite read() {
		ResultSet rs = null;
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "SELECT * FROM matiere WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, this.getId());
			rs = statement.executeQuery();
			if(rs.next()) {
				this.setId(rs.getInt("id"));
				this.setIntitule(rs.getString("intitule"));
				this.sethT(rs.getInt("htotal"));
				this.sethP(rs.getInt("htptd"));
				this.setEnseignant(rs.getInt("enseignant"));
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
		String sql = "UPDATE matiere SET intitule = ?, htotal = ?, htptd = ? WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			String intitule = this.getIntitule();
			int htotal = this.gethT();
			int htptd = this.gethP();
			int id = this.getId();
			statement.setString(1, intitule);
			statement.setInt(2, htotal);
			statement.setInt(3, htptd);
			statement.setInt(4, id);
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
		String sql = "DELETE FROM matiere WHERE id = ?";
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
	public static ArrayList readall(int enseignant){
		System.out.print(enseignant);
		ArrayList ids = new ArrayList();
		ResultSet rs = null;
		Connection connection = JDBCMySQLConnection.getConnection();
		String sql = "SELECT id FROM matiere WHERE enseignant = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, enseignant);
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
