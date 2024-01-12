package conc

import java.util.concurrent.{Executors, Future => JFuture}
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future, Promise}

class Account {

  private val executorService = Executors.newFixedThreadPool(1)
  private implicit val ec: ExecutionContext =
    ExecutionContext.fromExecutorService(executorService)

  private var balance = 0

  def deposit(amount: Int) = Future {
    // atomic block
    // step1
    // step2
    // step3
    balance += amount
  }

  def getBalance() = Future {
    balance
  }

  def shutdown() = executorService.shutdown()
}

object Account {
  implicit class RichFuture[T](future: Future[T]) {
    def block(): T = Await.result(future, 10.seconds)
  }

  def main(args: Array[String]): Unit = {
    val account = new Account

    val executorService = Executors.newFixedThreadPool(10)
    implicit val ec = ExecutionContext.fromExecutorService(executorService)

    val results: Seq[Future[Future[Unit]]] = (1 to 100).map { x =>
      val future = account.deposit(1)
      Future(future)
    }

    // Seq[Future[_]] => Future[Seq[_]]
    val future: Future[Seq[Unit]] = Future.sequence(results.map(_.flatten))

    future.block()
    println(account.getBalance().block())

    account.shutdown()
    executorService.shutdown()
  }
}
