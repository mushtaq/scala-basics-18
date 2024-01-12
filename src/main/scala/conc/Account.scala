package conc

import java.util.concurrent.{Executors, Future => JFuture}
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future, Promise}

class Account {

  private var balance = 0

  def deposit(amount: Int) =
    balance += amount

  def getBalance() = balance

}

object Account {
  def main(args: Array[String]): Unit = {
    val account = new Account

    val executorService = Executors.newFixedThreadPool(10)
    implicit val ec = ExecutionContext.fromExecutorService(executorService)

    val results: Seq[Future[Unit]] = (1 to 100).map { x =>
      val p = Promise[Unit]()

      val runnable: Runnable = { () =>
        account.deposit(1)
        p.success(())
      }
      executorService.submit(runnable)

      p.future
    }

    // Seq[Future[_]] => Future[Seq[_]]
    val future: Future[Seq[Unit]] = Future.sequence(results)

    Await.result(future, 10.seconds)
    println(account.getBalance())
  }
}
