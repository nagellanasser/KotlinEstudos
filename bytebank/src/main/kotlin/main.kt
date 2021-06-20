fun main() {
    println("Bem vindo ao Bytebank\n")

    val contaAlex =
        Conta(numero = 1000, titular = "Alex") //Conta() ñ está dentro da variável. A variável está apontando para o endereço Conta()
    contaAlex.deposita(200.0)
    println("Titular: ${contaAlex.titular}")
    println("N° da Conta: ${contaAlex.numero}")
    println("Saldo: ${contaAlex.saldo}\n")

    val contaFran = Conta("Fran", 1001)
    contaFran.deposita(300.0)
    println("Titular: ${contaFran.titular}")
    println("N° da Conta: ${contaFran.numero}")
    println("Saldo: ${contaFran.saldo}\n")

    println("Depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println("Saldo atual: ${contaAlex.saldo}\n")

    println("Depositando na conta da Fran")
    contaFran.deposita(70.0)
    println("Saldo atual: ${contaFran.saldo}\n")

    println("Sacando na conta do Alex")
    contaAlex.saca(250.0)
    println("Saldo atual: ${contaAlex.saldo}\n")

    println("Sacando na conta da Fran")
    contaFran.saca(400.0)
    println("Saldo atual: ${contaFran.saldo}\n")

    println("Transferência da conta da Fran para o Alex")

    if (contaFran.transfere(100.0, contaAlex)) {
        println("Transferência sucedida!")
    } else {
        println("Falha na transferência")
    }

    println("Saldo do Alex: ${contaAlex.saldo}")
    println("Saldo da Fran: ${contaFran.saldo}")
}

class Conta(
    val titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set  //propriedade da variável - variáveis são properties

    fun deposita(valor: Double) {
        if (valor > 0) {
            saldo += valor

        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        } else {
            println("Saldo insuficiente para saque do valor requerido.")
        }
    }

    fun transfere(valor: Double, contaDestino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            contaDestino.deposita(valor)
            return true
        }
        return false
    }

}


fun testaCondicoesIfWhen(saldo: Double) {
    //IF
    if (saldo > 0.0) {
        println("Conta positiva")
    } else if (saldo == 0.0) {
        println("Conta neutra")
    } else {
        println("Conta negativa")
    }

    //IF replace for WHEN expression
    when {
        saldo > 0.0 -> println("Conta positiva")
        saldo == 0.0 -> println("Conta neutra")
        else -> println("Conta negativa")
    }
}

fun testaLacoForLoop() {

    //cria 5 contas
    for (i in 1..5) {

        val titular: String = "Fulano $i" // val valor da variável não muda
        val numeroConta: Int = 1000 + i // val valor da variável não muda
        var saldo = i + 10.0 // var variável de valores mutável

        println("Titular: $titular")
        println("N° da conta: $numeroConta")
        println("Saldo: $saldo")
        println()
    }

    //cria 5 contas na ordem decrescente
    for (i in 5 downTo 1) {

        val titular: String = "Fulano $i" // val valor da variável não muda
        val numeroConta: Int = 1000 + i // val valor da variável não muda
        var saldo = i + 10.0 // var variável de valores mutável

        println("Titular: $titular")
        println("N° da conta: $numeroConta")
        println("Saldo: $saldo")
        println()
    }

    //cria 3 contas de 2 em 2
    for (i in 1..5 step 2) {

        val titular: String = "Fulano $i" // val valor da variável não muda
        val numeroConta: Int = 1000 + i // val valor da variável não muda
        var saldo = i + 10.0 // var variável de valores mutável

        println("Titular: $titular")
        println("N° da conta: $numeroConta")
        println("Saldo: $saldo")
        println()
    }

    //cria apenas 4 contas do 1 até 4 - DESTA FORMA aplicada só funciona no Range
    for (i in 1 until 5) {

        val titular: String = "Fulano $i" // val valor da variável não muda
        val numeroConta: Int = 1000 + i // val valor da variável não muda
        var saldo = i + 10.0 // var variável de valores mutável

        println("Titular: $titular")
        println("N° da conta: $numeroConta")
        println("Saldo: $saldo")
        println()
    }

    //For loop suporta uso de break e continue
    loop@ for (i in 1..100) {
        println("i $i")
        for (j in 1..100) {
            println("j $j")
            if (j == 5) break@loop
        }
    }
    //    O resultado seria:
    //    i 1
    //    j 1
    //    j 2
    //    j 3
    //    j 4
    //    j 5
}

fun testaLacoWhileLoop() {
    var i = 0
    while (i < 5) {
        val titular: String = "Fulano $i" // val valor da variável não muda
        val numeroConta: Int = 1000 + i // val valor da variável não muda
        var saldo = i + 10.0 // var variável de valores mutável

        println("Titular: $titular")
        println("N° da conta: $numeroConta")
        println("Saldo: $saldo")
        println()
        i++
    }
}