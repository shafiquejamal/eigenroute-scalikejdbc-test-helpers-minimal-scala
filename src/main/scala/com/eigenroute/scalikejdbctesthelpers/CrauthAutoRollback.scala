package com.eigenroute.scalikejdbctesthelpers

import com.eigenroute.scalikejdbchelpers.DBConfig
import scalikejdbc.scalatest.AutoRollback
import scalikejdbc.{ConnectionPool, DB}

trait CrauthAutoRollback extends AutoRollback {
  self: org.scalatest.fixture.Suite =>

  def dBConfig: DBConfig

  override def db(): DB = DB(ConnectionPool.borrow(Symbol(dBConfig.dBName)))
}