package layering_1.MODEL;

import java.sql.SQLException;

public interface IApi {

    public void onBotonCargar(String nombre, String telefono, String region) throws SQLException;
}
