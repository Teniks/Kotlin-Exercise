fun main() {
    //ex1
    println("Введите желаемую сумму:")
    val amountLine = readLine()
    val amount: Float = amountLine!!.toFloat()
    val discount: Float = 0.75f
    var result: Float = 0.0f

    if(amount > 35){
        result = (amount/100*discount)
    }else{
        println("Сумма меньше минимума - минимум 35 руб")
    }

    println("Комиссия платежа составляет: $result руб")

    //ex2
    val likes: Int = readLine()!!.toInt()

    if(likes%2 == 0){
        println("Понравилось $likes человек")
    }else if(likes%2 == 1){
        println("Понравилось $likes человеку")
    }else{
        println("Понравилось $likes людям")
    }

    //ex3
    var customers: List<RegularCustomer> = ArrayList()
    var i: Int = -1
    while(true){
        i++
        println("Хотите добавить нового клиента?")
        if(!(readLine()!!.contains("да", true))){
            break;
        }
        println("Введите имя:")
        val name: String = readLine().toString()
        println("Постоянный покупатель?")
        val isRegular: Boolean = if(readLine()!!.contains("да", true)) true else false
        customers += RegularCustomer(name, isRegular)

        println("На какую сумму совершил покупку?")
        val summ: Float = readLine()!!.toFloat()
        var result: Float = 0f
        if(summ > 999){
            result = summ - 100
            if(summ > 10000){
                result = result - (result/100*5)
            }
        }

        if(customers[i].isRegular){
            result = result - (result/100*1)
        }

        println("Его итоговая сумма: $result")
    }


}