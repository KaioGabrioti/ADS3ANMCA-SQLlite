package br.com.usjt_ads3anmca_app_helpdesk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChamadoDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "chamados.db";
    private static final int DB_VERSION = 1;
    public ChamadoDBHelper (Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HelpDeskContract.createTableFila());
        db.execSQL(HelpDeskContract.createTableChamado());
        db.execSQL(HelpDeskContract.insertFilas());
        db.execSQL(HelpDeskContract.insertChamados());
    }

    @Override public void onOpen(SQLiteDatabase db) {
        db.execSQL(HelpDeskContract.ChamadoContract.DROP_TABLE);
        db.execSQL(HelpDeskContract.FilaContract.DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
