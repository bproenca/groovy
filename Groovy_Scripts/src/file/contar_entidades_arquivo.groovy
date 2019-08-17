package file

//cat arq_tst_saida.txt | cut -d"|" -f2 | sort -u
//def filePath = System.console().readLine 'Informe o caminho competo do arquivo:'
if (!args || args.size() != 1) {
    println "Parâmetro NÃO informado"
    System.exit(1)
} else if (!args[0]) {
    println "Caminho completo do arquivo NÃO informado"
    System.exit(1)
}
println "Caminho completo do arquivo: ${args[0]}"
def filePath = args[0].toString().trim()
File arquivo = new File(filePath)

if (!arquivo.exists()) {
    println "Arquivo NÃO existe"
    System.exit(1)
}

def mapa = [:]
def contador = 1

arquivo.eachLine {
    if (contador > 1) {
      try {
        entidade = it.split(/\|/)[1]
        mapa.put(entidade, mapa.get(entidade) ? mapa.get(entidade) + 1 : 1)
      } catch (all) {
        //println "Linha n�o lida ${it}"
      }
    } else {
      println it
      contador++
    }
}

mapa.each { key, value ->
    println "${key}: ${value}"
}

println '\n*** FIM ***'

