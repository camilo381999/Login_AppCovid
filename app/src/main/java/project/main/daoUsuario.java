package project.main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tabla = "create table usuarios(id integer primary key autoincrement, usuario text, pass text, nombre text, ap text)";

    public daoUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();

    }

    public boolean insertUsuario(Usuario u) {
        if (buscar(u.getUsuario()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("usuario", u.getUsuario());
            cv.put("pass", u.getPassword());
            cv.put("nombre", u.getNombre());
            cv.put("ap", u.getApellido());
            cv.put("dir",u.getDireccion());
            cv.put("edad",u.getEdad());
            cv.put("cedula",u.getCedula());
            cv.put("genero",u.getGenero());


            return (sql.insert("usuario", null, cv) > 0);
        } else {
            return false;
        }
    }

    private int buscar(String u) {
        int x = 0;
        lista = selectUsuarios();
        for (Usuario us : lista) {
            if (us.getUsuario().equals(u)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {

                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombre(cr.getString(3));
                u.setApellido(cr.getString(4));
                u.setGenero(cr.getString(5));
                u.setDireccion(cr.getString(6));
                u.setCedula(cr.getString(7));
                u.setEdad(cr.getString(8));

                lista.add(u);
            } while (cr.moveToNext());
        }
        return lista;
    }

}
