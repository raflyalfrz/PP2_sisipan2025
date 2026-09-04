package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import model.Mahasiswa;

public class MahasiswaDao {

    public int insert(Mahasiswa mahasiswa) {

        int result = -1;

        try (Connection connection =
                MySqlConnection.getInstance().getConnection()) {

            PreparedStatement statement =
                connection.prepareStatement(
                    "insert into mahasiswa " +
                    "(npm, nama, prodi, semester, alamat) " +
                    "values (?, ?, ?, ?, ?)"
                );

            statement.setString(1, mahasiswa.getNpm());
            statement.setString(2, mahasiswa.getNama());
            statement.setString(3, mahasiswa.getProdi());
            statement.setInt(4, mahasiswa.getSemester());
            statement.setString(5, mahasiswa.getAlamat());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int update(Mahasiswa mahasiswa) {

        int result = -1;

        try (Connection connection =
                MySqlConnection.getInstance().getConnection()) {

            PreparedStatement statement =
                connection.prepareStatement(
                    "update mahasiswa set " +
                    "nama = ?, prodi = ?, semester = ?, alamat = ? " +
                    "where npm = ?"
                );

            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getProdi());
            statement.setInt(3, mahasiswa.getSemester());
            statement.setString(4, mahasiswa.getAlamat());
            statement.setString(5, mahasiswa.getNpm());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int delete(Mahasiswa mahasiswa) {

        int result = -1;

        try (Connection connection =
                MySqlConnection.getInstance().getConnection()) {

            PreparedStatement statement =
                connection.prepareStatement(
                    "delete from mahasiswa where npm = ?"
                );

            statement.setString(1, mahasiswa.getNpm());

            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Mahasiswa> findAll() {

        List<Mahasiswa> list = new ArrayList<>();

        try (Connection connection =
                MySqlConnection.getInstance().getConnection();
             Statement statement =
                connection.createStatement()) {

            try (ResultSet resultSet =
                    statement.executeQuery(
                        "select * from mahasiswa"
                    )) {

                while (resultSet.next()) {

                    Mahasiswa mahasiswa = new Mahasiswa();

                    mahasiswa.setNpm(
                        resultSet.getString("npm")
                    );

                    mahasiswa.setNama(
                        resultSet.getString("nama")
                    );

                    mahasiswa.setProdi(
                        resultSet.getString("prodi")
                    );

                    mahasiswa.setSemester(
                        resultSet.getInt("semester")
                    );

                    mahasiswa.setAlamat(
                        resultSet.getString("alamat")
                    );

                    list.add(mahasiswa);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}