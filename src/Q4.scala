import scala.::



object Q4 {
  class Account(id:String,n: Int, b: Double) {
    val nic: String = id
    val acnumber: Int = n
    var balance: Double = b

    override def toString =
      "[" + nic + ":" + acnumber + ":" + balance + "]"



    def withdraw(a:Double) =
      this.balance=this.balance-a
    def deposit(a:Double) =
      this.balance=this.balance+a
    def transfer(a:Account,b:Double): Unit = {
      a.balance=a.balance+b
      this.balance=this.balance-b
    };

    var m=0;
    val find=(n:String,b:List[Account])=> b.filter(x=>x.nic.equals(n))

    val overdraft=(b:List[Account])=> b.filter(x=>x.balance<0)
    //val total_balance=(b:List[Account])=> b.reduce(
    //  val total_balance = (b: List[Account]) => b.reduce((x,y)=>x.balance+y.balance)

    val interest=(b:List[Account])=>b.map((x)=>if(x.balance>=0){x.balance=x.balance+0.05*x.balance}else{x.balance=x.balance+0.1*x.balance})
  }
  def main(args: Array[String]): Unit = {

    val acc1=new Account("abcd",23,200.00)
    val acc2=new Account("qwer",24,100.00)
    val acc3=new Account("mnop",34,-300.00)
    val acc4=new Account("zxcv",29,500.00)

    var bank: List[Account] = List(acc1,acc2,acc3,acc4);


    println("Overdraft: "+acc2.overdraft(bank));
    println("balance in Account1 before transfer: "+acc1.balance)
    println("balance in Account2 before transfer: "+acc2.balance)

    acc1.transfer(acc2,50.00)
    println("balance in Account1 before transfer: "+acc1.balance)
    println("balance in Account2 before transfer: "+acc2.balance)


    println("balance in account1 before apply interest: "+acc1.balance)
    acc1.interest(bank)
    println("balance in account1 after apply interest: "+acc1.balance)

  }




}
