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

statement.executeUpdate();





PreparedStatement statement =
    connection.prepareStatement(
        "delete from mahasiswa where npm = ?"
    );

statement.setString(1, mahasiswa.getNpm());

statement.executeUpdate();





mahasiswaDao.delete(mahasiswa);

mainFrame.refreshData();
mainFrame.resetForm();