package com.curso.android.module3.amiibo.`data`.local.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performInTransactionSuspending
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.curso.android.module3.amiibo.`data`.local.entity.AmiiboDetailEntity
import com.curso.android.module3.amiibo.`data`.local.entity.AmiiboEntity
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AmiiboDao_Impl(
  __db: RoomDatabase,
) : AmiiboDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfAmiiboEntity: EntityInsertAdapter<AmiiboEntity>

  private val __insertAdapterOfAmiiboDetailEntity: EntityInsertAdapter<AmiiboDetailEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfAmiiboEntity = object : EntityInsertAdapter<AmiiboEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `amiibos` (`id`,`name`,`gameSeries`,`imageUrl`) VALUES (?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: AmiiboEntity) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.gameSeries)
        statement.bindText(4, entity.imageUrl)
      }
    }
    this.__insertAdapterOfAmiiboDetailEntity = object : EntityInsertAdapter<AmiiboDetailEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `amiibo_details` (`id`,`name`,`character`,`gameSeries`,`amiiboSeries`,`type`,`imageUrl`,`releaseNA`,`releaseEU`,`releaseJP`,`releaseAU`,`compatibleGamesJson`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: AmiiboDetailEntity) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.character)
        statement.bindText(4, entity.gameSeries)
        statement.bindText(5, entity.amiiboSeries)
        statement.bindText(6, entity.type)
        statement.bindText(7, entity.imageUrl)
        val _tmpReleaseNA: String? = entity.releaseNA
        if (_tmpReleaseNA == null) {
          statement.bindNull(8)
        } else {
          statement.bindText(8, _tmpReleaseNA)
        }
        val _tmpReleaseEU: String? = entity.releaseEU
        if (_tmpReleaseEU == null) {
          statement.bindNull(9)
        } else {
          statement.bindText(9, _tmpReleaseEU)
        }
        val _tmpReleaseJP: String? = entity.releaseJP
        if (_tmpReleaseJP == null) {
          statement.bindNull(10)
        } else {
          statement.bindText(10, _tmpReleaseJP)
        }
        val _tmpReleaseAU: String? = entity.releaseAU
        if (_tmpReleaseAU == null) {
          statement.bindNull(11)
        } else {
          statement.bindText(11, _tmpReleaseAU)
        }
        statement.bindText(12, entity.compatibleGamesJson)
      }
    }
  }

  public override suspend fun insertAll(amiibos: List<AmiiboEntity>): Unit = performSuspending(__db,
      false, true) { _connection ->
    __insertAdapterOfAmiiboEntity.insert(_connection, amiibos)
  }

  public override suspend fun insertDetail(detail: AmiiboDetailEntity): Unit =
      performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfAmiiboDetailEntity.insert(_connection, detail)
  }

  public override suspend fun replaceAll(amiibos: List<AmiiboEntity>): Unit =
      performInTransactionSuspending(__db) {
    super@AmiiboDao_Impl.replaceAll(amiibos)
  }

  public override fun getAllAmiibos(): Flow<List<AmiiboEntity>> {
    val _sql: String = "SELECT * FROM amiibos ORDER BY name ASC"
    return createFlow(__db, false, arrayOf("amiibos")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfGameSeries: Int = getColumnIndexOrThrow(_stmt, "gameSeries")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _result: MutableList<AmiiboEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: AmiiboEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpGameSeries: String
          _tmpGameSeries = _stmt.getText(_columnIndexOfGameSeries)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          _item = AmiiboEntity(_tmpId,_tmpName,_tmpGameSeries,_tmpImageUrl)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getCount(): Flow<Int> {
    val _sql: String = "SELECT COUNT(*) FROM amiibos"
    return createFlow(__db, false, arrayOf("amiibos")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getAmiibosPage(limit: Int, offset: Int): List<AmiiboEntity> {
    val _sql: String = "SELECT * FROM amiibos ORDER BY name ASC LIMIT ? OFFSET ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, limit.toLong())
        _argIndex = 2
        _stmt.bindLong(_argIndex, offset.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfGameSeries: Int = getColumnIndexOrThrow(_stmt, "gameSeries")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _result: MutableList<AmiiboEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: AmiiboEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpGameSeries: String
          _tmpGameSeries = _stmt.getText(_columnIndexOfGameSeries)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          _item = AmiiboEntity(_tmpId,_tmpName,_tmpGameSeries,_tmpImageUrl)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getTotalCount(): Int {
    val _sql: String = "SELECT COUNT(*) FROM amiibos"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _result: Int
        if (_stmt.step()) {
          val _tmp: Int
          _tmp = _stmt.getLong(0).toInt()
          _result = _tmp
        } else {
          _result = 0
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getDetailByName(name: String): AmiiboDetailEntity? {
    val _sql: String = "SELECT * FROM amiibo_details WHERE name = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, name)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfCharacter: Int = getColumnIndexOrThrow(_stmt, "character")
        val _columnIndexOfGameSeries: Int = getColumnIndexOrThrow(_stmt, "gameSeries")
        val _columnIndexOfAmiiboSeries: Int = getColumnIndexOrThrow(_stmt, "amiiboSeries")
        val _columnIndexOfType: Int = getColumnIndexOrThrow(_stmt, "type")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _columnIndexOfReleaseNA: Int = getColumnIndexOrThrow(_stmt, "releaseNA")
        val _columnIndexOfReleaseEU: Int = getColumnIndexOrThrow(_stmt, "releaseEU")
        val _columnIndexOfReleaseJP: Int = getColumnIndexOrThrow(_stmt, "releaseJP")
        val _columnIndexOfReleaseAU: Int = getColumnIndexOrThrow(_stmt, "releaseAU")
        val _columnIndexOfCompatibleGamesJson: Int = getColumnIndexOrThrow(_stmt,
            "compatibleGamesJson")
        val _result: AmiiboDetailEntity?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpCharacter: String
          _tmpCharacter = _stmt.getText(_columnIndexOfCharacter)
          val _tmpGameSeries: String
          _tmpGameSeries = _stmt.getText(_columnIndexOfGameSeries)
          val _tmpAmiiboSeries: String
          _tmpAmiiboSeries = _stmt.getText(_columnIndexOfAmiiboSeries)
          val _tmpType: String
          _tmpType = _stmt.getText(_columnIndexOfType)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          val _tmpReleaseNA: String?
          if (_stmt.isNull(_columnIndexOfReleaseNA)) {
            _tmpReleaseNA = null
          } else {
            _tmpReleaseNA = _stmt.getText(_columnIndexOfReleaseNA)
          }
          val _tmpReleaseEU: String?
          if (_stmt.isNull(_columnIndexOfReleaseEU)) {
            _tmpReleaseEU = null
          } else {
            _tmpReleaseEU = _stmt.getText(_columnIndexOfReleaseEU)
          }
          val _tmpReleaseJP: String?
          if (_stmt.isNull(_columnIndexOfReleaseJP)) {
            _tmpReleaseJP = null
          } else {
            _tmpReleaseJP = _stmt.getText(_columnIndexOfReleaseJP)
          }
          val _tmpReleaseAU: String?
          if (_stmt.isNull(_columnIndexOfReleaseAU)) {
            _tmpReleaseAU = null
          } else {
            _tmpReleaseAU = _stmt.getText(_columnIndexOfReleaseAU)
          }
          val _tmpCompatibleGamesJson: String
          _tmpCompatibleGamesJson = _stmt.getText(_columnIndexOfCompatibleGamesJson)
          _result =
              AmiiboDetailEntity(_tmpId,_tmpName,_tmpCharacter,_tmpGameSeries,_tmpAmiiboSeries,_tmpType,_tmpImageUrl,_tmpReleaseNA,_tmpReleaseEU,_tmpReleaseJP,_tmpReleaseAU,_tmpCompatibleGamesJson)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun searchAmiibos(query: String): Flow<List<AmiiboEntity>> {
    val _sql: String =
        " SELECT * FROM amiibos WHERE name LIKE '%' || ? || '%' COLLATE NOCASE ORDER BY name ASC "
    return createFlow(__db, false, arrayOf("amiibos")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, query)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfGameSeries: Int = getColumnIndexOrThrow(_stmt, "gameSeries")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _result: MutableList<AmiiboEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: AmiiboEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpGameSeries: String
          _tmpGameSeries = _stmt.getText(_columnIndexOfGameSeries)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          _item = AmiiboEntity(_tmpId,_tmpName,_tmpGameSeries,_tmpImageUrl)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteAll() {
    val _sql: String = "DELETE FROM amiibos"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
