package webframe.dao;

public interface BaseDao<T> {

    public T insert(T t) throws Exception;


    public T update(T t)throws Exception;


    public T findById(String id)throws Exception;

    public T list() throws Exception;

    public int  deteteById(String id)throws Exception;

}
