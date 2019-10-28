package org.bogle.scryfall

import akka.actor.{Actor, ActorLogging}

class ScryfallActor extends Actor 
  with ActorLogging {
  
  def receive = {
    log.info("receive msg in Scryfall")
    ???
  }
}
