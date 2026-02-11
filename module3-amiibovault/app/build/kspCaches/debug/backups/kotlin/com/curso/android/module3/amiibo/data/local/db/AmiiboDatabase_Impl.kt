package com.curso.android.module3.amiibo.`data`.local.db

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.curso.android.module3.amiibo.`data`.local.dao.AmiiboDao
import com.curso.android.module3.amiibo.`data`.local.dao.AmiiboDao_Impl
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AmiiboDatabase_Impl : AmiiboDatabase() {
  private val _amiiboDao: Lazy<AmiiboDao> = lazy {
    AmiiboDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(2,
        "6d41dd80aa01b553f14c648910be0bb0", "9c68cf94061bea3182c84cf63f6fe157") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `amiibos` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `gameSeries` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `amiibo_details` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `character` TEXT NOT NULL, `gameSeries` TEXT NOT NULL, `amiiboSeries` TEXT NOT NULL, `type` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `releaseNA` TEXT, `releaseEU` TEXT, `releaseJP` TEXT, `releaseAU` TEXT, `compatibleGamesJson` TEXT NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6d41dd80aa01b553f14c648910be0bb0')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `amiibos`")
        connection.execSQL("DROP TABLE IF EXISTS `amiibo_details`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsAmiibos: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsAmiibos.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiibos.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiibos.put("gameSeries", TableInfo.Column("gameSeries", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiibos.put("imageUrl", TableInfo.Column("imageUrl", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysAmiibos: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesAmiibos: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoAmiibos: TableInfo = TableInfo("amiibos", _columnsAmiibos, _foreignKeysAmiibos,
            _indicesAmiibos)
        val _existingAmiibos: TableInfo = read(connection, "amiibos")
        if (!_infoAmiibos.equals(_existingAmiibos)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |amiibos(com.curso.android.module3.amiibo.data.local.entity.AmiiboEntity).
              | Expected:
              |""".trimMargin() + _infoAmiibos + """
              |
              | Found:
              |""".trimMargin() + _existingAmiibos)
        }
        val _columnsAmiiboDetails: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsAmiiboDetails.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("character", TableInfo.Column("character", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("gameSeries", TableInfo.Column("gameSeries", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("amiiboSeries", TableInfo.Column("amiiboSeries", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("type", TableInfo.Column("type", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("imageUrl", TableInfo.Column("imageUrl", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("releaseNA", TableInfo.Column("releaseNA", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("releaseEU", TableInfo.Column("releaseEU", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("releaseJP", TableInfo.Column("releaseJP", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("releaseAU", TableInfo.Column("releaseAU", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsAmiiboDetails.put("compatibleGamesJson", TableInfo.Column("compatibleGamesJson",
            "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysAmiiboDetails: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesAmiiboDetails: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoAmiiboDetails: TableInfo = TableInfo("amiibo_details", _columnsAmiiboDetails,
            _foreignKeysAmiiboDetails, _indicesAmiiboDetails)
        val _existingAmiiboDetails: TableInfo = read(connection, "amiibo_details")
        if (!_infoAmiiboDetails.equals(_existingAmiiboDetails)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |amiibo_details(com.curso.android.module3.amiibo.data.local.entity.AmiiboDetailEntity).
              | Expected:
              |""".trimMargin() + _infoAmiiboDetails + """
              |
              | Found:
              |""".trimMargin() + _existingAmiiboDetails)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "amiibos", "amiibo_details")
  }

  public override fun clearAllTables() {
    super.performClear(false, "amiibos", "amiibo_details")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(AmiiboDao::class, AmiiboDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun amiiboDao(): AmiiboDao = _amiiboDao.value
}
