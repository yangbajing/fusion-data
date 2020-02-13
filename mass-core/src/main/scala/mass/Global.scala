package mass

import akka.actor.typed.ActorSystem

object Global {
  private var _system: ActorSystem[_] = _

  private[mass] def registerActorSystem(system: ActorSystem[_]): ActorSystem[_] = synchronized {
    if (_system != null) {
      throw new ExceptionInInitializerError("ActorSystem[_] already set.")
    }
    _system = system
    _system
  }

  def system: ActorSystem[_] = synchronized {
    if (_system == null) {
      throw new ExceptionInInitializerError("ActorSystem[_] not set.")
    }
    _system
  }
}
