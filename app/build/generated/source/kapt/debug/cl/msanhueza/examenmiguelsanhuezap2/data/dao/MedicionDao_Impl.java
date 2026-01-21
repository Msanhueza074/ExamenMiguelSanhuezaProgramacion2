package cl.msanhueza.examenmiguelsanhuezap2.data.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class MedicionDao_Impl implements MedicionDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Medicion> __insertAdapterOfMedicion;

  public MedicionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfMedicion = new EntityInsertAdapter<Medicion>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `mediciones` (`id`,`tipo`,`valor`,`fecha`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final Medicion entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTipo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getTipo());
        }
        statement.bindLong(3, entity.getValor());
        if (entity.getFecha() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getFecha());
        }
      }
    };
  }

  @Override
  public Object insert(final Medicion medicion, final Continuation<? super Unit> $completion) {
    if (medicion == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMedicion.insert(_connection, medicion);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<Medicion>> getAll() {
    final String _sql = "SELECT * FROM mediciones ORDER BY id DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"mediciones"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTipo = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "tipo");
        final int _columnIndexOfValor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "valor");
        final int _columnIndexOfFecha = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "fecha");
        final List<Medicion> _result = new ArrayList<Medicion>();
        while (_stmt.step()) {
          final Medicion _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTipo;
          if (_stmt.isNull(_columnIndexOfTipo)) {
            _tmpTipo = null;
          } else {
            _tmpTipo = _stmt.getText(_columnIndexOfTipo);
          }
          final int _tmpValor;
          _tmpValor = (int) (_stmt.getLong(_columnIndexOfValor));
          final String _tmpFecha;
          if (_stmt.isNull(_columnIndexOfFecha)) {
            _tmpFecha = null;
          } else {
            _tmpFecha = _stmt.getText(_columnIndexOfFecha);
          }
          _item = new Medicion(_tmpId,_tmpTipo,_tmpValor,_tmpFecha);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
