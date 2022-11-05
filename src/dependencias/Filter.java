package dependencias;

public interface Filter<T>
{
    public boolean isAccept(T record);
}
