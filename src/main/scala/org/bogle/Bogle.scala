package org.bogle

import org.slf4j.LoggerFactory
import org.slf4j.Logger
import com.typesafe.config.ConfigFactory
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer

import scala.concurrent.Future
import scala.util.{ Failure, Success }

object Bogle extends App {
  val SCRYFALL_KEY = "scryfall.key"
  val TELEGRAM_TOKEN = "telegram.token"

  val LOG:Logger = LoggerFactory.getLogger(Bogle.getClass())
  val config = ConfigFactory.load()
  LOG.info("Let's start Bogle to be Hexproof")
  LOG.info(s"${SCRYFALL_KEY} => ${config.getString(SCRYFALL_KEY)}") 
  LOG.info(s"${TELEGRAM_TOKEN} => ${config.getString(TELEGRAM_TOKEN)}")


  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher
}

