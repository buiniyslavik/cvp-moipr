interface Business {
    val VariableCosts: Int
    val ConstantCosts: Int
}

class TargetSalesBusiness(
    val PricePerUnit: Int,
    val TargetProfit: Int,
    override val VariableCosts: Int,
    override val ConstantCosts: Int
): Business {
    fun getTargetSales(): Int {
        val marginProfit = PricePerUnit - VariableCosts
        return (ConstantCosts + TargetProfit) / marginProfit
    }
}

class TargetPriceBusiness(
    val MaxVolume: Int,
    val TargetProfit: Int,
    override val VariableCosts: Int,
    override val ConstantCosts: Int
): Business {
    fun getTargetPrice(): Int {
        return ((ConstantCosts + TargetProfit) / MaxVolume) + VariableCosts
    }
}

fun targetSalesMode() {
    print("Введите целевую прибыль [100]:")
    val tgp = readLine()?.toIntOrNull()?: 100
    print("Введите постоянные расходы в месяц [10]:")
    val cExp = readLine()?.toIntOrNull()?: 10
    print("Введите затраты на изготовление 1 единицы продукции [5]:")
    val vExp = readLine()?.toIntOrNull()?: 5
    print("Введите отпускную цену единицы продукции [10]:")
    val ppu = readLine()?.toIntOrNull()?: 10

    val company = TargetSalesBusiness(ppu, tgp, vExp, cExp)
    println("Целевой объём продаж: ${company.getTargetSales()}")
}

fun targetPriceMode() {
    print("Введите целевую прибыль [100]:")
    val tgp = readLine()?.toIntOrNull()?: 100
    print("Введите постоянные расходы в месяц [10]:")
    val cExp = readLine()?.toIntOrNull()?: 10
    print("Введите затраты на изготовление 1 единицы продукции [5]:")
    val vExp = readLine()?.toIntOrNull()?: 5
    print("Введите желаемый объём выпуска [22]:")
    val mv = readLine()?.toIntOrNull()?: 22
    val company = TargetPriceBusiness(mv, tgp, vExp, cExp)
    println("Минимальная отпускная цена для получения заданной прибыли: ${company.getTargetPrice()}")
}

fun main() {
    targetSalesMode()
    println("\n\n\n")
    targetPriceMode()
}