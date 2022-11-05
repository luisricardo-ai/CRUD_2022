package dependencias;

import java.util.ArrayList;

public interface IDao<T,E>
{
    // CRUD
    public void create( T objeto );
    public T read(E primaryKey);
    public ArrayList<T> readAll();
    public ArrayList<T> readAll( Filter<T> filtro );
    public void update( T objeto );
    public void delete(E primaryKey);
}
