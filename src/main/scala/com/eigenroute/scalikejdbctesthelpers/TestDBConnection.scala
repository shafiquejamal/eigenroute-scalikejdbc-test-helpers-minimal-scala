package com.eigenroute.scalikejdbctesthelpers

import org.scalatest.BeforeAndAfterEach
import scalikejdbc.{DBSession, SQL}

trait TestDBConnection extends InitialMigration { this: CrauthAutoRollback with BeforeAndAfterEach =>

  override val dBConfig = new ScalikeJDBCTestDBConfig()

  def sqlToExecute: Vector[SQL[_, _]]

  override def fixture(implicit session: DBSession) {
    migrate(dBConfig)
    sqlToExecute.foreach(_.update.apply())
  }

  override def beforeEach() {
    dBConfig.setUpAllDB()
  }

  override def afterEach() {
    dBConfig.closeAll()
  }

}
