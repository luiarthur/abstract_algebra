def ack(x:Long, y:Long, numEvals:Long=1):(Long, Long) = {
  if (numEvals % 100000 == 0) println(numEvals)
  (x, y) match {
    case (0, b) => (b + 1, numEvals)
    case (a, 0) => ack(a - 1, 1, numEvals + 1)
    case _ => {
      val (b, numEvalsNew) = ack(x, y - 1, numEvals + 1)
      ack(x - 1, b, numEvalsNew + 1)
    }
  }
}

ack(0, 0)
ack(1, 1)
ack(4, 0)
ack(3, 1)
ack(3, 10)
ack(2, 10000)
/* too large: */
// ack(3, 12)
// ack(4, 1)
// ack(4, 1)
// ack(5, 1)
