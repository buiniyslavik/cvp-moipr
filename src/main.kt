class Business(
    val PricePerUnit: Int,
    val VariableCosts: Int,
    val ConstantCosts: Int,
    val TargetProfit: Int

) {
    var NumberOfUnits = 0
    fun getProfit(): Number {
        return (PricePerUnit - VariableCosts) * NumberOfUnits - ConstantCosts
    }
    fun getTargetSales(): Number {
        val marginProfit = PricePerUnit - VariableCosts
        return (ConstantCosts+TargetProfit)/marginProfit
    }

}

fun main() {

}