package org.bogle

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.scaladsl.Sink
import akka.stream.scaladsl.Source
import com.typesafe.config.ConfigFactory
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.{Await, Future}

object Bogle extends App {
  val SCRYFALL_KEY = "scryfall.key"
  val TELEGRAM_TOKEN = "telegram.token"

  val LOG: Logger = LoggerFactory.getLogger(Bogle.getClass())
  val config = ConfigFactory.load()
  LOG.info("Let's start Bogle to be Hexproof")
  LOG.info(s"${SCRYFALL_KEY} => ${config.getString(SCRYFALL_KEY)}")
  LOG.info(s"${TELEGRAM_TOKEN} => ${config.getString(TELEGRAM_TOKEN)}")


  implicit val system = ActorSystem()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  val route =
    path("card") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }

  val serverSource: Source[Http.IncomingConnection, Future[Http.ServerBinding]] =
    Http().bind(interface = "localhost", port = 8080)
  val bindingFuture: Future[Http.ServerBinding] =
    serverSource.to(Sink.foreach { connection => // foreach materializes the source
      println("Accepted new connection from " + connection.remoteAddress)
    }).run()

}
