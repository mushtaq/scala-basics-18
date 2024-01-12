package conc

import java.util.concurrent.{Executors, Future}

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

    val results: Seq[Future[_]] = (1 to 100).map { x =>
      val runnable: Runnable = () => account.deposit(1)
      val javaFuture = executorService.submit(runnable)
      javaFuture
    }

    // Seq[Future[_]] => Future[Seq[_]]

    results.foreach(_.get())

    println(account.getBalance())
  }
}