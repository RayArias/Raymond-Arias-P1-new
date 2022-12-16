package com.revature.erts.intrfcs;

// CRUD = Create, Read, Update, Delete -OR- Open, Read, Put, Close
public interface CRUD_IF<T> {

    public T open();

    public void close(T ifToken);

    public String readln(T ifToken);

    public void putln(String line);

//    public void putln(T ifToken, String line);

    public String readwd(T ifToken);

    public void putwd(String word);

    //   public void putwd(T ifToken, String word);

}
