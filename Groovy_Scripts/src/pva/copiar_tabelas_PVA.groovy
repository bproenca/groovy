package pva

import java.text.SimpleDateFormat

if (!args || args.size() != 2) {
    println "Parâmetros NÃO informados"
    System.exit(1)
} else if (!args[0]) {
    println "Diretório de trabalho NÃO informado"
    System.exit(1)
} else if (!args[1]) {
    println "Diretório do PVA NÃO informado"
    System.exit(1)
}
println "Diretório de trabalho informado: ${args[0]}"
println "Diretório do PVA informado: ${args[1]}"

def filePath = args[0].toString().trim()
def pvaPath = args[1].toString().trim()

File diretorioPVA = new File(pvaPath)
if (!diretorioPVA.exists() || !diretorioPVA.isDirectory()) {
	println "Diretório do PVA nao existe"
	System.exit(1)
}
println "Diretório do PVA: ${diretorioPVA}"

def date = new Date()
sdf = new SimpleDateFormat("yyyyMMdd")
//println sdf.format(date)

def dirHoje = new File("${filePath}/${sdf.format(date)}")
println "Diretório destino ${dirHoje}"
if (dirHoje.exists()) {

    print "Dir ${dirHoje} já existe, deseja excluir? (S/N): "
    def podeExcluir = "${System.in.newReader().readLine()}"
    //def podeExcluir = System.console().readLine "Dir ${dirHoje} ja existe, deseja excluir? (S/N)"
	if ("S".equalsIgnoreCase(podeExcluir)) {
		dirHoje.deleteDir()
		dirHoje.mkdir()
	} else {
		println "Pulando etapa (copiar tabelas do PVA)"
		System.exit(0)
	}
} else {
	dirHoje.mkdir()
}

diretorioPVA.eachFile() { src ->
	println "Copiando arquivo ${src.getName()}"
	def dst = new File("${dirHoje}/${src.getName()}")
    dst << src.text
}
