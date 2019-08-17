package file

//cat arq_tst_saida.txt | cut -d"|" -f2 | sort -u

if (!args || args.size() != 1) {
    println "Parâmetro NÃO informado ou informado mais de 1"
    System.exit(1)
} else if (!args[0]) {
    println "Caminho completo do arquivo NÃO informado"
    System.exit(1)
}
println "Caminho completo do arquivo: ${args[0]}"
def filePath = args[0].toString().trim()

//def filePath = "/home/bcp/Downloads/arq_tst_modelo.txt"
File arquivo = new File(filePath)

if (!arquivo.exists()) {
    println "Arquivo NÃO existe"
    System.exit(1)
}

def input = System.console().readLine 'Informe o nome da entidade ESPAÇO número do campo que deseja contar (ex: "Nf 18" = conta modelo[18] da entidade NF): '

if (input =~ "[A-Za-z]+[ \t][0-9]+")
    println "Input = ${input}"
else {
    println "Entidade ou campo não foi informado corretamente"
    System.exit(1)
}

def nomeEntidade = input.split(" ")[0]
idxCampo = Integer.valueOf(input.split(" ")[1])

def mapa = [:]

arquivo.eachLine {

    campos = it.split(/\|/)
    entidade = campos[1]

    if (nomeEntidade.equalsIgnoreCase(entidade)) {
        modelo = campos[idxCampo]
        mapa.put(modelo, mapa.get(modelo) ? mapa.get(modelo) + 1 : 1)
    }
}

mapa.each { key, value ->
    println "Valor = ${key} : Qtd = ${value}"
}

println '\n*** FIM ***'

