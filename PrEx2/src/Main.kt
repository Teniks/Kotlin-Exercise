fun main(){
    //ex1
    println("Введите кол-во секунд, прошедших с последней активности:")
    val  secondPass: Int = readln()!!.toInt()

    println("Пользователь " + agoToText(secondPass))

    //ex2
    var amountPreviousTransfers:Float = 0f
    println("Введите желаемую сумму перевода: ")
    val amount: Float = readln()!!.toFloat()
    amountPreviousTransfers += amount
    println("Перевод на счет какого банка? (MasterCard/VKPay/Maestro/Visa/Мир)")
    val typeOfCard: String = readln()!!.toString()
    println("Итого комиссия: " + getCommission(typeOfCard, amount, amountPreviousTransfers))

}

public fun agoToText(secondPass: Int): String{
    return when(secondPass){
        in 0..60 -> "был(а) только что"
        in 61..60*60 -> "был(а) " + secondPass/60 + " "+getAgoMinutesRightText(secondPass)+"назад"
        in 60*60..24*60*60 -> "был(а) " + secondPass/60/60 + " " + getAgoHoursRightText(secondPass) + " назад"
        in 24*60*60..2*24*60*60 -> "был(а) вчера"
        in 2*24*60*60..3*24*60*60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}
public fun getAgoMinutesRightText(secondPass: Int): String{
    return if(secondPass != 11) when(secondPass/60 % 5){
        1 -> "минуту"
        2,3,4 -> "минуты"
        else -> "минут"
    } else "минут"
}
public fun getAgoHoursRightText(secondPass: Int): String{
    return when(secondPass/60/60 % 5){
        1 -> "час"
        2,3,4 -> "часа"
        else -> "часов"
    }
}

public fun getCommission(typeOfCard:String, amount:Float, amountPreviousTransfers: Float = 0f): Float{
    return when(typeOfCard)
    {
            "MasterCard", "Maestro" ->
                when(amountPreviousTransfers in 300.0..75000.0){
                    true -> 0.0f
                    else -> (amount/100.0f*0.6f) + 20.0f }
            "Visa", "Мир" -> (amount/100.0f*0.75f)
            "VKPay" -> 0f
            else -> (amount/100.0f*5.0f)
    }
}