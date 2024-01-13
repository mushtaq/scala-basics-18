package conc

import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.actor.typed.{ActorSystem, Behavior}
import org.apache.pekko.stream.scaladsl.Source

import scala.concurrent.Future
import concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn
import scala.util.{Failure, Success}
import scala.concurrent.duration.DurationInt

object FutureDemo {

  def printFuture[T](future: Future[T]) = future.onComplete {
    case Failure(exception) => println(exception.getMessage)
    case Success(value) => println(value)
  }

  def main(args: Array[String]): Unit = {
    implicit val actorSystem = ActorSystem(Behaviors.empty, "demo")
    val stream = Source.tick(1.second, 1.second, ())
    stream.runForeach(println)
  }

  def main2(args: Array[String]): Unit = {
    val future3: Future[Int] = Future(1)
    val future4: Future[Int] = Future(100)

    val futures: List[Future[Int]] = List(future3, future4) // .. size is not known
    val future: Future[List[Int]] = Future.sequence(futures)

    printFuture(future.map(xs => xs.sum))

    val result1 = future3.flatMap { v1 =>
      future4.map { v2 =>
        v1 + v2
      }
    }

    val result2 = for {
      v1 <- future3
      v2 <- future4
    } yield v1 + v2

    val result3 = for {
      v1 <- Future(1)
      v2 <- Future(100)
    } yield v1 + v2

    printFuture(result1)
    printFuture(result2)

    StdIn.readLine()
  }

  def main1(args: Array[String]): Unit = {
    val future1: Future[Int] = Future.successful(1)
    val future2: Future[Int] = Future.failed(new RuntimeException("this is future2"))

    val future3: Future[Int] = Future(1)
    val future4: Future[Int] = Future(1 / 0)
    printFuture(future1)
    printFuture(future2)
    printFuture(future3)
    printFuture(future4)

    StdIn.readLine()
  }

}
