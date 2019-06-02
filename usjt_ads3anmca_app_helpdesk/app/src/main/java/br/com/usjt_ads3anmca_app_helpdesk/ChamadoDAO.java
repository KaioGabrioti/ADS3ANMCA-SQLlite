public class ChamadoDAO {
    private Context context;

    public ChamadoDAO(Context context){
        this.context = context;
    }

    public List<Chamado> busca(String chave) {

            ChamadoDBHelper dbHelper = new ChamadoDBHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            List<Chamado> chamados = new ArrayList<>();

            String command = String.format(
                Locale.getDefault(),
                "SELECT * FROM %s INNER JOIN %s ON %s.%s = %s.%s",
                HelpDeskContract.FilaContract.TABLE_NAME,
                HelpDeskContract.ChamadoContract.TABLE_NAME,
                HelpDeskContract.FilaContract.TABLE_NAME,
                HelpDeskContract.FilaContract.COLUMN_NAME_ID,
                HelpDeskContract.ChamadoContract.TABLE_NAME,
                HelpDeskContract.FilaContract.COLUMN_NAME_ID,
                HelpDeskContract.FilaContract.TABLE_NAME,
                HelpDeskContract.FilaContract.COLUMN_NAME_NOME
            );

            Cursor cursor = db.rawQuery(command, null);

            while (cursor.moveToNext()){
                int idChamado = cursor.getInt(
                                cursor.getColumnIndex(
                                            String.format(
                                                Locale.getDefault(),
                                                "%s.%s",
                                                HelpDeskContract.ChamadoContract.TABLE_NAME,
                                                HelpDeskContract.ChamadoContract.COLUMN_NAME_ID)));
                String descricao = cursor.getString(
                                    cursor.getColumnIndex(
                                                String.format(
                                                    Locale.getDefault(),
                                                    "%s.%s",
                                                    HelpDeskContract.ChamadoContract.TABLE_NAME,
                                                    HelpDeskContract.ChamadoContract.COLUMN_NAME_DESCRICAO)));
                String status = cursor.getString(
                                cursor.getColumnIndex(
                                            String.format(
                                                    Locale.getDefault(),
                                                    "%s.%s",
                                                    HelpDeskContract.ChamadoContract.TABLE_NAME,
                                                    HelpDeskContract.ChamadoContract.COLUMN_NAME_STATUS)));
                long dtAbertura = cursor.getLong(
                                cursor.getColumnIndex(
                                            String.format(
                                                    Locale.getDefault(),
                                                    "%s.%s",
                                                    HelpDeskContract.ChamadoContract.TABLE_NAME,
                                                    HelpDeskContract.ChamadoContract.COLUMN_NAME_DATA_ABERTURA)));
                long dtFechamento = cursor.getLong(
                                    cursor.getColumnIndex(
                                                String.format(
                                                        Locale.getDefault(),
                                                        "%s.%s",
                                                        HelpDeskContract.ChamadoContract.TABLE_NAME,
                                                        HelpDeskContract.ChamadoContract.COLUMN_NAME_DATA_FECHAMENTO)));
                String nomeFila = cursor.getString(
                                cursor.getColumnIndex(
                                            String.format(
                                                    Locale.getDefault(),
                                                    "%s.%s",
                                                    HelpDeskContract.FilaContract.TABLE_NAME,
                                                    HelpDeskContract.FilaContract.COLUMN_NAME_NOME)));
                int idFila = cursor.getInt(
                            cursor.getColumnIndex(
                                        String.format(
                                                Locale.getDefault(),
                                                "%s.%s",
                                                HelpDeskContract.FilaContract.TABLE_NAME,
                                                HelpDeskContract.FilaContract.COLUMN_NAME_ID)));
                int iconId = cursor.getInt(
                            cursor.getColumnIndex(
                                        String.format(
                                                Locale.getDefault(),
                                                "%s.%s",
                                                HelpDeskContract.FilaContract.TABLE_NAME,
                                                HelpDeskContract.FilaContract.COLUMN_NAME_ICON_ID)));

                Chamado chamado = new Chamado(idChamado, new Fila(idFila, nomeFila, iconId),descricao, new Date(dtAbertura), dtFechamento > 0 ? new Date(dtFechamento) : null, status);

                chamados.add(chamado);
        }
            cursor.close();
            db.close();
            dbHelper.close();
            return chamados;
    }
}